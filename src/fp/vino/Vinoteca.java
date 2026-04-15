package fp.vino;

import java.util.Collection;

//EJERCICIO 2
public interface Vinoteca {
	
	void agregarVino(Vino v);
	void eliminarVino(Vino v);
	Integer obtenerNumeroVinos();
	Boolean contieneVino(Vino v);
	void agregarVinos(Collection<Vino> vinos);
	Boolean contieneVinos(Collection<Vino> vinos);

}
