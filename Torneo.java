package deportista;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 *
 * @author Guillermo López
 */
public class Torneo {
    private ArrayList<Deportista> deportistas;
    private Fecha fechaTorneo;
    private Deportista ganador;

    
    public Torneo() {
    }
    
    public Torneo(ArrayList deportistas, Fecha fechaTorneo){
        this.deportistas = deportistas;
        this.fechaTorneo = fechaTorneo;
    }

    public Torneo(ArrayList<Deportista> deportistas, Fecha fechaTorneo, Deportista ganador) {
        this.deportistas = deportistas;
        this.fechaTorneo = fechaTorneo;
        this.ganador = ganador;
    }

    public ArrayList<Deportista> getDeportistas() {
        return deportistas;
    }

    public Fecha getFechaTorneo() {
        return fechaTorneo;
    }

    public Deportista getGanador() {
        return ganador;
    }

    public void setDeportistas(ArrayList<Deportista> deportistas) {
        this.deportistas = deportistas;
    }

    public void setFechaTorneo(Fecha fechaTorneo) {
        this.fechaTorneo = fechaTorneo;
    }

    public void setGanador(Deportista ganador) {
        this.ganador = ganador;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Torneo)) return false;
        Torneo torneo = (Torneo) o;
        return getDeportistas().equals(torneo.getDeportistas()) &&
                getFechaTorneo().equals(torneo.getFechaTorneo()) &&
                getGanador().equals(torneo.getGanador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeportistas(), getFechaTorneo(), getGanador());
    }


    @Override
    public String toString() {
        return "Torneo{" +
                "deportistas=" + deportistas +
                ", fechaTorneo=" + fechaTorneo +
                ", ganador=" + ganador +
                '}';
    }

    /*
    public Deportista genTorneo(Deportista[] encuentro1, Deportista[] encuentro2,
                                Deportista[] encuentro3, Deportista[] encuentro4){
        
        Deportista[] encuentro5 = new Deportista[2];
        Deportista[] encuentro6 = new Deportista[2];
        Deportista[] encuentro7 = new Deportista[2];
        Deportista ganador = null;
        
        //octavos de final
        if(encuentro1[0].getPow() > encuentro1[1].getPow())
            encuentro5[0] = encuentro1[0];
        else
            encuentro5[0] = encuentro1[1];
        
        if(encuentro2[0].getPow() > encuentro2[1].getPow())
            encuentro5[1] = encuentro2[0];
        else
            encuentro5[1] = encuentro2[1];
        
        //cuartos de final
        if(encuentro3[0].getPow() > encuentro3[1].getPow())
            encuentro6[0] = encuentro3[0];
        else
            encuentro6[0] = encuentro3[1];
        
        if(encuentro4[0].getPow() > encuentro4[1].getPow())
            encuentro6[1] = encuentro4[0];
        else
            encuentro6[1] = encuentro4[1];
        
        //semifinal
        if(encuentro5[0].getPow() > encuentro5[1].getPow())
            encuentro7[0] = encuentro5[0];
        else
            encuentro7[0] = encuentro5[1];
        
        if(encuentro6[0].getPow() > encuentro6[1].getPow())
            encuentro7[1] = encuentro6[0];
        else
            encuentro7[1] = encuentro6[1];
        
        //final
        if(encuentro7[0].getPow() > encuentro7[1].getPow())
            ganador = encuentro7[0];
        else
            ganador = encuentro7[1];
        
        this.ganador = ganador;
        
        System.out.println("Encuentro 5:\n"+Arrays.toString(encuentro5));
        System.out.println("Encuentro 6:\n"+Arrays.toString(encuentro6));
        System.out.println("Encuentro 7:\n"+Arrays.toString(encuentro7));
        
        return ganador;
    }
    */
    
    public static void main(String[] args) {
        //(ArrayList deportistas, Fecha fechaTorneo)
        ArrayList<Deportista> deportistas = new ArrayList<>();
        deportistas.add(new Deportista("Carlos", "paena", 23, 170, 'h', "mexicano", 3, 69, 82, false, "C:/",0));
        deportistas.get(0).genPow();
        deportistas.add(new Deportista("pablo", "lopez", 45, 159, 'h', "peruano", 1, 57, 58, true, "C:/",0));
        deportistas.get(1).genPow();
        deportistas.add(new Deportista("betoo", "pena", 45, 159, 'h', "peruano", 8, 89, 45, true, "C:/",0));
        deportistas.get(2).genPow();
        deportistas.add(new Deportista("laura", "smith", 28, 160, 'm', "venezolana", 7, 80, 80, false, "C:/",0));
        deportistas.get(3).genPow();
        deportistas.add(new Deportista("pedro", "morales", 30, 189, 'h', "peruana", 5, 34, 78, true, "C:/",0));
        deportistas.get(4).genPow();
        deportistas.add(new Deportista("antonio", "sutra", 25, 187, 'h', "boliviano", 3, 80, 59, false, "C:/",0));
        deportistas.get(5).genPow();
        deportistas.add(new Deportista("otto", "peterson", 29, 170, 'h', "brazileño", 6, 59, 83, true, "C:/",0));
        deportistas.get(6).genPow();
        deportistas.add(new Deportista("HERNAN", "GOMEZ", 50, 190, 'h', "CHILENO", 1, 40, 40, true, "C:/",0));
        deportistas.get(7).genPow();


        Fecha fechaTorneo = new Fecha(2020,07,23);

        Deportista ganador;
        // constructor
        Torneo tsTorneo = new Torneo(deportistas,fechaTorneo);
        System.out.println(deportistas);
        //System.out.println("resultados de la contienda : \n"+tsTorneo.encuentro(deportistas));

        

    }
        
}
