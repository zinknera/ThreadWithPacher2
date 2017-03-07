/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwithpacher2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class BuyRunnable implements Runnable{

    MoneyContainer moneyContainer;
    
    public BuyRunnable(MoneyContainer moneyContainer) {
        this.moneyContainer = moneyContainer;
    }
    
    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            synchronized (moneyContainer) {
                moneyContainer.setMoney(moneyContainer.getMoney() - rand.nextDouble()*20);
            }
            
            System.out.println("buy= " + moneyContainer.getMoney());
            
            try {
                Thread.sleep(900 + rand.nextInt(200));
            } catch (InterruptedException ex) {
                Logger.getLogger(SellRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
}
