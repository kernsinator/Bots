package model;

public class Bot extends Entity implements Movable {
    private Directions direction;
    private int moveSpeed;

    public Bot( Location l, int id, Directions dir) {
        super(l, id);
        this.direction = dir;
        moveSpeed = SLOW_SPEED;
    }

    public boolean move(Map m) {
        boolean botMoved = false;
        if(validBotMove(m)) {
            moveNumSpaces(moveSpeed, m);
            botMoved = true;
        } else {
            System.out.println("Invalid move!");
        }
        return botMoved;
    }

    public void moveNumSpaces(int spaces, Map m) {
        if (direction == Directions.UP) {
            getLoc().setRow(getLoc().getRow() - spaces);
        } else if (direction == Directions.RIGHT) {
            getLoc().setCol(getLoc().getCol() + spaces);
        } else if (direction == Directions.DOWN) {
            getLoc().setRow(getLoc().getRow() + spaces);
        } else if (direction == Directions.LEFT) {
            getLoc().setCol(getLoc().getCol() - spaces);
        }
    }

    public boolean validBotMove(Map m) {
        boolean valid;
        if (direction == Directions.UP) {
            valid = validCell(m, getLoc().getRow() - moveSpeed, getLoc().getCol()) && movePathClear(m));
        } else if (direction == Directions.DOWN) {
            valid = validCell(m, getLoc().getRow() + moveSpeed, getLoc().getCol()) && movePathClear(m));
        } else if (direction == Directions.RIGHT) {
            valid = validCell(m, getLoc().getRow(), getLoc().getCol() + moveSpeed) && movePathClear(m));
        } else {
            valid = validCell(m, getLoc().getRow(), getLoc().getCol() - moveSpeed) && movePathClear(m));
        }
        return valid;
    }

    public boolean validCell(Map m, int row, int col) {
        boolean validRow = validRow(m, row);
        boolean validCol = validCol(m, col);
        boolean cellNotOccupied = false;
        if(validCol && validRow) {
            cellNotOccupied = m.getBotMap()[row][col] == null;
        }
        return validCol && validRow && cellNotOccupied;
    }

}
