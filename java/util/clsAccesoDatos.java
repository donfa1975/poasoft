/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import modelo.Tblcargos;
import modelo.Tbldirecciones;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author angela.olivo
 */
public class clsAccesoDatos {

    public clsAccesoDatos() {
    }
    public void actualizar(Object T)
    {
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(T);
            sesion.getTransaction().commit();
            sesion.close();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    /********************/
    
    /*********************/
    public Object getItem(int idpk, Class tipo)
    {
         try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Object objeto=sesion.get(tipo, idpk);
            sesion.getTransaction().commit();
            sesion.close();
            return objeto;
        }catch(Exception e){
           e.printStackTrace();
        }
         return null;
    }
     
    
    /********************/
     public void agregar(Object T)
    {
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(T);
            sesion.getTransaction().commit();
            sesion.close();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public List consulta(String dato)
    {
        List lista=null;
        try{ 
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery(dato);
            lista = query.list();
            session.getTransaction().commit();
            session.close();
            
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return lista;
    }
    
}
