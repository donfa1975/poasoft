package modelo;
// Generated 17/03/2023 20:30:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tblproyectos generated by hbm2java
 */
public class Tblproyectos  implements java.io.Serializable {


     private Integer idtblproyectos;
     private Tblprogramas tblprogramas;
     private String proyecto;
     private String meta;
     private String indicadores;
     private String tiempo;
     private String tipo;
     private Integer iddirecciones;
     private Set tblactividadeses = new HashSet(0);

    public Tblproyectos() {
    }

    public Tblproyectos(Tblprogramas tblprogramas, String proyecto, String meta, String indicadores, String tiempo, String tipo, Integer iddirecciones, Set tblactividadeses) {
       this.tblprogramas = tblprogramas;
       this.proyecto = proyecto;
       this.meta = meta;
       this.indicadores = indicadores;
       this.tiempo = tiempo;
       this.tipo = tipo;
       this.iddirecciones = iddirecciones;
       this.tblactividadeses = tblactividadeses;
    }
   
    public Integer getIdtblproyectos() {
        return this.idtblproyectos;
    }
    
    public void setIdtblproyectos(Integer idtblproyectos) {
        this.idtblproyectos = idtblproyectos;
    }
    public Tblprogramas getTblprogramas() {
        return this.tblprogramas;
    }
    
    public void setTblprogramas(Tblprogramas tblprogramas) {
        this.tblprogramas = tblprogramas;
    }
    public String getProyecto() {
        return this.proyecto;
    }
    
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }
    public String getMeta() {
        return this.meta;
    }
    
    public void setMeta(String meta) {
        this.meta = meta;
    }
    public String getIndicadores() {
        return this.indicadores;
    }
    
    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }
    public String getTiempo() {
        return this.tiempo;
    }
    
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Integer getIddirecciones() {
        return this.iddirecciones;
    }
    
    public void setIddirecciones(Integer iddirecciones) {
        this.iddirecciones = iddirecciones;
    }
    public Set getTblactividadeses() {
        return this.tblactividadeses;
    }
    
    public void setTblactividadeses(Set tblactividadeses) {
        this.tblactividadeses = tblactividadeses;
    }




}


