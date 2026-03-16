/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_coches;


public class Coche {

    private String matricula;
    private int velocidad;

    public Coche(String m) {
        matricula = m;
        velocidad = 0;
    }

    public void acelerar(int va) {
        velocidad += va; //velocidad=velocidad+va;
    }

    public boolean frenar(int vf) {
    	if(velocidad-vf<0)
    		return false;
    
        velocidad -= vf;
		return true;
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", velocidad=" + velocidad + "]";
	}

}
