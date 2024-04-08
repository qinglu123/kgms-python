package com.lq.map;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.inference.KolmogorovSmirnovTest;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.*;

/**
 * 正态校验发布
 */
public class NormalityTestExample {
    public static void main(String[] args) {
        // 生成随机体重数据
//        List<Double> weights = generateRandomWeights(100);

        // 转换为数组
//        double[] data = new double[weights.size()];
//        for (int i = 0; i < weights.size(); i++) {
//            data[i] = weights.get(i);
//        }
        double[] data = {40, 50, 60, 65, 70, 56, 57, 58};

        // 将double数组转换为List
        List<Double> dataList = Arrays.asList(Arrays.stream(data).boxed().toArray(Double[]::new));

        // 正态性检验
        KolmogorovSmirnovTest test = new KolmogorovSmirnovTest();
        boolean isNormallyDistributed = test.kolmogorovSmirnovTest(new NormalDistribution(50, 10), data, 0.05);

        // 统计描述
        DescriptiveStatistics statistics = new DescriptiveStatistics(data);
        //平均值
        double mean = statistics.getMean();
        //标准差
        double stdDev = statistics.getStandardDeviation();
        //获取中位数
        double median = statistics.getPercentile(50);
        // 获取偏度
        double skewness = statistics.getSkewness();
        // 获取峰度
        double kurtosis = statistics.getKurtosis();


        // 绘制直方图 数据范围划分为10个等宽的区间
        Histogram histogram = new Histogram(dataList, data.length);

        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("正态性检验 - 直方图")
                .xAxisTitle("体重区间")
                .yAxisTitle("频数")
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.addSeries("真实频数", histogram.getxAxisData(), histogram.getyAxisData());
        new SwingWrapper<>(chart).displayChart();

        // 计算拟正态频率
        double sum = Arrays.stream(data).sum();
        // 计算拟正态频率
        List<Double> frequenciesList = new ArrayList<>();
        for (double d : data) {
            double frequency = d / sum;
            frequenciesList.add(frequency);
        }
        // 创建折线图
        XYChart xyChart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("真实频数和拟正态频率")
                .xAxisTitle("分组")
                .yAxisTitle("频率")
                .theme(Styler.ChartTheme.GGPlot2)
                .build();
        xyChart.addSeries("拟正态频率", histogram.getxAxisData(), frequenciesList);
        new SwingWrapper<>(xyChart).displayChart();

        // 输出结果
        System.out.println("是否正态分布: " + isNormallyDistributed);
        System.out.println("均值: " + mean);
        System.out.println("标准差: " + stdDev);
        System.out.println("中位数: " + median);
        System.out.println("偏度: " + Math.abs(skewness));
        System.out.println("标准差: " + Math.abs(stdDev));
    }

    // 生成随机体重数据
    private static List<Double> generateRandomWeights(int size) {
        List<Double> weights = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            double weight = 50 + random.nextGaussian() * 10; // 平均值为50，标准差为10
            weights.add(weight);
        }

        return weights;
    }
}