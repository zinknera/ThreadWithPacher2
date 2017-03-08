/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwithpacher2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author micha
 */
public class Model_BL extends AbstractTableModel {

    private ArrayList<Person> liste = new ArrayList();


    private static final String colNames[] = {"Vorname", "Nachname", "Geburtsdatum", "Adresse", "Geschlecht", "Money"};
    ChangeListener cl;
    
    public Model_BL() {
        cl = (evt) -> {
            super.fireTableDataChanged();
        };
        liste.forEach(p -> p.getMoneyContainer().addChangeListener(cl));
    }
    
    

    public boolean add(Person p) {
        liste.add(p);
        p.getMoneyContainer().addChangeListener(cl);
        return true;
    }

    @Override
    public int getRowCount() {
        return liste.size();
    }

    public String getColumnName(int i) {
        return colNames[i];
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        super.setValueAt(o, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return super.isCellEditable(i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    public void update() {
        this.fireTableDataChanged();
        this.fireTableCellUpdated(0, liste.size());
    }

    @Override
    public Object getValueAt(int row, int col) {
        Person p = liste.get(row);
        switch (col) {
            case 0:
                return p.getVn();
            case 1:
                return p.getNn();
            case 2:
                return p.getGebdate();
            case 3:
                return p.getAdresse();
            case 4:
                return p.getGender();
            case 5:
                return p.getMoney();
        }
        throw new UnsupportedOperationException("Fehler: getValueAt ");
    }

    public void einlesenTxt(String path) {
        if (path != null) {
            String line = "";
            try {
                BufferedReader breader = new BufferedReader(new FileReader(path));
                while ((line = breader.readLine()) != null) {
                    String split[] = line.split(";");
                    System.out.println(split[4]);
                    Person p = new Person(split[0], split[1], split[2], split[3], Double.parseDouble(split[4]));
                    liste.add(p);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void speichernTxt(String path) {
        if (path != null) {
            try {
                BufferedWriter bwriter = new BufferedWriter(new FileWriter(path));
                for (int i = 0; i < liste.size(); i++) {
                    Person p = liste.get(i);
                    String line = p.getVn() + ";" + p.getNn() + ";" + p.getGebdate() + ";" + p.getGender() + ";" + p.getAdresse() + ";" + p.getMoney();
                    bwriter.write("test");
                }
            } catch (IOException ex) {
                Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    void testdaten(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            String[] dataPeaces;
            while((line = br.readLine())!= null){
                dataPeaces = line.split("æ");
                Person p = new Person(dataPeaces[0], dataPeaces[1], dataPeaces[2], dataPeaces[3], Double.parseDouble(dataPeaces[4]));
                p.getMoneyContainer().addChangeListener(cl);
                liste.add(p);
            }
           
            update();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
