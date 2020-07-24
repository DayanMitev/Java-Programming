package shoppingcart;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class Cart {
    // View view = new View();
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ComboBox<Item> cboSelectedItem;
    @FXML
    private Label lblUnit;
    @FXML
    private Label lblPrice;
    @FXML
    private Label lblPurchasedNumber;
    @FXML
    private Slider sldSelectUnits;
    @FXML
    private Label lblTotalPrice;

    @FXML
    void initialize() {
        Model model = new Model();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        lblTotalPrice.setText(String.format("%s",nf.format(0)));
        DoubleProperty currentPrice = new SimpleDoubleProperty(0);
        //bind cboSelectedItem with data
        cboSelectedItem.setItems(model.getItemsObservableList());
        //attach a listener to cboSelectedItem to display unit quantity and price labels
        //and set the sldSelectUnits back to 0
//        cboSelectedItem.valueProperty().addListener((observable, oldValue, newValue) -> {
//            if (cboSelectedItem.getSelectionModel().getSelectedIndex() >= 0) {
//                lblUnit.setText(String.format("%.2f %s", newValue.getUnitQuantity(), newValue.getUnit()));
//                lblPrice.setText(String.format("$ %.2f", newValue.getUnitPrice()));
//                sldSelectUnits.setValue(0);
//            }
//        });
        cboSelectedItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (cboSelectedItem.getSelectionModel().getSelectedIndex() >= 0) {
                lblUnit.setText(String.format("%.2f %s", newValue.getUnitQuantity(), newValue.getUnit()));
                lblPrice.setText(String.format("$ %.2f", newValue.getUnitPrice()));

                currentPrice.setValue(newValue.getUnitPrice());
                sldSelectUnits.setValue(0);
            }
        });
        //bind purchase units label with slider value
        lblPurchasedNumber.textProperty().bind(Bindings.format("%.0f", sldSelectUnits.valueProperty()));

        NumberBinding unitPrice = new DoubleBinding() {
            {
                super.bind(sldSelectUnits.valueProperty(), currentPrice);
            }
            @Override
            protected double computeValue() {
                if (!lblPrice.getText().isEmpty()){
                    return sldSelectUnits.getValue() * currentPrice.get();
                }
                else return 0;
            }
        };

        unitPrice.addListener((a,b,o)->lblTotalPrice.setText(String.format("%s", nf.format(o.doubleValue()))));
    }
}
