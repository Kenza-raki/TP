/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Lachgar
 */
@Entity
public class Service implements Serializable{
    @Id
    @GeneratedValue
     private int id;
    private String code;
    private String libelle;
    
    @OneToMany (mappedBy = "service",fetch = FetchType.EAGER)
    private List<Employe> employes;

    public Service() {
        
    }

    public Service(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    

    @Override
    public String toString() {
        return libelle ;
    }
    
    
    
}
