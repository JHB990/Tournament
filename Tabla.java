
package deportista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JPanel {

   
    private final JTable table;
    private DeportistaTableModel model;
    public Tabla(ArrayList<Deportista> lista ) {
        
        super(new GridLayout(1,0));

     model = new DeportistaTableModel(lista);
             
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table.setFillsViewportHeight(true);
       
        JScrollPane scrollPane = new JScrollPane(table);
        
        add(scrollPane);
    }
  

   /* private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Tabla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
     Tabla newContentPane = new Tabla();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);

       
        frame.pack();
        frame.setVisible(true);
    }*/


}

