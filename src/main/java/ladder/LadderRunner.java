package ladder;

import static ladder.TimePeriod.*;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    //todo for문 안에 Row 단위로 출력하는 print 메서드 만들기
    //todo * 찍기
    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            //Before
            System.out.println(BEFORE);
            printLadder(position, i);

            rows[i].nextPosition(position);

            //After
            System.out.println(AFTER);
            printLadder(position, i);
        }
        return position.getValue();
    }

    private void printLadder(Position position, int i) {
        for (int j = 0; j < rows.length; j++) {
            if (i == j) {
                rows[j].printStarRow(position);
                continue;
            }
            rows[j].printRow();
        }
    }
}
