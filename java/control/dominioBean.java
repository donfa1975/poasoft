/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clsdominios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Tblactividades;
import modelo.Tblobjetivos;
import modelo.Tblproyectos;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author angela.olivo
 */
@Named(value = "dominioBean")
@SessionScoped
public class dominioBean implements Serializable {
    private clsdominios _dominio;
    private int _direccionSel;
    private String _nuevoObjetivo;
    private String _nuevoPrograma;
    private Tblproyectos _nuevoProyecto;
    private String _nuevoTipo;
    private Tblobjetivos _objetivoSel;
    private Tblactividades _actividadSel;
    private Tblactividades _nuevaactividad;
    private int _idobjetivo;
    private int _idprograma;
    private int _idproyecto;
    private int _idusuario;
    
    /**
     * Creates a new instance of dominioBean
     */
    public dominioBean() {
        _dominio=new clsdominios();
        _dominio.carga_objetivos();
        _nuevaactividad=new Tblactividades();
        _actividadSel=new Tblactividades();
        _nuevoProyecto=new Tblproyectos();
    }
    public String getDireccion(int iddireccion)
    {
        String direccion=_dominio.getDireccion(iddireccion);
        return direccion;
    }
    public void onRowEdit(RowEditEvent<Tblobjetivos> event) {
        try{
        Tblobjetivos c= event.getObject();
        _dominio.actualizar(c);
        //_dominio.carga_objetivos();
        /*car.actualizar(c);
        car.carga_lista();*/
        }        
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
      /*  FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getCode()));
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }
    /**
     * @return the _dominio
     */
    public clsdominios getDominio() {
        return _dominio;
    }

    public void nuevo_objetivo()
    {
        _dominio.crear_objetivo(_nuevoObjetivo, _direccionSel);
        _dominio.carga_objetivos();
    }
    public void crea_actividad()
    {
        _dominio.crear_actividad(_nuevaactividad, _idproyecto, _idusuario);
        _dominio.carga_actividades(_idproyecto);
    }
    public void update_actividad()
    {
        _dominio.actualizar(_actividadSel);
        _dominio.carga_actividades(_idproyecto);
    }
    public void nuevo_programa()
    {
        _dominio.crear_programa(_nuevoPrograma, this._idobjetivo,this._nuevoTipo);
        _dominio.carga_programas(_idobjetivo);
    }
    public void crear_proyecto()
    {
        _dominio.crear_proyecto(_nuevoProyecto, _idprograma);
        _dominio.carga_proyectos(_idprograma);
        _nuevoProyecto=new Tblproyectos();
    }
    public void cargar_programas()
    {
        _dominio.carga_programas(_idobjetivo);
        
    }
    public void cargar_proyectos()
         {
        _dominio.carga_proyectos(_idprograma);
    }
    public void cargar_actividades()
         {
        _dominio.carga_actividades(_idproyecto);
    }   
    /**
     * @param _dominio the _dominio to set
     */
    public void setDominio(clsdominios _dominio) {
        this._dominio = _dominio;
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
     * @return the _nuevoObjetivo
     */
    public String getNuevoObjetivo() {
        return _nuevoObjetivo;
    }

    /**
     * @param _nuevoObjetivo the _nuevoObjetivo to set
     */
    public void setNuevoObjetivo(String _nuevoObjetivo) {
        this._nuevoObjetivo = _nuevoObjetivo;
    }

    /**
     * @return the _objetivoSel
     */
    public Tblobjetivos getObjetivoSel() {
        return _objetivoSel;
    }

    /**
     * @param _objetivoSel the _objetivoSel to set
     */
    public void setObjetivoSel(Tblobjetivos _objetivoSel) {
        this._objetivoSel = _objetivoSel;
    }

    /**
     * @return the _idobjetivo
     */
    public int getIdobjetivo() {
        return _idobjetivo;
    }

    /**
     * @param _idobjetivo the _idobjetivo to set
     */
    public void setIdobjetivo(int _idobjetivo) {
        this._idobjetivo = _idobjetivo;
    }

    /**
     * @return the _nuevoPrograma
     */
    public String getNuevoPrograma() {
        return _nuevoPrograma;
    }

    /**
     * @param _nuevoPrograma the _nuevoPrograma to set
     */
    public void setNuevoPrograma(String _nuevoPrograma) {
        this._nuevoPrograma = _nuevoPrograma;
    }

    /**
     * @return the _nuevoTipo
     */
    public String getNuevoTipo() {
        return _nuevoTipo;
    }

    /**
     * @param _nuevoTipo the _nuevoTipo to set
     */
    public void setNuevoTipo(String _nuevoTipo) {
        this._nuevoTipo = _nuevoTipo;
    }

    /**
     * @return the _nuevoProyecto
     */
    public Tblproyectos getNuevoProyecto() {
        return _nuevoProyecto;
    }

    /**
     * @param _nuevoProyecto the _nuevoProyecto to set
     */
    public void setNuevoProyecto(Tblproyectos _nuevoProyecto) {
        this._nuevoProyecto = _nuevoProyecto;
    }

    /**
     * @return the _idprograma
     */
    public int getIdprograma() {
        return _idprograma;
    }

    /**
     * @param _idprograma the _idprograma to set
     */
    public void setIdprograma(int _idprograma) {
        this._idprograma = _idprograma;
    }

    /**
     * @return the _idproyecto
     */
    public int getIdproyecto() {
        return _idproyecto;
    }

    /**
     * @param _idproyecto the _idproyecto to set
     */
    public void setIdproyecto(int _idproyecto) {
        this._idproyecto = _idproyecto;
    }

    /**
     * @return the _actividadSel
     */
    public Tblactividades getActividadSel() {
        return _actividadSel;
    }

    /**
     * @param _actividadSel the _actividadSel to set
     */
    public void setActividadSel(Tblactividades _actividadSel) {
        this._actividadSel = _actividadSel;
        this._idusuario=_actividadSel.getTblusuarios().getIdtblusuario();
    }

    /**
     * @return the _nuevaactividad
     */
    public Tblactividades getNuevaactividad() {
        return _nuevaactividad;
    }

    /**
     * @param _nuevaactividad the _nuevaactividad to set
     */
    public void setNuevaactividad(Tblactividades _nuevaactividad) {
        this._nuevaactividad = _nuevaactividad;
    }

    /**
     * @return the _idusuario
     */
    public int getIdusuario() {
        return _idusuario;
    }

    /**
     * @param _idusuario the _idusuario to set
     */
    public void setIdusuario(int _idusuario) {
        this._idusuario = _idusuario;
    }
}
