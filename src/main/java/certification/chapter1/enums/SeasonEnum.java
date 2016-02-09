package certification.chapter1.enums;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public enum SeasonEnum {

    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    private String expectedVisitors;
    private int order;
    static int i=0;
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    private SeasonEnum(String expectedVisitors) {
        System.out.println("3");
        this.expectedVisitors = expectedVisitors;
        //order=i++; // DOES NOT COMPILE
    }
    {
        System.out.println("4");
    }
    static {
        System.out.println("5");
    }
}
