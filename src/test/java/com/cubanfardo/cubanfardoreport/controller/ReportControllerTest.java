package com.cubanfardo.cubanfardoreport.controller;

import com.cubanfardo.cubanfardoreport.model.Shipping;
import com.cubanfardo.cubanfardoreport.service.JReportService;
import net.sf.jasperreports.engine.JRException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.mockito.Mockito.verify;

import java.io.IOException;

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
                , "Las Tunas", 50, 10.5
                , "3 bags", null, null, null);

        reportController.createPdf(shipping, response);

        verify(response).setContentType("application/pdf");

        String expectedFileName = shipping.tracking() + "-" + shipping.province() + ".pdf";

        verify(response).setHeader("Content-Disposition"
                , "attachment; filename=" + expectedFileName);

        verify(jReportService).exportJasperReport(shipping, response);
    }
}