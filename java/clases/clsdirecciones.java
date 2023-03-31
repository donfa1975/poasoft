/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import modelo.Tbldirecciones;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import util.clsAccesoDatos;

/**
 *
 * @author angela.olivo
 */
public class clsdirecciones {

    private List<Tbldirecciones> _lista;
    private Tbldirecciones _seleccionado=null;
    clsAccesoDatos c;
    public clsdirecciones() {
        carga_lista();
    }
    ///////////////
    public void carga_lista()
    {
        c=new clsAccesoDatos();
        _lista=c.consulta("from Tbldirecciones order by Direccion");
    }
    public void crearDireccion(String nombredireccion)
    {
        Tbldirecciones nueva=new Tbldirecciones();
        nueva.setActivo(Byte.valueOf("1"));
        nueva.setDireccion(nombredireccion);
        nueva.setIdtbldireccion(0);
          c=new clsAccesoDatos();
          c.agregar(nueva);
    }
    public void actualizar(Tbldirecciones d)
    {
        c=new clsAccesoDatos();
        c.actualizar(d);
        carga_lista();
    }
    
    //////////////

    /**
     * @return the _lista
     */
    public List<Tbldirecciones> getLista() {
        return _lista;
    }

    /**
     * @param _lista the _lista to set
     */
    public void setLista(List<Tbldirecciones> _lista) {
        this._lista = _lista;
    }

    /**
     * @return the _seleccionado
     */
    public Tbldirecciones getSeleccionado() {
        return _seleccionado;
    }

    /**
     * @param _seleccionado the _seleccionado to set
     */
    public void setSeleccionado(Tbldirecciones _seleccionado) {
        this._seleccionado = _seleccionado;
    }
    
}
