package com.example.bibliotecav1.demo.Repository;

import com.example.bibliotecav1.demo.Model.libro;
import com.example.bibliotecav1.demo.Model.prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class LibroRepository {

    private final List<libro> listaLibros = new ArrayList<>();
    private final List<prestamo> listaPrestamos = new ArrayList<>();

    public LibroRepository(){
        listaLibros.add(new libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new libro(7, "9780321127426", "Effective Java", "Addison- Wesley", 2008, "Joshua Bloch"));
        listaLibros.add(new libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2014, "Robert C. Martin"));
        listaLibros.add(new libro(9, "9780201633610", "Design Patterns", "Addison- Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2014, "Robert C. Martin"));
        listaPrestamos.add(new prestamo(1, 2, "22.294.222-2", new Date(), null, 5, 0));
    }



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

    public int totalLibros(){return listaLibros.size();}


    public List<libro> buscarAnio(int anio) {
        List<libro> listaLibrosAnio = new ArrayList<>();

        for (libro libro : listaLibros) {
            if (libro.getFechaPublicacion() == anio) {
                listaLibrosAnio.add(libro);
            }
        }

        return listaLibrosAnio;
    }

    public int totalLibrosContador(int anio){
        int contador = 0;
        for (libro libro : listaLibros){
            if (libro.getFechaPublicacion() == anio) {
                contador++;
            }
        }
        return contador;}

    public libro buscarPorAutor(String autor) {
        for (libro libro : listaLibros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    public libro masAntiguo() {
        libro masAntiguo = listaLibros.getFirst();

        for (libro libro : listaLibros) {
            if (libro.getFechaPublicacion() < masAntiguo.getFechaPublicacion()) {
                masAntiguo = libro;
            }
        }

        return masAntiguo;
    }

    public libro masNuevo() {
        libro masNuevo = listaLibros.getFirst();

        for (libro libro : listaLibros) {
            if (libro.getFechaPublicacion() > masNuevo.getFechaPublicacion()) {
                masNuevo = libro;
            }
        }

        return masNuevo;
    }

    public List<prestamo> getPrestamos() {
        return listaPrestamos;
    }

    public prestamo guardarPrestamo(prestamo pres) {
        listaPrestamos.add(pres);
        return pres;
    }

    public prestamo buscarPrestamoPorId(Integer id) {
        for (prestamo prestamo : listaPrestamos) {
            if (prestamo.getId_prestamo() == id) {
                return prestamo;
            }
        }
        return null;
    }

    public prestamo actualizarPrestamo(prestamo prest) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == prest.getId_prestamo()){
                id = prest.getId_prestamo();
                idPosicion = i;
            }
        }

        prestamo prestates1 = new prestamo();
        prestates1.setId_prestamo(id);
        prestates1.setId_libro(prest.getId_libro());
        prestates1.setRun_solicitante(prest.getRun_solicitante());
        prestates1.setFecha_solicitud(prest.getFecha_solicitud());
        prestates1.setFecha_entrega(prest.getFecha_solicitud());
        prestates1.setCantidad_dias(prest.getCantidad_dias());
        prestates1.setMultas(prest.getMultas());

        listaPrestamos.set(idPosicion, prestates1);
        return prestates1;
    }

    public void eliminarPrestamo(int id){
        prestamo prestamo = buscarPrestamoPorId(id);
        if(prestamo!=null){
            listaPrestamos.remove(prestamo);
        }
        listaPrestamos.remove(prestamo);
    }
}
