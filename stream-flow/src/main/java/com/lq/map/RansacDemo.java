package com.lq.map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 鲁棒回归
 */
public class RansacDemo {

    public static void main(String[] args) {
        // 生成带有噪声的数据集
        List<Double> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        generateDataWithNoise(xData, yData);

        // 运行 RANSAC 算法
        RansacResult ransacResult = ransac(xData, yData, 0.1, 100, 10);

        // 创建数据集
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] originalData = {toDoubleArray(xData), toDoubleArray(yData)};
        double[][] fittedData = {toDoubleArray(ransacResult.inliersX), toDoubleArray(ransacResult.inliersY)};
        dataset.addSeries("Original Data", originalData);
        dataset.addSeries("Fitted Line", fittedData);

        // 创建散点图
        JFreeChart chart = ChartFactory.createScatterPlot("RANSAC Demo", "X", "Y", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        // 显示图表
        ChartFrame frame = new ChartFrame("RANSAC Demo", chart);
        frame.pack();
        frame.setVisible(true);
    }

    private static void generateDataWithNoise(List<Double> xData, List<Double> yData) {
        Random rand = new Random();
        for (double x = 0; x <= 10; x += 0.1) {
            double y = 2 * x + 3 + rand.nextGaussian();
            xData.add(x);
            yData.add(y);
        }
    }

    private static double[] toDoubleArray(List<Double> list) {
        double[] array = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static RansacResult ransac(List<Double> xData, List<Double> yData, double threshold, int maxIterations, int minInliers) {
        RansacResult bestResult = null;
        Random rand = new Random();

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // 随机选择两个数据点作为模型参数
            int randomIndex1 = rand.nextInt(xData.size());
            int randomIndex2 = rand.nextInt(xData.size());
            double x1 = xData.get(randomIndex1);
            double y1 = yData.get(randomIndex1);
            double x2 = xData.get(randomIndex2);
            double y2 = yData.get(randomIndex2);

            // 计算直线参数
            double a = (y2 - y1) / (x2 - x1);
            double b = y1 - a * x1;

            // 计算拟合误差
            List<Double> inliersX = new ArrayList<>();
            List<Double> inliersY = new ArrayList<>();
            int numInliers = 0;
            for (int i = 0; i < xData.size(); i++) {
                double x = xData.get(i);
                double y = yData.get(i);
                double distance = Math.abs(a * x + b - y);
                if (distance < threshold) {
                    inliersX.add(x);
                    inliersY.add(y);
                    numInliers++;
                }
            }

            // 更新最优结果
            if (numInliers >= minInliers && (bestResult == null || numInliers > bestResult.numInliers)) {
                bestResult = new RansacResult(a, b, inliersX, inliersY, numInliers);
            }
        }

        return bestResult;
    }

    private static class RansacResult {
        double a;
        double b;
        List<Double> inliersX;
        List<Double> inliersY;
        int numInliers;

        public RansacResult(double a, double b, List<Double> inliersX, List<Double> inliersY, int numInliers) {
            this.a = a;
            this.b = b;
            this.inliersX = inliersX;
            this.inliersY = inliersY;
            this.numInliers = numInliers;
        }
    }
}