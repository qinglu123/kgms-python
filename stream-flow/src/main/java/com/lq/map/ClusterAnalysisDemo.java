package com.lq.map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 聚类分析
 */
public class ClusterAnalysisDemo {

    public static void main(String[] args) {
        // 假设已经执行了聚类算法并获得了聚类结果
        // 假设聚类结果用整数（clusterId）表示，存储在一个数组或列表中
        int[] clusterResults = { 1, 2, 1, 3, 2, 1, 3, 3, 3, 2 };

        // 计算每个聚类类别的频数
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int clusterId : clusterResults) {
            frequencyMap.put(clusterId, frequencyMap.getOrDefault(clusterId, 0) + 1);
        }

        // 计算每个类别的百分比
        int totalDataPoints = clusterResults.length;
        Map<Integer, Double> percentageMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int clusterId = entry.getKey();
            int frequency = entry.getValue();
            double percentage = (double) frequency / totalDataPoints * 100;
            percentageMap.put(clusterId, percentage);
        }

        // 创建饼状图数据集
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int clusterId = entry.getKey();
            //频数
            int frequency = entry.getValue();
            //百分比
            double percentage = percentageMap.get(clusterId);
            dataset.setValue("Cluster " + clusterId + " (" + frequency + ", " + percentage + "%)", frequency);
        }

        // 创建饼状图
        JFreeChart chart = ChartFactory.createPieChart("Cluster Analysis", dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        //聚类类别
        plot.setSectionPaint("Cluster 1", Color.RED);
        plot.setSectionPaint("Cluster 2", Color.BLUE);
        plot.setSectionPaint("Cluster 3", Color.GREEN);

        // 创建图形面板并添加到界面
        JPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Cluster Analysis 聚类分析");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}