package ru.makhmutov.task1.animals;

public class Animal {

    protected float height;
    protected float weight;
    protected String color;

    /**
     * This is a constructor of a class
     *
     * @param height the height of an animal
     * @param weight the weight of an animal
     * @param color the color of an animal
     */
    public Animal(float height, float weight, String color) {
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    /**
     * This method allows an animal to eat
     */
    protected void eat(){
        System.out.println("Animal is eating");
    }

    /**
     * This method allows an animal to sleep
     */
    protected void sleep(){
        System.out.println("Animal is sleeping");
    }

    /**
     * This method allows an animal to talk
     */
    protected void animalSound(){
        System.out.println("Animal is talking");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "height=" + height +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
