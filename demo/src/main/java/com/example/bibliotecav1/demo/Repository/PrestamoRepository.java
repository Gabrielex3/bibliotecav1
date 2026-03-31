package com.example.bibliotecav1.demo.Repository;

import com.example.bibliotecav1.demo.Model.libro;
import com.example.bibliotecav1.demo.Model.prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class PrestamoRepository {

    private final List<prestamo> listaPrestamos = new ArrayList<>();
    private final List<libro> listaLibros = new ArrayList<>();

    public PrestamoRepository(){
        listaPrestamos.add(new prestamo(1, 2, "22.294.222-2", new Date(), null, 5, 0));
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
