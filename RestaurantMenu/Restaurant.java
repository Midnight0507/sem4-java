class Restaurnat{
    String name;
    float stars;
    Item[] menu_Items;
    public Restaurnat(String name, float starts, Item[] menu_Items) {
        super();
        this.name = name;
        this.stars = starts;
        this.menu_Items = menu_Items;
    }

    public boolean order(Item items) {
        System.out.println("Order Received");
        return true;
    }
    
    public float bill ( Item[] i) {
        float sum = 0;
        for (int j = 0; j<i.length; j++) {
            if(i[j] != null) {
                sum += i[j].getPrice();
            }
        }
        return sum;
    }
}