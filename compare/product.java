public class product implements Comparable<product> {
    public String name;
    public int prodId;
    public int rating;
    public int price;

    public product(String name, int prodId, int rating, int price) {
        this.name = name;
        this.prodId = prodId;
        this.rating = rating;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(product o) {
        product p = (product) o;

        return this.price - p.price;
    }

}