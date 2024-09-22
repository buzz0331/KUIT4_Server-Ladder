package ladder;

import static ladder.ExceptionMessage.INVALID_LADDER_POSITION;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    public static Position from(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public void prev() {
        position--;
    }

    public void next() {
        position++;
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    public boolean isSamePosition(int i) {
        return this.position == i;
    }
}
