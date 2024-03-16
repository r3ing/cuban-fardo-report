package com.cubanfardo.cubanfardoreport.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Sender(@NotNull(message = "Name is mandatory") String name,
                     @NotBlank(message = "Phone is mandatory") String phone) {
}
