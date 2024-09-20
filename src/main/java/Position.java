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

}
