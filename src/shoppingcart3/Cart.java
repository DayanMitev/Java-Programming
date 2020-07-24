package shoppingcart3;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class Cart {
    private Model model = new Model();
    private ObservableList<PurchasedItem> purchasedItems;

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
    private Button btnPurchaseItem;

    @FXML
    private TableView<PurchasedItem> tblPurchasedItems;

    @FXML
    private TableColumn<PurchasedItem, String> colName;

    @FXML
    private TableColumn<PurchasedItem, String> colUnit;

    @FXML
    private TableColumn<PurchasedItem, Double> colUnitQty;

    @FXML
    private TableColumn<PurchasedItem, Double> colUnitPrice;

    @FXML
    private TableColumn<PurchasedItem, Integer> colUnitPurchased;

    @FXML
    private TableColumn<PurchasedItem, String> colTotalPrice;


    @FXML
    void btnPurchaseItemOnAction(ActionEvent event) {
        if (cboSelectedItem.getSelectionModel().getSelectedIndex() >= 0){
            Item item = cboSelectedItem.getSelectionModel().selectedItemProperty().getValue();
            PurchasedItem purchasedItem =
                    new PurchasedItem(item.getName(),item.getUnit(),item.getUnitQuantity(),item.getUnitPrice(), (int) sldSelectUnits.getValue());
            purchasedItems.add(purchasedItem);
        }

    }
    @FXML
    void initialize() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        purchasedItems = FXCollections.observableArrayList();
        tblPurchasedItems.setItems(purchasedItems);
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUnitQty.setCellValueFactory(new PropertyValueFactory<>("unitQuantity"));
        colUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colUnitPurchased.setCellValueFactory(new PropertyValueFactory<>("purchasedUnits"));

        colTotalPrice.setCellValueFactory(cell -> {
            PurchasedItem pi = cell.getValue();
            return new ObjectBinding<String>() {
                @Override
                protected String computeValue() {
                    return nf.format(pi.getUnitPrice() * pi.getPurchasedUnits());
                }
            };
        });

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
