package com.example.bibliotecav1.demo.Service;

import com.example.bibliotecav1.demo.Model.libro;
import com.example.bibliotecav1.demo.Model.prestamo;
import com.example.bibliotecav1.demo.Repository.LibroRepository;
import com.example.bibliotecav1.demo.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<prestamo> getPrestamos() {
        return prestamoRepository.getPrestamos();
    }

    public prestamo savePrestamo(prestamo prest){
        return prestamoRepository.guardarPrestamo(prest);
    }

    public prestamo getPrestamoId(int id){
        return prestamoRepository.buscarPrestamoPorId(id);
    }

    public prestamo actualizarPrestamo(prestamo prest){
        return prestamoRepository.actualizarPrestamo(prest);
    }

    public String deletePrestamo(int id){
        prestamoRepository.eliminarPrestamo(id);
        return "Prestamo Eliminado";
    }

}
