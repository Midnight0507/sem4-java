class Computer extends Electronic {
    // Additional state specific to computers
    private String brand;
    private int storage; // in gigabytes
    private int ram; // in gigabytes
    // Constructor to initialize the Computer object
    public Computer(String brand, int storage, int ram) {
        super(); // Call the superclass constructor
        this.brand = brand;
        this.storage = storage;
        this.ram = ram;
    }
    // Specific behavior for Computer
    public void upgradeRam(int additionalRam) {
        this.ram += additionalRam;
        System.out.println("RAM upgraded. Total RAM: " + ram + " GB.");
    }
    // Overriding the display method to include computer specifics
    public void displaySpecs() {
        System.out.println("Brand: " + brand);
        System.out.println("Storage: " + storage + " GB");
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Power status: " + (isOn ? "On" : "Off"));
    }
}