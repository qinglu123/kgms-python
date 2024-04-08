package com.lq.map;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
//正态性校验Q-Q图
public class QQPlotDemo extends JFrame {

    public QQPlotDemo() {
        setTitle("Q-Q Plot Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Generate sample data
        NormalDistribution distribution = new NormalDistribution(0, 1);
        double[] sample = new double[100];
        for (int i = 0; i < 100; i++) {
            sample[i] = distribution.sample();
        }

        // Create histogram dataset
        HistogramDataset histogramDataset = new HistogramDataset();
        histogramDataset.addSeries("Sample Data", sample, 10);

        // Compute quantiles
        double[] quantiles = new double[100];
        for (int i = 0; i < 100; i++) {
            quantiles[i] = distribution.inverseCumulativeProbability((i + 0.5) / 100);
        }

        // Create XY dataset for Q-Q plot
        XYSeries series = new XYSeries("Quantiles");
        for (int i = 0; i < 100; i++) {
            series.add(quantiles[i], sample[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Create scatter plot
        JFreeChart qqPlot = ChartFactory.createScatterPlot(
                "Q-Q Plot", "Theoretical Quantiles", "Sample Quantiles",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        // Create chart panel
        ChartPanel chartPanel = new ChartPanel(qqPlot);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        QQPlotDemo demo = new QQPlotDemo();
        demo.setVisible(true);
    }
}