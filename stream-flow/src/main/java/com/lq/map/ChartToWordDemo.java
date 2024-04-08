package com.lq.map;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 生成图表导出到Word
 */
public class ChartToWordDemo {

    public static void main(String[] args) {
        // 创建图表数据集
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(200, "Sales", "Product 1");
        dataset.addValue(300, "Sales", "Product 2");
        dataset.addValue(400, "Sales", "Product 3");

        // 创建柱状图
        JFreeChart chart = ChartFactory.createBarChart("Sales", "Product", "Amount", dataset);

        try {
            // 创建Word文档
            XWPFDocument document = new XWPFDocument();
            // 创建段落
            XWPFParagraph paragraph = document.createParagraph();
            // 创建文本运行
            XWPFRun run = paragraph.createRun();
            // 设置文本内容
            run.setText("Sales Chart:");
            // 添加换行
            run.addBreak();

            // 创建图片段落
            XWPFParagraph chartParagraph = document.createParagraph();
            // 设置段落对齐方式为居中
            chartParagraph.setAlignment(ParagraphAlignment.CENTER);

            // 创建图片，并设置大小
            ByteArrayOutputStream chartOutputStream = new ByteArrayOutputStream();
            ChartUtils.writeChartAsPNG(chartOutputStream, chart, 600, 400);
            InputStream chartInputStream = new ByteArrayInputStream(chartOutputStream.toByteArray());
            XWPFRun chartRun = chartParagraph.createRun();
            chartRun.addPicture(chartInputStream, Document.PICTURE_TYPE_PNG, "chart.png", Units.toEMU(500), Units.toEMU(400));
            chartInputStream.close();
            chartOutputStream.close();

            // 导出到Word文件
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\芦庆\\Desktop\\output.docx");
            document.write(outputStream);
            document.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}