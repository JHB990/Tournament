
package deportista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.event.DocumentEvent; 
//import javax.swing.event.DocumentListener;
//import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guillermo López & Hans Bautista
 */
public class DeportistaGUI extends JFrame{
    
    private Deportista dep,depAux;
    private JLabel lblNombre;
    private JLabel lblApellido1;
    private JLabel lblEdad;
    private JLabel lblEstatura;
    private JLabel lblSexo;
    private JLabel lblPais;
    private JLabel lblGrado;
    private JLabel lblHabilidad;
    private JLabel lblValHabilidad;
    private JLabel lblValMotivacion;
    private JLabel lblMotivacion;
    private JLabel lblZurdo;
    private JTextField txtNombre;
    private JTextField txtApellido1;
    private JSpinner spiEdad;
    private JSpinner spiEstatura;
    private JRadioButton rbnHombre;
    private JRadioButton rbnMujer;
    private ButtonGroup SexoButtonGroup;
    private JComboBox cbbPais;
    private JComboBox cbbGrado;
    private JSlider jslHabilidad;
    private JSlider jslMotivacion;
    private JRadioButton rbnZurdo;
    private JRadioButton rbnDiestro;
    private ButtonGroup ZurdoButtonGroup;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnMostrar;
    private JButton btnInTor;
    private JButton btnSelecIm;
    private JButton btnClear;
    private JLabel lblLista;
    private JLabel lblImagen;
    private JButton btnTest;
    private JFileChooser chooser;
    private int retorno = -1;
    private ArrayList<Deportista> deportistas;
    private ArrayList<Deportista> dpTest;
    private Tabla tabla;
    private int posicion;
    private Torneo torneo;
    private Deportista ganador;
    private JLabel lblGanador;
    private JLabel lblWinner;
    private Fecha fechaT;
    
    private String copiarImagen(String seleccion){
        String path = "";
        if (seleccion.equals("Guardar")){
            if (retorno == chooser.APPROVE_OPTION) {
                InputStream fin = null;
                OutputStream fout = null;
                try {
                    File file = chooser.getSelectedFile();
                    System.out.println(file);

                    File copia = new File("img\\" + file.getName() );
                    copia.createNewFile();
                    path += copia.getAbsolutePath();
                    fin = new FileInputStream(file);
                    fin = new BufferedInputStream(fin);
                    fout = new FileOutputStream(copia);
                    fout = new BufferedOutputStream(fout);

                    int c;
                    while ((c = fin.read()) >= 0) {
                        fout.write(c);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(FileChooser.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fout.close();
                        fin.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FileChooser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }else{
            System.out.println("No se guardo el archivo.");
        }
        return path;
}
    
    private void limpiarCampos(){
        txtNombre.setText("");
        txtApellido1.setText("");
        spiEdad.setValue(20);
        spiEstatura.setValue(130);
        SexoButtonGroup.clearSelection();
        cbbPais.setSelectedIndex(0);
        cbbGrado.setSelectedIndex(0);
        jslHabilidad.setValue(20);
        jslMotivacion.setValue(0);
        ZurdoButtonGroup.clearSelection();
        ImageIcon imageIcon = new ImageIcon(
                        new ImageIcon("img/unnamed.png").getImage().getScaledInstance(
                                lblImagen.getHeight(), lblImagen.getWidth(), Image.SCALE_SMOOTH));
                    lblImagen.setIcon(imageIcon);
        tabla.removeAll();
    }
    
    public DeportistaGUI() {
        this.setVisible(true);
        this.setSize(1024, 720); //cuando se minimiza el tamaño
        this.setExtendedState(MAXIMIZED_BOTH); //se extiende a todo el tamañano de la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Torneo");
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setLayout(null);
        DeportistaGUI.setDefaultLookAndFeelDecorated(true);
        chooser = new JFileChooser();
        fechaT = new Fecha(2020, 07, 27);
        torneo = new Torneo(deportistas, fechaT);
        
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setBounds(50, 50, 100, 25);
        lblApellido1 =new JLabel("Apellido: ");
        lblApellido1.setBounds(50, 100, 100, 25);
        lblEdad = new JLabel("Edad: ");
        lblEdad.setBounds(50, 150, 100, 25);
        lblEstatura = new JLabel("Estatura: ");
        lblEstatura.setBounds(50, 200, 100, 25);
        lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 250, 100, 25);
        lblPais = new JLabel ("Pais: ");
        lblPais.setBounds(50, 300, 100, 25);
        lblGrado = new JLabel ("Grado: ");
        lblGrado.setBounds(50, 350, 100, 25);
        lblHabilidad = new JLabel ("Habilidad: ");
        lblHabilidad.setBounds(50, 400, 58, 25);
        lblValHabilidad = new JLabel ("20"); // muestra el valor del JSlider para habilidad
        lblValHabilidad.setBounds(110, 400, 58, 25);
        lblMotivacion = new JLabel("Motivacion: ");
        lblMotivacion.setBounds(50, 475, 67, 25);
        lblValMotivacion = new JLabel("0"); //muestra el valor del JSlider para motivacion 
        lblValMotivacion.setBounds(119, 475, 30, 25);
        lblZurdo = new JLabel ("Zurdo: ");
        lblZurdo.setBounds(50, 550, 100, 25);
        deportistas=new ArrayList<>();

        dpTest =  new ArrayList<>();
        dpTest.add(new Deportista("Carlos", "paena", 23, 170, 'h', "mexicano", 3, 69, 82, false, "C:/",0));
        dpTest.get(0).genPow();
        dpTest.add(new Deportista("pablo", "lopez", 45, 159, 'h', "peruano", 1, 57, 58, true, "C:/",0));
        dpTest.get(1).genPow();
        dpTest.add(new Deportista("betoo", "pena", 45, 159, 'h', "peruano", 8, 89, 45, true, "C:/",0));
        dpTest.get(2).genPow();
        dpTest.add(new Deportista("laura", "smith", 28, 160, 'm', "venezolana", 7, 80, 80, false, "C:/",0));
        dpTest.get(3).genPow();
        dpTest.add(new Deportista("pedro", "morales", 30, 189, 'h', "peruana", 5, 34, 78, true, "C:/",0));
        dpTest.get(4).genPow();
        dpTest.add(new Deportista("antonio", "sutra", 25, 187, 'h', "boliviano", 3, 80, 59, false, "C:/",0));
        dpTest.get(5).genPow();
        dpTest.add(new Deportista("otto", "peterson", 29, 170, 'h', "brazileño", 6, 59, 83, true, "C:/",0));
        dpTest.get(6).genPow();
        dpTest.add(new Deportista("HERNAN", "GOMEZ", 50, 190, 'h', "CHILENO", 1, 40, 40, true, "C:/",0));
        dpTest.get(7).genPow();

        btnTest = new JButton("Test");
        btnTest.setBounds(635,586,100,25); //(525, 550, 100, 25)
        /*
        btnTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                System.out.println(dpTest);
                Collections.sort(deportistas, new Comparator<Deportista>() {

                    @Override
                    public int compare(Deportista deportista, Deportista t1) {
                        if (deportista.getPow() > t1.getPow()){
                            return 1;
                        }
                        if( deportista.getPow() < t1.getPow()){
                            return -1;
                        }
                        return 0;
                    }
                });
                System.out.println(deportistas);
            }
        });
    */
        
        //Campos de texto
        txtNombre = new JTextField();
        /*txtNombre.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e){
                updated();
            }
            @Override
            public void removeUpdate(DocumentEvent e){
                updated();
            }
            @Override
            public void insertUpdate(DocumentEvent e){
                updated();
            }
            public void updated(){
                    txtNombre.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent ke) {
                        System.out.println("" + ke.getKeyChar() + "---->" + ke.getKeyCode());
                        if ((!(ke.getKeyChar() >= 65 && ke.getKeyChar() <= 90)) && (!(ke.getKeyChar() >= 97 && ke.getKeyChar() <= 122))
                                && (!(ke.getKeyChar() == 'ñ')) && (!(ke.getKeyChar() == 'Ñ'))) {
                            System.out.println("Caracter Invalido ");
                            ke.consume();
                        } else {
                            System.out.println("Caracter Valido");
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent ke) {

                    }

                    @Override
                    public void keyReleased(KeyEvent ke) {

                    }

                }
                );
                btnAgregar.setEnabled(txtNombre.getText().length()>0);
            }
        });*/
        txtNombre.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent ke) {
                        System.out.println("" + ke.getKeyChar() + "---->" + ke.getKeyCode());
                        if ((!(ke.getKeyChar() >= 65 && ke.getKeyChar() <= 90)) && (!(ke.getKeyChar() >= 97 && ke.getKeyChar() <= 122))
                                && (!(ke.getKeyChar() == 'ñ')) && (!(ke.getKeyChar() == 'Ñ'))) {
                            System.out.println("Caracter Invalido ");
                            ke.consume();
                        } else {
                            System.out.println("Caracter Valido");
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent ke) {

                    }

                    @Override
                    public void keyReleased(KeyEvent ke) {

                    }

                }
                );
        txtNombre.setBounds(175, 50, 100, 25);
        
        txtApellido1 = new JTextField();
        txtApellido1.setBounds(175, 100, 100, 25);
        txtApellido1.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent ke) {
                        System.out.println("" + ke.getKeyChar() + "---->" + ke.getKeyCode());
                        if ((!(ke.getKeyChar() >= 65 && ke.getKeyChar() <= 90)) && (!(ke.getKeyChar() >= 97 && ke.getKeyChar() <= 122))
                                && (!(ke.getKeyChar() == 'ñ')) && (!(ke.getKeyChar() == 'Ñ'))) {
                            System.out.println("Caracter Invalido ");
                            ke.consume();
                        } else {
                            System.out.println("Caracter Valido");
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent ke) {

                    }

                    @Override
                    public void keyReleased(KeyEvent ke) {

                    }

                }
                );
        SpinnerNumberModel model1 = new SpinnerNumberModel(20, 16, 66, 1);
        spiEdad = new JSpinner(model1);
        spiEdad.setBounds(175, 150, 100, 25);
        SpinnerNumberModel model2 = new SpinnerNumberModel(175, 130, 220, 1);
        spiEstatura = new JSpinner(model2);
        spiEstatura.setBounds(175, 200, 100, 25);
        rbnHombre = new JRadioButton("H");
        rbnHombre.setBounds(225, 250, 50, 25);
        rbnMujer = new JRadioButton("M");
        rbnMujer.setBounds(175, 250, 50, 25);
        //grupo de botones radio
        SexoButtonGroup = new ButtonGroup();
        SexoButtonGroup.add(rbnMujer);
        SexoButtonGroup.add(rbnHombre);
        //Combo box
        cbbPais = new JComboBox();
        cbbPais.setBounds(175, 300, 100, 25);
        cbbPais.addItem("Antigua y Barbuda");
        cbbPais.addItem("Argentina");
        cbbPais.addItem("Bahamas");
        cbbPais.addItem("Barbados");
        cbbPais.addItem("Belice");
        cbbPais.addItem("Bolivia");
        cbbPais.addItem("Brasil");
        cbbPais.addItem("Colombia");
        cbbPais.addItem("Costa Rica");
        cbbPais.addItem("Cuba");
        cbbPais.addItem("Chile");
        cbbPais.addItem("Dominica");
        cbbPais.addItem("Ecuador");
        cbbPais.addItem("El Salvador");
        cbbPais.addItem("Granada");
        cbbPais.addItem("Guatemala");
        cbbPais.addItem("Guayana");
        cbbPais.addItem("Haiti");
        cbbPais.addItem("Honduras");
        cbbPais.addItem("Jamaica");
        cbbPais.addItem("Mexico");
        cbbPais.addItem("Nicaragua");
        cbbPais.addItem("Panama");
        cbbPais.addItem("Paraguay");
        cbbPais.addItem("Peru");
        cbbPais.addItem("Republica Dominicana");
        cbbPais.addItem("San Cristobal Y Nieves");
        cbbPais.addItem("San Vicente Y las Granadinas");
        cbbPais.addItem("Santa Lucia");
        cbbPais.addItem("Surinam");
        cbbPais.addItem("Trinidad Y Tobago");
        cbbPais.addItem("Uruguay");
        cbbPais.addItem("Venezuela");
        cbbGrado = new JComboBox();
        cbbGrado.setBounds(175, 350, 100, 25);
        cbbGrado.addItem("1");
        cbbGrado.addItem("2");
        cbbGrado.addItem("3");
        cbbGrado.addItem("4");
        cbbGrado.addItem("5");
        cbbGrado.addItem("6");
        cbbGrado.addItem("7");
        cbbGrado.addItem("8");
        cbbGrado.addItem("9");
        cbbGrado.addItem("10");
        jslHabilidad = new JSlider(JSlider.HORIZONTAL,20,100,20);
        jslHabilidad.setBounds(175, 400, 400, 50);
        jslHabilidad.setPaintLabels(true);
        jslHabilidad.setPaintTicks(true);
        jslHabilidad.setMajorTickSpacing(5);
        jslHabilidad.setMinorTickSpacing(0);
        jslHabilidad.setSnapToTicks(true);
        jslHabilidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblValHabilidad.setText(String.valueOf(jslHabilidad.getValue()));
            }
        });
        jslMotivacion = new JSlider(JSlider.HORIZONTAL,0,100,0);
        jslMotivacion.setBounds(175, 475, 400, 50);
        jslMotivacion.setPaintLabels(true);
        jslMotivacion.setPaintTicks(true);
        jslMotivacion.setMajorTickSpacing(10);
        jslMotivacion.setMinorTickSpacing(0);
        jslMotivacion.setSnapToTicks(true);//Mueve el knob(iondicador) al siguente valor mas proximo.
        jslMotivacion.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblValMotivacion.setText(String.valueOf(jslMotivacion.getValue()));
            }
        });
        rbnZurdo = new JRadioButton("Zurdo"); //Cabiarlo por el group de Zurdo/Diestro
        rbnZurdo.setBounds(175, 550, 100, 25);
        rbnDiestro = new JRadioButton("Diestro");
        rbnDiestro.setBounds(275, 550, 100, 25);
        ZurdoButtonGroup = new ButtonGroup();
        ZurdoButtonGroup.add(rbnZurdo);
        ZurdoButtonGroup.add(rbnDiestro);
        btnSelecIm = new JButton("Selec");
        btnSelecIm.setBounds(400, 550, 100, 25);//275, 550, 100, 25
        btnSelecIm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    
                if (SexoButtonGroup.getSelection() == null || txtNombre.getText().isEmpty() || txtApellido1.getText().isEmpty() || ZurdoButtonGroup.getSelection() == null) {
                        JOptionPane.showMessageDialog(null, "Un Dato se encuentra vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    FileFilter filter = new FileNameExtensionFilter("png files", "png");
                    chooser.addChoosableFileFilter(filter);
                    filter = new FileNameExtensionFilter("jpg files", "jpg");
                    chooser.addChoosableFileFilter(filter);
                    filter = new FileNameExtensionFilter("gif files", "gif");
                    chooser.addChoosableFileFilter(filter);
                    retorno = chooser.showDialog(null,"Seleccionar");
                    if(retorno == JFileChooser.APPROVE_OPTION){
                        chooser.getSelectedFile();
                        File file = chooser.getSelectedFile();
                        String path = file.getAbsolutePath();
                        ImageIcon x=new ImageIcon(path);
                        Image img = x.getImage();
                        Image img1 = img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon imagen = new ImageIcon(img1);
                        lblImagen.setIcon(imagen);
                        btnAgregar.setEnabled(true);
                    }

                }
            }
        });
        btnClear = new JButton("Limpiar");
        btnClear.setBounds(525, 550, 100, 25);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarCampos();
                btnActualizar.setEnabled(false);
                btnMostrar.setEnabled(false);
            }
        });
        lblImagen = new JLabel("Imagen");  //Imagen
        lblImagen.setBounds(300, 10, 350, 350); //ubicacion del label de Imagen
        lblGanador = new JLabel("Ganador: ");
        lblGanador.setBounds(600, 400, 100, 25);//175, 400, 400, 50)
        lblWinner = new JLabel(" ");
        lblWinner.setBounds(700, 400, 100, 25);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(150, 600, 100, 25);
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombre = JOptionPane.showInputDialog("Introduce Nombre para buscar :");
                if(nombre == null){
                    
                }
                else{
                    depAux = new Deportista(nombre.trim()); 
                    if(deportistas.contains(depAux)){
                        posicion = deportistas.indexOf(depAux);
                        dep = deportistas.get(posicion);
                        txtNombre.setText(dep.getNombre());
                        txtApellido1.setText(dep.getApellido());
                        spiEdad.setValue(dep.getEdad());
                        switch(dep.getSexo()){
                            case 'H' :  rbnHombre.setSelected(true);    break;
                            case 'M' :  rbnMujer.setSelected(true);     break;
                        }
                        cbbPais.setSelectedItem(dep.getNacionalidad());
                        jslHabilidad.setValue(dep.getHabilidad());
                        jslMotivacion.setValue(dep.getMotivacion());
                        if(dep.isZurdo() == true){
                            dep.setZurdo(true);
                        }else{
                            dep.setZurdo(false);
                        }
                        chooser.getSelectedFile();
                            File file = chooser.getSelectedFile();
                            String path = file.getAbsolutePath();
                            ImageIcon x=new ImageIcon(path);
                            Image img = x.getImage();
                            Image img1 = img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon imagen = new ImageIcon(img1);
                            lblImagen.setIcon(imagen);
                        btnActualizar.setEnabled(true);
                        btnEliminar.setEnabled(true);
                       
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Deportista: "+depAux.getNombre()+" no encontrado");
                    }
                }
            }
        });

        btnInTor = new JButton("Inicar Torneo");
        btnInTor.setBounds(575, 600, 100, 25);
        ArrayList <Deportista> deportistas2 = null;
        for(int i = 0; i < deportistas.size(); i++){
            deportistas2.add(deportistas.get(i));
        }
        btnInTor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                    Collections.sort(deportistas, new Comparator<Deportista>() {

                        @Override
                        public int compare(Deportista deportista, Deportista t1) {
                            if (deportista.getPow() > t1.getPow()){
                                return 1;
                            }
                            if( deportista.getPow() < t1.getPow()){
                                return -1;
                            }
                            return 0;
                        }
                    });
                System.out.println(deportistas);
            }
        });
        btnInTor.setEnabled(false);
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(250, 600, 100, 25);
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (SexoButtonGroup.getSelection() == null || txtNombre.getText().isEmpty() || txtApellido1.getText().isEmpty() || ZurdoButtonGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Un dato se encuentra vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    //Recibir Datos
                    String nombre = txtNombre.getText().toLowerCase().trim();
                    String apellido = txtApellido1.getText().toLowerCase().trim();
                    char sexo = ' ';
                    if (rbnHombre.isSelected()) {
                        sexo += rbnHombre.getText().charAt(0);
                    } else {
                        sexo += rbnMujer.getText().charAt(0);
                    }
                    boolean zurdo;
                    if(rbnZurdo.isSelected()){
                        zurdo = true;
                    }else{
                        zurdo = false;
                    }

                    // Enviar Datos al constructor
                    //dep = new Deportista();
                    dep.setNombre(nombre);
                    dep.setApellido(apellido);
                    String value = spiEdad.getValue()+"";
                    int edadAux = Integer.parseInt(value);
                    dep.setEdad(edadAux);
                    dep.setSexo(sexo);
                    String value2 = spiEstatura.getValue()+"";
                    int estaturaAux = Integer.parseInt(value2);
                    dep.setEstatura(estaturaAux);
                    dep.setNacionalidad(cbbPais.getSelectedItem().toString());
                    dep.setGrado(cbbGrado.getSelectedIndex());
                    dep.setHabilidad(jslHabilidad.getValue());
                    dep.setMotivacion(jslMotivacion.getValue());
                    dep.setZurdo(zurdo);
                    chooser.getSelectedFile();
                    File file = chooser.getSelectedFile();
                    String path = file.getAbsolutePath();
                    ImageIcon x=new ImageIcon(path);
                    Image img = x.getImage();
                    Image img1 = img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imagen = new ImageIcon(img1);
                    lblImagen.setIcon(imagen);
                    dep.setRutaImg(path);
                    deportistas.add(dep);
                    if(deportistas.size()>=2){
                        btnActualizar.setEnabled(false);
                    }
                    System.out.println(deportistas);
                }
            }
        });
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(350, 600, 100, 25);
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null, "¿Eliminar registro?");
                if(input == 0){
                    if(deportistas.remove(posicion)!= null){
                        JOptionPane.showMessageDialog(null,"Se ha eliminado el registro.");
                        if(!(deportistas.size() > 1)){
                            btnBuscar.setEnabled(true);
                        }else{
                            btnBuscar.setEnabled(false);
                            btnAgregar.setEnabled(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"No se elimino el registro.");
                    }
                    btnActualizar.setEnabled(false);
                    btnEliminar.setEnabled(false);

                    limpiarCampos();
                }
            }
        });
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(50, 600, 100, 25);
        btnAgregar.setEnabled(false);
        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(450, 600, 100, 25);
        btnMostrar.setEnabled(false);
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tabla == null) {
                    tabla = new Tabla(deportistas);
                    tabla.setBounds(675, 50, 680, 300);
                    deportista.DeportistaGUI.this.add(tabla);
                }
            }
        });


        //btnAgregar.setEnabled(enable);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Validacion de Campos
                if (txtNombre.getText().isEmpty() || txtApellido1.getText().isEmpty()) {
                    if(txtNombre.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Campo " + txtNombre.getName() + "Vacio");
                        return;
                    }else{
                        JOptionPane.showMessageDialog(null, "Campo " + txtApellido1.getName() + "Vacio");
                        return;
                    }
                }
                if (SexoButtonGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Sexo se encuentra vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (ZurdoButtonGroup.getSelection() == null){
                    JOptionPane.showMessageDialog(null, "Zurdo se encuentra vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (SexoButtonGroup.getSelection() == null || txtNombre.getText().isEmpty() 
                        || txtApellido1.getText().isEmpty() || ZurdoButtonGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Un Dato se encuentra vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    //tomamos los datos de los campos y componentes
                    copiarImagen("Guardar");
                    String nombre = txtNombre.getText().toLowerCase().trim();
                    String apellido = txtApellido1.getText().toLowerCase().trim();
                    char sexo = ' ';
                    if (rbnHombre.isSelected()) {
                        sexo += rbnHombre.getText().charAt(0);
                    } else {
                        sexo += rbnMujer.getText().charAt(0);
                    }
                    boolean zurdo = false;
                    if(rbnZurdo.isSelected()){
                        zurdo = true;
                    }
                    if(rbnDiestro.isSelected()){
                        zurdo = false;
                    }

                    // Enviar Datos al constructor
                    dep = new Deportista();
                    dep.setNombre(nombre);
                    dep.setApellido(apellido);
                    String value = spiEdad.getValue()+"";
                    int edadAux = Integer.parseInt(value);
                    dep.setEdad(edadAux);//observar
                    dep.setSexo(sexo);
                    String value2 = spiEstatura.getValue()+"";
                    int estaturaAux = Integer.parseInt(value2);
                    dep.setEstatura(estaturaAux);
                    dep.setNacionalidad(cbbPais.getSelectedItem().toString());
                    dep.setGrado(cbbGrado.getSelectedIndex());
                    dep.setHabilidad(jslHabilidad.getValue());
                    dep.setMotivacion(jslMotivacion.getValue());
                    dep.setZurdo(zurdo);
                    dep.setRutaImg(copiarImagen("Guardar"));
                    dep.genPow();
                    if(deportistas.add(dep)){
                        JOptionPane.showMessageDialog(null, "Deportista "+dep.getNombre()+" agregado correctamente!");
                        btnBuscar.setEnabled(true);
                        System.out.println(dep);
                    }
                    
                    if(deportistas.size()>8){
                        JOptionPane.showMessageDialog(null, "Limite de Deportistas alcanzado!!! (8)");
                        btnInTor.setEnabled(true);
                        deportistas.remove(8);
                    }
                    
                    if(deportistas.size()>= 1){
                        btnMostrar.setEnabled(true);
                        btnBuscar.setEnabled(true);
                        btnEliminar.setEnabled(true);
                        btnMostrar.setEnabled(true);
                    }else{
                        btnBuscar.setEnabled(false);
                    }
                    System.out.println(deportistas);
                }
            }
        });
        lblLista = new JLabel("Lista"); //Tercera columna
        lblLista.setBounds(910, 700, 600, 500);//300, 10, 600, 600
        tabla = new Tabla(deportistas);
        tabla.setVisible(true);
        tabla.setBounds(675, 50, 680, 300);//575, 600, 100, 25
        
        
        this.add(lblNombre);
        this.add(lblApellido1);
        this.add(lblEdad);
        this.add(lblEstatura);
        this.add(lblSexo);
        this.add(lblPais);
        this.add(lblGrado);
        this.add(lblHabilidad);
        this.add(lblMotivacion);
        this.add(lblValHabilidad);
        this.add(lblZurdo);
        this.add(txtNombre);
        this.add(txtApellido1);
        this.add(spiEdad);
        this.add(spiEstatura);
        this.add(rbnHombre);
        this.add(rbnMujer);
        this.add(cbbPais);
        this.add(cbbGrado);
        this.add(jslHabilidad);
        this.add(jslMotivacion);
        this.add(rbnZurdo);
        this.add(rbnDiestro);
        this.add(btnAgregar);
        this.add(btnBuscar);
        this.add(btnActualizar);
        this.add(btnEliminar);
        this.add(btnMostrar);
        this.add(btnInTor);
        this.add(lblLista);
        this.add(lblImagen);
        this.add(lblValMotivacion);
        this.add(btnSelecIm);
        this.add(btnClear);
        this.add(tabla);
        this.add(lblGanador);
        this.add(lblWinner);
        this.add(btnTest);

        
}
    

    public static void main(String[] args) {
        new DeportistaGUI();
    }
}