package com.se.team21.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import com.se.team21.backend.Entity.*;
import com.se.team21.backend.Repository.*;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @GetMapping("/Country")
    public Collection<CountryEntity> getCountryName(){
        return countryRepository.findAll().stream().collect(Collectors.toList());
    }
}
