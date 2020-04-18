/*
 * Tyler Kerns
 */

package model;

public class Location {
    private int row;
    private int col;

    public Location(int r, int c) {
        row = r;
        col = c;
    }

    public boolean equals(Location loc) {
        boolean sameRow = this.row == loc.getRow();
        boolean sameCol = this.row == loc.getCol();
        return sameRow && sameCol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "[ROW: " + row + " COL: " + col + "]";
    }
}
