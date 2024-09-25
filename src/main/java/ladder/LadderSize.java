package ladder;

public class LadderSize {
    private final GreaterThanOne numberOfPerson;
    private final GreaterThanOne numberOfRow;

    public LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
        this.numberOfRow = numberOfRow;
    }

    public int calLineSize() {
        return (int)(numberOfPerson.getNumber()*numberOfRow.getNumber()*0.3);
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }
}
