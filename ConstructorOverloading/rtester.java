class rtester {
    public static void main(String[] args) {
        Registration r1 = new Registration("Kevin", "MN989IN", new long[]{9452425421L, 7676765252L});
        System.out.println("Congratulations " + r1.getCustomerName() + "!!! you have been successfully registered for our services with the following details:");
        System.out.println("Passport number: " + r1.getPassportNo());
        System.out.println("Phone Numbers: " + r1.getTelephoneNo()[0]);
        System.out.println(r1.getTelephoneNo()[1]);
        
        Registration r2 = new Registration("Julias", 123, "PN7878", new long[]{2345615451L, 6763562562L});
        System.out.println("Congratulations " + r2.getCustomerName() + "!!! you have been successfully registered for our services with the following details:");
        System.out.println("License number: " + r2.getLicenseNo());
        System.out.println("Pan Card number: " + r2.getPanCardNo());
        System.out.println("Phone Numbers: " + r2.getTelephoneNo()[0]);
        System.out.println(r2.getTelephoneNo()[1]);
        
        Registration r3 = new Registration("Jammy", 45453, 765, new long[]{9634524353L, 9887373737L});
        System.out.println("Congratulations " + r3.getCustomerName() + "!!! you have been successfully registered for our services with the following details:");
        System.out.println("Voter id: " + r3.getVoterId());
        System.out.println("License number: " + r3.getLicenseNo());
        System.out.println("Phone Numbers: " + r3.getTelephoneNo()[0]);
        System.out.println(r3.getTelephoneNo()[1]);
        
        Registration r4 = new Registration("Rose", "PN8934", 34356, new long[]{9867456367L, 7645367356L});
        System.out.println("Congratulations " + r4.getCustomerName() + "!!! you have been successfully registered for our services with the following details:");
        System.out.println("Pan Card number: " + r4.getPanCardNo());
        System.out.println("Voter id: " + r4.getVoterId());
        System.out.println("Phone Numbers: " + r4.getTelephoneNo()[0]);
        System.out.println(r4.getTelephoneNo()[1]);
    }
}
