
import entities.Service;
import service.ServiceService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Test {
      public static void main(String[] args) {
        ServiceService ss = new ServiceService();
        //création des Services
        ss.create(new Service("I", "Informatique"));
        ss.create(new Service("A", "Arabe"));
        ss.create(new Service("C", "Comptailité"));
        //La liste des services
        for (Service s : ss.getAll()) {
            System.out.println("" + s.getCode());
        }
    }
    
}
