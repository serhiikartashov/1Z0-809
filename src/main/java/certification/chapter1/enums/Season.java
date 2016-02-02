package certification.chapter1.enums;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public enum Season {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");

    private String expectedVisitors;

    private Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}

// public enum ExtendedSeason extends Season {}	// DOES NOT COMPILE

class TestClass2 {
    public static void main(String[] args) {
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER); // SUMMER

        // static final constants
        System.out.println(s == Season.SUMMER); // true

        for (Season season : Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }

        // if ( Season.SUMMER == 2)	{}	//	DOES NOT COMPILE

        Season s1 = Season.valueOf("SUMMER"); // SUMMER
        // Season s2 = Season.valueOf("summer"); // exception IllegalArgumentException

        Season summer = Season.SUMMER;
        switch (summer) {
            case WINTER:
                System.out.println("Get	out	the	sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet?");
        }

        /*switch (summer) {
            case 0:                    //	DOES	NOT	COMPILE
                System.out.println("Get	out	the	sled!");
                break;
        }*/

        Season.SUMMER.printExpectedVisitors();
    }
}

enum OnlyOne {
    ONCE(true);

    private OnlyOne(boolean b) {
        System.out.println("constructing");
    }

    public static void main(String[] args) {
        OnlyOne firstCall = OnlyOne.ONCE;  // prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
    }
}

enum Season2 {
    WINTER {
        public void printHours() {
            System.out.println("9am-3pm");
        }
    }, SPRING {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    }, SUMMER {
        public void printHours() {
            System.out.println("9am-7pm");
        }
    }, FALL {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    };

    public abstract void printHours();
}

enum Season3 {
    WINTER {
        public void printHours() {
            System.out.println("short	hours");
        }
    }, SUMMER {
        public void printHours() {
            System.out.println("long	hours");
        }
    }, SPRING, FALL;

    public void printHours() {
        System.out.println("default	hours");
    }
}

interface PrintHours {
    void printHours();
}

enum Season4 implements PrintHours{
    WINTER {
        public void printHours() {
            System.out.println("short	hours");
        }
    }, SUMMER {
        public void printHours() {
            System.out.println("long	hours");
        }
    };

}