package modelo;
// Generated 17/03/2023 20:30:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tblopciones generated by hbm2java
 */
public class Tblopciones  implements java.io.Serializable {


     private Integer idtblopcion;
     private String opcion;
     private Set tblaccesousus = new HashSet(0);

    public Tblopciones() {
    }

    public Tblopciones(String opcion, Set tblaccesousus) {
       this.opcion = opcion;
       this.tblaccesousus = tblaccesousus;
    }
   
    public Integer getIdtblopcion() {
        return this.idtblopcion;
    }
    
    public void setIdtblopcion(Integer idtblopcion) {
        this.idtblopcion = idtblopcion;
    }
    public String getOpcion() {
        return this.opcion;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    public Set getTblaccesousus() {
        return this.tblaccesousus;
    }
    
    public void setTblaccesousus(Set tblaccesousus) {
        this.tblaccesousus = tblaccesousus;
    }




}


