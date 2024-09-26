package ladder.game;

import ladder.Position;
import ladder.Row;

import static ladder.TimePeriod.*;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        StringBuilder sb = new StringBuilder();
        for (int running_row = 0; running_row < rows.length; running_row++) {
            //Before
            sb.append(BEFORE.getTimePeriod() + "\n");
            printLadder(position, running_row, sb);

            rows[running_row].nextPosition(position);

            //After
            sb.append(AFTER.getTimePeriod() + "\n");
            printLadder(position, running_row, sb);
        }
        System.out.println(sb);
        return position.getValue();
    }

    private void printLadder(Position position, int running_row, StringBuilder sb) {
        for (int i = 0; i < rows.length; i++) {
            if (isSameRow(running_row, i)) {
                rows[i].printStarRow(position, sb);
                continue;
            }
            rows[i].printRow(sb);
        }
    }

    private static boolean isSameRow(int running_row, int i) {
        return running_row == i;
    }
}
