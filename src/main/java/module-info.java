module ru.wanderer.javafx_course {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.web;

    opens ru.wanderer.javafx_course to javafx.fxml;
    exports ru.wanderer.javafx_course;
}

