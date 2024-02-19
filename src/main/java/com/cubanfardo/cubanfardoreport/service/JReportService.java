package com.cubanfardo.cubanfardoreport.service;

import com.cubanfardo.cubanfardoreport.model.Article;
import com.cubanfardo.cubanfardoreport.model.Shipping;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JReportService {

    public void exportJasperReport(Shipping shipping, HttpServletResponse response) throws IOException, JRException {
        ClassPathResource classPathResource = new ClassPathResource("report/invoice.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(classPathResource.getInputStream());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(shipping.articles());

        Map<String, Object> param = new HashMap<>();
        param.put("shipping", shipping);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
        //JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\APP\\cuban-fardo-report\\invoice.pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }

}
