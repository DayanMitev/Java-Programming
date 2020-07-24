package shoppingcart3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartApplication extends Application {
    public static void main(String[] args) {
            launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root
                = FXMLLoader.load(getClass().getResource("View.fxml"));

        Scene scene = new Scene(root);

        // Set the Window title
        stage.setTitle("Shopping Cart");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
