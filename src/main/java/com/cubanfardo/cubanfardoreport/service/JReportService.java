package com.cubanfardo.cubanfardoreport.service;

import com.cubanfardo.cubanfardoreport.model.Article;
import com.cubanfardo.cubanfardoreport.model.Shipping;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class JReportService {

    public void exportJasperReport(Shipping shipping, HttpServletResponse response) throws IOException, JRException {

        File file = ResourceUtils.getFile("classpath:report/invoice.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(shipping.articles());

        Map<String, Object> param = new HashMap<>();
        param.put("shipping", shipping);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
        //JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\APP\\cuban-fardo-report\\invoice.pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }

    private List<Article> splitContent(List<Article> articles) {
        if(articles.size() <= 35) {
            return articles;
        }

        for (int i = 0; i < articles.size(); i++) {

        }

        List<Article> content = articles.subList(33, articles.size());

        for (int i = 0; i < content.size(); i++) {
            articles.get(i).setTotal1(content.get(i).getTotal());
            articles.get(i).setName1(content.get(i).getName());
            if(i == 32) {
                break;
            }
        }

        return articles;

        //return articles.subList(0, articles.size() - content.size());
    }
}
