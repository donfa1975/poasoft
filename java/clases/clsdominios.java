/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import modelo.Tblactividades;
import modelo.Tbldirecciones;
import modelo.Tblobjetivos;
import modelo.Tblprogramas;
import modelo.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author angela.olivo
 */
public class clsdominios {
   
    private List<Tblobjetivos> _objetivos;
    private List<Tblprogramas> _programas;
    private List<Tblproyectos> _proyectos;
    private List<Tblactividades> _actividades;
    private boolean _mostrar_programas;
    private boolean _mostrar_proyectos;
    private Session misession;
    public clsdominios() {
        misession= HibernateUtil.getSessionFactory().openSession();
    }
    public void carga_objetivos()
    {
        try{ 
            misession.beginTransaction();
            Query query = misession.createQuery("from Tblobjetivos order by objetivo");
            _objetivos = query.list();
              misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    public void actualizar(Object T)
    {
        try{
        misession.beginTransaction();
        misession.update(T);
        misession.getTransaction().commit();}
        catch(Exception e){
           e.printStackTrace();
        }
            
    }
    public void carga_programas(int idobjetivo)
    {
        try{ 
            misession.beginTransaction();
            Tblobjetivos objetivo=(Tblobjetivos)misession.get(Tblobjetivos.class, idobjetivo);
            Query query = misession.createQuery("from Tblprogramas p where p.tblobjetivos=:objetivo order by p.programa");
            query.setParameter("objetivo", objetivo);
            _programas = query.list();
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    public String getDireccion(int iddireccion)
    {
    
    Tbldirecciones dir=(Tbldirecciones)misession.get(Tbldirecciones.class, iddireccion);
    return dir.getDireccion();
    }
    public void carga_proyectos(int idprograma)
    {
        try{ 
            misession.beginTransaction();
            Tblprogramas programa=(Tblprogramas)misession.get(Tblprogramas.class, idprograma);
            
            Query query = misession.createQuery("from Tblproyectos p where p.tblprogramas=:programa order by p.proyecto");
            query.setParameter("programa", programa);
            
            _proyectos = query.list();
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
     public void carga_actividades(int idproyecto)
    {
        try{ 
            misession.beginTransaction();
            Tblproyectos proy=(Tblproyectos)misession.get(Tblproyectos.class, idproyecto);
            
            Query query = misession.createQuery("from Tblactividades a where a.tblproyectos=:proyecto order by a.actividad");
            query.setParameter("proyecto", proy);
            
            _actividades = query.list();
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    public void crear_objetivo(String nombreobjetivo, int iddireccion)
    {
        
        Tblobjetivos nuevoObj=new Tblobjetivos();
        nuevoObj.setObjetivo(nombreobjetivo);
        nuevoObj.setIddireccion(iddireccion);
        nuevoObj.setIdperiodo(1);
        nuevoObj.setNivel("1");
        
        try{ 
            misession.beginTransaction();
            misession.save(nuevoObj);
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
      
    }
    /**
     * @return the _metas
     */
   

    /**
     * @return the _objetivos
     */
    public List<Tblobjetivos> getObjetivos() {
        return _objetivos;
    }

    /**
     * @param _objetivos the _objetivos to set
     */
    public void setObjetivos(List<Tblobjetivos> _objetivos) {
        this._objetivos = _objetivos;
    }

    /**
     * @return the _programas
     */
    public List<Tblprogramas> getProgramas() {
        return _programas;
    }

    /**
     * @param _programas the _programas to set
     */
    public void setProgramas(List<Tblprogramas> _programas) {
        this._programas = _programas;
    }

    /**
     * @return the _proyectos
     */
    public List<Tblproyectos> getProyectos() {
        return _proyectos;
    }

    /**
     * @param _proyectos the _proyectos to set
     */
    public void setProyectos(List<Tblproyectos> _proyectos) {
        this._proyectos = _proyectos;
    }

    /**
     * @return the _mostrar_programas
     */
    public boolean isMostrar_programas() {
        _mostrar_programas=true;
        if(this._programas==null)
            _mostrar_programas=false;
        
        return _mostrar_programas;
    }

    /**
     * @param _mostrar_programas the _mostrar_programas to set
     */
    public void setMostrar_programas(boolean _mostrar_programas) {
        this._mostrar_programas = _mostrar_programas;
    }

    /**
     * @return the _mostrar_proyectos
     */
    public boolean isMostrar_proyectos() {
          _mostrar_proyectos=true;
        if(this._proyectos==null)
            _mostrar_proyectos=false;
        
        
        return _mostrar_proyectos;
    }

    /**
     * @param _mostrar_proyectos the _mostrar_proyectos to set
     */
    public void setMostrar_proyectos(boolean _mostrar_proyectos) {
        this._mostrar_proyectos = _mostrar_proyectos;
    }

    public void crear_programa(String _nuevoPrograma, int _idobjetivo,String tipo) 
    {
         Tblprogramas nuevoProg=new Tblprogramas();
        nuevoProg.setCodigopoa("00");
        nuevoProg.setPeso(1);
        nuevoProg.setPrograma(_nuevoPrograma);
        nuevoProg.setTipo(tipo);
        Tblobjetivos objetivo=(Tblobjetivos)misession.get(Tblobjetivos.class, _idobjetivo);
        nuevoProg.setTblobjetivos(objetivo);
        
       
        try{ 
            misession.beginTransaction();
            misession.save(nuevoProg);
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    public void crear_proyecto(Tblproyectos _nuevoProyecto, int _idprograma) 
    {
        Tblprogramas programa=(Tblprogramas)misession.get(Tblprogramas.class, _idprograma);
        _nuevoProyecto.setTblprogramas(programa);
        _nuevoProyecto.setIddirecciones(programa.getTblobjetivos().getIddireccion());
       
        try{ 
            misession.beginTransaction();
            misession.save(_nuevoProyecto);
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    public void crear_actividad(Tblactividades _nueva, int _idproyecto,int _idresponsable) 
    {
        Tblproyectos proy=(Tblproyectos)misession.get(Tblproyectos.class, _idproyecto);
        Tblusuarios usu=(Tblusuarios)misession.get(Tblusuarios.class, _idresponsable);
        _nueva.setTblproyectos(proy);
        _nueva.setTblusuarios(usu);
        _nueva.setIdestado(1);
        _nueva.setIdcanton(0);
        _nueva.setPeso(1);
        try{ 
            misession.beginTransaction();
            misession.save(_nueva);
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }

    /**
     * @return the _actividades
     */
    public List<Tblactividades> getActividades() {
        return _actividades;
    }

    /**
     * @param _actividades the _actividades to set
     */
    public void setActividades(List<Tblactividades> _actividades) {
        this._actividades = _actividades;
    }
}
