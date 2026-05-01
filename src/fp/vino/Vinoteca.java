package fp.vino;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

//EJERCICIO 2
public interface Vinoteca {
	
	void agregarVino(Vino v);
	void eliminarVino(Vino v);
	Integer obtenerNumeroVinos();
	Boolean contieneVino(Vino v);
	void agregarVinos(Collection<Vino> vinos);
	Boolean contieneVinos(Collection<Vino> vinos);
	//4a
	Integer calcularNumeroVinosDePais(String pais);
	Collection<Vino> obtenerVinosRangoPuntos(Integer minimoPuntos, Integer maximoPuntos);
	Integer calcularNumeroDeVinosDePaisConPuntuacionSuperior(String pais, Integer umbralPuntos);
	Set<Vino> obtenerVinosBaratos(Double precio);
	Boolean existeVinoDeUvaenRegion(String uva, String region);
	//4b
	Set<String> calcularUvasDeRegion(String Region);
	Integer calcularTotalPuntosVinosDeRegion(String Region);
	Double calcularMediaPuntosVinosDeUva(String uva);
	//4c
	Vino obtenerVinoMejorPuntuado();
	Vino obtenerVinoMejorPuntuadoDePais(String pais);
	List<Vino> obtenernVinosRegionOrdenadosPrecio(String region,Integer n);
	//4d
	Map<String,List<Vino>> agruparVinosPorPais();
	Map<String,Set<String>> agruparUvasPorPais(); 
	Map<String,Long> calcularCalidadPrecioPorRegionMayorDe(Double umbral);
	Map<String,Vino> calcularVinoMasCaroPorPais();
	SortedMap<String,List<Vino>> calcularNMejoresVinosPorPais(Integer n);
	String calcularRegionConMejoresVinos(Double umbral);
	

}
