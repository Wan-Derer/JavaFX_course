/*
https://www.youtube.com/watch?v=6Py7WNolqxw&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 245: FX 21: Swing и Fx

 */

package ru.wanderer.javafx_course;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import javax.swing.*;


public class Lesson21_Swing_and_Fx {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Swing и Java Fx");
    frame.setSize(640, 480);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JFXPanel panel = new JFXPanel();
    frame.add(panel);

    Group group = new Group();
    Scene scene = new Scene(group, Color.ALICEBLUE);
    group.getChildren().add(new Button("КНОПКА"));
    panel.setScene(scene);

  }
}


