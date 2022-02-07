/*
https://www.youtube.com/watch?v=xXsftCRhOfo&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=9
Урок Java 233: FX 9: Обработка событий

https://docs.oracle.com/javafx/2/events/convenience_methods.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Lesson09_Events_Handle extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
        stage.getIcons().add(icon);

        Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        VBox vBox = new VBox();

        Button button = new Button("КНОПКА");
        button.setOnMouseClicked(event-> System.out.println("НАЖАТО!"));
        button.addEventHandler(MouseEvent.MOUSE_RELEASED, actionEvent -> System.out.println("отпущено!"));

        root.getChildren().add(button);
        stage.setTitle("Приложение 9");
        stage.setScene(scene);

        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}

