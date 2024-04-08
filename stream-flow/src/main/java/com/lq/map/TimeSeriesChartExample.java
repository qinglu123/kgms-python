package com.lq.map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

//ARIMA 时间序列模型
public class TimeSeriesChartExample {
    public static void main(String[] args) {
        // 创建一个时间序列集合
        TimeSeriesCollection dataset = new TimeSeriesCollection();

        // 创建一个原始数据时间序列
        TimeSeries originalData = new TimeSeries("原始数据Data");
        addData(originalData);
        dataset.addSeries(originalData);

        // 创建一个模型拟合值时间序列
        TimeSeries fittedData = calculateFittedData(originalData);
        dataset.addSeries(fittedData);

        // 创建一个模型预测值时间序列
        TimeSeries predictedData = calculatePredictedData(originalData);
        dataset.addSeries(predictedData);

        // 创建一个图表
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "时间序列数据图", // 图表标题
                "日期", // x轴标签
                "值", // y轴标签
                dataset, // 数据集合
                true, // 是否显示图例
                true, // 是否生成工具提示
                false // 是否生成URL链接
        );

        // 设置图表背景色
        chart.setBackgroundPaint(Color.white);

        // 创建一个图表框架
        ChartFrame frame = new ChartFrame("时间序列数据图", chart);
        frame.pack();
        frame.setVisible(true);
    }

    // 生成随机示例数据
    private static void addData(TimeSeries series) {
        LocalDate startDate = LocalDate.of(2020, Month.JANUARY, 1);
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            double value = random.nextDouble() * 100;
            series.add(new Year(startDate.getYear() + i), value);
        }
    }

    //TODO 计算模型拟合值  编写算法
    private static TimeSeries calculateFittedData(TimeSeries originalData) {
        TimeSeries fittedData = new TimeSeries("模型拟合值Data");
        for (int i = 0; i < originalData.getItemCount(); i++) {
            double value = originalData.getValue(i).doubleValue();
            fittedData.add(originalData.getTimePeriod(i), value);
        }
        return fittedData;
    }

    //TODO 计算模型预测值
    private static TimeSeries calculatePredictedData(TimeSeries originalData) {
        TimeSeries predictedData = new TimeSeries("模型预测值Data");
        for (int i = 0; i < originalData.getItemCount(); i++) {
            double value = originalData.getValue(i).doubleValue();
            predictedData.add(originalData.getTimePeriod(i), value);
        }
        return predictedData;
    }
}
