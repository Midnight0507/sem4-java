class PermanentEmployee extends Employee {
    private double basicPay;
    private double hra;
    private int experience;

    double getBasicPay() {
        return basicPay;
    }

    void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    double getHra() {
        return hra;
    }

    void setHra(double hra) {
        this.hra = hra;
    }

    int getExperience() {
        return experience;
    }

    void setExperience(int experience) {
        this.experience = experience;
    }

    void calculateSalary() {
        double variableComponent=0;
        if(experience<3){
            variableComponent=0;  
        }
        else if(experience>=3 & experience<5){
            variableComponent=0.05*basicPay;
        }
        else if(experience>=5 & experience<10){
            variableComponent=0.07*basicPay;
        }
        else{
            variableComponent=0.12*basicPay;
        }
        double salary =variableComponent+ basicPay + hra;
        setSalary(salary);
        System.out.println("Permanent Employee: Your salary is: "+ salary);
    }
}