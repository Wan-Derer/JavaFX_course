/*
https://www.youtube.com/watch?v=xXsftCRhOfo&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=10
Урок Java 232: FX 8: Кастомный контрол Control

https://docs.oracle.com/javase/8/javafx/fxml-tutorial/custom_control.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

public class Lesson08_Custom_Controls extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);

    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    VBox vBox = new VBox();

    NumberTextField numberTextField = new NumberTextField();
    vBox.getChildren().add(numberTextField);

    CustomControl customControl = new CustomControl();
    vBox.getChildren().add(customControl);

    root.getChildren().add(vBox);

    stage.setTitle("Приложение 8");
    stage.setScene(scene);

    stage.show();

  }


  public static void main(String[] args) {
    launch();
  }
}

class NumberTextField extends TextField {
  static final String numReg = "[0-9]*";

  @Override
  public void replaceText(int start, int end, String text) {
    String oldValue = getText();
    if (validateText(text)) {
      super.replaceText(start, end, text);
      String newText = super.getText();
      if (!validateText(newText)) super.setText(oldValue);
    }
  }

  private boolean validateText(String text) {
    return ("".equals(text) || text.matches(numReg));
  }
}

class CustomControl extends VBox {
  @FXML
  private TextField textField;

  public CustomControl() throws MalformedURLException {
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(new URL("file:///" +
      Path.of("src/main/java/ru/wanderer/javafx_course/lesson08_Custom_Control.fxml").toAbsolutePath()
      )
    );
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException(e);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public String getText() {
    return textField.textProperty().get();
  }

  public void setText(String value) {
    textField.textProperty().set(value);
  }

  public StringProperty textProperty() {
    return textField.textProperty();
  }


  @FXML
  protected void doSomething() {
    System.out.println("Нажато!");
  }

}
