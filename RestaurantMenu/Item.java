public class Item {
    private String name;
    private float price;
    private boolean inStock;
    private String category;

    public Item(String name, float price, boolean inStock, String category) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getCategory() {
        return category;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}