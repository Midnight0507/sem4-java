public class ptester {
    public static void main(String[] args){
        PlayerRating p1=new PlayerRating(1, "Oscar");
        p1.calculateAverageRating(1.0f,1.0f,1.0f);
        p1.calculateCategory();
        p1.display();
        PlayerRating p2=new PlayerRating(2, "Dan");
        p2.calculateAverageRating(8,6);
        p2.calculateCategory();
        p2.display();
    }
}
