/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import modelo.Tblopciones;
import util.clsAccesoDatos;

/**
 *
 * @author angela.olivo
 */
public class clsopciones {
 private List<Tblopciones> _lista;
    private Tblopciones _seleccionado=null;
    clsAccesoDatos c;
    public clsopciones() {
        carga_lista();
    }
    ///////////////
    public void carga_lista()
    {
        c=new clsAccesoDatos();
        _lista=c.consulta("from Tblopciones order by Opcion");
    }
    public void crearOpcion(String nombreopcion)
    {
        Tblopciones nueva=new Tblopciones();
        nueva.setOpcion(nombreopcion);
        nueva.setIdtblopcion(0);
          c=new clsAccesoDatos();
          c.agregar(nueva);
    }
    public void actualizar(Tblopciones op)
    {
        c=new clsAccesoDatos();
        c.actualizar(op);
        carga_lista();
    }   
    
    public List<Tblopciones> getLista() {
        return _lista;
    }

    /**
     * @param _lista the _lista to set
     */
    public void setLista(List<Tblopciones> _lista) {
        this._lista = _lista;
    }

    /**
     * @return the _seleccionado
     */
    public Tblopciones getSeleccionado() {
        return _seleccionado;
    }

    /**
     * @param _seleccionado the _seleccionado to set
     */
    public void setSeleccionado(Tblopciones _seleccionado) {
        this._seleccionado = _seleccionado;
    }
}
