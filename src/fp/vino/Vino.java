package fp.vino;

import fp.utiles.Checkers;

//EJERCICIO 1

public record Vino(String pais, String region, Integer puntos,Double precio, String uva) {
	
	public Vino{
		Checkers.check("los puntos deben estar entre 0 y 100", puntos>=0 && puntos<=100);
		Checkers.check("el precio debe ser mayor que 0", precio>0);
	}
	
	public Double getCalidadPrecio() {
		return puntos/precio;
	}

}
