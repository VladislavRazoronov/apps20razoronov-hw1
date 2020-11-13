package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {-10.0, -25.0, -1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-1.0, 25.0, -1.0, 5.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {1.0, 1.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZero() {
        double[] temperatureSeries = {-1.0, 25.0, 1.0, 5.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testClosestToValue() {
        double[] temperatureSeries = {-1.0, 25.0, -1.0, 5.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(8.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(1.0);
    }

    @Test
    public void testFindLessThan() {
        double[] temperatureSeries = {-1.0, 25.0, 1.0, 5.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0, 1.0, 5.0};

        double[] actualResult = seriesAnalysis.findTempsLessThan(8.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindLessThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsLessThan(1.0);
    }

    @Test
    public void testFindGreaterThan() {
        double[] temperatureSeries = {-1.0, 25.0, 1.0, 5.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {25.0, 10.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThan(8.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindGreaterThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsGreaterThan(1.0);
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {1.0, 1.0, 1.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        String expResult = "Average: 2.0; Deviation: 1.0; Max: 3.0; Min: 1.0";

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        assertEquals(expResult, actualResult.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testAdd() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        double expResult = 5.0;
        double[] additionalValues = {60.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

        seriesAnalysis.addTemps(additionalValues);

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddWrongTemp() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] ImpossibleTemperature = {-274.0, 1.0, 2.0, 10000.0};

        // expect exception here
        seriesAnalysis.addTemps(ImpossibleTemperature);
    }
}
