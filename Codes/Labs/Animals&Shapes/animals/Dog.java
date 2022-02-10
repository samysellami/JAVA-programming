package ru.makhmutov.task1.animals;

public class Dog extends Animal {

    /**
     * This is a constructor of a class
     *
     * @param height the height of an animal
     * @param weight the weight of an animal
     * @param color  the color of an animal
     */
    public Dog(float height, float weight, String color) {
        super(height, weight, color);
    }

    /**
     * This method allows an animal to eat
     */
    @Override
    protected void eat() {
        System.out.println("The " + this.getClass().getSimpleName() + " is eating");
    }

    /**
     * This method allows an animal to sleep
     */
    @Override
    protected void sleep() {
        System.out.println("The " + this.getClass().getSimpleName() + " is sleeping");
    }

    /**
     * This method allows an animal to talk
     */
    @Override
    protected void animalSound() {
        System.out.println("The " + this.getClass().getSimpleName() + " is barking");
    }
}