package com.cubanfardo.cubanfardoreport.controller;

import com.cubanfardo.cubanfardoreport.model.Shipping;
import com.cubanfardo.cubanfardoreport.service.JReportService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    private final static Logger logger = LoggerFactory.getLogger(ReportController.class);

    private final JReportService jReportService;

    public ReportController(JReportService jReportService) {
        this.jReportService = jReportService;
    }

    @PostMapping("/pdf")
    public void createPdf(@Valid @RequestBody Shipping shipping, HttpServletResponse response) throws JRException, IOException {
        String fileName = shipping.tracking() + "-" + shipping.province() + ".pdf";

        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+fileName;
        response.setHeader(headerKey, headerValue);

        jReportService.exportJasperReport(shipping, response);
        logger.info("Invoice {} generated successfully!", shipping.tracking());
    }
}
