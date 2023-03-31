/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clsdirecciones;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Tbldirecciones;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author angela.olivo
 */
@Named(value = "direccionBean")
@SessionScoped
public class direccionBean implements Serializable {
  private clsdirecciones dir;
  private String _nuevadireccion;
    /**
     * Creates a new instance of direccionBean
     */
    public direccionBean() {
        dir=new clsdirecciones();
    }
    public void crear_nueva()
    {
        dir.crearDireccion(_nuevadireccion);
        dir.carga_lista();
        _nuevadireccion="";
    }
    
    public void onRowEdit(RowEditEvent<Tbldirecciones> event) {
        try{
        Tbldirecciones d= event.getObject();
        dir.actualizar(d);
        dir.carga_lista();
        }        
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
      /*  FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getCode()));
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }
    /**
     * @return the dir
     */
    public clsdirecciones getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(clsdirecciones dir) {
        this.dir = dir;
    }

    /**
     * @return the _nuevadireccion
     */
    public String getNuevadireccion() {
        return _nuevadireccion;
    }

    /**
     * @param _nuevadireccion the _nuevadireccion to set
     */
    public void setNuevadireccion(String _nuevadireccion) {
        this._nuevadireccion = _nuevadireccion;
    }
    
}
