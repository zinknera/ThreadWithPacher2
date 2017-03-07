/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwithpacher2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    
   private static final String colNames[]={"Vorname","Nachname","Geburtsdatum","Adresse","Geschlächt"};

    @Override
    public int getRowCount() {
       return liste.size();
    }
    
    public String getColumnName(int i){
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
      switch(col){
          case 0: return "Sandra";// Person.getVorname();
          case 1 : return "Vollmann";//Person.getNachname();
          case 2 : return "1.1.2000";// Person.getGeb();
          case 3 : return "Grazerstraße 2 ";//Person.getAdresse();
          case 4 : return "Weiblich";//Person.getGender();
      }
     throw new UnsupportedOperationException("Fehler: getValueAt ");
    }
    
    
    public void einlesen(String paht){
        if(paht != null){
            String line="";
            try{
                BufferedReader breader = new BufferedReader(new FileReader(paht));
                while((line = breader.readLine())!=null){
                    String split[] = line.split(";");
                    Person p = new Person(split[0],split[1],split[2],split[3],split[4]);
                    liste.add(p);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Model_BL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }

}
