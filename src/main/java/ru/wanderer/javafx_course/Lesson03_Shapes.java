/*
https://www.youtube.com/watch?v=GKFJVDBFB3g&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=3
Урок Java 227: FX 3: Shapes
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lesson03_Shapes extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);

    Line line = new Line(0, 0, 200, 100);
    line.setStroke(Color.DARKGREEN);
    root.getChildren().add(line);

    Ellipse ellipse = new Ellipse(300, 200, 30, 50);
    ellipse.setStroke(Color.DARKGREEN);
    ellipse.setFill(Color.GREENYELLOW);
    root.getChildren().add(ellipse);

    Text text = new Text(200, 400, "Текст");
    text.setFont(Font.font(100));
    text.setStroke(Color.BLACK);
    text.setFill(Color.GREENYELLOW);
    root.getChildren().add(text);

    stage.setTitle("Приложение 3");
    stage.setScene(scene);

    stage.show();

  }

  // Arc
  // Circle
  // CubicCurve
  // Ellipse
  // Line
  // Path
  // Polygon
  // Polyline
  // QuadCurve
  // Rectangle
  // SVGPath
  // Text

  public static void main(String[] args) {
    launch();
  }
}
