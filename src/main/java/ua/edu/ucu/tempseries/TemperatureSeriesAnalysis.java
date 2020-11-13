package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private final double MIN_TEMP = -273.0;
    private final int BASE_SIZE = 10;
    private double[] tempList;
    private int lastItem;

    public TemperatureSeriesAnalysis() {
        tempList = new double[BASE_SIZE];
        lastItem = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        tempList = temperatureSeries.clone();
        lastItem = temperatureSeries.length;
    }

    public double average() throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0.0;
        for (double temp: tempList) {
            sum += temp;
        }
        return sum/(double)(lastItem);
    }

    public double deviation() throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        double mean = average();
        double sum = 0;
        for (double temp: tempList) {
            sum += (temp - mean)*(temp - mean);
        }
        sum /= lastItem;
        return sum;
    }

    public double min() throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        double minimum = Double.POSITIVE_INFINITY;
        for (double temp: tempList) {
            if (temp < minimum) {
                minimum = temp;
            }
        }
        return minimum;
    }

    public double max() throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        double maximum = MIN_TEMP;
        for (double temp: tempList) {
            if (maximum < temp) {
                maximum = temp;
            }
        }
        return maximum;
    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue)
            throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        double closest = MIN_TEMP;
        for (double temp: tempList) {
            if (Math.abs(closest - tempValue) < Math.abs(temp - tempValue)) {
                closest = temp;
            }
            if ( Double.compare(Math.abs(closest - tempValue),
                    Math.abs(temp - tempValue)) == 0) {
                if (temp > 0 && closest < 0) {
                    closest = temp;
                }
            }
        }
        return closest;
    }

    public double[] findTempsLessThan(double tempValue)
            throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        double[] minTemps = new double[BASE_SIZE];
        int index = 0;
        for (double temp: tempList) {
            if (temp < tempValue) {
                if (index <= minTemps.length) {
                    minTemps = extendSequence(minTemps);
                }
                minTemps[index] = temp;
                index++;
            }
        }
        return minTemps;
    }

    public double[] findTempsGreaterThan(double tempValue)
            throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        double[] maxTemps = new double[BASE_SIZE];
        int index = 0;
        for (double temp: tempList) {
            if (temp > tempValue) {
                if (index <= maxTemps.length) {
                    maxTemps = extendSequence(maxTemps);
                }
                maxTemps[index] = temp;
                index++;
            }
        }
        return maxTemps;
    }

    public TempSummaryStatistics summaryStatistics()
            throws IllegalArgumentException {
        if (lastItem == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(average(), deviation(), max(), min());
    }

    private double[] extendSequence(double[] temps) {
        double[] newTemps = new double[temps.length * 2];
        int newInd = 0;
        for (double temp: temps) {
            newTemps[newInd] = temp;
            newInd++;
        }
        return newTemps;
    }

    public int addTemps(double...temps) throws InputMismatchException {
        for (double temp: temps) {
            if (temp < MIN_TEMP) {
                throw new InputMismatchException();
            }
        }
        for (double temp: temps) {
            if (lastItem >= tempList.length) {
                tempList = extendSequence(tempList);
            }
            tempList[lastItem] = temp;
            lastItem++;
        }
        return 0;
    }
}