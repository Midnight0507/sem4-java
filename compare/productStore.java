import java.util.*;

public class productStore {

    public static void main(String[] args) {

        List<product> productList = new ArrayList<product>();
        product p1 = new product("Product 1", 1, 9, 500);
        product p2 = new product("Product 2", 2, 10, 200);
        product p3 = new product("Product 3", 3, 3, 300);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

        System.out.println("Product List: " + productList);

        productList.sort(null);

        Collections.sort(productList);

        System.out.println("Sorted Product List: " + productList);

        productList.sort(new productRating());

        System.out.println("Sorted Product List by rating: " + productList);

        productList.sort(new productName());

        System.out.println("Sorted Product List by name: " + productList);

        productList.stream().map( p -> {if (p.rating > 5) {p.name = p.name.toUpperCase();} else {p.name = p.name.toLowerCase();} return p;});

        for (product product : productList) {
            System.out.println(product.name);   
        }

    }
    
}
