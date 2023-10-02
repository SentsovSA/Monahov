package Lab2.Interface;

import java.util.HashMap;

public class CarInventory implements CarSalesManager {
    private HashMap<String, CarModel> carInventory;

    public CarInventory() {
        carInventory = new HashMap<>();
    }

    @Override
    public String addNewModel(String modelName, int initialStock) {
        if (carInventory.containsKey(modelName)) {
            return "Данная модель уже есть в базе";
        } else {
            CarModel newModel = new CarModel(modelName, initialStock);
            carInventory.put(modelName, newModel);
            return "Новая модель успешно добавлена";
        }
    }

    @Override
    public String receiveCars(String modelName, int quantity) {
        CarModel model = carInventory.get(modelName);
        if (model != null && quantity > 0) {
            model.setAvailableCars(model.getAvailableCars() + quantity);
            return "Автомобили успешно получены";
        } else {
            return "Проверьте введенные данные: возможно такой модели не существует или Вы ввели некорректное количество";
        }
    }

    @Override
    public String sellCar(String modelName) {
        CarModel model = carInventory.get(modelName);
        if (model != null && model.getAvailableCars() > 0) {
            model.setAvailableCars(model.getAvailableCars() - 1);
            return "Автомобиль успешно продан";
        } else {
            return "Доступных авто данной модели нет";
        }
    }

    @Override
    public String returnCar(String modelName) {
        CarModel model = carInventory.get(modelName);
        if (model != null) {
            model.setAvailableCars(model.getAvailableCars() + 1);
            return "Автомобиль успешно возвращён";
        } else {
            return "Такой модели нет в базе";
        }
    }

    @Override
    public int getAvailableCars(String modelName) {
        CarModel model = carInventory.get(modelName);
        if (model != null) {
            return model.getAvailableCars();
        } else {
            return -1;
        }
    }
}
