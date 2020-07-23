/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carolina.managedbean;

import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.inject.Named;


/**
 *
 * @author dennis
 */
@Named(value = "reservaManagedBean")
@Dependent
public class ReservaManagedBean implements Serializable{

    /**
     * Creates a new instance of ReservaManagedBean
     */
    public ReservaManagedBean() {
    }
    
}
