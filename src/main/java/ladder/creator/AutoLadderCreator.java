package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class AutoLadderCreator implements LadderCreator {

    private final Row[] rows;

    public AutoLadderCreator(LadderSize ladderSize) {
        GreaterThanOne numberOfRow = ladderSize.getNumberOfRow();
        GreaterThanOne numberOfPerson = ladderSize.getNumberOfPerson();

        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }

        drawAutoRandomLine(ladderSize, numberOfPerson, numberOfRow);
    }

    //todo HashSet으로 중복해결
    private void drawAutoRandomLine(LadderSize ladderSize, GreaterThanOne numberOfPerson, GreaterThanOne numberOfRow) {
        //생성해야 하는 line 개수
        int lineSize = ladderSize.calLineSize();

        Random random = new Random();
        int count = 0;

        while (true) {
            //0~numberOfPerson-2 사이의 난수 생성 => 왼쪽에만 생성되기 때문에 2를 뺌!
            int col = random.nextInt(numberOfPerson.getNumber()-1);

            //0~numberOfRow-1 사이의 난수 생성
            int row = random.nextInt(numberOfRow.getNumber());

            try{
                this.drawLine(Position.from(row), Position.from(col));
            } catch (IllegalArgumentException e) {
                continue;
            }

            count++;
            if (count == lineSize) {
                break;
            }
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
