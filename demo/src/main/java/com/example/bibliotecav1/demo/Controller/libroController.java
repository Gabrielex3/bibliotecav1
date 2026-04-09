package com.example.bibliotecav1.demo.Controller;

import com.example.bibliotecav1.demo.Model.libro;
import com.example.bibliotecav1.demo.Service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/libros")
public class libroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity <List<libro>> listarLibros(){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.getLibros());
    }

//    @PostMapping
//    public libro agregarLibro(@RequestBody libro libro){
//        return libroService.saveLibro(libro);
//    }

    @PostMapping
    public ResponseEntity <libro> agregarLibro(@Valid @RequestBody libro libro) {
        // Creo una variable para almacenar la respuesta
        libro libroGuardado=libroService.saveLibro(libro);
        // Respondo con código HttpStatus
        return
                ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado);
    }



    @GetMapping("buscador/id/{id}")
    public ResponseEntity<?>  buscarLibro(@Valid @PathVariable Integer id){
       libro libroBuscado = libroService.getLibroId(id);
        if (libroService.getLibroId(id)!=null) {
            // Ejemplo 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(libroBuscado);
        } else {
            // Ejemplo 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro con el id "+id+" no encontrado");
        }
    }

    @PutMapping("/id/{id}")
    public libro actualizarLibro(@PathVariable Integer id, @RequestBody libro libro){
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("buscador/id/{id}")
    public String eliminarLibro(@PathVariable Integer id){
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibroV2(){return libroService.totalLibro2();}

    @GetMapping("buscador/isbn/{strb}")
    public libro buscarLibroStbr(@PathVariable String strb){
        return libroService.getLibroIsbn(strb);
    }

    @GetMapping("buscador/getAnioLista/{year}")
    public List<libro> getTotalLibrosAnio(@PathVariable int year){
        return libroService.getTotalLibrosAnio(year);
    }
    @GetMapping("buscador/getAnioContador/{year}")
    public String getTotalLibrosContador(@PathVariable int year){
        return "EL TOTAL DE LIBROS LO CUALES SON DEL ANIO : "+year+" Son en total :"+ libroService.getTotaLibrosAnioContador(year);
    }

    @GetMapping("buscador/getForAutor/{autor}")
    public libro getForAutor(@PathVariable String autor){
        return libroService.getForAutor(autor);
    }

    @GetMapping("buscador/masAntiguo")
    public libro getMoreOld(){
        return libroService.getMoreOld();
    }

    @GetMapping("buscador/masNuevo")
    public libro getMoreNew(){
        return libroService.getMoreNew();
    }




}




