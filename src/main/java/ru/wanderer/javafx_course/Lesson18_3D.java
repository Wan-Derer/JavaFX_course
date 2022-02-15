/*
https://www.youtube.com/watch?v=iqBlEjcCqP0&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 242: FX 18: Работа с 3D


 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
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

public class Lesson18_3D extends Application {
  private PerspectiveCamera cam;
  private final double camQty = 10;
  private final double camModifier = 50;
  private double mouXold = 0;
  private double mouYold = 0;
  private final double rotModifier = 25;
  private final double camYlim = 15;

  @Override
  public void start(Stage stage) throws Exception {
    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    stage.setTitle("Приложение 18");
    stage.setScene(scene);
    stage.show();

    scene.setFill(Color.DARKGRAY);

//    scene.setOnMouseClicked(mouseEvent -> {
//      Node picked = mouseEvent.getPickResult().getIntersectedNode();
//      if (null != picked) {
//        double scalar = 2;
//        if (picked.getScaleX() > 1) scalar = 1;
//        picked.setScaleX(scalar);
//        picked.setScaleY(scalar);
//        picked.setScaleZ(scalar);
//      }
//    });

    cam = new PerspectiveCamera(true);
    cam.setFarClip(50000.0);
    cam.setTranslateZ(-1000);
    scene.setCamera(cam);

    scene.setOnKeyPressed(keyEvent -> {
      double change = camQty;
      if (keyEvent.isShiftDown()) change = camModifier;

      KeyCode code = keyEvent.getCode();
      if (code == KeyCode.W) cam.setTranslateZ(cam.getTranslateZ() + change);
      if (code == KeyCode.S) cam.setTranslateZ(cam.getTranslateZ() - change);
      if (code == KeyCode.A) cam.setTranslateX(cam.getTranslateX() + change);
      if (code == KeyCode.D) cam.setTranslateX(cam.getTranslateX() - change);
    });

    Rotate xRot = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
    Rotate yRot = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
    cam.getTransforms().addAll(xRot, yRot);

    scene.addEventHandler(MouseEvent.ANY, event -> {
      if (event.getEventType() == MouseEvent.MOUSE_PRESSED || event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
        double mouXnew = event.getSceneX();
        double mouYnew = event.getSceneY();
        if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
          double pitchRot = xRot.getAngle() + (mouYnew - mouYold) / rotModifier;
          pitchRot = Math.min(pitchRot, camYlim);
          pitchRot = Math.max(pitchRot, -camYlim);
          xRot.setAngle(pitchRot);
          double yawRot = yRot.getAngle() - (mouXnew - mouXold) / rotModifier;
          yRot.setAngle(yawRot);
        }
        mouXold = mouXnew;
        mouYold = mouYnew;
      }
    });


    Cylinder cylinder = new Cylinder(100, 200);
    root.getChildren().add(cylinder);

    PhongMaterial blueMat = new PhongMaterial();
    blueMat.setDiffuseColor(Color.DARKCYAN);
    blueMat.setSpecularColor(Color.CYAN);
    cylinder.setMaterial(blueMat);

    cylinder.setRotationAxis(Rotate.X_AXIS);
    cylinder.setRotate(45);


  }


  public static void main(String[] args) {
    launch();
  }
}


