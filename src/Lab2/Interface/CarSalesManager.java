package Lab2.Interface;

public interface CarSalesManager {
    String addNewModel(String modelName, int initialStock);
    String receiveCars(String modelName, int quantity);
    String sellCar(String modelName);
    String returnCar(String modelName);
    int getAvailableCars(String modelName);
}
