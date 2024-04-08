package com.lq.map;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

public class ChartToPdfDemo {

    public static void main(String[] args) {
        // 创建图表数据集
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(200, "Sales", "Product 1");
        dataset.addValue(300, "Sales", "Product 2");
        dataset.addValue(400, "Sales", "Product 3");

        // 创建柱状图
        JFreeChart chart = ChartFactory.createBarChart("Sales", "Product", "Amount", dataset);

        try {
            // 创建PDF文档
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\芦庆\\Desktop\\output.pdf"));
            document.open();
            
            // 将图表绘制到PDF文档
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(500, 400);
            Graphics2D graphics2d = template.createGraphics(500, 400, new DefaultFontMapper());
            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, 500, 400);
            chart.draw(graphics2d, rectangle2d);
            graphics2d.dispose();
            contentByte.addTemplate(template, 30, 300);

            // 添加其他内容
            Paragraph paragraph = new Paragraph("Sales Chart:");
            document.add(paragraph);

            // 关闭文档
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}