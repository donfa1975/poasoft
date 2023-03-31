/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clscargos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Tblcargos;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author angela.olivo
 */
@Named(value = "cargoBean")
@SessionScoped
public class cargoBean implements Serializable {

    /**
     * Creates a new instance of cargoBean
     */
  private clscargos car;
  private String _nuevocargo;
    
    /**
     * Creates a new instance of cargoBean
     */
    public cargoBean() {
        car=new clscargos();
    }
    public void crear_nueva()
    {
       
        car.crearCargo(_nuevocargo);
        car.carga_lista();
        _nuevocargo="";
    }
    
    public void onRowEdit(RowEditEvent<Tblcargos> event) {
        try{
        Tblcargos c= event.getObject();
        car.actualizar(c);
        car.carga_lista();
        }        
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
      /*  FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getCode()));
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }
    /**
     * @return the car
     */
    public clscargos getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(clscargos car) {
        this.car = car;
    }

    /**
     * @return the _nuevocargo
     */
    public String getNuevocargo() {
        return _nuevocargo;
    }

    /**
     * @param _nuevocargo the _nuevocargo to set
     */
    public void setNuevocargo(String _nuevocargo) {
        this._nuevocargo = _nuevocargo;
    }

    /**
     * @return the _nuevocargo
     */
    

    
    
}

