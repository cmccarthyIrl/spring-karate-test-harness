package cmccarthyirl.controllers;

import cmccarthyirl.models.ResultRequest;
import cmccarthyirl.storage.ResultsContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultsController {

    @DeleteMapping(value = "/results")
    public static ResponseEntity<?> deleteResults() {
        ResultsContainer.deleteResults();
        return new ResponseEntity<>(ResultsContainer.getResult(), HttpStatus.OK);
    }

    @PostMapping(value = "/results", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> results(@RequestBody ResultRequest resultRequest) {
        return new ResponseEntity<>(ResultsContainer.getResult(resultRequest.getResultId()), HttpStatus.OK);
    }

    @GetMapping(value = "/results", produces = "application/json")
    public ResponseEntity<?> results() {
        return new ResponseEntity<>(ResultsContainer.getResult(), HttpStatus.OK);
    }
}