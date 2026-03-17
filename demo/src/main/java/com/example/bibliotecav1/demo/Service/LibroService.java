package com.example.bibliotecav1.demo.Service;

import com.example.bibliotecav1.demo.Model.libro;
import com.example.bibliotecav1.demo.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public libro saveLibro(libro libro){
        return libroRepository.guardarLibro(libro);
    }

    public libro getLibroId(int id){
        return libroRepository.buscarLibroPorId(id);
    }

    public libro updateLibro(libro libro){
        return libroRepository.actualizarLibro(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "Producto Eliminado";
    }
}
