public class Snils extends Document{

    public Snils(String name, int number) {
        super(DocType.SNILS, number, name);
    }

    @Override
    public void print() {
        System.out.println(type() + " #" + number + " of "+owner_name);
    }
}
