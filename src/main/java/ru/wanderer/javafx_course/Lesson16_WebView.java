/*
https://www.youtube.com/watch?v=lB25LIajFHo&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 240: FX 16: Отображение HTML и JavaScript в WebView


 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.io.FileInputStream;

import static javafx.concurrent.Worker.State.SUCCEEDED;

public class Lesson16_WebView extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    stage.setTitle("Приложение 16");
    stage.setScene(scene);
    stage.show();

    WebView webView = new WebView();
    root.getChildren().add(webView);

    WebEngine webEngine = webView.getEngine();
//    webEngine.load("file://......html");
    webEngine.loadContent(
      "<div id='div'>Привет!</div>" +
        "<script>" +
        "document.getElementById('div').style.color='blue';" +
        "function changeColor(){" +
        "   document.getElementById('div').style.color='red';" +
        "   document.getElementById('div').innerHTML = helloClass.getHello('Вася');" +
        "}" +
        "function f1(){" +
        "document.getElementById('div').style.color='green';" +
        "}" +
        "</script>"
    );

    JSObject jsObject = (JSObject) webEngine.executeScript("window");
    jsObject.setMember("helloClass", new HelloClass());

    webEngine.getLoadWorker()
      .stateProperty()
      .addListener((obs, oldValue, newValue) -> {
        if (newValue == SUCCEEDED) {
          webEngine.executeScript("changeColor();");
        }
      });

  }

  public class HelloClass {
    public String getHello(String name){
      System.out.println(">>>>>>>>>>> HelloClass");
      return "Привет, " + name;
    }
  }


  public static void main(String[] args) {
    launch();
  }
}


