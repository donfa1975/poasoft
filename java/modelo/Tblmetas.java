package modelo;
// Generated 17/03/2023 20:30:04 by Hibernate Tools 4.3.1



/**
 * Tblmetas generated by hbm2java
 */
public class Tblmetas  implements java.io.Serializable {


     private int idtblmeta;
     private String meta;
     private Integer idperiodo;
     private Long indicador;

    public Tblmetas() {
    }

	
    public Tblmetas(int idtblmeta) {
        this.idtblmeta = idtblmeta;
    }
    public Tblmetas(int idtblmeta, String meta, Integer idperiodo, Long indicador) {
       this.idtblmeta = idtblmeta;
       this.meta = meta;
       this.idperiodo = idperiodo;
       this.indicador = indicador;
    }
   
    public int getIdtblmeta() {
        return this.idtblmeta;
    }
    
    public void setIdtblmeta(int idtblmeta) {
        this.idtblmeta = idtblmeta;
    }
    public String getMeta() {
        return this.meta;
    }
    
    public void setMeta(String meta) {
        this.meta = meta;
    }
    public Integer getIdperiodo() {
        return this.idperiodo;
    }
    
    public void setIdperiodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }
    public Long getIndicador() {
        return this.indicador;
    }
    
    public void setIndicador(Long indicador) {
        this.indicador = indicador;
    }




}


