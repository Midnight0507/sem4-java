public interface Hotspot {

    // Setting a non changable final password
    final String password = "Kmit123$";
    // protected int signal = 45;

    void getPassword();


    default void changeSignalStrength(){
        System.out.println("Signal strength changed .");
    }

    static void returnWifi(){
        System.out.println("Your wifi is                ");
    }

}
