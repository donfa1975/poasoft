/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.clsdirecciones;
import clases.clsseguimiento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import modelo.Tblactividades;
import clases.clsresumenp;
import java.math.BigDecimal;
import java.util.Objects;
import modelo.Tbldirecciones;

//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.ChartData;

import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartOptions;

/**
 *
 * @author fabricio
 */
@Named(value = "resumenBean")
@SessionScoped
public class resumenBean implements Serializable {
private PieChartModel pieSeguimiento;
private PieChartModel piePresupuesto;
private double _p_iniciado;
private double _p_pendiente;
private double _p_terminado;

private double _d_iniciado;
private double _d_pendiente;
private double _d_terminado;


private List<clsresumenp> _resumen;
private List<clsresumenp> _presupuesto;
    /**
     * Creates a new instance of resumenBean
     */
    public resumenBean() {
       //createDonutModelSeguimiento();
       
    }
    @PostConstruct
    public void init(){
    try{
        createDonutModelSeguimiento();
        createDonutModelPresupuesto();
    }catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
    public void createDonutModelSeguimiento() {
        //this._donaSeguimiento=new DonutChartModel();
        pieSeguimiento = new PieChartModel();
        ChartData data = new ChartData();
        //////////////////////////////////
        clsseguimiento seg=new clsseguimiento();
        seg.carga_presupuesto();
        List<Tblactividades> _datos=seg.getPresupuesto();
        int sin_iniciar=(int)_datos.stream().filter(n->n.getIdestado()==1).count();
        int iniciado=(int)_datos.stream().filter(n->n.getIdestado()==2).count();
        int terminado=(int)_datos.stream().filter(n->n.getIdestado()==3).count();
        int total=sin_iniciar+iniciado+terminado;
       //////////////////////////////////
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        
        this._p_iniciado=(double)iniciado/total;
        this._p_iniciado=Math.round(_p_iniciado*100.0);
        this._p_pendiente=(double)sin_iniciar/total;
        _p_pendiente=Math.round(_p_pendiente*100.0);
        this._p_terminado=(double)terminado/total;
        _p_terminado=Math.round(_p_terminado*100.0);
        
        values.add(sin_iniciar);
        values.add(iniciado);
        values.add(terminado);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(168, 80, 50)");
        bgColors.add("rgb(70, 168, 50)");
        bgColors.add("rgb(50, 76, 168)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Pendiente");
        labels.add("Iniciado");
        labels.add("Terminado");
        data.setLabels(labels);
        
        
        pieSeguimiento.setData(data);
        avance_por_proceso(_datos);
    }
    //////////////////////////////////////////////////////
     public void createDonutModelPresupuesto() {
        //this._donaSeguimiento=new DonutChartModel();
        setPiePresupuesto(new PieChartModel());
        ChartData data = new ChartData();
        //////////////////////////////////
        clsseguimiento seg=new clsseguimiento();
        seg.carga_presupuesto();
        List<Tblactividades> _datos=seg.getPresupuesto();
        double sin_iniciar=_datos.stream().filter(n->n.getIdestado()==1).map(p->p.getValorRefer()).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        double iniciado=_datos.stream().filter(n->n.getIdestado()==2).map(p->p.getValorRefer()).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        double terminado=_datos.stream().filter(n->n.getIdestado()==3).map(p->p.getValorRefer()).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        double total = iniciado   + sin_iniciar + terminado;
       //////////////////////////////////
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        
        this.setD_iniciado(iniciado/total);
        this.setD_iniciado(Math.round(getD_iniciado() * 100.0));
        this.setD_pendiente(sin_iniciar/total);
        setD_pendiente(Math.round(getD_pendiente() * 100.0));
        this.setD_terminado(terminado/total);
        setD_terminado(Math.round(getD_terminado() * 100.0));
        
        values.add(sin_iniciar);
        values.add(iniciado);
        values.add(terminado);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(168, 80, 50)");
        bgColors.add("rgb(70, 168, 50)");
        bgColors.add("rgb(50, 76, 168)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Pendiente");
        labels.add("Iniciado");
        labels.add("Terminado");
        data.setLabels(labels);
        
        
        getPiePresupuesto().setData(data);
        this.presupuesto_por_proceso(_datos);
    }
    //////////////////////////////////////////////////////
    private void avance_por_proceso(List<Tblactividades> _datos)
    {
      clsdirecciones dir=new clsdirecciones();
      List<Tbldirecciones> dirs=dir.getLista();
      _resumen=new ArrayList();
      clsresumenp res;
      int pendiente,iniciado,terminado,total;
      for(Tbldirecciones d:dirs)
      {
          pendiente=(int)_datos.stream().filter(n->Objects.equals(n.getTblproyectos().getIddirecciones(), d.getIdtbldireccion())&& n.getIdestado()==1).count();
          iniciado=(int)_datos.stream().filter(n->Objects.equals(n.getTblproyectos().getIddirecciones(), d.getIdtbldireccion())&& n.getIdestado()==2).count();
          terminado=(int)_datos.stream().filter(n->Objects.equals(n.getTblproyectos().getIddirecciones(), d.getIdtbldireccion())&& n.getIdestado()==3).count();
          if(pendiente>0||iniciado>0||terminado>0)
          {
          total=pendiente+iniciado+terminado;
          res=new clsresumenp(d.getDireccion());
          res.setPendiente((double)pendiente/total);
          res.setIniciado((double)iniciado/total);
          res.setEjecutado((double)terminado/total);
          _resumen.add(res);
          }
      }
      
      
    }
    private void presupuesto_por_proceso(List<Tblactividades> _datos)
    {
      clsdirecciones dir=new clsdirecciones();
      List<Tbldirecciones> dirs=dir.getLista();
      _presupuesto=new ArrayList();
      clsresumenp res;
      double pendiente,iniciado,terminado,total;
      for(Tbldirecciones d:dirs)
      {
          pendiente=_datos.stream().filter(n->Objects.equals(n.getTblproyectos().getIddirecciones(), d.getIdtbldireccion())&& n.getIdestado()==1)
                  .map(p->p.getValorRefer()).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
          iniciado=_datos.stream().filter(n->Objects.equals(n.getTblproyectos().getIddirecciones(), d.getIdtbldireccion())&& n.getIdestado()==2)
                  .map(p->p.getValorRefer()).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
          terminado=_datos.stream().filter(n->Objects.equals(n.getTblproyectos().getIddirecciones(), d.getIdtbldireccion())&& n.getIdestado()==3)
                  .map(p->p.getValorRefer()).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
          if(pendiente>0||iniciado>0||terminado>0)
          {
          total=pendiente+iniciado+terminado;
          res=new clsresumenp(d.getDireccion());
          res.setPendiente(pendiente);
          res.setIniciado(iniciado);
          res.setEjecutado(terminado);
          _presupuesto.add(res);
          }
      }
      
      
    }
    /**
     * @return the pieSeguimiento
     */
    public PieChartModel getPieSeguimiento() {
        return pieSeguimiento;
    }

    /**
     * @param pieSeguimiento the pieSeguimiento to set
     */
    public void setPieSeguimiento(PieChartModel pieSeguimiento) {
        this.pieSeguimiento = pieSeguimiento;
    }

    /**
     * @return the _p_iniciado
     */
    public double getP_iniciado() {
        return _p_iniciado;
    }

    /**
     * @param _p_iniciado the _p_iniciado to set
     */
    public void setP_iniciado(double _p_iniciado) {
        this._p_iniciado = _p_iniciado;
    }

    /**
     * @return the _p_pendiente
     */
    public double getP_pendiente() {
        return _p_pendiente;
    }

    /**
     * @param _p_pendiente the _p_pendiente to set
     */
    public void setP_pendiente(double _p_pendiente) {
        this._p_pendiente = _p_pendiente;
    }

    /**
     * @return the _p_terminado
     */
    public double getP_terminado() {
        return _p_terminado;
    }

    /**
     * @param _p_terminado the _p_terminado to set
     */
    public void setP_terminado(double _p_terminado) {
        this._p_terminado = _p_terminado;
    }

    /**
     * @return the _resumen
     */
    public List<clsresumenp> getResumen() {
        return _resumen;
    }

    /**
     * @param _resumen the _resumen to set
     */
    public void setResumen(List<clsresumenp> _resumen) {
        this._resumen = _resumen;
    }

    /**
     * @return the _presupuesto
     */
    public List<clsresumenp> getPresupuesto() {
        return _presupuesto;
    }

    /**
     * @param _presupuesto the _presupuesto to set
     */
    public void setPresupuesto(List<clsresumenp> _presupuesto) {
        this._presupuesto = _presupuesto;
    }

    /**
     * @return the _d_iniciado
     */
    public double getD_iniciado() {
        return _d_iniciado;
    }

    /**
     * @param _d_iniciado the _d_iniciado to set
     */
    public void setD_iniciado(double _d_iniciado) {
        this._d_iniciado = _d_iniciado;
    }

    /**
     * @return the _d_pendiente
     */
    public double getD_pendiente() {
        return _d_pendiente;
    }

    /**
     * @param _d_pendiente the _d_pendiente to set
     */
    public void setD_pendiente(double _d_pendiente) {
        this._d_pendiente = _d_pendiente;
    }

    /**
     * @return the _d_terminado
     */
    public double getD_terminado() {
        return _d_terminado;
    }

    /**
     * @param _d_terminado the _d_terminado to set
     */
    public void setD_terminado(double _d_terminado) {
        this._d_terminado = _d_terminado;
    }

    /**
     * @return the piePresupuesto
     */
    public PieChartModel getPiePresupuesto() {
        return piePresupuesto;
    }

    /**
     * @param piePresupuesto the piePresupuesto to set
     */
    public void setPiePresupuesto(PieChartModel piePresupuesto) {
        this.piePresupuesto = piePresupuesto;
    }

    /**
     * @return the _donaSeguimiento
     */
   
}
