package certification.chapter6.assertions;

/**
 * Created by Serhii K. on 2/5/2016.
 */
enum Season{
    SPRING, SUMMER, FALL, WINTER
}
public class SeasonsClass {

    static void test(Season s){
        switch (s) {
            case SPRING:
            case FALL:
                System.out.println("111");
                break;
            case SUMMER:
                System.out.println("222");
                break;
            default:
                assert false: "Invalid season";
        }
    }

    public static void main(String[] args) {
        test (Season.WINTER);
    }
}
