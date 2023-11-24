package com.cubanfardo.cubanfardoreport.model;

public record Shipping(String tracking, String province, Sender sender, Receives receives, Article article) {
}
