package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

public class ManualLadderCreator implements LadderCreator {

    private final Row[] rows;

    public ManualLadderCreator(LadderSize ladderSize) {
        GreaterThanOne numberOfPerson = ladderSize.getNumberOfPerson();
        GreaterThanOne numberOfRow = ladderSize.getNumberOfRow();

        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }


}
