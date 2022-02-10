package ru.makhmutov.task3.objects;

import ru.makhmutov.task3.interfaces.Living;
import ru.makhmutov.task3.interfaces.Swimmable;

public class Penguin implements Living, Swimmable {

    boolean isSwimming = false;

    @Override
    public void swim() {
        if (!isSwimming) {
            System.out.println("The " + this.getClass().getSimpleName() +
                    " is swimming between icebergs");
            isSwimming = true;
        }
    }

    @Override
    public void stopSwimming() {
        if (isSwimming) {
            System.out.println("The " + this.getClass().getSimpleName() +
                    " stopped swimming between icebergs");
            isSwimming = false;
        }
    }
}
