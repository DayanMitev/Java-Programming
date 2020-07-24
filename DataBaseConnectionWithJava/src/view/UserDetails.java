/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Recreate the following table in MySQl with user.grab or execute the script below
 * <p>
 * //
 */
//create table `app`.user_info
//(
//	id INT not null primary key,
//	name VARCHAR(70),
//	email VARCHAR(60),
//	depatment VARCHAR(60)
//)
public class UserDetails {

    private StringProperty name;
    private StringProperty email;
    private StringProperty department;

    public UserDetails(String name, String email, String department) {
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.department = new SimpleStringProperty(department);
    }

    // Getter
    public StringProperty nameProperty() {// property value
        return name;
    }
    public String getName() { return name.get();    }
    public StringProperty emailProperty() {// property value
        return email;
    }
    public String getEmail() {
        return email.get();
    }
    public StringProperty departmentProperty() {// property value
        return department;
    }
    public String getDepartment() {
        return department.get();
    }

    // Setters
    public void setName(String value) {  name.set(value);    }
    public void setEmail(String value) {
             email.set(value);
    }
    public void setDepartment(String value) {
        department.set(value);
    }
}
