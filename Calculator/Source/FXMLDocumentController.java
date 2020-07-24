package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController extends AnchorPane {

    private enum Operation {
        PLUS, MINUS, DIVIDE, MULT, NO_OP
    };
    private Operation operation;
    private double input;
    private double result;

    private Alert mb;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSubstract;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnQuit;
    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn5;

    @FXML
    private Button btn4;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn0;

    @FXML
    private Button btn00;


    @FXML
    void btn00OnAction(ActionEvent event) {
        showDigit("00");
    }

    @FXML
    void btn0OnAction(ActionEvent event) {
        showDigit("0");
    }

    @FXML
    void btn1OnAction(ActionEvent event) {
        showDigit("1");
    }

    @FXML
    void btn2OnAction(ActionEvent event) {
        showDigit(btn2.getText());
    }

    @FXML
    void btn3OnAction(ActionEvent event) {
        showDigit("3");
    }

    @FXML
    void btn4OnAction(ActionEvent event) {
        showDigit("4");
    }

    @FXML
    void btn5OnAction(ActionEvent event) {
        showDigit("5");
    }

    @FXML
    void btn6OnAction(ActionEvent event) {
        showDigit("6");
    }

    @FXML
    void btn7OnAction(ActionEvent event) {
        showDigit("7");
    }

    @FXML
    void btn8OnAction(ActionEvent event) {
        showDigit("8");
    }

    @FXML
    void btn9OnAction(ActionEvent event) {
        showDigit("9");
    }

    private void showDigit(String digit) {
        String text = txtInput.getText();
        if (text.equals("0")) {
            txtInput.setText(digit);
        } else {
            txtInput.setText(text + digit);
        }
    }

    private void doOperation(Operation op) {
        input = Double.parseDouble(txtInput.getText());
        operation = op;
        txtInput.setText("0");
    }

    @FXML
    void btnClearAllOnAction(ActionEvent event) {
        txtInput.setText("0");
        operation = Operation.NO_OP;
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtInput.setText("0");
    }

    @FXML
    void btnComputeOnAction(ActionEvent event) {
        result = Double.parseDouble(txtInput.getText());
        switch (operation) {
            case MULT:
                result *= input;
                break;
            case DIVIDE:
                result = input / result;
                break;
            case PLUS:
                result = result + input;
                break;
            case MINUS:
                result = input - result;
                break;
            default:
                return;
        }
        txtInput.setText("" + result);
        operation = Operation.NO_OP;
    }

    @FXML
    void btnDivideOnAction(ActionEvent event) {
        doOperation(Operation.DIVIDE);
    }

    @FXML
    void btnDotOnAction(ActionEvent event) {
        showDigit(".");
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event) {
        doOperation(Operation.MULT);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) { // ask to quit
        if ( ButtonType.OK == mb.showAndWait().get()) {
            Platform.exit();
        }

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        doOperation(Operation.PLUS);
    }

    @FXML
    void btnSubstractOnAction(ActionEvent event) {
        doOperation(Operation.MINUS);
    }

    @FXML
    void initialize() {
        operation = Operation.NO_OP;
        mb = new Alert(Alert.AlertType.CONFIRMATION);
        mb.setTitle("Quit");
        mb.setHeaderText(null);
        mb.setContentText("Do you really want to quit?");

    }
}