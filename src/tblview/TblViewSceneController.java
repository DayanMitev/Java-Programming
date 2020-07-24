package tblview;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.time.temporal.ChronoUnit.YEARS;


public class TblViewSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Person> tblPersonDetails;
    @FXML
    private TableColumn<Person, Integer> colId;
    @FXML
    private TableColumn<Person, String> colFirstName;
    @FXML
    private TableColumn<Person, String> colLastName;
    @FXML
    private TableColumn<Person, String> colBirthday;

    @FXML
    private Button btnLoadData;

    @FXML
    void initialize() {
        final ObservableList<Person> data
                = FXCollections.observableArrayList(
                new Person("Ivan", "Petrov", LocalDate.of(2019, 3, 11)),
                new Person("Anelia", "Ivanova", LocalDate.of(2020, 10, 1)),
                new Person("Emil", "Georgiev", LocalDate.of(2020, 6, 17)),
                new Person("Asen", "Botev", LocalDate.of(2020, 4, 19)),
                new Person("Vasil", "Petrov", LocalDate.of(2020, 5, 8))
        );
        tblPersonDetails.setItems(data);
        colId.setCellValueFactory(new PropertyValueFactory<>("personId"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        // tblPersonDetails.getItems().add(new Person("Maria", "Petrova", LocalDate.of(2020, 5, 8)));
//        TableColumn<Person, String> ageCol = new TableColumn<>("Age");
//        ageCol.setCellValueFactory(cellData -> {
//            Person p = cellData.getValue();
//            LocalDate dob = p.getBirthDate();
//            String ageInYear = "Unknown";
//            if (dob != null) {
//                long years = YEARS.between(dob, LocalDate.now());
//                if (years == 0) {
//                    ageInYear = "< 1 year";
//                } else if (years == 1) {
//                    ageInYear = years + " year";
//                } else {
//                    ageInYear = years + " years";
//                }
//            }
//            return new ReadOnlyStringWrapper(ageInYear);
//        });
    }
}

//    public static ObservableList<Person> getPersonList() {
//        Person p1 = new Person("Ashwin", "Sharan", LocalDate.of(2012, 10, 11));
//        Person p2 = new Person("Advik", "Sharan", LocalDate.of(2012, 10, 11));
//        Person p3 = new Person("Layne", "Estes", LocalDate.of(2011, 12, 16));
//        Person p4 = new Person("Mason", "Boyd", LocalDate.of(2003, 4, 20));
//        Person p5 = new Person("Babalu", "Sharan", LocalDate.of(1980, 1, 10));
//        return FXCollections.<Person>observableArrayList(p1, p2, p3, p4, p5);
//    }
