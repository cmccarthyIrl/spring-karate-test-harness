package cmccarthyirl.server.storage;

import cmccarthyirl.server.models.BattleResultsLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultsContainer {

    private List<BattleResultsLog> listOfResults = new ArrayList<>();

    public ResultsContainer(List<BattleResultsLog> initialResults) {
        if (initialResults != null) {
            this.listOfResults = new ArrayList<>(initialResults);
        }
    }

    public ResultsContainer() {
        this.listOfResults = new ArrayList<>();
    }

    public BattleResultsLog getResult(int id) {
        for (BattleResultsLog result : listOfResults) {
            if (result.getResultId() == id) {
                return result;
            }
        }
        return null;
    }

    public List<BattleResultsLog> getResults() {
        return listOfResults;
    }

    public void addResult(BattleResultsLog battleResultsLog) {
        if (battleResultsLog != null) {
            listOfResults.add(battleResultsLog);
        }
    }

    public void initializeResults(List<BattleResultsLog> newResults) {
        if (newResults != null) {
            this.listOfResults = new ArrayList<>(newResults);
        }
    }

    public void deleteResults() {
        this.listOfResults = new ArrayList<>();
    }
}
