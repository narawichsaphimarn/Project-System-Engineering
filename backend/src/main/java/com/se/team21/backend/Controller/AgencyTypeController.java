package com.se.team21.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import com.se.team21.backend.Entity.*;
import com.se.team21.backend.Repository.*;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class AgencyTypeController {
    @Autowired
    private AgencyTypeRepository agencyTypeRepository;

    @Autowired
    public AgencyTypeController(AgencyTypeRepository agencyTypeRepository){
        this.agencyTypeRepository = agencyTypeRepository;
    }

    @GetMapping("/agencyType")
    public Collection<AgencyTypeEntity> getAgencyName(){
        return agencyTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/agencyType/{agencyTypeN}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AgencyTypeEntity getAgencyName(@PathVariable String agencyTypeN){
        AgencyTypeEntity AgencyType = new AgencyTypeEntity();
        AgencyType.setAgencyName(agencyTypeN);
        return agencyTypeRepository.save(AgencyType);
    }
}
