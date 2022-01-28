/*
https://www.youtube.com/watch?v=GKFJVDBFB3g&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=7
Урок Java 231: FX 7: UI Controls

https://docs.oracle.com/javafx/2/ui_controls/jfxupb-ui_controls.htm
 */

package ru.wanderer.javafx_course;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Lesson07_UI_Controls extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    stage.getIcons().add(new Image(new FileInputStream("src/main/resources/pict/icon.png")));
    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);

    MenuBar menuBar = new MenuBar();
    Menu menuFile = new Menu("Файл");
    MenuItem menuItemOpen = new MenuItem("Открыть");
    MenuItem menuItemSave = new MenuItem("Сохранить");
    menuFile.getItems().addAll(menuItemOpen, menuItemSave);
    Menu menuEdit = new Menu("Редактирование");
    MenuItem menuItemCut = new MenuItem("Вырезать");
    MenuItem menuItemCopy = new MenuItem("Скопировать");
    menuEdit.getItems().addAll(menuItemCut, menuItemCopy);
    menuBar.getMenus().addAll(menuFile, menuEdit);

    FlowPane flowPane = new FlowPane();

    Separator sep = new Separator(Orientation.VERTICAL);
    Label label = new Label("Надпись");
    Button button = new Button("КНОПКА");

    final ToggleGroup tg = new ToggleGroup();
    RadioButton rb1 = new RadioButton("РК1");
    rb1.setToggleGroup(tg);
    rb1.setSelected(true);
    RadioButton rb2 = new RadioButton("РК2");
    rb2.setToggleGroup(tg);
    RadioButton rb3 = new RadioButton("РК3");
    rb3.setToggleGroup(tg);

    ToggleButton toggleButton = new ToggleButton("С ФИКСАЦИЕЙ");
    CheckBox checkBox = new CheckBox("Галка");

    flowPane.getChildren().add(label);
    flowPane.getChildren().add(sep);
    flowPane.getChildren().add(button);
    flowPane.getChildren().addAll(rb1, rb2, rb3);
    flowPane.getChildren().add(toggleButton);
    flowPane.getChildren().add(checkBox);

    ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("Один", "Два", "Три"));
    flowPane.getChildren().add(choiceBox);

    TextField textField = new TextField("Текст");
    flowPane.getChildren().add(textField);

    PasswordField passwordField = new PasswordField();
    flowPane.getChildren().add(passwordField);

    Slider slider1 = new Slider(100, 500, 400);
    slider1.setBlockIncrement(100);
    slider1.setMajorTickUnit(50);
    slider1.setMinorTickCount(10);
    slider1.setSnapToTicks(true);
    slider1.setShowTickLabels(true);
    slider1.setShowTickMarks(true);
//    slider1.setOrientation(Orientation.VERTICAL);
    flowPane.getChildren().add(slider1);

    ListView<String> listView = new ListView<>();
    ObservableList<String> items = FXCollections.observableArrayList("Один", "Два", "Три", "Четыре", "Пять", "Шесть");
    listView.setItems(items);
    listView.setMaxHeight(100);
    flowPane.getChildren().add(listView);

    TreeView<String> treeView = new TreeView<>();
    treeView.setMaxHeight(100);
    TreeItem<String> rootItem = new TreeItem<>("Дерево");
    rootItem.setExpanded(true);
    for (int i = 1; i <= 5; i++) {
      rootItem.getChildren().add(new TreeItem<>("Ветка " + i));
    }
    treeView.setRoot(rootItem);
    flowPane.getChildren().add(treeView);

    ObservableList<String> options = FXCollections.observableArrayList("Один", "Два", "Три", "Четыре", "Пять", "Шесть");
    ComboBox<String> comboBox = new ComboBox<>(options);
    flowPane.getChildren().add(comboBox);


    ScrollBar scrollBar1 = new ScrollBar();
    ProgressBar progressBar = new ProgressBar(0.60);
    ProgressIndicator progressIndicator = new ProgressIndicator(0.25);
    Hyperlink hyperlink = new Hyperlink("https://wan-derer.ru");
    Tooltip tooltip1 = new Tooltip("Это ссылка!");
    hyperlink.setTooltip(tooltip1);
    hyperlink.setOnAction(actionEvent -> System.out.println("Клик!"));

    flowPane.getChildren().add(scrollBar1);
    flowPane.getChildren().add(progressBar);
    flowPane.getChildren().add(progressIndicator);
    flowPane.getChildren().add(hyperlink);

    final HTMLEditor editor = new HTMLEditor();
    editor.setPrefHeight(245);
    flowPane.getChildren().add(editor);

    TitledPane titledPane = new TitledPane("Разворачивалка 1", new Button("Кнопка 1"));
    flowPane.getChildren().add(titledPane);

    Accordion accordion = new Accordion();
    accordion.getPanes().addAll(titledPane, new TitledPane("Разворачивалка 2", new Button("Кнопка 2")));
    accordion.setExpandedPane(titledPane);
    flowPane.getChildren().add(accordion);

    ColorPicker colorPicker = new ColorPicker();
    flowPane.getChildren().add(colorPicker);

    Pagination pagination = new Pagination();
    flowPane.getChildren().add(pagination);

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Выбор файла");
    Button fileButton = new Button("Открыть файл");
    fileButton.setOnAction(actionEvent -> fileChooser.showOpenDialog(stage));
    flowPane.getChildren().add(fileButton);


    VBox vBox = new VBox(menuBar, flowPane);
    root.getChildren().add(vBox);


    stage.setTitle("Приложение 7");
    stage.setScene(scene);

    stage.show();

  }


  public static void main(String[] args) {
    launch();
  }
}
