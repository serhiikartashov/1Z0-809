package certification.chapter1.enums;

/**
 * Created by Serhii on 2/8/2016.
 */
public enum Enum {

    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    private String expectedVisitors;

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    private Enum(String expectedVisitors) {
        System.out.println("3");
        this.expectedVisitors = expectedVisitors;
    }

    {
        System.out.println("4");
    }

    static {
        System.out.println("5");
    }

    public static void main(String[] args) {
        System.out.println("Run");
    }

}
