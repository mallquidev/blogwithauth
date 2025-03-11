package com.mallqui.blogwithcli.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    @NotBlank(message = "El titulo no debe estar vacio")
    private String title;

    @NotBlank(message = "El contenido no debe ir vacio")
    private String content;

}
