package com.cubanfardo.cubanfardoreport.service;

import com.cubanfardo.cubanfardoreport.model.Shipping;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class JReportService {

    public void exportJasperReport(Shipping shipping, HttpServletResponse response) throws IOException, JRException {

        File file = ResourceUtils.getFile("classpath:report/blank.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> param = new HashMap<>();
        param.put("shipping", shipping);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\APP\\cuban-fardo-report\\invoice.pdf");
        //JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
