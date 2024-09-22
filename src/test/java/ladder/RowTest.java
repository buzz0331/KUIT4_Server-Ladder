package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RowTest {

    @Test
    void 한_칸_사다리_이동() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);

        //given
        Position position = Position.from(0);
        row.nextPosition(position);

        //then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 두_칸_사다리_선_이동() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //given
        Position position = Position.from(0);
        row.nextPosition(position);

        //then
        assertThat(position.getPosition() ).isEqualTo(1);

        //given
        position = Position.from(1);
        row.nextPosition(position);

        //then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 세_칸_사다리_선_이동() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //given
        Position position = Position.from(0);
        row.nextPosition(position);

        //then
        assertThat(position.getPosition()).isEqualTo(1);

        //given
        position = Position.from(1);
        row.nextPosition(position);

        //then
        assertThat(position.getPosition()).isEqualTo(0);

        //given
        position = Position.from(2);
        row.nextPosition(position);

        //then
        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThatThrownBy(() -> new Row(GreaterThanOne.from(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_최대_사람수_초과_예외() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //given

        //then
        assertThatThrownBy(() -> row.nextPosition(Position.from(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_최소_사람수_미만_예외() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //given

        //then
        assertThatThrownBy(() -> row.nextPosition(Position.from(-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_위치_초과_예외() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //given
        Position position = Position.from(3);

        //then
        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_위치_미만_예외() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //given

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_좌측_선_중복_예외() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_우측_선_중복_예외() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(1));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(0)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}