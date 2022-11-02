package com.wizardVadim;

import java.util.ArrayList;

public class Cell {
    private ArrayList<Cell> next;
    private Status status;

    public Cell() {
        status = Status.NONE;
        next = new ArrayList<>();
    }

    public void addNext(Cell cell) {
        next.add(cell);
    }

    public void step1() {
        int around = countNextCells();
        status = status.step1(around);
    }

    public void step2() {
        status = status.step2();
    }

    public int countNextCells() {
        int count = 0;
        for (Cell cell : next) {
            if (cell.status.isCell()) {
                count++;
            }
        }
        return count;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public void turn() {
        for (Cell cell : next) {
            cell.status = cell.status.isCell() ? Status.NONE : Status.LIVE;
        }
    }

}
