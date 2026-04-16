package fp.vino;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class VinotecaStream implements Vinoteca{

	@Override
	public void agregarVino(Vino v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarVino(Vino v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer obtenerNumeroVinos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean contieneVino(Vino v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarVinos(Collection<Vino> vinos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean contieneVinos(Collection<Vino> vinos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularNumeroVinosDePais(String pais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Vino> obtenerVinosRangoPuntos(Integer minimoPuntos, Integer maximoPuntos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularNumeroDeVinosDePaisConPuntuacionSuperior(String pais, Integer umbralPuntos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Vino> obtenerVinosBaratos(Double precio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeVinoDeUvaenRegion(String uva, String region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> calcularUvasDeRegion(String Region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularTotalPuntosVinosDeRegion(String Region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularMediaPuntosVinosDeUva(String uva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vino obtenerVinoMejorPuntuado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vino> obtenernVinosRegionOrdenadosPrecio(String region, Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Vino>> agruparVinosPorPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<String>> agruparUvasPorPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> calcularCalidadPrecioPorRegionMayorDe(Integer umbral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> calcularVinoMasCaroPorPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String calcularRegionConMejoresVinos(Integer umbral) {
		// TODO Auto-generated method stub
		return null;
	}

}
