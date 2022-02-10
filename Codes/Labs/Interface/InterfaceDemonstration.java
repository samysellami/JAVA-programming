package ru.makhmutov.task3;

import ru.makhmutov.task3.interfaces.Living;
import ru.makhmutov.task3.objects.Duck;
import ru.makhmutov.task3.objects.Penguin;

public class InterfaceDemonstration {

    /**
     * The entry point of the DifferentInterfaces program.
     * It allows creating objects implementing different set
     * of interfaces including Living, Swimmable and Flyable
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Living[] livings = addLivingObjects();
        letObjectsLive(livings);
    }

    /**
     * This method allows all elements of the array live
     *
     * @param livings the array of living objects
     */
    private static void letObjectsLive(Living[] livings) {
        for (Living living : livings) {
            living.live();
        }
    }

    /**
     * This method allows adding living objects into
     * the array
     *
     * @return the array of living things
     */
    private static Living[] addLivingObjects() {
        Living[] livings = new Living[2];

        Duck duck = new Duck();
        livings[0] = duck;

        Penguin penguin = new Penguin();
        livings[1] = penguin;

        return livings;
    }
}
