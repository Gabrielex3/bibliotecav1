package com.example.bibliotecav1.demo.Controller;

import com.example.bibliotecav1.demo.Model.libro;
import com.example.bibliotecav1.demo.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/libros")
public class libroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public libro agregarLibro(@RequestBody libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("/id/{id}")
    public libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping("/id/{id}")
    public libro actualizarLibro(@PathVariable int id, @RequestBody libro libro){
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/id/{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibroV2(){return libroService.totalLibro2();}

    @GetMapping("/isbn/{strb}")
    public libro buscarLibroStbr(@PathVariable String strb){
        return libroService.getLibroIsbn(strb);
    }


}




