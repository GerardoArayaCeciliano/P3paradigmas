/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3_paradigmas.util;

import proyecto3_paradigmas.model.Persona;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta es una clse de utilidades que ejecuta la logica necesaria para cargar
 * el padron en memoria.
 * @author Roberth
 */
public class PadronUtils {

    /**
     * Lee un documento en formato txt con el nombre "PADRON_COMPLETO.txt"
     * el cual debe ser descargado de la pagina del registro nacional de Costa
     * Rica.
     * @return Lista per <b>Personas</b> que fueron generadas a partir del
     * documento de texto.
     */
    public static List<Persona> cargarPersonas() {
        List<String> stringPersonas = new ArrayList();
        List<Persona> listPersona = new ArrayList();

        try {

            FileReader archivo = new FileReader("PADRON_COMPLETO.txt");
            BufferedReader br = new BufferedReader(archivo);
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("1"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("2"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("3"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("4"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("5"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("6"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("7"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("8"))
                    .limit(50000).collect(Collectors.toList()));
            
            stringPersonas.addAll(br.lines().filter((str) -> str.startsWith("9"))
                    .limit(50000).collect(Collectors.toList()));

            stringPersonas.forEach((actual) -> {
                String split[] = actual.split(",");

                Persona persona = new Persona(split[5], split[6], split[7],
                        split[0], split[3]);
                listPersona.add(persona);
            });

        } catch (FileNotFoundException e) {
            System.err.println("Archivo de padron no encontrado");
        }

        return listPersona;
    }
}
