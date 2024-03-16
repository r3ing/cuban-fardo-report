package com.cubanfardo.cubanfardoreport.model;

import jakarta.validation.constraints.*;

import java.util.List;


public record Shipping(@NotBlank(message = "Tracking is mandatory") String tracking,
                       @NotBlank(message = "Province is mandatory") String province,
                       @PositiveOrZero(message = "Amount is positive value")
                       @NotNull(message = "Amount is mandatory") Integer amount,
                       Double weight, String details,
                       @NotNull(message = "Sender is mandatory") Sender sender,
                       @NotNull(message = "Receives is mandatory") Receives receives,
                       @NotEmpty(message = "Articles is mandatory") List<Article> articles) {
}
