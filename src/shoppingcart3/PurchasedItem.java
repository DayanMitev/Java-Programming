package shoppingcart3;

public class PurchasedItem extends Item {
    private int purchasedUnits;

    public PurchasedItem(String name, String unit, double quantity, double unitPrice, int purchasedUnits) {
        super(name, unit, quantity, unitPrice);
        setPurchasedUnits(purchasedUnits);
    }

    public int getPurchasedUnits() {
        return purchasedUnits;
    }

    public void setPurchasedUnits(int purchasedUnits) {
        if (purchasedUnits >= 0){
            this.purchasedUnits = purchasedUnits;
        }
        else this.purchasedUnits = 0;

    }

    @Override
    public String toString() {
        return "PurchasedItem{" +
                "purchasedUnits=" + purchasedUnits +
                '}';
    }
}
