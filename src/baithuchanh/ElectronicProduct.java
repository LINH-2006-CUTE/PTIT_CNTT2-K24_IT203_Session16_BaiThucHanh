package baithuchanh;


class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice(); // Giá không đổi
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Số tháng bảo hành: " + warrantyMonths);
    }
}