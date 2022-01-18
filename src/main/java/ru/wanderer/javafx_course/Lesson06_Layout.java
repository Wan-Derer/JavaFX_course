/*
https://www.youtube.com/watch?v=GKFJVDBFB3g&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=6
Урок Java 230: FX 6: Layout

https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.nio.file.Path;

public class Lesson06_Layout extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    stage.getIcons().add(new Image(Path.of("src/main/resources/pict/icon.png").toAbsolutePath().toString()));
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);

    Button button = new Button("КНОПКА");
    TextField textField = new TextField();

//    BorderPane borderPane = new BorderPane();
//    borderPane.setMinWidth(400);
//    borderPane.setMinHeight(300);
//    borderPane.setTop(textField);
//    borderPane.setBottom(button);
//
//    root.getChildren().addAll(borderPane);

//    HBox hBox = new HBox(400);
    HBox hBox = new HBox();
    hBox.getChildren().addAll(textField, button);
    hBox.setSpacing(5);
    hBox.setPadding(new Insets(5));



    root.getChildren().add(hBox);

    stage.setTitle("Приложение 6");
    stage.setScene(scene);

    stage.show();

  }



  public static void main(String[] args) {
    launch();
  }
}
