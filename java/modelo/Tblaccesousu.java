package modelo;
// Generated 17/03/2023 20:30:04 by Hibernate Tools 4.3.1



/**
 * Tblaccesousu generated by hbm2java
 */
public class Tblaccesousu  implements java.io.Serializable {


     private Integer idtblaccesousu;
     private Tblopciones tblopciones;
     private Tblusuarios tblusuarios;

    public Tblaccesousu() {
    }

    public Tblaccesousu(Tblopciones tblopciones, Tblusuarios tblusuarios) {
       this.tblopciones = tblopciones;
       this.tblusuarios = tblusuarios;
    }
   
    public Integer getIdtblaccesousu() {
        return this.idtblaccesousu;
    }
    
    public void setIdtblaccesousu(Integer idtblaccesousu) {
        this.idtblaccesousu = idtblaccesousu;
    }
    public Tblopciones getTblopciones() {
        return this.tblopciones;
    }
    
    public void setTblopciones(Tblopciones tblopciones) {
        this.tblopciones = tblopciones;
    }
    public Tblusuarios getTblusuarios() {
        return this.tblusuarios;
    }
    
    public void setTblusuarios(Tblusuarios tblusuarios) {
        this.tblusuarios = tblusuarios;
    }




}

