package certification.jvm;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.ListenerNotFoundException;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class MemoryUtil {
    private static final int NORM_NAME_LENGTH = 25;
    private static final long SIZE_KB = 1024;
    private static final long SIZE_MB = SIZE_KB * 1024;
    private static final long SIZE_GB = SIZE_MB * 1024;
    private static final String SPACES = "                    ";
    private static Map<String, MemRegion> memRegions;

    // Вспомогательный класс для хранения информации о регионах памяти
    private static class MemRegion {
        private boolean heap;        // Признак того, что это регион кучи
        private String normName;    // Имя, доведенное пробелами до универсальной длины

        public MemRegion(String name, boolean heap) {
            this.heap = heap;
            normName = name.length() < NORM_NAME_LENGTH ? name.concat(SPACES.substring(0, NORM_NAME_LENGTH - name.length())) : name;
        }

        public boolean isHeap() {
            return heap;
        }

        public String getNormName() {
            return normName;
        }
    }

    static {
        // Запоминаем информацию обо всех регионах памяти
        memRegions = new HashMap<String, MemRegion>(ManagementFactory.getMemoryPoolMXBeans().size());
        for (MemoryPoolMXBean mBean : ManagementFactory.getMemoryPoolMXBeans()) {
            memRegions.put(mBean.getName(), new MemRegion(mBean.getName(), mBean.getType() == MemoryType.HEAP));
        }
    }

    // Обработчик сообщений о сборке мусора
    private static NotificationListener gcHandler = new NotificationListener() {
        @Override
        public void handleNotification(Notification notification, Object handback) {
            if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                GarbageCollectionNotificationInfo gcInfo = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
                Map<String, MemoryUsage> memBefore = gcInfo.getGcInfo().getMemoryUsageBeforeGc();
                Map<String, MemoryUsage> memAfter = gcInfo.getGcInfo().getMemoryUsageAfterGc();
                StringBuilder sb = new StringBuilder();
                sb.append("[").append(gcInfo.getGcAction()).append(" / ").append(gcInfo.getGcCause())
                        .append(" / ").append(gcInfo.getGcName()).append(" / (");
                appendMemUsage(sb, memBefore);
                sb.append(") -> (");
                appendMemUsage(sb, memAfter);
                sb.append("), ").append(gcInfo.getGcInfo().getDuration()).append(" ms]");
                System.out.println(sb.toString());
            }
        }
    };

    /**
     * Выводит в stdout информацию о текущем состоянии различных разделов памяти.
     */
    public static void printUsage(boolean heapOnly) {
        for (MemoryPoolMXBean mBean : ManagementFactory.getMemoryPoolMXBeans()) {
            if (!heapOnly || mBean.getType() == MemoryType.HEAP) {
                printMemUsage(mBean.getName(), mBean.getUsage());
            }
        }
    }

    /**
     * Запускает процесс мониторинга сборок мусора.
     */
    public static void startGCMonitor() {
        for (GarbageCollectorMXBean mBean : ManagementFactory.getGarbageCollectorMXBeans()) {
            ((NotificationEmitter) mBean).addNotificationListener(gcHandler, null, null);
        }
    }

    /**
     * Останавливает процесс мониторинга сборок мусора.
     */
    public static void stopGCMonitor() {
        for (GarbageCollectorMXBean mBean : ManagementFactory.getGarbageCollectorMXBeans()) {
            try {
                ((NotificationEmitter) mBean).removeNotificationListener(gcHandler);
            } catch (ListenerNotFoundException e) {
            }
        }
    }

    private static void printMemUsage(String title, MemoryUsage usage) {
        System.out.println(String.format("%s%s\t%.1f%%\t[%s]",
                memRegions.get(title).getNormName(),
                formatMemory(usage.getUsed()),
                usage.getMax() < 0 ? 0.0 : (double) usage.getUsed() / (double) usage.getMax() * 100,
                formatMemory(usage.getMax())));
    }

    private static String formatMemory(long bytes) {
        if (bytes > SIZE_GB) {
            return String.format("%.2fG", bytes / (double) SIZE_GB);
        } else if (bytes > SIZE_MB) {
            return String.format("%.2fM", bytes / (double) SIZE_MB);
        } else if (bytes > SIZE_KB) {
            return String.format("%.2fK", bytes / (double) SIZE_KB);
        }
        return Long.toString(bytes);
    }

    private static void appendMemUsage(StringBuilder sb, Map<String, MemoryUsage> memUsage) {
        for (Map.Entry<String, MemoryUsage> entry : memUsage.entrySet()) {
            if (memRegions.get(entry.getKey()).isHeap()) {
                sb.append(entry.getKey()).append(" used=")
                        .append(entry.getValue().getUsed() >> 10)
                        .append("K; ");
            }
        }
    }
}
