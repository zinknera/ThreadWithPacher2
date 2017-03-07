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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author micha
 */
public class Model_BL extends AbstractTableModel {

    private ArrayList<Person> liste = new ArrayList();

    private static final String colNames[] = {"Vorname", "Nachname", "Geburtsdatum", "Adresse", "Geschlächt", "Money"};

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
                }
            } catch (IOException ex) {
                Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
