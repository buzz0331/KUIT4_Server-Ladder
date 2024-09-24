package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        LadderCreator ladderCreator = new LadderCreator(ladderSize.getNumberOfRow(), ladderSize.getNumberOfRow());
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //생성해야 하는 line 개수
        int lineSize = ladderSize.calLineSize();
        GreaterThanOne numberOfPerson = ladderSize.getNumberOfPerson();
        GreaterThanOne numberOfRow = ladderSize.getNumberOfRow();

        Random random = new Random();
        int count = 0;

        while (true) {
            //0~numberOfPerson-2 사이의 난수 생성 => 왼쪽에만 생성되기 때문에 2를 뺌!
            int col = random.nextInt(numberOfPerson.getNumber()-1);

            //0~numberOfRow-2 사이의 난수 생성
            int row = random.nextInt(numberOfRow.getNumber()-1);

            try{
                ladderCreator.drawRandomLine(Position.from(row), Position.from(col));
            } catch (IllegalArgumentException e) {
                continue;
            }

            count++;
            if (count == lineSize) {
                break;
            }
        }


        return ladderGame;
    }

}
