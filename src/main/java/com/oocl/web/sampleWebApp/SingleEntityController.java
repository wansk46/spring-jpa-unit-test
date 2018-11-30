package com.oocl.web.sampleWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleEntity")

public class SingleEntityController {
    @Autowired
    private SingleEntityRepository parkingBoyRepository;

    @GetMapping
    public ResponseEntity<SingleEntity> getResult(){
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.name = "ABC";
        return ResponseEntity.ok(singleEntity);
    }

}
