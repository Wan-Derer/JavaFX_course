/*
https://www.youtube.com/watch?v=4DN054V5Yw4&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 241: FX 17: Графики - Charts

https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/charts.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Lesson17_Charts extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    stage.setTitle("Приложение 17");
    stage.setScene(scene);
    stage.show();

    ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
      new PieChart.Data("Грейпфруты", 13),
      new PieChart.Data("Апельсины", 25),
      new PieChart.Data("Персики", 10),
      new PieChart.Data("Груши", 22),
      new PieChart.Data("Яблоки", 30)
    );

    final PieChart chart = new PieChart(data);
    chart.setTitle("Фрукты");
    root.getChildren().add(chart);



  }




  public static void main(String[] args) {
    launch();
  }
}


