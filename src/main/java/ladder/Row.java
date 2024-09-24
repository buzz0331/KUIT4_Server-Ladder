package ladder;

import static ladder.Direction.*;

public class Row {
    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(NONE);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
    }

    //사다리의 Line을 랜덤으로 자동 생성할때 사용하는 메서드
    public void drawRandomLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        validateSideDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
    }

    public void nextPosition(Position position) {
        validatePosition(position);

        nodes[position.getValue()].move(position);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private void validateSideDrawLinePosition(Position startPosition) {
        //그리는 선 오른쪽 검증
        startPosition.next();
        validatePosition(startPosition);

        //그리는 선 왼쪽 검증
        startPosition.prev();
        startPosition.prev();
        validatePosition(startPosition);

        startPosition.next();

    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) ;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

    public void printRow() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].printNode();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printStarRow(Position position) {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].printNode();

            if (position.isSamePosition(i)) {
                System.out.print("*");
            }

            System.out.print(" ");
        }
        System.out.println();
    }

}