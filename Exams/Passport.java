public class Passport extends Document implements Expirable{
    private int age;
    private boolean reissued;

    public Passport(String name, int age, int number) {
        super(DocType.PASSPORT, number, name);
        this.age = age;
    }

    @Override
    public void print() {
        System.out.println(type() + " #" + number + " of "+owner_name);
        System.out.println("  Status: " + (hasExpired()?"expired":"valid"));
    }

    @Override
    public boolean hasExpired() {
        // False if age is older than 44 and has not reissued
        return (age>=45 && !reissued);
    }

    @Override
    public void reissue() {
        reissued = true;
    }
}
