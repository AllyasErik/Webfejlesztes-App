package hu.unideb.hu.springbootcrud.Service;

import hu.unideb.hu.springbootcrud.Model.Car;

import java.util.List;


public interface CarService {
    List<Car> getAllCars();
    void saveCar(Car car);
    Car getCarById(long id);
    void deleteCarById(long id);

}
