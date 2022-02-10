package ru.makhmutov.task2;

import java.util.Random;

public class Library {

    private static final String[] AUTHORS = {"Alexander Pushkin", "Sergey Esenin",
            "Nikolai Gogol", "Lev Tolstoi", "Jack London", "Salikh Saidashev"};
    private static final String[] EMAILS = {"a.pushkin@innopolis.ru",
            "best.author.ever@gmail.com", "rifmoplet@mail.ru", "call_me_boss@innopolis.ru"};
    private static final String[] BOOKS = {"Peace & War", "Eugene Onegin", "Dead Souls",
            "Thinking in Java"};
    private static final double MIN_PRICE = 50;
    private static final double MAX_PRICE = 5000;
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 1000;

    /**
     * The entry point of the Library program.
     * It allows adding books to the library
     * and then display them
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Book[] books = getBooks();
        displayBooks(books);
    }


    /**
     * This method allows getting the array of
     * generated books
     *
     * @return the array of books
     */
    private static Book[] getBooks() {
        Book[] books = new Book[3];
        for (int bookNo = 0; bookNo < books.length; bookNo++) {
            books[bookNo] = addBook();
        }
        return books;
    }

    /**
     * This method allows displaying all the books
     *
     * @param books the array of books
     */
    private static void displayBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    /**
     * This method allows generating book for
     * further adding it to the array of books
     *
     * @return the generated book
     */
    private static Book addBook() {
        Author author = addAuthor();
        return new Book(generateString(BOOKS), author,
                generatePrice(MIN_PRICE, MAX_PRICE), generateQuantity(MIN_QUANTITY, MAX_QUANTITY));
    }

    /**
     * This method allows generating author for
     * further linking it to the book
     *
     * @return the generated author
     */
    private static Author addAuthor() {
        return new Author(generateString(AUTHORS), generateString(EMAILS), 'M');
    }

    /**
     * This method allows randomly choosing the
     * string from the given array
     *
     * @param stringArray the input String array
     * @return the chosen string
     */
    private static String generateString(String[] stringArray) {
        Random random = new Random();
        return stringArray[random.nextInt(stringArray.length)];
    }

    /**
     * This method allows generating the price
     *
     * @param lowerBoundary the lower boundary of a price
     * @param upperBoundary the upper boundary of a price
     * @return the generated price
     */
    private static double generatePrice(double lowerBoundary, double upperBoundary) {
        Random random = new Random();
        return lowerBoundary + random.nextInt((int) (upperBoundary - lowerBoundary));
    }

    /**
     * This method allows generating the quantity
     * of books
     *
     * @param lowerBoundary the lower boundary of a quantity
     * @param upperBoundary the upper boundary of a quantity
     * @return the generated quantity of books
     */
    private static int generateQuantity(int lowerBoundary, int upperBoundary) {
        Random random = new Random();
        return lowerBoundary + random.nextInt(upperBoundary - lowerBoundary);
    }

}
