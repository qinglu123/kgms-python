package com.lq.map;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 * 最小二乘线性回归
 */
public class LinearRegressionDemo {

    public static void main(String[] args) {
        // 示例数据
        double[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] y = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        // 创建简单线性回归对象
        SimpleRegression regression = new SimpleRegression();

        // 添加数据点
        for (int i = 0; i < x.length; i++) {
            regression.addData(x[i], y[i]);
        }

        // 获取回归系数
        //斜率
        double slope = regression.getSlope();
        //截距
        double intercept = regression.getIntercept();

        // 打印回归系数
        System.out.println("回归系数：");
        System.out.println("截距 Intercept: " + intercept);
        System.out.println("斜率 Slope: " + slope);

        // 创建数据集
        XYDataset dataset = createDataset(x, y, slope, intercept);

        // 创建图表
        org.jfree.chart.JFreeChart chart = createChart(dataset, "Linear Regression");

        // 显示图表
        ChartFrame frame = new ChartFrame("Linear Regression Chart", chart);
        frame.pack();
        frame.setVisible(true);
    }

//     创建数据集
    private static XYDataset createDataset(double[] x, double[] y, double slope, double intercept) {
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = {x, y};
        dataset.addSeries("Data Points", data);

        // 计算回归线上的数据点
        double[] lineX = {x[0], x[x.length - 1]};
        double[] lineY = {slope * x[0] + intercept, slope * x[x.length - 1] + intercept};
        double[][] regressionLine = {lineX, lineY};
        dataset.addSeries("Regression Line", regressionLine);

        return dataset;
    }

    // 创建图表
    private static org.jfree.chart.JFreeChart createChart(XYDataset dataset, String title) {
        org.jfree.chart.JFreeChart chart = ChartFactory.createScatterPlot(
                title,
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        plot.getRenderer().setSeriesStroke(1, new java.awt.BasicStroke(2.0f));

        chart.setPadding(new RectangleInsets(10, 10, 10, 20));

        return chart;
    }
}