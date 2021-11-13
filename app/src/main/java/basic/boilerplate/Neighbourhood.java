package basic.boilerplate;

import java.util.Iterator;
import java.util.Vector;

public class Neighbourhood {
    private Vector<Cell> neighbourhood;

    public Neighbourhood(Vector<Cell> cells) {
        this.neighbourhood = cells;
    }

    public void bloom() {
        Iterator<Cell> cell = neighbourhood.iterator();
        while (cell.hasNext()) {
            Cell nextCell = cell.next();
            nextCell.deadOrAlive(
                    getAdjacent(nextCell.position)
            );
        }
    }

    private int getAdjacent(Position focusPosition) {
        int adjacent = 0;

        Iterator<Cell> cell = neighbourhood.iterator();
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

}
