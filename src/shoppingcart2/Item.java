package shoppingcart2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {

	private StringProperty name;
	private StringProperty unit;
	private DoubleProperty unitQuantity;
	private DoubleProperty unitPrice;

	public Item(String name, String unit,  double quantity, double unitPrice) {
		this.name = new SimpleStringProperty(name);
		this.unit = new SimpleStringProperty(unit);
		this.unitQuantity = new SimpleDoubleProperty(quantity);
		this.unitPrice = new SimpleDoubleProperty(unitPrice);
	}

	// Getter
	public final StringProperty nameProperty() {// property value
		return name;
	}
	public final String getName() { return name.get();    }
	public final StringProperty unitProperty() {// property value
		return unit;
	}
	public final String getUnit() {
		return unit.get();
	}
	public final DoubleProperty unitQuantityProperty() {// property value
		return unitQuantity;
	}
	public final Double getUnitQuantity() {
		return unitQuantity.get();
	}
	public final DoubleProperty unitPriceProperty() {// property value
		return unitQuantity;
	}
	public final Double getUnitPrice() {
		return unitPrice.get();
	}

	// Setters
	public final void setName(String value) {
		if (value != null)
			name.set(value);
		else
			name.set("Name");
	}
	public final void setUnit(String value) {
		if (value != null)
			unit.set(value);
		else
			unit.set("Unit");
	}
	public final void setUnitQuantity(Double value) {
		if (value != null && value > 0)
			unitQuantity.set(value);
		else
			unitQuantity.set(0);
	}
	public final void setUnitPrice(Double value) {
		if (value != null && value > 0)
			unitPrice.set(value);
		else
			unitPrice.set(0);
	}

	@Override
	public String toString() {  //this is needed for ComboBox
		return getName();
	}
	/*
	private String name;
	private String unit;
	private double unitQuantity;
	private double unitPrice;

	// Constructor, Getter and Setter and tostring()
	Item(String name, String unit,  double quantity, double unitPrice) {
		setName(name);
		setUnit(unit);
		setUnitQuantity(quantity);
		setUnitPrice(unitPrice);
	}
	@Override
	public String toString() {  //this is needed for ComboBox
		return name;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getUnit() {
		return unit;
	}
	public final void setUnit(String unit) {
		this.unit = unit;
	}
	public final double getUnitQuantity() {
		return unitQuantity;
	}
	public final void setUnitQuantity(double unitQuantity) {
		this.unitQuantity = unitQuantity;
	}
	public final double getUnitPrice() {
		return unitPrice;
	}
	public final void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	 */
}
