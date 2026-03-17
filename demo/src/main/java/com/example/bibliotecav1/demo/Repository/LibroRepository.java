package com.example.bibliotecav1.demo.Repository;

import com.example.bibliotecav1.demo.Model.libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LibroRepository {

    private List<libro> listaLibros = new ArrayList<>();


    public List<libro> obtenerLibros() {
        return listaLibros;
    }

    public libro buscarLibroPorId(Integer id) {
        for (libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public libro buscarPorIsbn(String isbn) {
        for (libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public libro guardarLibro(libro lib) {
        listaLibros.add(lib);
        return lib;
    }

    public libro actualizarLibro(libro lib) {
        int id = 0;
        int idPosition = 0;
        for (int i=0; 1 <listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosition = 1;
            }
        }


    }
}
