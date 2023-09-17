package Lab2.Interface;

public class CarModel {
    private String modelName;
    private int availableCars;

    public CarModel(String modelName, int availableCars) {
        this.modelName = modelName;
        this.availableCars = availableCars;
    }

    public String getModelName() {
        return modelName;
    }

    public int getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(int availableCars) {
        this.availableCars = availableCars;
    }
}
