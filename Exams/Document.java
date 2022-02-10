public abstract class Document implements Printable {
    final private DocType type;
    protected int number;
    protected String owner_name;

    protected Document(DocType type, int number, String name) {
        this.type = type;
        this.number = number;
        this.owner_name = name;
    }

    public DocType type(){
        return type;
    }
}
