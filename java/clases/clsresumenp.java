/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author fabricio
 */
public class clsresumenp {
    private String _direccion;
    private double _pendiente;
    private double _iniciado;
    private double _ejecutado;

    public clsresumenp(String _direccion) {
        this._direccion = _direccion;
        _pendiente=0;
        _iniciado=0;
        _ejecutado=0;
    }
    
    /**
     * @return the _direccion
     */
    public String getDireccion() {
        return _direccion;
    }

    /**
     * @param _direccion the _direccion to set
     */
    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    /**
     * @return the _pendiente
     */
    public double getPendiente() {
        return _pendiente;
    }

    /**
     * @param _pendiente the _pendiente to set
     */
    public void setPendiente(double _pendiente) {
        this._pendiente = _pendiente;
    }

    /**
     * @return the _iniciado
     */
    public double getIniciado() {
        return _iniciado;
    }

    /**
     * @param _iniciado the _iniciado to set
     */
    public void setIniciado(double _iniciado) {
        this._iniciado = _iniciado;
    }

    /**
     * @return the _ejecutado
     */
    public double getEjecutado() {
        return _ejecutado;
    }

    /**
     * @param _ejecutado the _ejecutado to set
     */
    public void setEjecutado(double _ejecutado) {
        this._ejecutado = _ejecutado;
    }
   
    
}
