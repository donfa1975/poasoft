/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.math.BigDecimal;

/**
 *
 * @author fabricio
 */
public class clsitem {
    private String _item;
    private String _tipo;
    private BigDecimal _valor;

    public clsitem(String _item, BigDecimal _valor) {
        this._item = _item;
        this._valor = _valor;
    }
    public clsitem(String _item,String _tipo, BigDecimal _valor) {
        this._item = _item;
        this._valor = _valor;
        this._tipo=_tipo;
    }
    
    /**
     * @return the _item
     */
    public String getItem() {
        return _item;
    }

    /**
     * @param _item the _item to set
     */
    public void setItem(String _item) {
        this._item = _item;
    }

    /**
     * @return the _valor
     */
    public BigDecimal getValor() {
        return _valor;
    }

    /**
     * @param _valor the _valor to set
     */
    public void setValor(BigDecimal _valor) {
        this._valor = _valor;
    }

    /**
     * @return the _tipo
     */
    public String getTipo() {
        return _tipo;
    }

    /**
     * @param _tipo the _tipo to set
     */
    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }
    
    
}
