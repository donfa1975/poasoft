package modelo;
// Generated 17/03/2023 20:30:04 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tblavances generated by hbm2java
 */
public class Tblavances  implements java.io.Serializable {


     private int idtblavances;
     private Integer mes;
     private Date anio;
     private Integer idperiodo;
     private Integer planeado;
     private Integer ejecutado;
     private Integer idactividad;
     private Set tblactividadeses = new HashSet(0);

    public Tblavances() {
    }

	
    public Tblavances(int idtblavances) {
        this.idtblavances = idtblavances;
    }
    public Tblavances(int idtblavances, Integer mes, Date anio, Integer idperiodo, Integer planeado, Integer ejecutado, Integer idactividad, Set tblactividadeses) {
       this.idtblavances = idtblavances;
       this.mes = mes;
       this.anio = anio;
       this.idperiodo = idperiodo;
       this.planeado = planeado;
       this.ejecutado = ejecutado;
       this.idactividad = idactividad;
       this.tblactividadeses = tblactividadeses;
    }
   
    public int getIdtblavances() {
        return this.idtblavances;
    }
    
    public void setIdtblavances(int idtblavances) {
        this.idtblavances = idtblavances;
    }
    public Integer getMes() {
        return this.mes;
    }
    
    public void setMes(Integer mes) {
        this.mes = mes;
    }
    public Date getAnio() {
        return this.anio;
    }
    
    public void setAnio(Date anio) {
        this.anio = anio;
    }
    public Integer getIdperiodo() {
        return this.idperiodo;
    }
    
    public void setIdperiodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }
    public Integer getPlaneado() {
        return this.planeado;
    }
    
    public void setPlaneado(Integer planeado) {
        this.planeado = planeado;
    }
    public Integer getEjecutado() {
        return this.ejecutado;
    }
    
    public void setEjecutado(Integer ejecutado) {
        this.ejecutado = ejecutado;
    }
    public Integer getIdactividad() {
        return this.idactividad;
    }
    
    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }
    public Set getTblactividadeses() {
        return this.tblactividadeses;
    }
    
    public void setTblactividadeses(Set tblactividadeses) {
        this.tblactividadeses = tblactividadeses;
    }




}


