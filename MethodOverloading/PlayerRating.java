public class PlayerRating {
    int playerPosition;
    String playerName;
    private float criticOneRating;
    private float criticTwoRating;
    private float criticThreeRating;
    private float averageRating;
    char category;
    
    PlayerRating(int playerPosition, String playerName){
        this.playerPosition=playerPosition;
        this.playerName=playerName;
    }

    void calculateAverageRating(float criticOneRating, float criticTwoRating){
        this.criticOneRating=criticOneRating;
        this.criticTwoRating=criticTwoRating;
        averageRating = (criticOneRating+criticTwoRating)/2;
    }

    void calculateAverageRating(float criticOneRating, float criticTwoRating,float criticThreeRating ){
        this.criticOneRating=criticOneRating;
        this.criticTwoRating=criticTwoRating;
        this.criticThreeRating=criticThreeRating;
        averageRating = (criticOneRating+criticTwoRating+criticThreeRating)/3;
    }

    void calculateCategory(){
        if (averageRating > 8) {
            category='A';
        } else if (averageRating >=5) {
            category= 'B';
        } else {
            category='C';
        }
    }

    void display(){
        System.out.println("The Player name is: "+playerName);
        System.out.println("The Player Position is: "+playerPosition);
        System.out.println("The Average Rating is: "+averageRating);
        System.out.println("The Player Category is: "+category);
    }
}
