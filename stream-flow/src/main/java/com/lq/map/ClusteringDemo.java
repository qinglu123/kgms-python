package com.lq.map;

import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterer;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;

import java.util.Arrays;
import java.util.List;

//聚类分析
public class ClusteringDemo {
    public static void main(String[] args) {
        // 示例数据
        double[][] data = {
            {1.0, 1.0},
            {1.5, 2.0},
            {3.0, 4.0},
            {5.0, 7.0},
            {3.5, 5.0},
            {4.5, 5.0},
            {3.5, 4.5}
        };

        // 创建聚类算法对象并指定聚类的数量
        int numClusters = 2;
        Clusterer<DoublePoint> clusterer = new KMeansPlusPlusClusterer<>(numClusters);

        // 将数据转换为DoublePoint对象，并进行聚类分析
        DoublePoint[] points = Arrays.stream(data)
                                    .map(DoublePoint::new)
                                    .toArray(DoublePoint[]::new);
        List<Cluster<DoublePoint>> clusterResults = (List<Cluster<DoublePoint>>) clusterer.cluster(Arrays.asList(points));

        // 打印聚类结果
        for (int i = 0; i < clusterResults.size(); i++) {
            System.out.println("Cluster " + i + ":");
            for (DoublePoint point : clusterResults.get(i).getPoints()) {
                System.out.println(point);
            }
        }
    }
}