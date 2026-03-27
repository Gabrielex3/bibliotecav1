package com.example.bibliotecav1.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@CrossOrigin(origins = "*")
public class webController {
    // Aquí creamos la ruta que tú querías
    @GetMapping("/api/v1/prestamos/html")
    public String mostrarPagina() {
        // Esto le dice a Spring: "Ve a la carpeta static y muestra el index.html"
        return "forward:/index.html";
    }
}
