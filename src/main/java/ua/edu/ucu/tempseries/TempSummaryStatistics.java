package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp, devTemp, maxTemp, minTemp;
    public TempSummaryStatistics(double avg, double dev, double max,
                                 double min) {
        avgTemp = avg;
        devTemp = dev;
        maxTemp = max;
        minTemp = min;
    }
    public String toString() {
        return "Average: " + avgTemp + "; Deviation: " + devTemp
                + "; Max: " + maxTemp + "; Min: " + minTemp;
    }
}
