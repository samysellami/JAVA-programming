package ru.makhmutov.task4.animals;

import java.util.Objects;

public class Cat extends Animal {

    private final int purLoudness;

    public Cat(String nickname, int purLoudness) {
        super(nickname);
        this.purLoudness = purLoudness;
    }

    @Override
    public void voice() {
        System.out.println("I am a Cat, purrrrrr");
    }

    @Override
    public String toString() {
        return "nickname=" + super.getNickname() +
                " Cat{" + "purLoudness=" + purLoudness +
                '}';
    }

//    @Override
//    public int compare(Cat o1, Cat o2) {
//        String name1 = o1.getNickname();
//        String name2 = o2.getNickname();
//        if (name1.compareTo(name2) < 0) {
//            return -1;
//        } else if (name1.compareTo(name2) > 0) {
//            return 1;
//        } else {
//            return Integer.compare(o1.purLoudness, o2.purLoudness);
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return purLoudness == cat.purLoudness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), purLoudness);
    }
}
