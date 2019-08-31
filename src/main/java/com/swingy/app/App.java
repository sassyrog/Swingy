package com.swingy.app;

/**
 * Hello world!
 *
 */

import java.sql.*;
import com.swingy.controls.*;
import com.swingy.models.Hero;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.Scanner;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.swingy.views.Colors;
import com.swingy.views.TypeWriter;

public class App {
    static MysqlConnect conn = MysqlConnect.getDbCon();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        if (args.length < 1) {
            try {
                ResultSet rSet = conn.query("SELECT 1 FROM Players LIMIT 1;");
                if (rSet.next() != false) {
                    new TypeWriter(Colors._CYAN + "\nWelcome back!!!\n\n" + Colors._RESET);
                } else {
                    new TypeWriter(Colors._CYAN
                            + "\nWelcome to the hero war game.\nStarting mode can be chosen\nbetween Console (Default) and GUI. You can choose to\ncreate a new hero or choose from previously created heros.\nIf there are no previously created\nheros, you'll be required to create a new hero.\n\n"
                            + Colors._RESET);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {

                System.out.print(Colors._WHITE + "Would you like to create a new hero? (Y|N) : " + Colors._RESET);
                while (true) {
                    String inpuString = scn.nextLine().trim();
                    if (inpuString.equals("n") || inpuString.equals("N")) {
                        ResultSet rSet = conn.query("SELECT * FROM Players ORDER BY Experience ASC LIMIT 10");

                        new TypeWriter(Colors._CYAN
                                + "\nHere are the Top 10 heros, based on experience points,\nthat have been previously created. Please select a hero\nusing their Hero ID e.g 123.\n\n"
                                + Colors._RESET, 40);
                        HeroFactory hf = new HeroFactory();
                        conn.printHeros(rSet);
                        System.out.print(Colors._WHITE + "Please enter hero by ID : " + Colors._RESET);
                        Hero hero = hf.newHero(scn.nextInt());
                        System.out.println("----> " + hero.getExperience());
                        break;
                    } else if (inpuString.equals("y") || inpuString.equals("Y")) {
                        System.out.println("----yes----");
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            for (String i : args) {
                System.out.println(i);
            }
        }

        // JFrame frame = new JFrame("Roger");

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setPreferredSize(new Dimension(900, 600));
        // frame.getContentPane().setBackground(Color.BLACK);

        // JLabel label = new JLabel("I'm here");
        // label.setPreferredSize(new Dimension(300, 100));
        // frame.setFocusable(true);
        // frame.getContentPane().add(label, BorderLayout.CENTER);

        // frame.addKeyListener(new KeyListener() {
        // public void keyTyped(KeyEvent e) {
        // }

        // public void keyPressed(KeyEvent e) {
        // System.out.println("key : " + e.getKeyCode());
        // }

        // public void keyReleased(KeyEvent e) {
        // }
        // });
        // frame.pack();
        // frame.setVisible(true);
        // while (true) {
        // frame.repaint();
        // // System.out.println("Hello World!");
        // }
        // jFrame.setBackground(new Color(255));
        scn.close();
    }
}
