package com.swingy.app;

/**
 * Hello world!
 *
 */

import java.sql.*;
import com.swingy.controls.*;
import com.swingy.models.Player;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.swingy.views.Colors;

public class App {
    static MysqlConnect conn = MysqlConnect.getDbCon();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Player player = new Player();
        player.setHeroName("Malibu");

        try {
            ResultSet rSet = conn.query("SELECT * FROM Players");
            rSet.next();
            System.out.println(rSet.getString("Name"));
            rSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // } catch (SQLException e) {

        // e.printStackTrace();
        // }
        if (args.length < 1) {
            String text = Colors._CYAN
                    + "\nWelcome to the hero war game.\nStarting mode can be chosen\nbetween Console (Default) and GUI. You can choose to\ncreate a new hero or choose from previously created heros.\nIf there are no previously created\nheros, you'll be required to create a new hero.\n\n"
                    + Colors._RESET;
            int i;
            for (i = 0; i < text.length(); i++) {
                System.out.printf("%c", text.charAt(i));
                try {
                    if (text.charAt(i) == '.')
                        Thread.sleep(500);
                    else
                        Thread.sleep(80);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.print("Would you like to create a new hero? (y|n) : ");
            String opt = scn.nextLine().trim();
            System.out.println(opt);
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
