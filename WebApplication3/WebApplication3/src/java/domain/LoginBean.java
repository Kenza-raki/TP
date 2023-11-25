/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entities.Login;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import service.LoginService;

/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    
    private Login login;
    private LoginService loginService;

    public LoginBean() {
        login = new Login();
        loginService = new LoginService();
                
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
    
    
    
     public void login() {
        // Your login logic here

        // Redirect to the desired URL
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/welcomePrimefaces.xhtml");
        } catch (IOException e) {
            // Handle the exception as needed
            e.printStackTrace();
        }
    }
}
