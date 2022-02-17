/*
https://www.youtube.com/watch?v=wqHsWoTN1QM&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 243: FX 19: Collections

https://docs.oracle.com/javase/8/javafx/collections-tutorial/collections.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Lesson19_Collections extends Application {

  @Override
  public void start(Stage stage) throws Exception {
//    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
//    stage.getIcons().add(icon);
//    Group root = new Group();
//    Scene scene = new Scene(root, 640, 480);
//    stage.setTitle("Приложение 19");
//    stage.setScene(scene);
//    stage.show();

    List<String> list = new ArrayList<>();
    ObservableList<String> observableList = FXCollections.observableList(list);

    observableList.addListener((ListChangeListener<String>) System.out::println);

    observableList.add("Один");
    list.add("Два");

    System.out.println(list);
    System.out.println(observableList);

  }


  public static void main(String[] args) {
    launch();
  }
}


