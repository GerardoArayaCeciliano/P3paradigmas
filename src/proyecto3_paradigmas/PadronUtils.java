/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3_paradigmas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Andres
 */
public class PadronUtils {

    public static List<Persona> CargarPersonas() {
        List<String> perso = new ArrayList();
        List<Persona> listPersona = new ArrayList();

        try {
            FileReader archivo = new FileReader("PADRON_COMPLETO.txt");
            BufferedReader br = new BufferedReader(archivo);
            perso.addAll(br.lines().filter((str) -> str.startsWith("1"))
                    .limit(50000).collect(Collectors.toList()));
           perso.addAll(br.lines().filter((str) -> str.startsWith("2"))
                    .limit(50000).collect(Collectors.toList()));
            perso.addAll(br.lines().filter((str) -> str.startsWith("3"))
                    .limit(50000).collect(Collectors.toList()));
            perso.addAll(br.lines().filter((str) -> str.startsWith("4"))
                    .limit(50000).collect(Collectors.toList()));
            perso.addAll(br.lines().filter((str) -> str.startsWith("5"))
                    .limit(50000).collect(Collectors.toList()));
            perso.addAll(br.lines().filter((str) -> str.startsWith("6"))
                    .limit(50000).collect(Collectors.toList()));
            perso.addAll(br.lines().filter((str) -> str.startsWith("7"))
                    .limit(50000).collect(Collectors.toList()));
            perso.addAll(br.lines().filter((str) -> str.startsWith("8"))
                    .limit(50000).collect(Collectors.toList()));
             perso.addAll(br.lines().filter((str) -> str.startsWith("9"))
                    .limit(50000).collect(Collectors.toList()));
            perso.forEach((actual) -> {
                String split[] = actual.split(",");

                Persona persona = new Persona(split[5], split[6], split[7], split[0], split[3], split[1]);
                listPersona.add(persona);

            });
            //RecorrerArchivo(br, listPersona,0);

            System.out.println(archivo);
        } catch (Exception e) {
            System.err.println("error");
        }

        return listPersona;

    }

    public static void RecorrerArchivo(BufferedReader br, List<Persona> li, int cont) {
        String linea;

        try {
            if ((linea = br.readLine()) != null) {

                String split[] = linea.split(",");

                Persona persona = new Persona(split[5], split[6], split[7], split[0], split[3], split[1]);
                li.add(persona);

                RecorrerArchivo(br, li, cont + 1);

            }
        } catch (Exception e) {

        }

    }

}
