class EventRegistration {
    private String name;
    private String nameOfEvent;
    private double registrationFee;
    static int NumberofEvent =  0;

    EventRegistration(String name, String nameOfEvent) {
        this.name = name;
        this.nameOfEvent = nameOfEvent;
        NumberofEvent += 1;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getNameOfEvent() {
        return nameOfEvent;
    }

    void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    double getRegistrationFee() {
        return registrationFee;
    }

    void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    void registerEvent() {
        double baseFee = 0;
        switch (getNameOfEvent()) {
            case "ShakeALeg":
                baseFee = 100;
                break;
            case "Sing&Win":
                baseFee = 150;
                break;
            case "Actathon":
                baseFee = 70;
                break;
            case "PlayAway":
                baseFee = 130;
                break;
            default:
                System.out.println("Please choose a valid event");
                return;
        }
        setRegistrationFee(baseFee);
        
    }
}
