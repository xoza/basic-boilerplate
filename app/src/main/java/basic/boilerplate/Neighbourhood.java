package basic.boilerplate;

import java.util.Iterator;
import java.util.Vector;

public class Neighbourhood {
    public Vector<Cell> cells;

    public Neighbourhood(Vector<Cell> cells) {
        this.cells = cells;
    }

    public void bloom(boolean drawingMode) {
        Iterator<Cell> cell = cells.iterator();
        while (cell.hasNext()) {
            Cell nextCell = cell.next();
            nextCell.deadOrAlive(
                    getAdjacent(nextCell.position)
            );
        }

        if (drawingMode) {
            this.print();
            this.bloom(true);
        }
    }

    private int getAdjacent(Position focusPosition) {
        int adjacent = 0;

        Iterator<Cell> cell = cells.iterator();
        while (cell.hasNext()) {
            if (isAdjacent(focusPosition, cell.next().position)) adjacent++;
        }

        return adjacent;
    }

    private boolean isAdjacent(Position a, Position b) {
        double xDistance = squared((b.horizontalAxysPosition - a.horizontalAxysPosition));
        double yDistance = squared((b.verticalAxysPosition - a.verticalAxysPosition));
        double distance = Math.sqrt(xDistance + yDistance);
        boolean isAdjacent = (distance < 2 && distance != 0);

        return isAdjacent;
    }

    private double squared(int baseNumber) {
        return Math.pow(baseNumber, 2);
    }

    private void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                Iterator<Cell> cell = cells.iterator();
                while (cell.hasNext()) {
                    Cell nextCell = cell.next();
                    if (nextCell.position.horizontalAxysPosition == i
                            && nextCell.position.verticalAxysPosition == j) {
                        if (nextCell.isAlive == true) {
                            System.out.print("O ");
                        } else {
                            System.out.print("X ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

}
