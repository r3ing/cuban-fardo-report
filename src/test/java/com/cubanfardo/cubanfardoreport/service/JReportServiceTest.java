package com.cubanfardo.cubanfardoreport.service;

import com.cubanfardo.cubanfardoreport.model.*;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JReportServiceTest {

    @InjectMocks
    JReportService jReportService;

    @Mock
    private HttpServletResponse response;


    @Test
    public void exportJasperPdfReportTest() throws IOException, JRException {

        List<Article> articles = new ArrayList<>();
        articles.add(new Article(10, "Article 1"));
        articles.add(new Article(20, "Article 2"));


        Shipping shipping = new Shipping("W1234"
                , "Las Tunas", 50.0, 10.5, "3 bags"
                , new Sender("anyString", "anyString")
                , new Receives("anyString", "anyString", "anyString")
                , new Office("anyString", "anyString", "anyString")
                , articles);


        ServletOutputStream servletOut = mock(ServletOutputStream.class);
        when(response.getOutputStream()).thenReturn(servletOut);

        jReportService.exportJasperReport(shipping, response);

    }

}