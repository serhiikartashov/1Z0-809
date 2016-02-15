package certification.chapter3.comparation.comparable;

/**
 * Created by Serhii K. on 2/15/2016.
 */
// compareTo() method is not consistent with equals
public class Product implements Comparable<Product> {
    int id;
    String name;

    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}
