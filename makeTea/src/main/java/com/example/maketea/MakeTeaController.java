package com.example.maketea;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/maketeaapi")
public class MakeTeaController {

    @GetMapping
    public ResponseEntity<String> makeTea(@RequestBody String nameOfTea) {

        try {
            //TODO: check for empty name doesn't work :/
            if (nameOfTea.isEmpty() || nameOfTea.isBlank()) {
                return new ResponseEntity<>("Boring hot water.", HttpStatus.OK);
            } else {
                //TODO: call blends service and ask if blend is actually available
                return new ResponseEntity<>("Here is your cup of " + nameOfTea + ". Enjoy!", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
