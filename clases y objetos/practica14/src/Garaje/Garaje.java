package Garaje;

public class Garaje {
private int Id, planta;
private double metros, precio, contracto;
private boolean alquilado=false;
private static int totalGanancias;

public Garaje(int id, int planta, double metros) {
	
	Id = id;
	this.planta = planta;
	this.metros = metros;
	
	switch(planta) {
	case 1:
		precio=precio+3;
		break;
	case 2:
		precio=precio+1.5;
		break;
	case -1:
		precio=precio+1;
		break;
	}
	if(metros> 4) {
		precio=precio+1.5;
	}
	else
		precio=precio-1;
	this.precio = 18+precio;
}
public boolean alquiler () {

	if(alquilado) {
		return false;
	}
	alquilado=true;
	contracto=12*precio;
	totalGanancias+=contracto;
	return true;
}

public double getContracto() {
	return contracto;
}
public int getId() {
	return Id;
}
public int getPlanta() {
	return planta;
}
public double getMetros() {
	return metros;
}
public double getPrecio() {
	return precio;
}
public boolean isAlquilado() {
	return alquilado;
}
public double subirPrecio (double porcentaje) {
	if(!alquilado) {
	precio+=this.precio*(porcentaje/100);
	return precio;}
	return precio;
}
@Override
public String toString() {
	return "Garaje [Id=" + Id + ", planta=" + planta + ", metros=" + metros + ", precio=" + precio + ", alquilado="
			+ alquilado + "]";
}
public static int getTotalGanancias() {
	return totalGanancias;
}

}
