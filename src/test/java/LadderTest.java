import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void 사다리_생성() throws Exception {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.from(3);
        NaturalNumber row = NaturalNumber.from(3);
        Ladder ladder = new Ladder(row, numberOfPerson);

        //when

        //then
        assertThat(ladder.getRows().length).isEqualTo(3);
    }

    @Test
    public void 사다리_라인생성() throws Exception {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.from(2);
        NaturalNumber row = NaturalNumber.from(2);
        Ladder ladder = new Ladder(row, numberOfPerson);

        //when
        Position position = new Position(NaturalNumber.from(1), NaturalNumber.from(1));
        ladder.drawLine(position);

        //then
        assertThat(ladder.getRows()[0][0]).isEqualTo(1);
        assertThat(ladder.getRows()[0][1]).isEqualTo(-1);
    }

    @Test
    public void 사다리_라인생성_범위처리() throws Exception {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.from(4);
        NaturalNumber row = NaturalNumber.from(2);
        Ladder ladder = new Ladder(row, numberOfPerson);

        //when
        Position position = new Position(NaturalNumber.from(2), NaturalNumber.from(4));

        //then
        assertThatThrownBy(() -> ladder.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class);


    }
    @Test
    public void 사다리_라인생성_예외처리() throws Exception {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.from(2);
        NaturalNumber row = NaturalNumber.from(2);
        Ladder ladder = new Ladder(row, numberOfPerson);
        Position position = new Position(NaturalNumber.from(1), NaturalNumber.from(1));
        Position position1 = new Position(NaturalNumber.from(1), NaturalNumber.from(2));
        ladder.drawLine(position);

        //when

        //then
        assertThatThrownBy(() -> ladder.drawLine(position1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리_이동() throws Exception {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.from(3);
        NaturalNumber row = NaturalNumber.from(4);
        Ladder ladder = new Ladder(row, numberOfPerson);
        ladder.drawLine(new Position(NaturalNumber.from(1), NaturalNumber.from(1)));
        ladder.drawLine(new Position(NaturalNumber.from(2), NaturalNumber.from(2)));
        ladder.drawLine(new Position(NaturalNumber.from(3), NaturalNumber.from(2)));
        ladder.drawLine(new Position(NaturalNumber.from(4), NaturalNumber.from(2)));


        //when
        int result = ladder.run(NaturalNumber.from(1));

        //then
        assertThat(result).isEqualTo(3);

    }

}