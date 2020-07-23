/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carolina.managedbean;

/**
 *
 * @author dennis
 */
public interface ManagedBeanInterfaces <R>{
    //DEFINIR LOS METODO
    
    public void nuevo();
    
    public void grabar();
    
    public void seleccionar(R r);
    
    public void eliminar(R r);
    
    public void cancelar();
    
}
