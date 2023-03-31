/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.math.BigDecimal;
import java.util.List;
import modelo.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import util.HibernateUtil;
/**
 *
 * @author fabricio
 */
public class clsitemsfactory {
    private Session misession;
    private List<Tblobjetivos> _objetivos;
    
    public clsitemsfactory() {
        this.misession =  HibernateUtil.getSessionFactory().openSession();;
    }
    
    public TreeNode carga_nodos()
    {   TreeNode raiz;
        TreeNode rama;
        clsitem inicio=new clsitem("Estructura","POA",new BigDecimal(0));
        clsitem nodobase=new clsitem("POA GADPE","POA",new BigDecimal(0));
        raiz = new DefaultTreeNode(inicio, null);
        rama = new DefaultTreeNode(nodobase, raiz);
        
        BigDecimal valor=this.carga_objetivos(rama);
        nodobase.setValor(valor);
        return raiz;
        
    }
    private BigDecimal carga_actividades(TreeNode r,Tblproyectos p)
    {   TreeNode rama;
        clsitem item;
        double suma=0;
    for(Object i: p.getTblactividadeses())
        {
            Tblactividades a=(Tblactividades)i;
            item=new clsitem(a.getActividad(),"ACTIVIDAD",a.getValorRefer());
            suma+=a.getValorRefer().doubleValue();
            rama=new DefaultTreeNode(item,r);
        }
        return new BigDecimal(suma);
    }
    private BigDecimal carga_proyectos(TreeNode r,Tblprogramas pg)
    {   TreeNode rama;
        clsitem item;
        double suma=0;
        BigDecimal valor;
        for(Object i:pg.getTblproyectoses())
        {Tblproyectos p=(Tblproyectos)i;
            item=new clsitem(p.getProyecto(),"PROYECTO",new BigDecimal(0));
            rama=new DefaultTreeNode(item,r);
            valor=this.carga_actividades(rama, p);
            item.setValor(valor);
            suma+=valor.doubleValue();
        }
        return new BigDecimal(suma);
    }
    private BigDecimal carga_programas(TreeNode r,Tblobjetivos o)
    {   TreeNode rama;
        clsitem item;
        double suma=0;
        BigDecimal valor;
        for(Object i:o.getTblprogramases())
        {Tblprogramas pg=(Tblprogramas)i;
            item=new clsitem(pg.getPrograma(),"PROGRAMA",new BigDecimal(0));
            rama=new DefaultTreeNode(item,r);
            valor=this.carga_proyectos(rama, pg);
            item.setValor(valor);
            suma+=valor.doubleValue();
        }
        return new BigDecimal(suma);
    }
    public BigDecimal carga_objetivos(TreeNode r)
    {
        double suma=0;
        try{ 
            
            misession.beginTransaction();
            Query query = misession.createQuery("from Tblobjetivos order by objetivo");
            _objetivos = query.list();
             misession.getTransaction().commit();
             //////////////////
            TreeNode rama;
            clsitem item;
            
            BigDecimal valor;
            for(Tblobjetivos o:_objetivos)
            {
                item=new clsitem(o.getObjetivo(),"OBJETIVO",new BigDecimal(0));
                rama=new DefaultTreeNode(item,r);
                valor=this.carga_programas(rama, o);
                item.setValor(valor);
                suma+=valor.doubleValue();
            }
            
             //////////////////
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return new BigDecimal(suma);
    }
}
