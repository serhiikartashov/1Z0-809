package certification.chapter8.serialization;

import java.io.Serializable;

/**
 * Created by Serhii K. on 3/14/2016.
 */
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private char type;

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }

    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
    }
}
