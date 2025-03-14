package re1kur.rentalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import re1kur.rentalservice.dto.car.CarReadDto;
import re1kur.rentalservice.dto.car.CarWriteDto;
import re1kur.rentalservice.dto.car.details.CarDetailsWriteDto;
import re1kur.rentalservice.dto.car.images.CarImageWriteDto;
import re1kur.rentalservice.service.CarService;
import re1kur.rentalservice.service.MakeService;

import java.util.List;

@Controller
@RequestMapping("cars")
public class CarsController {
    private final CarService service;
    private final MakeService makeService;

    @Autowired
    public CarsController(CarService service,
                          MakeService makeService) {
        this.service = service;
        this.makeService = makeService;
    }

    @GetMapping("list")
    public String listCars(Model model) {
        model.addAttribute("cars", service.findAll(false, false));
        return "cars/list.html";
    }

    @PostMapping("/create")
    @Transactional
    public String createCar(
            @Validated CarWriteDto carForm,
            @Validated CarDetailsWriteDto carDetailsForm,
//            @Validated CarImageWriteDto carImageForm,
            Model model,
            BindingResult bindingResult) {
        carForm.setDetails(carDetailsForm);
//        carForm.setImage(carImageForm);
        if (bindingResult.hasErrors()) {
            model.addAttribute("car", carForm);
            model.addAttribute("makes", makeService.findAll());
            return "cars/create.html";
        }
        CarReadDto created = service.writeCar(carForm);
        model.addAttribute("car", created);
        return "redirect:/cars/" + created.getId();
    }

    @GetMapping("/create")
    public String getCreateCar(Model model) {
        model.addAttribute("makes",
                makeService.findAll());
        return "cars/create.html";
    }
}
