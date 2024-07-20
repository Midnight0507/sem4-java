class Registration {
    private String customerName;
    private String passportNo;
    private long[] telephoneNo;
    private int licenseNo;
    private String panCardNo;
    private int voterId;

    // Constructor with Passport Number and Telephone Numbers
    public Registration(String customerName, String passportNo, long[] telephoneNo) {
        this.customerName = customerName;
        this.passportNo = passportNo;
        this.telephoneNo = telephoneNo;
    }

    // Constructor with Customer Name, License Number, Pan Card Number, and Telephone Numbers
    public Registration(String customerName, int licenseNo, String panCardNo, long[] telephoneNo) {
        this.customerName = customerName;
        this.licenseNo = licenseNo;
        this.panCardNo = panCardNo;
        this.telephoneNo = telephoneNo;
    }

    // Constructor with Customer Name, License Number, Voter ID, and Telephone Numbers
    public Registration(String customerName, int licenseNo, int voterId, long[] telephoneNo) {
        this.customerName = customerName;
        this.licenseNo = licenseNo;
        this.voterId = voterId;
        this.telephoneNo = telephoneNo;
    }

    // Constructor with Customer Name, Pan Card Number, Voter ID, and Telephone Numbers
    public Registration(String customerName, String panCardNo, int voterId, long[] telephoneNo) {
        this.customerName = customerName;
        this.panCardNo = panCardNo;
        this.voterId = voterId;
        this.telephoneNo = telephoneNo;
    }

    // Getters for the fields
    public String getCustomerName() {
        return customerName;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public long[] getTelephoneNo() {
        return telephoneNo;
    }

    public int getLicenseNo() {
        return licenseNo;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public int getVoterId() {
        return voterId;
    }
}
