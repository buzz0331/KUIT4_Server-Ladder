package ladder;

import static ladder.Direction.*;

public class Node {

    private Direction direction;

    public Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public void setRightNode(Position position) {
        direction = RIGHT;
    }

    public void setLeftNode(Position position) {
        direction = LEFT;
    }

    public void move(Position position) {
        if (isRight()) {
            position.next();
            return;
        }
        if (isLeft()) {
            position.prev();
            return;
        }
    }

    private boolean isRight() {
        return direction == RIGHT;
    }

    private boolean isLeft() {
        return direction == LEFT;
    }

    public boolean isAlreadySetDirection() {
        return isNone();
    }

    private boolean isNone() {
        return direction == NONE;
    }

}
