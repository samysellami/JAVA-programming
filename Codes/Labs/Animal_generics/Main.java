package ru.makhmutov.task4;

import ru.makhmutov.task4.animals.Animal;
import ru.makhmutov.task4.animals.Cat;
import ru.makhmutov.task4.animals.Dog;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<Animal> animals = new ArrayList<>();
//        animals.add(new Animal("Alex"));
//        animals.add(new Animal("Marty"));
//
//        List<Cat> cats = new ArrayList<>();
//        cats.add(new Cat("Kitty", 3));
//        cats.add(new Cat("Gary", 2));
//
//        List<Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog("Spike", 6));
//        dogs.add(new Dog("Pluto", 4));

        Set<Animal> animals = new HashSet<>();
        animals.add(new Animal("Alex"));
        animals.add(new Animal("Marty"));

        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat("Kitty", 3));
        cats.add(new Cat("Kitty", 3));
        cats.add(new Cat("Gary", 2));

        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("Spike", 6));
        dogs.add(new Dog("Pluto", 4));


        displayAnimals(dogs);
        displayAnimals(cats);
        displayAnimals(animals);
        makeAnimalsTalk(cats);
        addAnimal(animals);
        displayAnimals(animals);
        displayAnimalsT(animals);

//        List<Number> numbers = new ArrayList<>();
//        numbers.add(5);
//        numbers.add(-9.4);
//        displayAnimalsT(numbers);

    }

    public static void displayAnimals(Collection<? extends Animal> animals) {
        System.out.println();
        for (Animal animal : animals) {
            System.out.println(animal.toString());
            animal.setNickname("Name");
        }
    }

    public static <T> void displayAnimalsT(Collection<? extends T> animals) {
        System.out.println();
        for (T animal : animals) {
            System.out.println(animal.toString());
        }
    }


    public static void makeAnimalsTalk(Collection<? extends Animal> animals) {
        System.out.println();
        for (Animal animal : animals) {
            animal.voice();
        }
    }

    public static void addAnimal(Collection<? super Animal> animals) {
        animals.add(new Cat("Kitty", 3));
        animals.add(new Dog("Spike", 6));
        animals.add(new Animal("Spike"));
    }
}
