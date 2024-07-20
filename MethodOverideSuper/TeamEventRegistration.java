class TeamEventRegistration extends EventRegistration {
    private int noOfParticipants;
    private int teamNo;

    TeamEventRegistration(String name, String nameOfEvent, int noOfParticipants, int teamNo) {
        super(name, nameOfEvent);
        this.noOfParticipants = noOfParticipants;
        this.teamNo = teamNo;
        
    }

    int getNoOfParticipants() {
        return noOfParticipants;
    }

    void setNoOfParticipants(int noOfParticipants) {
        this.noOfParticipants = noOfParticipants;
    }

    int getTeamNo() {
        return teamNo;
    }

    void setTeamNo(int teamNo) {
        this.teamNo = teamNo;
    }

    @Override
    void registerEvent() {
        double baseFee = 0;
        switch (getNameOfEvent()) {
            case "ShakeALeg":
                baseFee = 50;
                break;
            case "Sing&Win":
                baseFee = 60;
                break;
            case "Actathon":
                baseFee = 80;
                break;
            case "PlayAway":
                baseFee = 100;
                break;
            default:
                System.out.println("Please choose a valid event");
                return;
        }
        double fee=baseFee * noOfParticipants;
        setRegistrationFee(fee);
        System.out.println("Thank You "+getName()+" for your participation. Your registration Fee is: " + getRegistrationFee());
        System.out.println("You are participant No: " + getTeamNo());
        
}
}