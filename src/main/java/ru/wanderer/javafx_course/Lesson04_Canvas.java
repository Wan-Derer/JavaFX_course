/*
https://www.youtube.com/watch?v=GKFJVDBFB3g&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=4
Урок Java 228: FX 4: Canvas
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Lesson04_Canvas extends Application {
  @Override
  public void start(Stage stage) throws Exception {

    stage.getIcons().add(new Image(new FileInputStream("src/main/resources/pict/icon.png")));

    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);

    Canvas canvas = new Canvas(500, 300);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    drawShapes(gc);

    root.getChildren().add(canvas);
    stage.setTitle("Приложение 4");
    stage.setScene(scene);

    stage.show();

  }

  private void drawShapes(GraphicsContext gc) {
    gc.setFill(Color.GREENYELLOW);
    gc.setStroke(Color.DARKGREEN);
    gc.setLineWidth(5);
    gc.strokeLine(40, 10, 10, 40);
    gc.fillOval(10, 60, 30, 30);
    gc.strokeOval(60, 60, 30, 30);
    gc.fillRoundRect(110, 60, 30, 30, 10, 10);
    gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
    gc.fillArc(10,110,30,30,45,240, ArcType.OPEN);
    gc.fillArc(60,110,30,30,45,240, ArcType.CHORD);
    gc.fillArc(110,110,30,30,45,240, ArcType.ROUND);
    gc.strokeArc(10,160,30,30,45,240, ArcType.OPEN);
    gc.strokeArc(60,160,30,30,45,240, ArcType.CHORD);
    gc.strokeArc(110,160,30,30,45,240, ArcType.ROUND);
    gc.fillPolygon(new double[]{10,40,10,40}, new double[]{210,210,240,240}, 4);
    gc.strokePolygon(new double[]{60,90,60,90}, new double[]{210,210,240,240}, 4);
    gc.strokePolyline(new double[]{110,140,110,140}, new double[]{210,210,240,240}, 4);
  }

  public static void main(String[] args) {
    launch();
  }
}
