/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clscargos;
import clases.clsdirecciones;
import clases.clsusuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Tblcargos;
import modelo.Tbldirecciones;
import modelo.Tblusuarios;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author angela.olivo
 */
@Named(value = "usuarioBean")
@SessionScoped
public class usuarioBean implements Serializable {
    private clsusuarios _usuarios;
    private clscargos _cargos;
    private clsdirecciones _direccion;
    /*private Tbldirecciones _direccionSel;
    private Tblcargos _cargoSel;*/
    int _direccionSel,_cargoSel;
    private Tblusuarios _usuariosel, _nuevousuario;
    /**
     * Creates a new instance of usuarioBean
     */
    public usuarioBean() {
        _usuarios=new clsusuarios();
        _cargos=new clscargos();
        _direccion=new clsdirecciones();
        _direccionSel=0;//null;
        _cargoSel=0;//null;
        _usuariosel=new Tblusuarios();
        //_usuariosel.setNombre("Musollini");
        _nuevousuario=new Tblusuarios();
    }

  /*  public void onRowEdit(RowEditEvent<Tblusuarios> event) {
        try{
        Tblusuarios c= event.getObject();
        _usuarios.actualizar(c);
        _usuarios.carga_lista();
        }        
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
        }*/
    /**
     * @return the _usuarios
     */
    public clsusuarios getUsuarios() {
        return _usuarios;
    }

    /**
     * @param _usuarios the _usuarios to set
     */
    public void setUsuarios(clsusuarios _usuarios) {
        this._usuarios = _usuarios;
    }

    /**
     * @return the _cargos
     */
    public clscargos getCargos() {
        return _cargos;
    }

    /**
     * @param _cargos the _cargos to set
     */
    public void setCargos(clscargos _cargos) {
        this._cargos = _cargos;
    }

    /**
     * @return the _direccion
     */
    public clsdirecciones getDireccion() {
        return _direccion;
    }

    /**
     * @param _direccion the _direccion to set
     */
    public void setDireccion(clsdirecciones _direccion) {
        this._direccion = _direccion;
    }

    /**
     * @return the _direccionSel
     */
    public int getDireccionSel() {
        return _direccionSel;
    }

    /**
     * @param _direccionSel the _direccionSel to set
     */
    public void setDireccionSel(int _direccionSel) {
        this._direccionSel = _direccionSel;
    }

    /**
     * @return the _cargoSel
     */
    public int getCargoSel() {
        return _cargoSel;
    }

    /**
     * @param _cargoSel the _cargoSel to set
     */
    public void setCargoSel(int _cargoSel) {
        this._cargoSel = _cargoSel;
    }

    /**
     * @return the _usuariosel
     */
    public Tblusuarios getUsuariosel() {
        return _usuariosel;
    }

    /**
     * @param _usuariosel the _usuariosel to set
     */
    public void setUsuariosel(Tblusuarios _usuariosel) {
        this._usuariosel = _usuariosel;
       this._direccionSel=_usuariosel.getTbldirecciones().getIdtbldireccion();
       this._cargoSel=_usuariosel.getTblcargos().getIdtblcargo();
    }

    /**
     * @return the _nuevousuario
     */
    public Tblusuarios getNuevousuario() {
        return _nuevousuario;
    }

    /**
     * @param _nuevousuario the _nuevousuario to set
     */
    public void setNuevousuario(Tblusuarios _nuevousuario) {
        this._nuevousuario = _nuevousuario;
    }
    public void seleccionarUsuario(Tblusuarios este_usuario)
    {
        this._usuariosel=este_usuario;
    }
    public void crear_usuario()
    {
        int micargo=_cargoSel;
        int midireccion=0;
        midireccion=_direccionSel;
        _usuarios.crearUsuario(_nuevousuario,_cargoSel,_direccionSel);
        _usuarios.carga_lista();
    }
    public void actualizar_usuario()
    {
        int micargo=_cargoSel;
        int midireccion=_direccionSel;
        _usuarios.actualizar(_usuariosel,_cargoSel,_direccionSel);
        _usuarios.carga_lista();
    }
}
