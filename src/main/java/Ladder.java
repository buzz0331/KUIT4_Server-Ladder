import java.util.Arrays;

public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
        init(row);
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
        position.verify(rows);
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
}
