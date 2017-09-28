package certification.chapter1.equals_hashcode_tostring;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class Lion {

    private int idNumber;
    private int age;
    private String name;

    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }

    // validate equality only by id
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lion)) return false;
        Lion otherLion = (Lion) obj;
        return this.idNumber == otherLion.idNumber;
    }

    /*public boolean equals (Object obj){
        return EqualsBuilder.reflectionEquals(this, obj);
    }*/

    public static void main(String[] args) {
        Lion l1 = new Lion(1, 1, "name1");
        Lion l2 = new Lion(1, 1, "name1");
        Lion l3 = new Lion(1, 1, "name2");
        System.out.println(l1.equals(l2)); // true
        System.out.println(l1.equals(l3)); // false
    }
}
