package modelo;
// Generated 17/03/2023 20:30:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tbldirecciones generated by hbm2java
 */
public class Tbldirecciones  implements java.io.Serializable {


     private Integer idtbldireccion;
     private String direccion;
     private Byte activo;
     private Set tblusuarioses = new HashSet(0);

    public Tbldirecciones() {
    }

    public Tbldirecciones(String direccion, Byte activo, Set tblusuarioses) {
       this.direccion = direccion;
       this.activo = activo;
       this.tblusuarioses = tblusuarioses;
    }
   
    public Integer getIdtbldireccion() {
        return this.idtbldireccion;
    }
    
    public void setIdtbldireccion(Integer idtbldireccion) {
        this.idtbldireccion = idtbldireccion;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Byte getActivo() {
        return this.activo;
    }
    
    public void setActivo(Byte activo) {
        this.activo = activo;
    }
    public Set getTblusuarioses() {
        return this.tblusuarioses;
    }
    
    public void setTblusuarioses(Set tblusuarioses) {
        this.tblusuarioses = tblusuarioses;
    }




}


