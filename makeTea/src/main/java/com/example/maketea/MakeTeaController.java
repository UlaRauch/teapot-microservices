package com.example.maketea;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/maketeaapi")
public class MakeTeaController {

    @GetMapping
    public ResponseEntity<String> makeTea(@RequestBody String blendId) {
    //public ResponseEntity<String> makeTea(@RequestBody String nameOfTea) {
        try {
            //TODO: check for empty name doesn't work :/
            if (blendId.isEmpty() || blendId.isBlank()) {
                return new ResponseEntity<>("Boring hot water.", HttpStatus.OK);
            } else {
                //TODO: call blends service and ask if blend is actually available
                String nameOfTea = "Tea Placeholder";
                return new ResponseEntity<>("Here is your cup of " + nameOfTea + ". Enjoy!", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
