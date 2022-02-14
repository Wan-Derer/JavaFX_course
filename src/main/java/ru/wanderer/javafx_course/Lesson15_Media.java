/*
https://www.youtube.com/watch?v=tChQ3scYfNw&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Урок Java 239: FX 15: Media

https://docs.oracle.com/javase/8/javafx/media-tutorial/
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.nio.file.Path;

public class Lesson15_Media extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
    stage.getIcons().add(icon);
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);
    stage.setTitle("Приложение 15");
    stage.setScene(scene);
    stage.show();

    Media media = new Media(
      Path.of("src/main/resources/audio/abcdef100001.mp3").toUri().toString()
    );
    MediaPlayer player = new MediaPlayer(media);
    player.play();

//    MediaView view = new MediaView(player);
//    root.getChildren().add(view);

  }


  public static void main(String[] args) {
    launch();
  }
}


