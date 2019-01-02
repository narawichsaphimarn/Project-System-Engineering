package com.se.team21.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import com.se.team21.backend.Entity.*;
import com.se.team21.backend.Repository.*;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceController(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/Province")
    public Collection<ProvinceEntity> getProvinceName(){
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
}
