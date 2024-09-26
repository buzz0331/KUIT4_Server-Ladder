package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.ManualLadderCreator;
import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        LadderSize ladderSize = new LadderSize(GreaterThanOne.from(3), GreaterThanOne.from(5));

        //when
        LadderCreator ladderCreator = new ManualLadderCreator(ladderSize);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        LadderSize ladderSize = new LadderSize(GreaterThanOne.from(2), GreaterThanOne.from(3));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(GreaterThanOne.from(3), GreaterThanOne.from(4));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);

        LadderCreator ladderCreator = ladderGame.getLadderCreator();

        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }
}