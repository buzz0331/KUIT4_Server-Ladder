package ladder;

import static ladder.TimePeriod.*;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    //todo StringBuilder 사용하기
    public int run(Position position) {
        for (int running_row = 0; running_row < rows.length; running_row++) {
            //Before
            System.out.println(BEFORE.getTimePeriod());
            printLadder(position, running_row);

            rows[running_row].nextPosition(position);

            //After
            System.out.println(AFTER.getTimePeriod());
            printLadder(position, running_row);
        }
        return position.getValue();
    }

    private void printLadder(Position position, int running_row) {
        for (int i = 0; i < rows.length; i++) {
            if (isSameRow(running_row, i)) {
                rows[i].printStarRow(position);
                continue;
            }
            rows[i].printRow();
        }
    }

    private static boolean isSameRow(int running_row, int i) {
        return running_row == i;
    }
}
