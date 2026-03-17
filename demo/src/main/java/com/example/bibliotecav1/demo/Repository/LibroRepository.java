package com.example.bibliotecav1.demo.Repository;

import com.example.bibliotecav1.demo.Model.libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LibroRepository {

    private final List<libro> listaLibros = new ArrayList<>();


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
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }

        libro libro1 = new libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion,libro1);
        return libro1;
    }

    public void eliminar(int id){
        libro libro = buscarLibroPorId(id);
        if(libro!=null){
            listaLibros.remove(libro);
        }
        listaLibros.remove(libro);
    }


}
