package ru.gb.java.manoschenkova.queen;

public class Position {
    private int row, column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isAttack(Position position) {
        // row
        if (this.row == position.getRow()) {
            return true;
        }
        // col
        if (this.column == position.getColumn()) {
            return true;
        }
        // diagonal
        int rowOffset = Math.abs(this.row - position.getRow());
        int colOffset = Math.abs(this.column - position.getColumn());
        if (rowOffset == colOffset) {
            return true;
        }

        return false;
    }

}
