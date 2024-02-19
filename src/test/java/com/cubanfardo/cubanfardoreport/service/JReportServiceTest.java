package com.cubanfardo.cubanfardoreport.service;

import com.cubanfardo.cubanfardoreport.model.Article;
import com.cubanfardo.cubanfardoreport.model.Shipping;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class JReportServiceTest {

    @InjectMocks
    JReportService jReportService;

    @Mock
    private HttpServletResponse response;


    @Test
    public void exportJasperPdfReportTest() throws IOException, JRException {

        List<Article> articles = new ArrayList<>();
        articles.add(new Article( 10, "Article 1"));
        articles.add(new Article( 20, "Article 2"));


        Shipping shipping = new Shipping("W1234"
                , "Las Tunas", 50, 10.5
                , "3 bags", null, null, articles);


        ServletOutputStream servletOut = mock(ServletOutputStream.class);
        when(response.getOutputStream()).thenReturn(servletOut);

        jReportService.exportJasperReport(shipping, response);

    }

}