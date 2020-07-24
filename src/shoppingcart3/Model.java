package shoppingcart3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class Model {
	private ObservableList<Item> itemsObservableList = FXCollections.observableArrayList();
	private Item items[] = new Item[]{
			new Item("Eggs",  "dozen",1 ,2.5),
			new Item("Bread",  "loaf",1,3.25),
			new Item("Butter", "grams",250,2),
			new Item("Cereal", "grams",500,4),
			new Item("Milk", "bottle",1,1)
	};
	public ObservableList<Item> getItemsObservableList() {
		loadData();
		return itemsObservableList;
	}
	void loadData() {
		itemsObservableList.setAll(Arrays.asList(items));
	}
}
//		try (BufferedReader br = new BufferedReader(new FileReader("ItemsMaster.csv"))) {
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				String[] values = line.split(",");
//				Item item = new Item(values[0], values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]));
//				itemsObservableList.add(item);
//			}
//		} catch (NumberFormatException | IOException e) {
//			e.printStackTrace();
//		}