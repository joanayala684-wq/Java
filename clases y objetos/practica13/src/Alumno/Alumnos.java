package Alumno;

public class Alumnos {

	private int numMat;
	private double programacion, bbdd, entornos, media;
	private static int numAprobProg=0;
	double notas[];
	
	public Alumnos (int u, double p, double b, double e) {
		this.numMat=u;
		this.programacion=p;
		this.bbdd=b;
		this.entornos=e;
		this.media = (p+b+e)/3;
		
	} 
	public int getNumMat() {
		return numMat;
	}
	public double getProgramacion() {
		return programacion;
	}
	public double getBbdd() {
		return bbdd;
	}
	public double getEntornos() {
		return entornos;
	}
	public double[] getNotas() {
		return notas;
	}
	public double getMedia () {
		return media;
	}
	public double notaMedia() {
		return (this.programacion+this.bbdd+this.entornos)/3;
		return 
		
	}
	public String toString() {
		return "Alumnos [numMat=" + numMat + ", programacion=" + programacion + ", bbdd=" + bbdd + ", entornos="
				+ entornos + ", media=" + media + "]";
	}
	
}
