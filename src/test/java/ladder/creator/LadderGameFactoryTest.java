package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    //todo 랜덤하게 생성되는 라인을 어떻게 테스트할까
    @Test
    public void 랜덤사다리_게임_실행() throws Exception {
        //given
        LadderSize ladderSize = new LadderSize(GreaterThanOne.from(4), GreaterThanOne.from(4));
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //when

        //then
        Assertions.assertThat(ladderGame.run(Position.from(0))).isEqualTo(0);
    }
}