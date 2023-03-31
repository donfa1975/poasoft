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


import java.util.List;
import modelo.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class clsseguimiento {
    private List<Tblactividades> _actividades;
    private List<Tblactividades> _presupuesto;
    private boolean _mostrar_programas;
    private boolean _mostrar_proyectos;
    private Session misession;

    public clsseguimiento() {
         misession= HibernateUtil.getSessionFactory().openSession();
    }
    public void carga_actividades(int iddireccion)
    {
        try{ 
            misession.beginTransaction();
            Query query = misession.createQuery("from Tblactividades p where p.tblproyectos.iddirecciones=:direccion order by p.actividad");
            query.setParameter("direccion", iddireccion);
            _actividades= query.list();
            misession.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    public void carga_presupuesto()
    {
        try{ 
            misession.beginTransaction();
            Query query = misession.createQuery("from Tblactividades p where p.valorRefer>0");
            //query.setParameter("direccion", iddireccion);
            setPresupuesto((List<Tblactividades>) query.list());
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

    /**
     * @return the _presupuesto
     */
    public List<Tblactividades> getPresupuesto() {
        return _presupuesto;
    }

    /**
     * @param _presupuesto the _presupuesto to set
     */
    public void setPresupuesto(List<Tblactividades> _presupuesto) {
        this._presupuesto = _presupuesto;
    }
    
}
