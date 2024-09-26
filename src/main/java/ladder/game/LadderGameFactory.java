package ladder.game;

import ladder.LadderSize;
import ladder.creator.AutoLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.ManualLadderCreator;

public class LadderGameFactory {

    private static LadderCreator ladderCreator;

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        ladderCreator = new AutoLadderCreator(ladderSize);
        return new LadderGame(ladderCreator);
    }

    public static LadderGame createLadderGame(LadderSize ladderSize) {
        ladderCreator = new ManualLadderCreator(ladderSize);
        return new LadderGame(ladderCreator);
    }


}
