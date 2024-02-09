package com.cubanfardo.cubanfardoreport.controller;

import com.cubanfardo.cubanfardoreport.model.Shipping;
import com.cubanfardo.cubanfardoreport.service.JReportService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    private final JReportService jReportService;

    public ReportController(JReportService jReportService) {
        this.jReportService = jReportService;
    }

    @PostMapping("/export/pdf")
    public void createPdf(@RequestBody Shipping shipping, HttpServletResponse response) throws JRException, IOException {
        String fileName = shipping.tracking() + "-" + shipping.province() + ".pdf";

        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+fileName;
        response.setHeader(headerKey, headerValue);

        jReportService.exportJasperReport(shipping, response);
    }
}
