module ru.wanderer.javafx_course {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.web;
    requires javafx.swing;
    requires java.desktop;
  requires javafx.media;
  requires jdk.jsobject;

  opens ru.wanderer.javafx_course to javafx.fxml;
    exports ru.wanderer.javafx_course;
}

