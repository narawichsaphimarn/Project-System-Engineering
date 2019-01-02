package com.se.team21.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import com.se.team21.backend.Entity.*;
import com.se.team21.backend.Repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URLDecoder;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class TestController {
    @Autowired
    private  TestRepository testRepository;

    @Autowired
    public TestController(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    @GetMapping("/Test")
    public Collection<TestEntity> gettActivities(){
        return testRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Test/{tName}/{tActivities}/{tAddress}")
    public TestEntity testEntity(@PathVariable String tName,@PathVariable String tActivities,@PathVariable String tAddress){
        TestEntity t = new TestEntity();
        t.settName(tName);
        t.settAddress(tAddress);
        t.settActivities(tActivities);

        return testRepository.save(t);
    }
}
