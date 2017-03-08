/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwithpacher2;

import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author alex
 */
public class MoneyContainer {
    double money;
    
    private ArrayList<ChangeListener> clList = new ArrayList<>();    

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
        clList.forEach(l -> l.stateChanged(new ChangeEvent(money)));
    }

    public MoneyContainer(double money) {
        this.money = money;
    }
    
    public void addChangeListener(ChangeListener cl) {
        clList.add(cl);
    }
    
    public void removeChangeListener(ChangeListener cl) {
        clList.remove(cl);
    }
}
