/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.*;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLuserController   {

    // update generic parameters after creating the Scene FXML
    @FXML
    private TableView<UserDetails> tblUserDetails;
    @FXML
    private TableColumn<UserDetails, String> colName;
    @FXML
    private TableColumn<UserDetails, String> colEmail;
    @FXML
    private TableColumn<UserDetails, String> colDepartment;
    @FXML
    private Button btnLoadDetails;

    private ObservableList<UserDetails> data;

    @FXML
    private Button btnSort;

    /**
     * Initializes the controller class.
     */
    private DbConnection dc;
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DbConnection();
    }

    @FXML
    private void btnSortOnAction(ActionEvent event) {

        Comparator<UserDetails> c1 = (u1, u2) -> -u1.getName().compareTo(u2.getName());
        Comparator<UserDetails> c2 = (u1, u2) -> u1.getDepartment().compareTo(u2.getDepartment());
        FXCollections.sort(data, c2.thenComparing(c1));
    }

    @FXML
    private void btnLoadDetailsOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM userInfo LIMIT 100";
        data = FXCollections.observableArrayList();

        try (Connection conn = dc.connect();
             PreparedStatement  ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                data.add(new UserDetails(rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // load TableView with Observablelist
        tblUserDetails.setItems(null);
        tblUserDetails.setItems(data);
        // Set cell value factory to tableview
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
    }
}
