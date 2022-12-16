package hu.unideb.hu.springbootcrud.Service;

import hu.unideb.hu.springbootcrud.Model.Car;
import hu.unideb.hu.springbootcrud.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepo;

    @Override
    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    @Override
    public void saveCar(Car car) {
        this.carRepo.save(car);
    }

    @Override
    public Car getCarById(long id) {
        Optional<Car> optional = carRepo.findById(id);
        Car car = null;
        if(optional.isPresent()){
            car = optional.get();
        }
        else{
            throw new RuntimeException("Car not found for id :: "+id);
        }
        return car;
    }

    @Override
    public void deleteCarById(long id) {
        this.carRepo.deleteById(id);
    }
}
