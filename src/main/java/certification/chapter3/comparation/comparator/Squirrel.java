package certification.chapter3.comparation.comparator;

import java.util.Comparator;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class Squirrel {
    private int weight;
    private String species;

    public Squirrel(String theSpecies) {
        if (theSpecies == null) throw new IllegalArgumentException();
        species = theSpecies;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public static void main(String[] args) {
        Comparator<Squirrel> comp = new Comparator<Squirrel>(){

            @Override
            public int compare(Squirrel o1, Squirrel o2) {
                Comparator<Squirrel> c = Comparator.comparing(
                        s -> s.getSpecies()
                );
                c = c.thenComparing(s->s.getWeight());
                return c.compare(o1, o2);
            }
        };
    }
}
