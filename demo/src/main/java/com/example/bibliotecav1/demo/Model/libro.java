package com.example.bibliotecav1.demo.Model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class libro {

    @Min(1)
    @Max(100)
    private Integer id;

    @NotEmpty(message="El ISBN no puede estar vacio")
    private String isbn;

    @NotEmpty(message="El Titulo no puede estar vacio")
    private String titulo;

    @NotEmpty(message="La editorial no puede estar vacio")
    private String editorial;

    @NotNull(message="El año de publicacion no puede estar vacio")
    private int fechaPublicacion;

    @NotEmpty(message="El Titulo no puede estar vacio")
    private String autor;

}
