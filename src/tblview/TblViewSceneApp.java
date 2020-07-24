package tblview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TblViewSceneApp extends Application {
    public static void main(String[] args) {
            launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root
                = FXMLLoader.load(getClass().getResource("TblViewScene.fxml"));

        Scene scene = new Scene(root);

        // Set the Window title
        stage.setTitle("TableView Personal Details");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
