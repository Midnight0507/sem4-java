import java.util.Comparator;

public class productRating implements Comparator<product>{

    @Override
    public int compare(product o1, product o2) {

        return o1.rating - o2.rating;

    }
}
