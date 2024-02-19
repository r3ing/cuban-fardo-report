package com.cubanfardo.cubanfardoreport.model;

import java.util.List;

public record Shipping(String tracking, String province, Integer amount, Double weight, String details, Sender sender, Receives receives, List<Article> articles) {
}
