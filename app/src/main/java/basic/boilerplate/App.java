/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package basic.boilerplate;

import java.util.Iterator;
import java.util.Vector;

public class App {

    private Neighbourhood neighbourhood;

    public App(Vector<Cell> cells) {
        this.neighbourhood = new Neighbourhood(cells);
    }

    public void letLifeFoundAWay() {
        this.neighbourhood.bloom();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                Iterator<Cell> cell = this.neighbourhood.cells.iterator();
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
