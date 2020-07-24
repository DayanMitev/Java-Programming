module ViewSQLiteTable {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens view to javafx.fxml,javafx.base;
    exports view to javafx.graphics;
}