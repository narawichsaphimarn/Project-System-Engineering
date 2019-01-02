package com.se.team21.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import com.se.team21.backend.Entity.*;
import com.se.team21.backend.Repository.*;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ActivitiesController {
    @Autowired
    private ActivitiesRepository activitiesRepository;

    @Autowired
    public ActivitiesController(ActivitiesRepository activitiesRepository){
        this.activitiesRepository = activitiesRepository;
    }

    @GetMapping("/Activities")
    public Collection<ActivitiesEntity> getActivitiesName(){
        return activitiesRepository.findAll().stream().collect(Collectors.toList());
    }
}
