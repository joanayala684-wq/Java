package Teatro;

import java.time.LocalDate;
import java.util.Random;

public class Representacion {
	private String codigo, titulo;
	private LocalDate fecha;
	private int vips, normal;
	private static final int aforoVip = 15, aforoNormal = 25;
	private static final double precioVip = 20, precioNormal = 14;
	private static int totalRecaudado;
	private int[][] asientos = new int[8][5];
	// los etodos que son estaticos se lleman sus getter en el main empezando por el
	// nombre de la clase
	// Representacion.getaforoVip;

	public Representacion(String titulo, LocalDate fecha) {
		// String mes, dia;
		this.titulo = titulo;
		this.fecha = fecha;
		this.vips = aforoVip;
		this.normal = aforoNormal;
		/*
		 * usar if para que nos de el cero en el mesy7om dia si es menor de 10
		 * this.codigo = (titulo.substring(0, 3)).toUpperCase() + "-" +
		 * fecha.getMonthValue() + fecha.getDayOfMonth(); usamos if para introducir cero
		 * por delante int mes=fecha.getMonth(); int dia=fecha.getDayOfMonth();
		 * if(mes>10) { mes="0"+mes; } if(dia>10) { dia="0"+dia; }
		 * this.codigo=titulo.substring(0, 3).toUpperCase()+"-"+mes+dia;
		 */
	}

	public double comprar(String cod, int cont, int entradaVip, int entradaNormal) {
		double precio = 0;

		if (entradaVip > aforoVip || entradaNormal > aforoNormal) {
			return precio;
		}
		precio = precioVip * entradaVip + precioNormal * entradaNormal;
		totalRecaudado += precio;
		vips -= entradaVip;
		normal -= entradaNormal;

		return precio;
	}

	/*
	 * public void ocuparAsientos (int fila, int columna) { boolean esVip=false,
	 * ocupado=false; do { boolean filaCorrecta=(fila>=0 && fila<8 && columna>=0 &&
	 * columna <=5 ); if(fila<3 && fila>=0 ) { esVip=true; } if(fila>8 || columna >5
	 * || columna <0) { System.out.
	 * println("no ha sido posible asignarb los asientos, vuelva a intentarlo"); }
	 * if(filaCorrecta && asientos[fila][columna]==0) { asientos[fila][columna]=1;
	 * ocupado=true; System.out.println("el asiento se ha ocupado con exito");} else
	 * { System.out.println("el asiento ya se encuentra ocupado");}
	 * }while(!ocupado); }
	 */
	// Devuelve true si pudo ocupar el asiento, false si estaba ocupado o mal la
	// fila
	public boolean ocuparAsientoIndividual(int fila, int col, boolean esVip) {

		boolean filaCorrecta = (esVip && fila < 3) || (!esVip && fila >= 3 && fila < 8);
		// 2. Si la fila es correcta, la columna existe y el sitio es 0 (libre)
		if (filaCorrecta && col >= 0 && col < 5 && asientos[fila][col] == 0) {
			asientos[fila][col] = 1; // Ocupamos
			return true;
		}

		return false; // No se pudo (estaba ocupado o fila incorrecta)
	}

	public boolean hayLibres() {
		if (vips == 0 && normal == 0) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Teatro [codigo=" + codigo + ", titulo=" + titulo + ", fecha=" + fecha + ", vips=" + vips + ", normal="
				+ normal + "]";
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getVips() {
		return vips;
	}

	public static int getTotalRecaudado() {
		return totalRecaudado;
	}

	public static void setTotalRecaudado(int totalRecaudado) {
		Representacion.totalRecaudado = totalRecaudado;
	}

	public int getNormal() {
		return normal;
	}

	public static double getPreciovip() {
		return precioVip;
	}

	public static double getPrecionormal() {
		return precioNormal;
	}

}
