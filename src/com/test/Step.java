package com.test;

public class Step {

    private final int row, column, gold;

    public Step(int row, int column, int gold) {
        this.row = row;
        this.column = column;
        this.gold = gold;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getGold() {
        return gold;
    }
}
