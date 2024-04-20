package com.cubanfardo.cubanfardoreport.controller;

import com.cubanfardo.cubanfardoreport.model.*;
import com.cubanfardo.cubanfardoreport.service.JReportService;
import net.sf.jasperreports.engine.JRException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReportControllerTest {

    @Mock
    JReportService jReportService;

    @InjectMocks
    ReportController reportController;

    @Mock
    MockHttpServletResponse response;

    @Test
    void createPdfTest() throws JRException, IOException {

        Shipping shipping = new Shipping("W1234"
                , "Las Tunas", 50.0, 10.5, "3 bags"
                , new Sender("anyString", "anyString")
                , new Receives("anyString", "anyString", "anyString")
                , new Office("anyString", "anyString", "anyString")
                , List.of(new Article(0, "anyString")));

        reportController.createPdf(shipping, response);

        verify(response).setContentType("application/pdf");

        String expectedFileName = shipping.tracking() + "-" + shipping.province() + ".pdf";

        verify(response).setHeader("Content-Disposition", "attachment; filename=" + expectedFileName);

        verify(jReportService).exportJasperReport(shipping, response);
    }
}