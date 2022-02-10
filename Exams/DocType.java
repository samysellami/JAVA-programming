public enum DocType {
    PASSPORT (true), SNILS (false), OTHER(false);

    public final boolean isFixedTerm;

    private DocType (boolean value) {
        this.isFixedTerm = value;
    }
}
