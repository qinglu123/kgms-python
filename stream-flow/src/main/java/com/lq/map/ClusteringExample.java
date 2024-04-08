package com.lq.map;

import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterer;
import org.apache.commons.math3.ml.clustering.DBSCANClusterer;
import org.apache.commons.math3.ml.clustering.DoublePoint;

import java.util.ArrayList;
import java.util.List;
//聚类分析
public class ClusteringExample {
    public static void main(String[] args) {
        // 创建数据集
        List<DoublePoint> dataset = createDataset();
        
        // 创建聚类器
        // eps 邻域半径   minPts 最小邻居数
        Clusterer<DoublePoint> clusterer = new DBSCANClusterer<>(0.5, 2);

        // 进行聚类分析
        List<? extends Cluster<DoublePoint>> clusters = clusterer.cluster(dataset);

        // 输出聚类结果
        for (int i = 0; i < clusters.size(); i++) {
            Cluster<DoublePoint> cluster = clusters.get(i);
            List<DoublePoint> points = cluster.getPoints();
            for (DoublePoint point : points) {
                System.out.println(point);
            }
        }
    }
    
    // 创建一个简单的数据集
    private static List<DoublePoint> createDataset() {
        List<DoublePoint> dataset = new ArrayList<>();
        
        dataset.add(new DoublePoint(new double[]{1.0, 1.0}));
        dataset.add(new DoublePoint(new double[]{1.5, 2.0}));
        dataset.add(new DoublePoint(new double[]{2.0, 1.5}));
        dataset.add(new DoublePoint(new double[]{6.0, 7.0}));
        dataset.add(new DoublePoint(new double[]{7.0, 6.5}));
        dataset.add(new DoublePoint(new double[]{7.5, 7.5}));
        
        return dataset;
    }
}