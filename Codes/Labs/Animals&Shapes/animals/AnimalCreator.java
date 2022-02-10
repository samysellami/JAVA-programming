package ru.makhmutov.task1.animals;

import java.util.Arrays;

public class AnimalCreator {

    /**
     * The entry point of the Animals program.
     * It allows creating array of different animals
     * and demonstrate inheritance and polymorphism
     * principles
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Animal[] animals = addAnimals();
        System.out.println(Arrays.toString(animals));
    }

    /**
     * This method allows adding animals of different
     * type to the array
     *
     * @return the array of animals
     */
    private static Animal[] addAnimals() {
        Animal[] animals = new Animal[4];

        Animal animal = new Animal(50, 35.5F, "black");
        animals[0] = animal;

        Animal dog = new Dog(40, 28F, "brown");
        animals[1] = dog;

        Animal cat = new Cat(10, 5.5F, "orange");
        animals[2] = cat;

        Animal cow = new Cow(160.5F, 450, "white");
        animals[3] = cow;

        return animals;
    }
}
