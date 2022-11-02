package com.wizardVadim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JPanel {

    private Cell cell;


    public Box (int x, int y)
    {
        super();
        cell = new Cell();
        setBounds(x * Config.SIZE, y * Config.SIZE, Config.SIZE, Config.SIZE);
        setBackground(Config.getColor(Status.NONE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cell.turn();
            }
        });
    }

    public Cell getCell() {
        return cell;
    }

    public void initCells(int x, int y) {

    }

    public void setColor() {
        setBackground(Config.getColor(cell.getStatus()));
    }

    public void step1() {
        cell.step1();
        setColor();
    }

    public void step2() {
        cell.step2();
        setColor();
    }

}
