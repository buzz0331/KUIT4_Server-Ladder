public class NaturalNumber {
    private final int naturalNumber;

    private NaturalNumber(int naturalNumber) {
        if (naturalNumber < 1) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        this.naturalNumber = naturalNumber;
    }

    public static NaturalNumber from(int i) {
        return new NaturalNumber(i);
    }

    public int getNaturalNumber() {
        return naturalNumber;
    }
}
