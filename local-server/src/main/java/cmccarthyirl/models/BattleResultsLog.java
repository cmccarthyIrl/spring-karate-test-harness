package cmccarthyirl.models;

public class BattleResultsLog {
    private String result;
    private int resultId;
    private String message;

    public BattleResultsLog(String result, int resultId, String message) {
        this.result = result;
        this.resultId = resultId;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}