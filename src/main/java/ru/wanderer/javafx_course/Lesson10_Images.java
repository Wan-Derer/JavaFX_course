/*
https://www.youtube.com/watch?v=rgRIs4x0tgs&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=10
Урок Java 234: FX 10: Работа с изображениями

 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Lesson10_Images extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(new FileInputStream("src/main/resources/pict/icon.png"));
        stage.getIcons().add(icon);

        Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        VBox vBox = new VBox();

        Image fxLogo = new Image(new FileInputStream("src/main/resources/pict/fx_logo.jpg"));
        ImageView imageView = new ImageView(fxLogo);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        PixelReader pixelReader = fxLogo.getPixelReader();
        for (int x = 0; x < fxLogo.getWidth(); x++) {
            for (int y = 0; y < fxLogo.getHeight(); y++) {
                Color pixel = pixelReader.getColor(x, y);
//                System.out.println(pixel);
            }
        }

        WritableImage writableImage = new WritableImage((int) fxLogo.getWidth(), (int) fxLogo.getHeight());
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int x = 0; x < fxLogo.getWidth(); x++) {
            pixelWriter.setColor(x, (int) (fxLogo.getHeight() / 2), Color.BLACK);
        }
        for (int y = 0; y < fxLogo.getHeight(); y++) {
            pixelWriter.setColor((int) (fxLogo.getWidth() / 2), y, Color.BLACK);
        }

        ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png",
                new FileOutputStream("src/main/resources/pict/cross.png"));


        vBox.getChildren().add(imageView);
        vBox.getChildren().add(new ImageView(writableImage));
        root.getChildren().add(vBox);
        stage.setTitle("Приложение 10");
        stage.setScene(scene);

        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}

