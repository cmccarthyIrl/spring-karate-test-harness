package cmccarthyirl.controllers;

import cmccarthyirl.models.BattleReport;
import cmccarthyirl.models.BattleRequest;
import cmccarthyirl.models.BattleResultsLog;
import cmccarthyirl.storage.HeroList;
import cmccarthyirl.storage.ResultsContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class BattleController {


    @PostMapping(value = "/battle")
    public ResponseEntity<?> calculateFight(@RequestBody BattleRequest battleRequest) {
        int battleId = new Random().nextInt((1000 - 1) + 1) + 1;

        final BattleReport battleReport = new BattleReport();
        battleReport.setResultId(battleId);
        battleReport.setMessage("Please use the above Report ID to retrieve your Battle report");

        final BattleResultsLog battleResultsLog = checkResults(battleRequest.getFirstHeroToFight(), battleRequest.getSecondHeroToFight(), battleId);
        List<BattleResultsLog> battleResultsLogList = new ArrayList<>();
        battleResultsLogList.add(battleResultsLog);

        if (ResultsContainer.getResult() != null) {
            ResultsContainer.add(battleResultsLog);
        } else {
            new ResultsContainer(battleResultsLogList);
        }

        return new ResponseEntity<>(battleReport, HttpStatus.OK);
    }

    private BattleResultsLog checkResults(int firstHeroToFight, int secondHeroToFight, int battleId) {
        final BattleResultsLog battleResultsLog;
        final int firstHeroToFightAge = HeroList.getHero(firstHeroToFight).getAge();

        if (firstHeroToFightAge == HeroList.getHero(secondHeroToFight).getAge()) {
            battleResultsLog = new BattleResultsLog("DRAW", battleId, "Both Hero's fought for days to test their might, in the end Dead Pool got tired of waiting for a winner and killed them both");
        } else if (firstHeroToFightAge > HeroList.getHero(secondHeroToFight).getAge()) {
            battleResultsLog = new BattleResultsLog("WIN", battleId, HeroList.getHero(firstHeroToFight).getName() + " fought like a true champion and easily won the battle with " + HeroList.getHero(secondHeroToFight).getName());
        } else {
            battleResultsLog = new BattleResultsLog("LOSS", battleId, HeroList.getHero(firstHeroToFight).getName() + " fought well but in the end " + HeroList.getHero(secondHeroToFight).getName() + " kicked his ass!");
        }
        return battleResultsLog;
    }
}