package control4;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.nio.file.OpenOption;

public class main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /*
         * Haced un programa con un menú que realice las siguientes operaciones:
         * 
         * - Leed el nombre de una asignatura por teclado, si existe, cread un arrayList
         * con los alumnos que hayan aprobado. - Dado el dni de un alumno mostrad sus
         * notas en todas las asignaturas. - Ha habido un error en las calificaciones de
         * una asignatura. Cread un nuevo fichero ordenado por notas de mayor a menor,
         * en el que se ha sumado un punto a cada nota. Sustituir el antiguo fichero por
         * el nuevo.
         */

        Scanner sc = new Scanner(System.in);
        BufferedReader leerFicheros;
        BufferedWriter EscribirFichero = null;
        DirectoryStream<Path> LeerDirectorio;
        Charset charset = Charset.forName("UTF-8");
        Path ruta = Paths.get("asignaturas");
        boolean encontrado = false;

        System.out.println("****************MENU*****************");
        System.out.println("1.*******Alumnos Aprobados***********");
        System.out.println("2.**********alumno nota *************");
        System.out.println("3.*******NOTA MAYOR A MENOR***********");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
        case 1: {
            ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
            System.out.println("Que Asignaturas Buscas");
            String asignatura = sc.nextLine();
            try {
                LeerDirectorio = Files.newDirectoryStream(ruta);
                encontrado = false;
                for (Path path : LeerDirectorio) {
                    if (path.getFileName().toString().replace(".info", "").equalsIgnoreCase(asignatura)) {
                        String line = null;
                        leerFicheros = Files.newBufferedReader(path);
                        while ((line = leerFicheros.readLine()) != null) {
                            try {
                                String datos[] = line.split(",");

                                String dni = datos[0].trim();
                                String nombre = datos[1].trim();
                                String apellido = datos[2].trim();
                                double nota = Double.parseDouble(datos[3].trim());
                                Alumno al = new Alumno(dni, nombre, apellido, nota);
                                if (al.getNota() >= 5)
                                    listaAlumnos.add(al);
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < listaAlumnos.size(); i++) {
                            System.out.println(listaAlumnos.get(i).toString()); // imprime cada elemento
                        }
                        encontrado = true;
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error");
            }

            break;
        }

        case 2:
            System.out.println("DIME EL DNI DEL ALUMNO");
            String dni = sc.nextLine();
            try {
                LeerDirectorio = Files.newDirectoryStream(ruta);
                encontrado = false;
                for (Path path : LeerDirectorio) {
                    String line = null;
                    leerFicheros = Files.newBufferedReader(path);
                    while ((line = leerFicheros.readLine()) != null) {
                        String notas[] = line.split(",");
                        String Adni = notas[0].trim();
                        String Anombre = notas[1].trim();
                        String Aapellido = notas[2].trim();
                        int nota = Integer.parseInt(notas[3].trim());
                        if (dni.equalsIgnoreCase(Adni)) {
                            System.out.println(nota);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error");
            }
            break;

        case 3:
            try {
                LinkedList<Alumno> listaOrden = new LinkedList<Alumno>();
                LeerDirectorio = Files.newDirectoryStream(ruta);
                EscribirFichero=Files.newBufferedWriter(Paths.get("asignaturas\\ARCHVIO.TXT"), charset, CREATE, APPEND);
                for (Path path : LeerDirectorio) {
                    try (BufferedReader br = Files.newBufferedReader(path, charset)) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] datos = line.split(",");
                            
                            String sdni = datos[0].trim();
                            String nombre = datos[1].trim();
                            String apellido = datos[2].trim();
                            double nota=Double.parseDouble(datos[3].trim())+1;

                            Alumno alum = new Alumno(sdni, nombre, apellido, nota);

                            int posicion = pos(listaOrden, alum);
                            listaOrden.add(posicion, alum);
                        }
                    }
                }

                // Mostrar lista ordenada
                for (Alumno a : listaOrden) {
                    System.out.println(a.toString());
                    EscribirFichero.write(a.toString());
                    EscribirFichero.newLine();
                    
                }
                
                EscribirFichero.close();

            } catch (IOException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
            
            break;
        }

        System.out.println("Fin del programa");
    }

    public static int pos(LinkedList<Alumno> alum, Alumno a) {
        for (int i = 0; i < alum.size(); i++) {
            if (a.getNota() > alum.get(i).getNota())
                return i;
        }
        return alum.size();
    }

}