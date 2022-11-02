package com.wizardVadim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable{

    private JFrame frame;
    private Box[][] boxes;;


    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
    }

    private void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * Config.WIDTH + 25, Config.SIZE * Config.HEIGHT + 45); // Редактировать
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("TheGameIsLife");
    }

    private void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int i = 0; i < Config.WIDTH; i++) {
            for (int j = 0; j < Config.HEIGHT; j++) {
                boxes [i][j] = new Box(i, j);
                frame.add(boxes[i][j]);
            }
        }

        for (int i = 0; i < Config.WIDTH; i++) {
            for (int j = 0; j < Config.HEIGHT; j++) {
                for (int si = -1; si <= 1; si++) {
                    for (int sj = -1; sj <= 1; sj++) {
                        if (!(si == 0 && sj == 0)) {
                            boxes[i][j].getCell().addNext(boxes
                                    [(i + si + Config.WIDTH) % Config.WIDTH]
                                    [(j + sj + Config.HEIGHT) % Config.HEIGHT]
                                    .getCell()
                            );
                        }
                    }
                }
            }
        }
    }

    private void initTimer() {
        TimerListener  tl =  new TimerListener();
        Timer timer =  new Timer(Config.SLEEP, tl);
        timer.start();
    }

    private class TimerListener implements ActionListener {

        boolean flop = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int i = 0; i < Config.WIDTH; i++) {
                for (int j = 0; j < Config.HEIGHT; j++) {
                    if (flop) {
                        boxes[i][j].step1();
                    } else {
                        boxes[i][j].step2();
                    }
                }
            }
        }
    }
}
