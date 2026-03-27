package com.example.bibliotecav1.demo.Model;

import com.example.bibliotecav1.demo.Model.libro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class prestamo{
    private int id_prestamo;
    private int id_libro;
    private String run_solicitante;
    private Date fecha_solicitud=new Date();
    private Date fecha_entrega=null;
    private int cantidad_dias;
    private int multas=0;
}


