
package deportista;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class DeportistaTableModel extends AbstractTableModel{
    
    private String[] columnNames = {"Nombre","apellido","edad","estatura","sexo","nacionalidad","grado"
		,"habilidad","motivacion","Zurdo"};
    private ArrayList<Deportista> myList;

    public DeportistaTableModel(ArrayList<Deportista> myList) {
        this.myList = myList;
    }
    
    public int getColumnCount() {
      return columnNames.length;
   }
    @Override
   public int getRowCount() {
      int size;
      if (myList == null) {
         size = 0;
      }
      else {
         size = myList.size();
      }
      return size;
   }
   public Object getValueAt(int row, int col) {
      Object temp = null;
      if (col == 0) {
         temp = myList.get(row).getNombre();
      }
      else if (col == 1) {
         temp = myList.get(row).getApellido();
      }
      else if (col == 2) {
         temp = (myList.get(row).getEdad());
      }
      else if (col == 3) {
         temp = (myList.get(row).getEstatura());
      }
      else if (col == 4) {
         temp = (myList.get(row).getSexo());
      }
      else if (col == 5) {
         temp = (myList.get(row).getNacionalidad());
      }
      else if (col == 6) {
         temp = (myList.get(row).getGrado());
      }
      else if (col == 7) {
         temp = (myList.get(row).getHabilidad());
      }
      else if (col == 8) {
         temp = (myList.get(row).getMotivacion());
      }
      else if (col == 9) {
         temp = (myList.get(row).isZurdo());
      }

      return temp;
   }
   
   // needed to show column names in JTable
    @Override
   public String getColumnName(int col) {
      return columnNames[col];
   }

    @Override
   public Class getColumnClass(int col) {
      if (col == 2) {
         return String.class;
      }
      else {
         return String.class;
      }
   }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
 
}

   
    
    
    

