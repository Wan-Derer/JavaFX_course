/*
https://www.youtube.com/watch?v=PTpJFRAHFG8&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 238: FX 14: FXML

https://docs.oracle.com/javase/8/javafx/fxml-tutorial/
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Lesson14_FXML extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    stage.setTitle("Приложение 14");
    stage.setScene(scene);
    stage.show();

    Parent content = FXMLLoader.load(new URL("file:///" +
        Path.of("src/main/java/ru/wanderer/javafx_course/lesson14.fxml").toAbsolutePath()
      )
    );

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(content);
    root.getChildren().add(borderPane);


  }


  public static void main(String[] args) {
    launch();
  }
}


