package certification.chapter1.nested_classes.anonymousinnerclass;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class AnonInner {

    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }

    interface SaleTodayOnly2 {
        int dollarsOff2();
    }

    public int admission2(int basePrice) {
        SaleTodayOnly2 sale = new SaleTodayOnly2() {
            public int dollarsOff2() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff2();
    }

    public int pay() {
        return admission(5, new SaleTodayOnly2() {
            public int dollarsOff2() {
                return 3;
            }
        });
    }

    public int admission(int basePrice, SaleTodayOnly2 sale) {
        return basePrice - sale.dollarsOff2();
    }
}
