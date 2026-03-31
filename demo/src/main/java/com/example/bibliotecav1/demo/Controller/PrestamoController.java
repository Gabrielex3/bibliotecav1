package com.example.bibliotecav1.demo.Controller;

import com.example.bibliotecav1.demo.Model.prestamo;
import com.example.bibliotecav1.demo.Service.LibroService;
import com.example.bibliotecav1.demo.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos") // <--- AQUÍ se mapea la ruta principal
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<prestamo> getPrestamos(){
        return prestamoService.getPrestamos();
    }
    @PostMapping
    public prestamo agregarPrestamo(@RequestBody prestamo prest){
        return prestamoService.savePrestamo(prest);
    }
    @GetMapping("/{id}")
    public prestamo buscarPrestamo(@PathVariable int id){
        return prestamoService.getPrestamoId(id);
    }
    @PutMapping("/{id}")
    public prestamo actualizarPrestamo(@PathVariable int id, @RequestBody prestamo prest){
        return prestamoService.actualizarPrestamo(prest);
    }
    @DeleteMapping("/{id}")
    public String eliminarPrestamo(@PathVariable int id){
        return prestamoService.deletePrestamo(id);
    }
}