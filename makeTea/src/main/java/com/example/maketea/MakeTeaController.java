package com.example.maketea;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public ResponseEntity<String> makeTea(@RequestBody String blendId) {
    //public ResponseEntity<String> makeTea(@RequestBody String nameOfTea) {
        try {
            //TODO: check for empty name doesn't work :/
            if (blendId.isEmpty() || blendId.isBlank()) {
                return new ResponseEntity<>("Boring hot water.", HttpStatus.OK);
            } else {
                //TODO: fix this mess. Problem with request, not response, request doesn't even arrive.

                String nameOfTea = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8080/blendsapi/availabilitycheck")//TODO: call correct path for availabilitycheck
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                System.out.println(nameOfTea);
                /*
                //https://www.baeldung.com/spring-5-webclient
                WebClient client = WebClient.create("http://localhost:8080");
                WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
                WebClient.RequestBodySpec bodySpec = uriSpec.uri("/blendsapi/availabilitycheck");
                WebClient.RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue(blendId);
                Mono<String> monoResponse = headersSpec.retrieve().bodyToMono(String.class);
                monoResponse.subscribe(value -> System.out.println(value),
                        error -> error.printStackTrace(),
                        () -> System.out.println("completed without a value"));
                //System.out.println("response: " + response);

                 */
                //String nameOfTea = "Tea Placeholder";
                return new ResponseEntity<>("Here is your cup of " + nameOfTea + ". Enjoy!", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
