module org.a_javafx_test {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.a_javafx_test to javafx.fxml;
    exports org.a_javafx_test;
}
