package cmccarthyirl.server.controllers;

import cmccarthyirl.server.models.BattleReport;
import cmccarthyirl.server.models.BattleRequest;
import cmccarthyirl.server.models.BattleResultsLog;
import cmccarthyirl.server.storage.HeroList;
import cmccarthyirl.server.storage.ResultsContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;
import java.util.Random;

@RestController
public class BattleController {

    private static final int MIN_BATTLE_ID = 1;
    private static final int MAX_BATTLE_ID = 1000;
    private final Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(BattleController.class);

    private final HeroList heroList;
    private final ResultsContainer resultsContainer;

    public BattleController(HeroList heroList, ResultsContainer resultsContainer) {
        this.heroList = heroList;
        this.resultsContainer = resultsContainer;
    }

    @PostMapping(value = "/battle")
    public ResponseEntity<BattleReport> calculateFight(@RequestBody BattleRequest battleRequest) {
        if (battleRequest.getFirstHeroToFight() == 0 || battleRequest.getSecondHeroToFight() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        int battleId = generateBattleId();
        BattleReport battleReport = createBattleReport(battleId);

        Optional<BattleResultsLog> battleResultsLogOpt = checkResults(
                battleRequest.getFirstHeroToFight(),
                battleRequest.getSecondHeroToFight(),
                battleId
        );

        if (battleResultsLogOpt.isPresent()) {
            BattleResultsLog battleResultsLog = battleResultsLogOpt.get();
            storeResults(battleResultsLog);
            logger.info("Battle processed successfully: {}", battleResultsLog);
        } else {
            logger.error("Battle could not be processed. One or both heroes not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(battleReport, HttpStatus.OK);
    }

    private int generateBattleId() {
        return random.nextInt(MAX_BATTLE_ID - MIN_BATTLE_ID + 1) + MIN_BATTLE_ID;
    }

    private BattleReport createBattleReport(int battleId) {
        BattleReport battleReport = new BattleReport();
        battleReport.setResultId(battleId);
        battleReport.setMessage("Please use the above Report ID to retrieve your Battle report");
        return battleReport;
    }

    private void storeResults(BattleResultsLog battleResultsLog) {
        if (resultsContainer.getResults().isEmpty()) {
            // Initialize ResultsContainer with the first result
            resultsContainer.initializeResults(Collections.singletonList(battleResultsLog));
        } else {
            // Add the new result to the existing list
            resultsContainer.addResult(battleResultsLog);
        }
    }

    private Optional<BattleResultsLog> checkResults(int firstHeroId, int secondHeroId, int battleId) {
        var firstHero = heroList.getHero(firstHeroId);
        var secondHero = heroList.getHero(secondHeroId);

        if (firstHero == null || secondHero == null) {
            return Optional.empty();
        }

        int firstHeroAge = firstHero.getAge();
        int secondHeroAge = secondHero.getAge();
        String firstHeroName = firstHero.getName();
        String secondHeroName = secondHero.getName();

        String resultMessage;
        String resultStatus;

        if (firstHeroAge == secondHeroAge) {
            resultStatus = "DRAW";
            resultMessage = "Both heroes fought for days to test their might. In the end, Deadpool got tired of waiting for a winner and killed them both.";
        } else if (firstHeroAge > secondHeroAge) {
            resultStatus = "WIN";
            resultMessage = firstHeroName + " fought like a true champion and easily won the battle against " + secondHeroName + ".";
        } else {
            resultStatus = "LOSS";
            resultMessage = firstHeroName + " fought well, but in the end, " + secondHeroName + " prevailed!";
        }

        return Optional.of(new BattleResultsLog(resultStatus, battleId, resultMessage));
    }
}
