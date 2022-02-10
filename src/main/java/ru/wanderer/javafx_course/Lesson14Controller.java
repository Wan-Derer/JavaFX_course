package ru.wanderer.javafx_course;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Lesson14Controller implements Initializable {

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  @FXML
  public void print() {
    System.out.println("Обработка меню");
  }


}
