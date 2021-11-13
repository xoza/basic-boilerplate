package basic.boilerplate;

public class Cell {
    public boolean isAlive = true;
    public Position position;

    public Cell(Position position) {
        this.position = position;
    }

    public void deadOrAlive(int adjacent) {
        if (adjacent == 3) {
            this.isAlive = true;
        } else if (adjacent != 2) {
            this.isAlive = false;
        }
    }

}
