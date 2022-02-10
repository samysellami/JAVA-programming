package ru.makhmutov.task4.animals;

import java.util.Objects;

public class Animal {

    private String nickname;

    public Animal(String nickname) {
        this.nickname = nickname;
    }

    public void voice() {
        System.out.println("I am an Animal");
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(nickname, animal.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
