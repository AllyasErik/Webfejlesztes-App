package hu.unideb.hu.springbootcrud.Controller;


import hu.unideb.hu.springbootcrud.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hu.unideb.hu.springbootcrud.Service.CarService;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listCars", carService.getAllCars());
        return "index";
    }

    @GetMapping("/showNewCarForm")
    public String showNewCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car){
        carService.saveCar(car);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "update_car";

    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable long id) {
        this.carService.deleteCarById(id);
        return "redirect:/";
    }

}


