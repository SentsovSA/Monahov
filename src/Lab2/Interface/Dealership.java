package Lab2.Interface;

public class Dealership {
    public static void main(String[] args) {
        CarInventory carInventory = new CarInventory();

        System.out.println(carInventory.addNewModel("Toyota Highlander", 1));
        System.out.println(carInventory.receiveCars("Toyota Highlander", 3));
        System.out.println(carInventory.sellCar("Kbckadjhb"));
        System.out.println(carInventory.sellCar("Toyota Highlander"));

        System.out.println("Доступные Toyota Highlander: " + carInventory.getAvailableCars("Toyota Highlander"));
    }
}
