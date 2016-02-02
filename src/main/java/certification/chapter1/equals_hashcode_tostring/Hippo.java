package certification.chapter1.equals_hashcode_tostring;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class Hippo {
    private String name;
    private double weight;

    public Hippo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        //return name;
        /*return ToStringBuilder.reflectionToString(this);*/
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static void main(String[] args) {
        Hippo h1 = new Hippo("Harry", 3100);
        System.out.println(h1);
        // Harry
        // certification.chapter1.equals_hashcode_tostring.Hippo@3cd1a2f1[name=Harry,weight=3100.0]
        // Hippo[name=Harry,weight=3100.0]
    }
}
