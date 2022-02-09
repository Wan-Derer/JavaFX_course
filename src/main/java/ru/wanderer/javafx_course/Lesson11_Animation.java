/*
https://www.youtube.com/watch?v=3uILUbkR1Ls&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок по Java 235: FX 11: Анимация

https://docs.oracle.com/javafx/2/animations/basics.htm
 */

package ru.wanderer.javafx_course;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Lesson11_Animation extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    stage.setTitle("Приложение 11");
    stage.setScene(scene);
    stage.show();


    Image image = new Image(new FileInputStream("src/main/resources/pict/fx_logo.jpg"));
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(640);
    imageView.setFitHeight(480);
    root.getChildren().add(imageView);

    FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), imageView);
    fadeOut.setFromValue(1.0);
    fadeOut.setToValue(0.0);
    fadeOut.setCycleCount(Timeline.INDEFINITE);
    fadeOut.setAutoReverse(true);
    fadeOut.play();


    Rectangle rectPath = new Rectangle(0, 0, 40, 40);
    rectPath.setFill(Color.ORANGE);
    root.getChildren().add(rectPath);

//    Path path = new Path();
//    path.getElements().add(new MoveTo(20,20));
//    path.getElements().add(new CubicCurveTo(380,0,380,120,200,120));
//    path.getElements().add(new CubicCurveTo(0,120,0,240,380,240));
//    PathTransition pathTransition = new PathTransition();
//    pathTransition.setDuration(Duration.millis(4000));
//    pathTransition.setPath(path);
//    pathTransition.setNode(rectPath);
//    pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//    pathTransition.setCycleCount(Timeline.INDEFINITE);
//    pathTransition.setAutoReverse(true);
//    pathTransition.play();

    FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), rectPath);
    fadeTransition.setFromValue(1.0);
    fadeTransition.setToValue(0.3);
    fadeTransition.setCycleCount(3);
    fadeTransition.setAutoReverse(true);
    TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), rectPath);
    translateTransition.setFromX(50);
    translateTransition.setToX(350);
    translateTransition.setCycleCount(2);
    translateTransition.setAutoReverse(true);
    RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), rectPath);
    rotateTransition.setByAngle(180.0);
    rotateTransition.setCycleCount(4);
    rotateTransition.setAutoReverse(true);
    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectPath);
    scaleTransition.setToX(2.0);
    scaleTransition.setToY(2.0);
    scaleTransition.setCycleCount(2);
    scaleTransition.setAutoReverse(true);

//    ParallelTransition parallelTransition = new ParallelTransition();
//    parallelTransition.getChildren().addAll(
//      fadeTransition,
//      translateTransition,
//      rotateTransition,
//      scaleTransition
//    );
//    parallelTransition.setCycleCount(Animation.INDEFINITE);
//    parallelTransition.setAutoReverse(true);
//    parallelTransition.play();

    SequentialTransition sequentialTransition = new SequentialTransition();
    sequentialTransition.getChildren().addAll(
      fadeTransition,
      translateTransition,
      rotateTransition,
      scaleTransition
    );
    sequentialTransition.setCycleCount(Animation.INDEFINITE);
    sequentialTransition.setAutoReverse(true);
    sequentialTransition.play();


    Rectangle rectangle = new Rectangle(200, 200, 50, 50);
    root.getChildren().add(rectangle);

    KeyValue xValue = new KeyValue(rectangle.xProperty(), 300);
    KeyValue yValue = new KeyValue(rectangle.yProperty(), 300);

    KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), xValue, yValue);

    Timeline timeline = new Timeline();
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.setAutoReverse(true);
    timeline.getKeyFrames().add(keyFrame);
    timeline.play();


  }


  public static void main(String[] args) {
    launch();
  }
}

