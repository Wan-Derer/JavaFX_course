/*
https://www.youtube.com/watch?v=IMYi0bbOKvw&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 225: FX 1: HelloWorld

https://openjfx.io/openjfx-docs/
https://www.jetbrains.com/help/idea/javafx.html
https://docs.oracle.com/javase/8/javafx/get-started-tutorial/index.html
https://docs.oracle.com/javase/8/javafx/graphics-tutorial/
https://docs.oracle.com/javase/8/javafx/api/toc.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.nio.file.Path;

public class Lesson01_HelloWorld extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    // https://stackoverflow.com/questions/10121991/javafx-application-icon
    stage.getIcons().add(new Image(Path.of("src/main/resources/pict/icon.png").toAbsolutePath().toString()));

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
