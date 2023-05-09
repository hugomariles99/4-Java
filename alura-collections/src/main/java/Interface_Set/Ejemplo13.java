package Interface_Set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Ejemplo13 {

    public static void main(String[] args) {

        String alumno1 = "Luis Miguel";
        String alumno2 = "Pepito los palotes";
        String alumno3 = "Juan Carlos";
        String alumno4 = "Pedro Pedrito";
        String alumno5 = "Gustavo Sanchez";
        String alumno6 = "Marcia Maria";
        String alumno7 = "Marcia Maria";
        String alumno8 = "Gustavo Sanchez";

        Collection<String> listaAlumnos = new HashSet<>();

        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);
        listaAlumnos.add(alumno6);
        listaAlumnos.add(alumno7);
        listaAlumnos.add(alumno8);

//        listaAlumnos.forEach(alumno -> {
//            System.out.println(alumno);
//        });

        boolean valida = listaAlumnos.contains("Pedro Pedrito");
        System.out.println(valida);

        String max = listaAlumnos.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(max.length());

        listaAlumnos.removeIf(alumno -> "Pedro Pedrito".equalsIgnoreCase(alumno));
    }
}
