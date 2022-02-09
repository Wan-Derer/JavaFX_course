/*
https://www.youtube.com/watch?v=7PnnCvJM3Tg&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 237: FX 13: CSS

https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/apply-css.htm
http://aquafx-project.com

 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.file.Path;

public class Lesson13_CSS extends Application {
  @Override
  public void start(Stage stage) throws Exception {
//    Application.setUserAgentStylesheet(new URL("file:///" +
//      Path.of("src/main/java/ru/wanderer/javafx_course/lesson13.css")
//        .toAbsolutePath()).toString());

    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    scene.getStylesheets().add(
      new URL("file:///" +
      Path.of("src/main/java/ru/wanderer/javafx_course/lesson13.css")
        .toAbsolutePath()).toString()
    );
    stage.setTitle("Приложение 13");
    stage.setScene(scene);
    stage.show();

    VBox vBox = new VBox();
    root.getChildren().add(vBox);

    Button button = new Button("КНОПКА");
    button.setId("but1");
    vBox.getChildren().add(button);

    Button b2 = new Button("Кнопка2");
    b2.setStyle("-fx-background-color: red; -fx-font-size: 30; -fx-opacity: 0.6");
    vBox.getChildren().add(b2);

    Button b3 = new Button("Кнопка III");
    b3.getStyleClass().add("otherStyle");
    vBox.getChildren().add(b3);

  }


  public static void main(String[] args) {
    launch();
  }
}

