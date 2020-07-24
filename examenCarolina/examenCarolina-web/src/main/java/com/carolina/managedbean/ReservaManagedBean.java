/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carolina.managedbean;

import com.carolina.entidades.Reserva;
import com.carolina.session.ReservaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "reservaManagedBean")
@ViewScoped
public class ReservaManagedBean implements Serializable, ManagedBeanInterfaces<Reserva>{

    @EJB
    private ReservaFacadeLocal reservaFacadeLocal;
    
    public ReservaManagedBean() {
    }
    
     //VARIABLE DE TIPO LISTACARGOS
    private List<Reserva> listaReservas;
    
    //ESTO ES CUANDO QUIERO AGREGAR O EDITAR UN CARGO
    private Reserva reserva;
   
    @PostConstruct
    public void init(){
        
        //lista de los cargos que estan en la BDD
        //AQUI EL CARGO EN LA LISTA
        listaReservas = reservaFacadeLocal.findAll();
        
    }

    @Override
    public void nuevo() {
        reserva = new Reserva();
    }

    @Override
    public void grabar() {
        try{
           //CON ESTO COMPRUEBA SI ES PARA CREAR O ES PARA EDITAR
           if(reserva.getId() == null){
               reservaFacadeLocal.create(reserva);
           }else{
               reservaFacadeLocal.edit(reserva);
           }
           //SI YA SE GUARDO O SE EDITO
           //LA CLASE SE PONE EN NULL
           //LUEGO SE DEBE LISTAR
           reserva = null;
           listaReservas = reservaFacadeLocal.findAll();
           //LUEGO UN MENSAJE
           mostrarMensajeTry("INFORMACIÓN EXITOSA", FacesMessage.SEVERITY_INFO);
       }catch(Exception e){
           mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
       }
    }

    @Override
    public void seleccionar(Reserva r) {
        reserva = r;
    }

    @Override
    public void eliminar(Reserva r) {
        try{
            //ELIMINO EL EMPLEADO
            reservaFacadeLocal.remove(r);
            //LUEGO LISTO LOS EMPLEADOS
            listaReservas = reservaFacadeLocal.findAll();
            mostrarMensajeTry("ELIMINADO EXITOSAMENTE", FacesMessage.SEVERITY_INFO);
        }catch(Exception e){
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void cancelar() {
        reserva = null;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }  
}
