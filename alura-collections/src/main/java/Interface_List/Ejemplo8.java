package Interface_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ejemplo8 {

    public static final List<List<Integer>> listas = new ArrayList<List<Integer>>() {
        {
            add(new LinkedList<>());
            add(new ArrayList<>());
        }
    };

    public static void main(String[] args) {
        for (List<Integer> lista : listas) {

            final String nombreImplementacion = lista.getClass().getSimpleName();

            //add
            long inicio = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                lista.add(i);
            }

            long fin = System.currentTimeMillis();
            long duracion = fin - inicio;

            System.out.println(nombreImplementacion + " add: " + duracion);

            //get
            inicio = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                lista.get(i);
            }

            fin = System.currentTimeMillis();
            duracion = fin - inicio;

            System.out.println(nombreImplementacion + " get: " + duracion);

            //remove
            inicio = System.currentTimeMillis();
            for (int i = 99999; i >= 0; i--) {
                lista.remove(i);
            }

            fin = System.currentTimeMillis();
            duracion = fin - inicio;

            System.out.println(nombreImplementacion + " remove: " + duracion);
            
            //LINKED-LIST
            //A <-> B1 <-> B2 <-> C <-> D
            //Mas lenta al usar get porque todos los registros estan conectados con el anterior y el posterior
            //Mas eficiente si se quiere agregar un registro en una posicion anterior al ultimo indice
            
            //ARRAY-LIST
            //A -> B1 -> B2 -> C -> D
            //Mas rapida si no se agregan registros a indices anteriores al mas nuevo
            //Si se agrega un registro en una posicion anterior al ultimo indice, empujara todo +1 y demorara mucho
        }
    }
}
