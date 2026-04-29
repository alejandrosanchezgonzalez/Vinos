package fp.vino;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class VinotecaStream implements Vinoteca{
	
private Set<Vino> vinos;
	
	public  VinotecaStream() {
		this.vinos=new HashSet<Vino>();
		
	}
	
	public VinotecaStream(Collection<Vino> vinos) {
		this.vinos=new HashSet<Vino>(vinos);
	}
	@Override
	public void agregarVino(Vino v) {
		vinos.add(v);
		
	}

	@Override
	public void eliminarVino(Vino v) {
		Checkers.check("este vino no existe" + v, vinos.remove(v));
	}

	@Override
	public Integer obtenerNumeroVinos() {
		return vinos.size();
		
	}

	@Override
	public Boolean contieneVino(Vino v) {
		return vinos.contains(v);
	}

	@Override
	public void agregarVinos(Collection<Vino> Vinos) {
		for(Vino v:Vinos) {
			vinos.add(v);
			
		}
		//this.vinos.addAll(Vinos);
	}

	@Override
	public Boolean contieneVinos(Collection<Vino> Vinos) {
		return vinos.containsAll(Vinos);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(vinos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VinotecaStream other = (VinotecaStream) obj;
		return Objects.equals(vinos, other.vinos);
	}

	@Override
	public String toString() {
		return String.format("Num.vinos: %d\n", this.vinos.size());
	}


		//APARTADO 4A*************************************************************************************************************************************************
	@Override
	public Integer calcularNumeroVinosDePais(String pais) {
		return (int) vinos.stream().filter(v->v.pais().equals(pais)).count();
	}

	@Override
	public Collection<Vino> obtenerVinosRangoPuntos(Integer minimoPuntos, Integer maximoPuntos) {
		Checkers.check("el limite inferior debe ser menor o igual al superior",minimoPuntos<=maximoPuntos);
		return vinos.stream().filter(v->minimoPuntos<=v.puntos()&&(v.puntos()<=maximoPuntos)).toList();
	}

	@Override
	public Integer calcularNumeroDeVinosDePaisConPuntuacionSuperior(String pais, Integer umbralPuntos) {
		return (int)vinos.stream().filter(v->v.pais().equals(pais)&&(v.puntos()>umbralPuntos)).count();
	}

	@Override
	public Set<Vino> obtenerVinosBaratos(Double precio) {
		return vinos.stream().filter(v->v.precio()<precio).collect(Collectors.toSet());
	}

	@Override
	public Boolean existeVinoDeUvaenRegion(String uva, String region) {
		return vinos.stream().anyMatch(v->v.region().equals(region)&&(v.uva().equals(uva)));
	}
		//APARTADO 4B*************************************************************************************************************************************************
	@Override
	public Set<String> calcularUvasDeRegion(String Region) {
		return vinos.stream().filter(v->v.region().equals(Region)).map(Vino::uva).collect(Collectors.toSet());
	}

	@Override
	public Integer calcularTotalPuntosVinosDeRegion(String Region) {
		return (int) vinos.stream().filter(v->v.region().equals(Region)).mapToInt(Vino::puntos).sum();
	}

	@Override
	public Double calcularMediaPuntosVinosDeUva(String uva) {
		return  vinos.stream().filter(v->v.uva().equals(uva)).mapToInt(Vino::puntos).average().getAsDouble();
	}
		//APARTADO C*************************************************************************************************************************************************
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

	//APARTADO D*************************************************************************************************************************************************
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
	public Map<String, Vino> calcularVinoMasCaroPorPais() {
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
