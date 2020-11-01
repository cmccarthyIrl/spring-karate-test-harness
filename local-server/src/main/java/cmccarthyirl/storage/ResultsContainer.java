package cmccarthyirl.storage;


import cmccarthyirl.models.BattleResultsLog;

import java.util.ArrayList;
import java.util.List;

public class ResultsContainer {
    private static List<BattleResultsLog> listOfResults;

    public ResultsContainer(List<BattleResultsLog> listOfResults) {
        ResultsContainer.listOfResults = listOfResults;
    }

    public static BattleResultsLog getResult(int id) {
        BattleResultsLog anotherHero = null;
        for (BattleResultsLog result : listOfResults) {
            if (result.getResultId() == id) {
                anotherHero = result;
            }
        }
        return anotherHero;
    }

    public static List<BattleResultsLog> getResult() {
        return listOfResults;
    }

    public static void add(BattleResultsLog battleResultsLogList) {
        ResultsContainer.listOfResults.add(battleResultsLogList);
    }

    public static void deleteResults() {
        listOfResults = new ArrayList<>();
    }
}
