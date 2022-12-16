package hu.unideb.hu.springbootcrud.Repository;

import hu.unideb.hu.springbootcrud.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
