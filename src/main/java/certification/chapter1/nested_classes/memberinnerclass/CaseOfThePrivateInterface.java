package certification.chapter1.nested_classes.memberinnerclass;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class CaseOfThePrivateInterface {

    // private interface!
    private interface Secret {
        public void shh();
    }

    // can only be referred to within the current outer class
    class DontTell implements Secret {
        public void shh() {
        }
    }
}