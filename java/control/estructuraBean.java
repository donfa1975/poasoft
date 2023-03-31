/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clsitem;
import clases.clsitemsfactory;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.primefaces.model.TreeNode;

/**
 *
 * @author fabricio
 */
@Named(value = "estructuraBean")
@SessionScoped
public class estructuraBean implements Serializable {
    private TreeNode raiz;
    clsitemsfactory cif;
    private clsitem item;
    /**
     * Creates a new instance of estructuraBean
     */
    public estructuraBean() {
        cif=new clsitemsfactory();
        raiz=cif.carga_nodos();
    }

    /**
     * @return the raiz
     */
    public TreeNode getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(TreeNode raiz) {
        this.raiz = raiz;
    }

    /**
     * @return the item
     */
    public clsitem getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(clsitem item) {
        this.item = item;
    }
    
}
