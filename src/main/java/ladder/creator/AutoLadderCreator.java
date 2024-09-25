package ladder.creator;

import ladder.*;

import java.util.HashSet;
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

    private void drawAutoRandomLine(LadderSize ladderSize, GreaterThanOne numberOfPerson, GreaterThanOne numberOfRow) {
        //생성해야 하는 line 개수
        int lineSize = ladderSize.calLineSize();

        HashSet<PositionPair> set = new HashSet<>();
        Random random = new Random();

        int count = 0;

        while (count < lineSize) {
            //0~numberOfPerson-2 사이의 난수 생성 => 왼쪽에만 생성되기 때문에 2를 뺌!
            int col = random.nextInt(numberOfPerson.getNumber()-1);

            //0~numberOfRow-1 사이의 난수 생성
            int row = random.nextInt(numberOfRow.getNumber());
            PositionPair pair = new PositionPair(row, col);

            //중복 확인
            if(set.contains(pair)) {
                continue;
            }

            try{
                this.drawLine(Position.from(row), Position.from(col));
                set.add(pair);
                count++;
            } catch (IllegalArgumentException e) {
                continue;
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
