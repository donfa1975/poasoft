/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clsseguimiento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import modelo.Tblactividades;
import org.primefaces.model.file.UploadedFile;


/**
 *
 * @author fabricio
 */
@Named(value = "seguimientoBean")
@SessionScoped
public class seguimientoBean implements Serializable {
    private clsseguimiento _seg;
    private int _iddireccion;
    private int _idactividad;
    private String _nomact;
    private Double _valor;
    private Tblactividades _actividadSel;
    private String _log;
    private UploadedFile file;
    /**
     * Creates a new instance of seguimientoBean
     */
    public seguimientoBean() {
        _seg=new clsseguimiento();
        _seg.carga_presupuesto();
        _iddireccion=0;
    }
    public void update_presupuesto()
    {
        _actividadSel.setValorRefer(BigDecimal.valueOf(_valor));
        _seg.actualizar(_actividadSel);
        _seg.carga_presupuesto();
    }
    public void enviar_archivo()
    {
    
    }
    public void carga_presupuesto_dire()
    {
        if(_iddireccion>0)
        {
            _seg.carga_actividades(_iddireccion);
        }
    }
   
    /**
     * @return the _seg
     */
    public clsseguimiento getSeg() {
        return _seg;
    }

    /**
     * @param _seg the _seg to set
     */
    public void setSeg(clsseguimiento _seg) {
        this._seg = _seg;
    }

    /**
     * @return the _iddireccion
     */
    public int getIddireccion() {
        return _iddireccion;
    }

    /**
     * @param _iddireccion the _iddireccion to set
     */
    public void setIddireccion(int _iddireccion) {
        this._iddireccion = _iddireccion;
    }

    /**
     * @return the _actividadSel
     */
    public Tblactividades getActividadSel() {
        return _actividadSel;
    }
    public String ver_detalle()
    {
        return "wdetalleactividad?faces-redirect=true";
    }
   
    /**
     * @param _actividadSel the _actividadSel to set
     */
    public void setActividadSel(Tblactividades _actividadSel) {
        this._actividadSel = _actividadSel;
        this._idactividad=_actividadSel.getIdtblactividad();
        this._nomact=_actividadSel.getActividad();
        this._valor=_actividadSel.getValorRefer().doubleValue();
    }

    /**
     * @return the _log
     */
    public String getLog() {
        return _log;
    }

    /**
     * @param _log the _log to set
     */
    public void setLog(String _log) {
        this._log = _log;
    }

    /**
     * @return the _idactividad
     */
    public int getIdactividad() {
        return _idactividad;
    }

    /**
     * @param _idactividad the _idactividad to set
     */
    public void setIdactividad(int _idactividad) {
        this._idactividad = _idactividad;
    }

    /**
     * @return the _nomact
     */
    public String getNomact() {
        return _nomact;
    }

    /**
     * @param _nomact the _nomact to set
     */
    public void setNomact(String _nomact) {
        this._nomact = _nomact;
    }

    /**
     * @return the _valor
     */
    public Double getValor() {
        return _valor;
    }

    /**
     * @param _valor the _valor to set
     */
    public void setValor(Double _valor) {
        this._valor = _valor;
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
}
