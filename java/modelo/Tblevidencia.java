package modelo;
// Generated 17/03/2023 20:30:04 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tblevidencia generated by hbm2java
 */
public class Tblevidencia  implements java.io.Serializable {


     private int idevidencia;
     private Integer idactividad;
     private String archivo;
     private String descripcion;
     private Date fecha;

    public Tblevidencia() {
    }

	
    public Tblevidencia(int idevidencia) {
        this.idevidencia = idevidencia;
    }
    public Tblevidencia(int idevidencia, Integer idactividad, String archivo, String descripcion, Date fecha) {
       this.idevidencia = idevidencia;
       this.idactividad = idactividad;
       this.archivo = archivo;
       this.descripcion = descripcion;
       this.fecha = fecha;
    }
   
    public int getIdevidencia() {
        return this.idevidencia;
    }
    
    public void setIdevidencia(int idevidencia) {
        this.idevidencia = idevidencia;
    }
    public Integer getIdactividad() {
        return this.idactividad;
    }
    
    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }
    public String getArchivo() {
        return this.archivo;
    }
    
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


