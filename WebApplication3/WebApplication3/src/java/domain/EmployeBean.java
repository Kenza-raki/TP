/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import entities.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
import service.EmployeService;



/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class EmployeBean {
    
      private Employe employe;
    private List<Employe> employes;

    private EmployeService employeService;
     private static ChartModel barModel;

    /**
     * Creates a new instance of EmployeBean
     */
    public EmployeBean() {
        employes = new ArrayList<>();
        employe = new Employe();
        employeService = new EmployeService();
    }

    public void onCreateAction (){
        System.out.println(employe.getNom());
        System.out.println(employe.getPrenom());
        employes.add(employe);
        System.out.println(employes);
        employe = new Employe();
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

     public List<Employe> getEmployes() {
    if (employes == null) {
        employes = employeService.getAll();
        System.out.println(employes);
    }
    return employes;
}


    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
    public String onDeleteAction() {
        employe = new Employe();
        employeService.delete(employeService.getById(employe.getId()));
        return null;
    }
     public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries employess = new ChartSeries();
        employess.setLabel("machines");
        model.setAnimate(true);
        for (Object[] m : employeService.nbemploye()) {
            employess.set(m[1], Integer.parseInt(m[0].toString()));
        }
        model.addSeries(employess);

        return model;
    }
}
