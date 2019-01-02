package com.se.team21.backend.Repository;

import com.se.team21.backend.Entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TestRepository extends JpaRepository<TestEntity, Long>{
    TestEntity findBytActivities(String tActivities);
}
