/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwithpacher2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

/**
 *
 * @author micha
 */
public class Person {
    
    private String vn;
    private String nn;
    private LocalDate gebdate;
    private String adresse;
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    private enum Gender {
        MALE, FEMALE
    }
    

    public Person(String vn, String nn, String gebdate, String adresse) {
        this.vn = vn;
        this.nn = nn;
        
        this.gebdate = LocalDate.parse(gebdate, DateTimeFormatter.ISO_DATE);
        
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

    public LocalDate getGebdate() {
        return gebdate;
    }

    public void setGebdate(LocalDate gebdate) {
        this.gebdate = gebdate;
    }

   

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
    
    
    
}
