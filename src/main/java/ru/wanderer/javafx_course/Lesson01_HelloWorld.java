/*
https://www.youtube.com/watch?v=IMYi0bbOKvw&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 225: FX 1: HelloWorld

https://openjfx.io/openjfx-docs/
https://www.jetbrains.com/help/idea/javafx.html
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Lesson01_HelloWorld extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Group group = new Group();
    Scene scene = new Scene(group, 640, 480);

    stage.setTitle("Приложение");
    stage.setScene(scene);

    stage.show();

  }

  public static void main(String[] args) {
    launch();
  }
}
