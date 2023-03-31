/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import modelo.Tblcargos;
import util.clsAccesoDatos;

/**
 *
 * @author angela.olivo
 */
public class clscargos {
 private List<Tblcargos> _lista;
    private Tblcargos _seleccionado=null;
    clsAccesoDatos c;
    public clscargos() {
        carga_lista();
    }
    ///////////////
    public void carga_lista()
    {
        c=new clsAccesoDatos();
        _lista=c.consulta("from Tblcargos order by Cargo");
    }
    public void crearCargo(String cargo)
    {
         Tblcargos nuevo = new Tblcargos();
        nuevo.setCargo(cargo);
        nuevo.setIdtblcargo(0);
          c=new clsAccesoDatos();
          c.agregar(nuevo);
    }
    public void actualizar(Tblcargos cargo)
    {
        c=new clsAccesoDatos();
        c.actualizar(cargo);
        carga_lista();
    }   
    
    public List<Tblcargos> getLista() {
        return _lista;
    }

    /**
     * @param _lista the _lista to set
     */
    public void setLista(List<Tblcargos> _lista) {
        this._lista = _lista;
    }

    /**
     * @return the _seleccionado
     */
    public Tblcargos getSeleccionado() {
        return _seleccionado;
    }

    /**
     * @param _seleccionado the _seleccionado to set
     */
    public void setSeleccionado(Tblcargos _seleccionado) {
        this._seleccionado = _seleccionado;
    }

   
}
