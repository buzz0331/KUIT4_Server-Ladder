package ladder;

import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderGameFactoryTest {


    @Test
    public void 랜덤사다리_생성() throws Exception {
        //given
        LadderSize ladderSize = new LadderSize(GreaterThanOne.from(3), GreaterThanOne.from(3));
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //when

        //then
        Assertions.assertThat(ladderGame).isNotNull();
    }

    @Test
    public void 랜덤사다리_게임_실행() throws Exception {
        //given
        LadderSize ladderSize = new LadderSize(GreaterThanOne.from(4), GreaterThanOne.from(4));
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //when
        ladderGame.run(Position.from(0));

        //then
//        Assertions.assertThat(ladderGame.run(Position.from(0))).isEqualTo(0);
    }
}