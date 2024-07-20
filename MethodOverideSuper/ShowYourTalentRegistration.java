class ShowYourTalentRegistration {
    public static void main(String[] args) {
        SingleEventRegistration p1=new SingleEventRegistration("Jenny", "Sing&Win", 1);
        p1.registerEvent();
        SingleEventRegistration p2=new SingleEventRegistration("Hudson", "PlayAway", 2);
        p2.registerEvent();
        TeamEventRegistration p3=new TeamEventRegistration("Aura", "ShakeALeg", 5, 1);
        p3.registerEvent();
    }
}