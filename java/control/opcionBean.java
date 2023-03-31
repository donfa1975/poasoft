/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clsopciones;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Tblopciones;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author angela.olivo
 */
@Named(value = "opcionBean")
@SessionScoped
public class opcionBean implements Serializable {

    /**
     * Creates a new instance of opcionBean
     */
  private clsopciones op;
  private String _nuevaopcion;
    /**
     * Creates a new instance of opcionBean
     */
    public opcionBean() {
        op=new clsopciones();
    }
    public void crear_nueva()
    {
        op.crearOpcion(_nuevaopcion);
        op.carga_lista();
        _nuevaopcion="";
    }
    
    public void onRowEdit(RowEditEvent<Tblopciones> event) {
        try{
        Tblopciones d= event.getObject();
        op.actualizar(d);
        op.carga_lista();
        }        
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
      /*  FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getCode()));
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }
    /**
     * @return the op
     */
    public clsopciones getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(clsopciones op) {
        this.op = op;
    }

    /**
     * @return the _nuevaopcion
     */
    public String getNuevaopcion() {
        return _nuevaopcion;
    }

    /**
     * @param _nuevaopcion the _nuevaopcion to set
     */
    public void setNuevaopcion(String _nuevaopcion) {
        this._nuevaopcion = _nuevaopcion;
    }

    /**
     * @return the _nuevaopcion
     */
    
    
}
