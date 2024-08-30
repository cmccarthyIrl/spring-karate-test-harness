package cmccarthyirl.server.controllers;

import cmccarthyirl.server.models.BattleResultsLog;
import cmccarthyirl.server.models.ResultRequest;
import cmccarthyirl.server.storage.ResultsContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsController {

    private final ResultsContainer resultsContainer;

    @Autowired
    public ResultsController(ResultsContainer resultsContainer) {
        this.resultsContainer = resultsContainer;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteResults() {
        resultsContainer.deleteResults();
        return new ResponseEntity<>("Results have been deleted successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> getResultById(@RequestBody ResultRequest resultRequest) {
        BattleResultsLog result = resultsContainer.getResult(resultRequest.getResultId());
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Result not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BattleResultsLog>> getAllResults() {
        List<BattleResultsLog> results = resultsContainer.getResults();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
