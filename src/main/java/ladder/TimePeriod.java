package ladder;

public enum TimePeriod {
    BEFORE("Before"), AFTER("After");

    private final String timePeriod;

    TimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getTimePeriod() {
        return timePeriod;
    }
}
