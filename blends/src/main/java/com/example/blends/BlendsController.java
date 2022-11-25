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

    @PostMapping
    public ResponseEntity<Blend> createBlend(Blend blend) {
        try {
            Blend _bend = blendsRepository.save(new Blend(blend.getName(), blend.getId(), blend.getDescription()));
            return new ResponseEntity<>(_bend, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
