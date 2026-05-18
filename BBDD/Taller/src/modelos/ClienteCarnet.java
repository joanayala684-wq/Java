package modelos;

public class ClienteCarnet extends Cliente{

	public ClienteCarnet(String dni, String nombre, String telefono, String direccion, int carnet, int visitas) {
		super(dni, nombre, telefono, direccion, carnet, visitas);
		
	}

	@Override
	public double pagar(Arreglo a) {
		double importe=0;
		int num=visitas/4;
		if(importe> 200) {
			importe=importe*0.9;
		}
		if(visitas>=4) {
			importe=importe-(num*50);
		}
		visitas++;
		return importe;
	}
}
