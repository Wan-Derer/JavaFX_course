/*
https://www.youtube.com/watch?v=eG4I8vVi4lE&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 244: FX 20: Concurency

https://docs.oracle.com/javase/8/javafx/interoperability-tutorial/concurrency.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class Lesson20_Concurency extends Application {

  @Override
  public void start(Stage stage) throws Exception {
//    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
//    stage.getIcons().add(icon);
//    Group root = new Group();
//    Scene scene = new Scene(root, 640, 480);
//    stage.setTitle("Приложение 20");
//    stage.setScene(scene);
//    stage.show();

    MyService service = new MyService();
    service.setOnSucceeded(workerStateEvent ->
      System.out.println("Выполнено: " + workerStateEvent.getSource().getValue())
    );

    service.start();

  }

  static class MyService extends Service<String>{

    @Override
    protected Task<String> createTask() {
      return new Task<>() {
        @Override
        protected String call() {
          return "Привет, TASK!";
        }
      };
    }
  }


  public static void main(String[] args) {
    launch();
  }
}


