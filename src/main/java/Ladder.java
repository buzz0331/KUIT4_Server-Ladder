import java.util.Arrays;

public class Ladder {

    private final int[][] rows;

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new int[row.getNaturalNumber()][numberOfPerson.getNaturalNumber()];
        init(row.getNaturalNumber());
    }

    private void init(int row) {
        for (int i = 0; i < row; i++) {
            Arrays.fill(rows[i], 0);
        }
    }

    public int[][] getRows() {
        return rows;
    }

    public void drawLine(Position position) {
        verify(position);
        this.rows[position.getX()][position.getY()] = 1; //오른쪽으로 가는 선
        this.rows[position.getX()][position.getY()+1] = -1; //왼쪽으로 가는 선
    }

    public int run(NaturalNumber startNum) {
        int row = 0; //초기 시작 높이
        int personNum = startNum.getNaturalNumber() - 1; //초기 시작 줄

        while (row < rows.length) {
            int next = rows[row][personNum];
            personNum += next;
            row ++;
        }

        return personNum+1;
    }

    private void verify(Position position) {
        final int x = position.getX();
        final int y = position.getY();
        //제대된 라인인지 검증하는 함수
        if (x > rows.length - 1) {
            //높이 초과
            throw new IllegalArgumentException("잘못된 라인 생성입니다");
        }
        if (y == 0) {
            //첫번째 줄일때
            checkingLine(x, y, Sequence.FIRST);
        }
        if (y >= rows[0].length-1) {
            //마지막 줄은 라인 생성 불가
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (y > 0 && y < rows[0].length-1) {
            //중간 줄일때
            checkingLine(x, y, Sequence.MIDDLE);
        }
    }

    private void checkingLine(int x, int y, Sequence sequence) {
        if (rows[x][y] != 0) {
            //자신
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (y+1 != rows[0].length && rows[x][y + 1] != 0) {
            //선이 그려지는 오른쪽
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (y+2 != rows[0].length && rows[x][y + 2] != 0) {
            //두칸 오른쪽
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (sequence == Sequence.MIDDLE && y-1 != 0 && rows[x][y - 1] != 0) {
            //왼쪽 (가운데 라인을 생성하는 경우만 체크)
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
    }

}
