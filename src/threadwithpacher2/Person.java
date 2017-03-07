/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwithpacher2;

import java.util.Date;

/**
 *
 * @author micha
 */
public class Person {
    
    private String vn;
    private String nn;
    private Date gebdate;
    private String adresse;
    
    
    private enum Gender {
        MALE, FEMALE
    }

    public Person(String vn, String nn, Date gebdate, String adresse) {
        this.vn = vn;
        this.nn = nn;
        this.gebdate = gebdate;
        this.adresse = adresse;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }

    public Date getGebdate() {
        return gebdate;
    }

    public void setGebdate(Date gebdate) {
        this.gebdate = gebdate;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
    
    
    
}
