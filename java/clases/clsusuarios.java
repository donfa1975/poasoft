/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import modelo.Tblcargos;
import modelo.Tbldirecciones;
import modelo.Tblusuarios;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import util.clsAccesoDatos;

/**
 *
 * @author angela.olivo
 */
public class clsusuarios {
 private List<Tblusuarios> _lista;
    private Tblusuarios _seleccionado=null;
    clsAccesoDatos c;
    private Session misession;
    
    public clsusuarios() {
        
        
       
        carga_lista();
    }
    ///////////////
    public void carga_lista()
    {
       /*c=new clsAccesoDatos();
        _lista=c.consulta("from Tblusuarios order by Nombre");*/
         try{ 
             misession = HibernateUtil.getSessionFactory().openSession();
              misession.beginTransaction();
            Query query = misession.createQuery("from Tblusuarios order by nombre");
            _lista = query.list();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    ////////////////////////////
    
    ////////////////////////////
    public void crearUsuario(Tblusuarios usuario,int idcargo, int iddireccion)
    {
        
          c=new clsAccesoDatos();
          //Tbldirecciones dir=c.getDireccion(direccion);
          Tbldirecciones dir=(Tbldirecciones)c.getItem(iddireccion, Tbldirecciones.class);
          Tblcargos car=(Tblcargos)c.getItem(idcargo, Tblcargos.class);
          usuario.setTbldirecciones(dir);
          usuario.setTblcargos(car);
          usuario.setActivo(Byte.valueOf("1"));
          c.agregar(usuario);
    }
    public void actualizar(Tblusuarios usuario,int idcargo, int iddireccion)
    {
        c=new clsAccesoDatos();
        Tbldirecciones dir=(Tbldirecciones)c.getItem(iddireccion, Tbldirecciones.class);
        Tblcargos car=(Tblcargos)c.getItem(idcargo, Tblcargos.class);
        usuario.setTbldirecciones(dir);
        usuario.setTblcargos(car);
        c.actualizar(usuario);
        
        misession.update(usuario);
        misession.getTransaction().commit();
        carga_lista();
    }   
    
    public List<Tblusuarios> getLista() {
        return _lista;
    }

    /**
     * @param _lista the _lista to set
     */
    public void setLista(List<Tblusuarios> _lista) {
        this._lista = _lista;
    }

    /**
     * @return the _seleccionado
     */
    public Tblusuarios getSeleccionado() {
        return _seleccionado;
    }

    /**
     * @param _seleccionado the _seleccionado to set
     */
    public void setSeleccionado(Tblusuarios _seleccionado) {
        this._seleccionado = _seleccionado;
    }
}

