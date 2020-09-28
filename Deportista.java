package deportista;

import java.util.Objects;

/**
 *
 * @author Guillermo López
 */
public class Deportista {
    private String nombre;
    private String apellido;
    private int edad;
    private int estatura;
    private char sexo;
    private String nacionalidad;
    private int grado;
    private int habilidad;
    private int motivacion;
    private boolean zurdo;
    private String rutaImg;
    private double pow;
    private int id;

    public Deportista() {}

    public Deportista(String nombre) {
        this.nombre = nombre;
    }

    public Deportista(String nombre, String apellido, int edad, int estatura, 
            char sexo, String nacionalidad, int grado, int habilidad, 
            int motivacion, boolean zurdo, String rutaImg, double pow) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estatura = estatura;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.grado = grado;
        this.habilidad = habilidad;
        this.motivacion = motivacion;
        this.zurdo = zurdo;
        this.rutaImg = rutaImg;
        this.pow = pow;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getEstatura() {
        return estatura;
    }

    public char getSexo() {
        return sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getGrado() {
        return grado;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public int getMotivacion() {
        return motivacion;
    }

    public boolean isZurdo() {
        return zurdo;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public double getPow() {
        return pow;
    }
    
    public int getId(){
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public void setMotivacion(int motivacion) {
        this.motivacion = motivacion;
    }

    public void setZurdo(boolean zurdo) {
        this.zurdo = zurdo;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public void setPow(double pow) {
        this.pow = pow;
    }
    
    public void setId(int id){
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deportista other = (Deportista) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    // genera el valor para comparar en los encuentros
    public void genPow(){
        this.pow = (habilidad+motivacion)+(0.10*grado);
    }
    

    @Override
    public String toString() {
        return "Deportista{" + "nombre=" + nombre + ", apellido=" + apellido 
                + ", edad=" + edad + ", estatura=" + estatura + ", sexo=" + sexo 
                + ", nacionalidad=" + nacionalidad + ", grado=" + grado + ", habilidad=" + habilidad 
                + ", motivacion=" + motivacion + ", zurdo=" + zurdo + ", rutaImg=" + rutaImg + ", pow=" + pow + '}';
    }
    
    public static void main(String Args[]) {
        
    /*(String nombre, String apellido, int edad, int estatura,char sexo, 
    String nacionalidad, int grado, int habilidad, int motivacion, boolean zurdo, String rutaImg)*/
        Deportista tdp1 = new Deportista("Carlos","hernandez",34,179,'h',"Chileno"
                ,10,70,61,true,"C://Users//Guillermo//Pictures/",0);
        tdp1.genPow();
        System.out.println(tdp1);
    }
    
}    