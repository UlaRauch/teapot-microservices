package com.example.blends;

import com.example.blends.model.Blend;
import com.example.blends.repository.BlendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/blendsapi")
public class BlendsController {

    @Autowired
    BlendsRepository blendsRepository;

    @GetMapping
    public ResponseEntity<List<Blend>> getAllBlends() {
        try {

            List<Blend> blends = new ArrayList<Blend>(blendsRepository.findAll());

            if (blends.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(blends, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: availabilityCheck does not work yet! -> findByNameContaining() implementation!
    @GetMapping("/availabilityCheck")
    public ResponseEntity<Boolean> checkIfBlendAvailable(@RequestBody String name) {
        try {
            //TODO: AvailabilityCheck sinnvoller machen! Wär blöd bei verallgemeinerten sorten, deren name in spezialsorten enthalten ist.
            boolean isAvailable = blendsRepository.existsBlendByName(name); //momentan reicht es, wenn irgendein tee so heißt, egal ob mehrere zur Auswahl stehen
            //System.out.println("name: "+ name + ", available: " + isAvailable);
            //System.out.println(blendsRepository.findAll());
            return new ResponseEntity<>(isAvailable, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Blend> createBlend(@RequestBody Blend blend) {
        try {
            Blend _blend = blendsRepository.save(new Blend(blend.getName(), blend.getId(), blend.getDescription()));
            return new ResponseEntity<>(_blend, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
