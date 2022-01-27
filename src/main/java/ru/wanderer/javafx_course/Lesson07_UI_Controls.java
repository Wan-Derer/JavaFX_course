/*
https://www.youtube.com/watch?v=GKFJVDBFB3g&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=7
Урок Java 231: FX 7: UI Controls


 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Lesson07_UI_Controls extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    stage.getIcons().add(new Image(new FileInputStream("src/main/resources/pict/icon.png")));
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);

    Button button = new Button("КНОПКА");







    stage.setTitle("Приложение 7");
    stage.setScene(scene);

    stage.show();

  }



  public static void main(String[] args) {
    launch();
  }
}
