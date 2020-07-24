module JFXCollectionSamples {
    requires javafx.controls;
    requires javafx.fxml;
    opens tblview.date to javafx.fxml, javafx.base;
    exports tblview.date to javafx.graphics;

    opens shoppingcart to javafx.fxml;
    exports shoppingcart to javafx.graphics;
    opens shoppingcart2 to javafx.fxml, javafx.base;
    exports shoppingcart2 to javafx.graphics;
    opens shoppingcart3 to javafx.fxml, javafx.base;
    exports shoppingcart3 to javafx.graphics;
    opens tblview to javafx.fxml, javafx.base;
    exports tblview to javafx.graphics;


}