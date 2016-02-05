package certification.chapter2.design_patterns.immutable_object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public final class Animal {
    private final List<String> favoriteFoods;
    private final int age;

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    private final String species;

    public Animal(String species, int age, List<String> favoriteFoods){
        this.species = species;
        this.age = age;
        if (favoriteFoods==null){
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public int getFavoriteFoodsCount(){
        return favoriteFoods.size();
    }
    public String getFavoriteFood(int index){
        return favoriteFoods.get(index);
    }
}
