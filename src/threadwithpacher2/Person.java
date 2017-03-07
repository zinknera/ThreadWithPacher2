/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwithpacher2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.crypto.SealedObject;

/**
 *
 * @author micha
 */
public class Person {

    private String vn;
    private String nn;
    private LocalDate gebdate;
    private String adresse;
    MoneyContainer moneyContainer;
    private Gender gender;

    private enum Gender {
        MALE, FEMALE
    }

    public Person(String vn, String nn, String gebdate, String adresse, double money) {
        this.vn = vn;
        this.nn = nn;
        this.gebdate = LocalDate.parse(gebdate, DateTimeFormatter.ISO_DATE);
        this.adresse = adresse;

        moneyContainer = new MoneyContainer(money);
        
        
        Thread s1 = new Thread(new SellRunnable(moneyContainer));
        s1.start();
        
        Thread b1 = new Thread(new BuyRunnable(moneyContainer));
        b1.start();
        
        
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;

    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public double getMoney() {
        
        return moneyContainer.getMoney();
    }

    public void setMoney(double money) {
        this.moneyContainer.setMoney(money);
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

    public MoneyContainer getMoneyContainer() {
        return moneyContainer;
    }
    
    

}
