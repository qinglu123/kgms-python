package com.lq.map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;

//正态性检验 P-P图
public class PpPlotExample extends ApplicationFrame {

    public PpPlotExample(String title) {
        super(title);
        DefaultXYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
    }

    private DefaultXYDataset createDataset() {
        double[] heights = {40, 50, 60, 65, 70, 56, 57, 58};
        Arrays.sort(heights);
        double[] empiricalProbabilities = new double[heights.length];
        double[] theoreticalProbabilities = new double[heights.length];
        for (int i = 0; i < heights.length; i++) {
            empiricalProbabilities[i] = (i + 1.0) / heights.length;
            theoreticalProbabilities[i] = calculateTheoreticalProbability(heights[i]);
        }
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("P-P Plot", new double[][]{theoreticalProbabilities, empiricalProbabilities});
        return dataset;
    }

    private double calculateTheoreticalProbability(double value) {
        // 假设身高数据近似正态分布，计算理论累积概率
        double mean = 170; // 假设平均身高为170
        double stdDev = 5; // 假设标准差为5
        return 0.5 * (1 + erf((value - mean) / (stdDev * Math.sqrt(2))));
    }

    private double erf(double x) {
        return (2 / Math.sqrt(Math.PI)) * integrate(t -> Math.exp(-t * t), 0, x, 100);
    }

    private double integrate(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (f.apply(a) + f.apply(b));
        for (int i = 1; i < n; i++) {
            sum += f.apply(a + i * h);
        }
        return h * sum;
    }

    private JFreeChart createChart(DefaultXYDataset dataset) {
        JFreeChart chart = ChartFactory.createScatterPlot(
                "P-P Plot", "Theoretical Probability", "Empirical Probability", dataset,
                PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.getDomainAxis().setRange(0, 1);
        plot.getRangeAxis().setRange(0, 1);
        plot.getDomainAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer(0);
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesPaint(0, Color.blue);
        return chart;
    }

    public static void main(String[] args) {
        PpPlotExample example = new PpPlotExample("P-P Plot Example");
        example.pack();
        example.setVisible(true);
    }
}