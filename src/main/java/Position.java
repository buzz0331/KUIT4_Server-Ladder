public class Position {
    //선을 그려질 위치 (항상 왼쪽에서 오른쪽으로 선을 긋는걸 원칙으로 함)
    final int x,y;

    public Position(NaturalNumber x, NaturalNumber y) {
        //외부 주입
        this.x = x.getNaturalNumber()-1;
        this.y = y.getNaturalNumber()-1;
    }

    public int getX() {
        return x;
    } //Ladder의 row

    public int getY() {
        return y;
    } //Ladder의 numberOfPerson

    public void verify(int[][] rows) {
        //제대된 라인인지 검증하는 함수
        if (this.x > rows.length - 1) {
            //높이 초과
            throw new IllegalArgumentException("잘못된 라인 생성입니다");
        }
        if (this.y == 0) {
            //첫번째 줄일때
            firstLine(rows);
        }
        if (this.y >= rows[0].length-1) {
            //마지막 줄은 라인 생성 불가
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (this.y > 0 && this.y < rows[0].length-1) {
            //중간 줄일때
            middleLine(rows);
        }
    }

    private void middleLine(int[][] rows) {
        if (rows[this.x][this.y] != 0) {
            //자신
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (this.y-1 != 0 && rows[this.x][this.y - 1] != 0) {
            //왼쪽
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (this.y+1 != rows[0].length && rows[this.x][this.y + 1] != 0) {
            //선이 그려지는 오른쪽
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (this.y+2 != rows[0].length && rows[this.x][this.y + 2] != 0) {
            //두칸 오른쪽
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
    }

    private void firstLine(int[][] rows) {
        if (rows[this.x][this.y] != 0) {
            //자기 자신
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (this.y+1 != rows.length && rows[this.x][this.y+1] != 0) {
            //선이 그려지는 오른쪽
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
        if (this.y+2 != rows.length && rows[this.x][this.y + 2] != 0) {
            //두칸 오른쪽
            throw new IllegalArgumentException("잘못된 라인 생성입니다.");
        }
    }

}
