package AyalaJoanRA5_RA6;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/* Joan Ayala */
		LinkedList<Pedido> lista = new LinkedList<>();
		HashSet<String> destinos = new HashSet<String>();
		HashSet<String> usuarios = new HashSet<String>();

		HashMap<String, Double> listaImporte = new HashMap<String, Double>();
		BufferedReader leerFicheros;
		BufferedWriter EscribirFichero = null;
		DirectoryStream<Path> LeerDirectorio;
		Charset charset = Charset.forName("UTF-8");

		Path carpeta = Paths.get("Joan");
		Path pedidos = Paths.get("pedidos.txt");
		Path ped = Paths.get(carpeta + "/" + pedidos);

		try {

			LeerDirectorio = Files.newDirectoryStream(carpeta);

			for (Path path : LeerDirectorio) {
				if (!path.getFileName().toString().replace(".txt", "").equalsIgnoreCase("pedidos")) {
					try {
						Files.delete(path);
						System.out.println("borrado " + path.getFileName());

					} catch (IOException e) {
						System.err.println("error al borrar el archivo " + path.getFileName());
					}

				}
			}

		} catch (IOException e) {
			System.out.println("Error");
		}

		// Creamos el linkedList

		if (!Files.isDirectory(ped) && !Files.exists(ped)) {
			System.out.println("error");
		} else {
			String line = null;
			leerFicheros = Files.newBufferedReader(ped);

			while ((line = leerFicheros.readLine()) != null) {
				try {

					String datos[] = line.split(",");
					if (datos.length == 4) {

						int numPedido = Integer.parseInt(datos[0].trim());
						double precio = Double.parseDouble(datos[1].trim());
						String codUsu = datos[2].trim();
						String destino = datos[3].trim();
						if (codUsu.matches("[A-Za-z]{5,6}[0-9]{1,2}")) {

							Pedido p = new Pedido(numPedido, precio, codUsu, destino);
							int pos = buscarPos(lista, p);
							lista.add(pos, p);
							if (!destinos.contains(destino)) 
								destinos.add(destino);
							
							if (listaImporte.containsKey(codUsu)) 
								listaImporte.put(codUsu, (listaImporte.get(codUsu)) + precio);
							
							if (!listaImporte.containsKey(codUsu)) {
							    listaImporte.put(codUsu, 0.0);
							}
							
							if (!usuarios.contains(codUsu)) 
								usuarios.add(codUsu);
						}
						 else {
							System.err
									.println("no se ha podido procesar la linea por un error en el codigo de Usuario");
						
					} 
						
					}else 
						System.out.println("no se ha podido procesar la linea");
						
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
					
			}

		}
		// imprimimos la lista del importe total de cada usuario
		for (String p : listaImporte.keySet()) {
			System.out.println(p);
		}
		// imprimimos el HashSet
		for (String i : destinos)
			System.out.println(i);

		/*************************************************************************************/
		

		// Creamos un archivo por cada usuario
		
		try {

			for (String u : usuarios) {
				LinkedList<String> listaUsu = new LinkedList<String>();
				EscribirFichero = Files.newBufferedWriter(Paths.get(u.toString() + ".txt"), charset, CREATE, APPEND);

				try (BufferedReader br = Files.newBufferedReader(ped, charset)) {
					String line;

					while ((line = br.readLine()) != null) {
						String[] datos = line.split(",");
						int numPedido = Integer.parseInt(datos[0].trim());
						double precio = Double.parseDouble(datos[1].trim());
						String codUsu = datos[2].trim();
						line= ("Numero:" + numPedido+ "Importe"+precio);
						if (codUsu.equals(u.toString())) {
							listaUsu.add(line);
						}
					}
					
					/*  for (String a : listaUsu) { EscribirFichero.write(a.toString());
					  EscribirFichero.newLine();
					  
					  }*/
					 
					Iterator<String> it = listaUsu.iterator();
					while (it.hasNext()) {
						String linea = it.next();

						EscribirFichero.write(linea);
						EscribirFichero.newLine();

					}
					EscribirFichero.close();
				}
			}

		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}

	public static int buscarPos(LinkedList<Pedido> lista, Pedido p) {
		for (int i = 0; i < lista.size(); i++) {

			if (p.getCod_usu().compareTo(lista.get(i).getCod_usu()) < 0)
				return i;
			if (p.getCod_usu().equals(lista.get(i).getCod_usu())) {
				if (p.getNumPed() < lista.get(i).getNumPed()) {
					return i;
				}
			}
		}
		return lista.size();
	}

}
