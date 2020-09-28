/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deportista;

import java.util.ArrayList;

/**
 *
 * @author Guillermo
 */
public class Encuentro {
    private ArrayList<Deportista> deportistas;
    private Fecha fechaEncuentro;
    private Deportista[] encuentro;

    public Encuentro() {
    }
    
    public Encuentro(ArrayList<Deportista> deportistas, Fecha fechaEncuentro) {
        this.deportistas = deportistas;
        this.fechaEncuentro = fechaEncuentro;
    }

    public Encuentro(ArrayList<Deportista> deportistas, Fecha fechaEncuentro, Deportista[] encuentro) {
        this.deportistas = deportistas;
        this.fechaEncuentro = fechaEncuentro;
        this.encuentro = encuentro;
    }
    
    public Deportista[] genEncuentro(ArrayList<Deportista> deportistas){
        
        for (int i = 0; i < deportistas.size(); i++) {
            this.encuentro[i] = deportistas.get(i);
            if(encuentro.length > 2){
                
            }
        }
    return encuentro;
}
}
