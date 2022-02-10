package ru.makhmutov.task4.animals;

import java.util.Objects;

public class Dog extends Animal {

    private final int barkLoudness;

    public Dog(String nickname, int barkLoudness) {
        super(nickname);
        this.barkLoudness = barkLoudness;
    }

    @Override
    public void voice() {
        System.out.println("I am a Dog, I am barking");
    }

    @Override
    public String toString() {
        return "nickname=" + super.getNickname() + " Dog{" +
                "barkLoudness=" + barkLoudness +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return barkLoudness == dog.barkLoudness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), barkLoudness);
    }
}
