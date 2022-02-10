package ru.makhmutov.task3.objects;

import ru.makhmutov.task3.interfaces.Swimmable;

public class Submarine implements Swimmable {

    boolean isSwimming = false;

    @Override
    public void swim() {
        if (!isSwimming) {
            System.out.println("The " + this.getClass().getSimpleName() +
                    " is swimming in the military zone");
            isSwimming = true;
        }
    }

    @Override
    public void stopSwimming() {
        if (isSwimming) {
            System.out.println("The " + this.getClass().getSimpleName() +
                    " stopped swimming in the military zone");
            isSwimming = false;
        }
    }
}
