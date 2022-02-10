import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Document document = new Passport("Alice",18, 11133);
        Passport passport = new Passport("Bob", 50, 33333);
        Snils snils         = new Snils("Carl", 7777);

        /* Initialize a list and add document, passport and snils to it.
        * Iterate through elements of the list:
        * output a message "Document #" + number + " has expired"
        * if document has expired, or call print() on the element otherwise
        * Make sure to handle any exception (if any thrown)
         */
        List<Document> list = new ArrayList<>();
        list.add(document);
        list.add(passport);
        list.add(snils);

        for (Document el: list) {
            //
            try {
                Expirable d = (Expirable) el;
                if (d.hasExpired()) {
                    System.out.println("Document #" + el.number + " has expired");
                } else {
                    el.print();
                }
            } catch (Exception e) {
                System.out.println(el.type() + " has no expiration date");
            }
        }

    }
}


