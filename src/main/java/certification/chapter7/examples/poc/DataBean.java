package certification.chapter7.examples.poc;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Data
public class DataBean {

    private Integer date;
    private AtomicInteger value;

    public DataBean(Integer date, Integer value) {
        this.date = date;
        this.value = new AtomicInteger(value);
    }
}
