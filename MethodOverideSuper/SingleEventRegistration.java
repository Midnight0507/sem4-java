public class SingleEventRegistration extends EventRegistration {
    private int participantNo;

    SingleEventRegistration(String name, String nameOfEvent, int participantNo) {
        super(name, nameOfEvent);
        this.participantNo = participantNo;
        
    }

    int getParticipantNo() {
        return participantNo;
    }

    void setParticipantNo(int participantNo) {
        this.participantNo = participantNo;
    }

    @Override
    public void registerEvent() {
        double baseFee = 0;
        switch (getNameOfEvent()) {
            case "ShakeALeg":
                baseFee = 100;
                break;
            case "Sing&Win":
                baseFee = 150;
                break;
            case "PlayAway":
                baseFee = 130;
                break;
            default:
                System.out.println("Please choose a valid event");
                return;
        }
        setRegistrationFee(baseFee);
        System.out.println("Thank You "+getName()+" for your participation. Your registration Fee is: " + getRegistrationFee());
        System.out.println("You are participant No: " + getParticipantNo());
        
    }
}
