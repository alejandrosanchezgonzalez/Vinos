package fp.vino;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import fp.utiles.Checkers;

public class VinotecaBucles implements Vinoteca{
	
	private Set<Vino> vinos;
	
	public VinotecaBucles() {
		this.vinos=new HashSet<Vino>();
		
	}
	
	public VinotecaBucles(Collection<Vino> vinos) {
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
		VinotecaBucles other = (VinotecaBucles) obj;
		return Objects.equals(vinos, other.vinos);
	}

	@Override
	public String toString() {
		return String.format("Num.vinos: %d\n", this.vinos.size());
	}

	@Override
	public Integer calcularNumeroVinosDePais(String pais) {
		Integer i=0;
		for (Vino v:vinos) {
			if(v.pais().equals(pais)) {
				i=i+1;
			}
		}
		return i;
	}

	@Override
	public Collection<Vino> obtenerVinosRangoPuntos(Integer minimoPuntos, Integer maximoPuntos) {
		Checkers.check("el limite inferior debe ser menor o igual al superior",minimoPuntos<=maximoPuntos);
		Set<Vino> Vinos=new HashSet<Vino>();
		for(Vino v:vinos) {
			if(minimoPuntos<=v.puntos()&&(v.puntos()<=maximoPuntos)) {
				Vinos.add(v);
			}
		}
		return Vinos;
	}

	@Override
	public Integer calcularNumeroDeVinosDePaisConPuntuacionSuperior(String pais, Integer umbralPuntos) {
		Integer i=0;
		for(Vino v:vinos) {
			if(pais.equals(v.pais())) {
				if(v.puntos()>umbralPuntos) {
					i=i+1;
				}
			}
		}
		return i;
	}

	@Override
	public Set<Vino> obtenerVinosBaratos(Double precio) {
		Set<Vino> Vinos=new HashSet<Vino>();
		for(Vino v:vinos) {
			if(v.precio()<precio) {
				Vinos.add(v);
			}
		}
		return Vinos;
	}

	@Override
	public Boolean existeVinoDeUvaenRegion(String uva, String region) {
		Boolean res=false;
		for(Vino v:vinos) {
			if(v.region().equals(region)) {
				if(v.uva().equals(uva)) {
					res=true;
					break;
				}
			}
		}
		return res;
	}

	@Override
	public Set<String> calcularUvasDeRegion(String region) {
		Set<String> uvas= new HashSet<String>();
		for(Vino v:vinos) {
			if (v.region().equals(region)){
				uvas.add(v.uva());
			}
		}
		return uvas;
	}

	@Override
	public Integer calcularTotalPuntosVinosDeRegion(String region) {
		Integer suma=0;
		for(Vino v:vinos) {
			if(v.region().equals(region)) {
				suma=suma + v.puntos();
				
			}
		}
		return suma;
		
	}

	@Override
	public Double calcularMediaPuntosVinosDeUva(String uva) {
		Integer contador=0;
		Integer puntosTotales=0;
		for(Vino v:vinos) {
			if(v.uva().equals(uva)) {
				contador++;
				puntosTotales= puntosTotales+v.puntos();
			}
		}
		 if (contador == 0) {
		        return 0.0;
		    }
		return (double) (puntosTotales/contador);
		
	}

	@Override
	//TODO
	public Vino obtenerVinoMejorPuntuado() {
		Integer puntuacion=0;
		List<Vino> Vinos=new ArrayList<Vino>();
		for(Vino v:vinos) {
			if(v.puntos()>puntuacion) {
				puntuacion=v.puntos();
				Vinos.clear();
				Vinos.add(v);
			}
		}
		if (Vinos.isEmpty()) {
	        return null;
	    }
		return Vinos.get(Vinos.size()-1);
	}

	@Override
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		Integer puntuacion=0;
		List<Vino> Vinos=new ArrayList<Vino>();
		for(Vino v:vinos) {
			if(v.pais().equals(pais)) {
				if(puntuacion<v.puntos()) {
					puntuacion=v.puntos();
					Vinos.clear();
					Vinos.add(v);
					
				}
			}
			
			}
		if(Vinos.isEmpty()) {
			return null;
		}
		
		return Vinos.get(Vinos.size()-1);

	}

	@Override
	public List<Vino> obtenernVinosRegionOrdenadosPrecio(String region,Integer n) {
		List<Vino> Vinos=new ArrayList<Vino>();
		for (Vino v:vinos) {
			if(v.region().equals(region)) {
				Vinos.add(v);
			}
		}
		Collections.sort(Vinos, new Comparator<Vino>() {
	        @Override
	        public int compare(Vino v1, Vino v2) {
	            return Double.compare(v2.precio(), v1.precio());//res.sort(Comparator.comparing(Vino::precio).reversed());
	        }
	    });

		if (n > Vinos.size()) {
	        n = Vinos.size();
	    }
		return Vinos.subList(0,n);
		
	}

	@Override
	public Map<String, List<Vino>> agruparVinosPorPais() {
		Map<String,List<Vino>> resultado= new HashMap<>();
		for (Vino v:vinos) {
			String pais=v.pais();
			
			if(!resultado.containsKey(pais)) {
				resultado.put(pais, new ArrayList<>());
			}
			resultado.get(pais).add(v);
		}
		return resultado;
	}


	@Override
	public Map<String, Set<String>> agruparUvasPorPais() {
		Map<String,Set<String>> resultado=new HashMap<>();
		for(Vino v:vinos) {
			String pais=v.pais();
			if(!resultado.containsKey(pais)) {
				resultado.put(pais, new HashSet<>());
			}
			resultado.get(pais).add(v.uva());
		}
		return resultado;
	}

	@Override
	public Map<String, Double> calcularCalidadPrecioPorRegionMayorDe(Integer umbral) {
		Map<String,Double> resultado=new HashMap<>();
		for(Vino v:vinos) {
			String region=v.region();
			Double relacion=v.puntos()/v.precio();
			if(relacion>umbral) {
				if(!resultado.containsKey(region)) {
					resultado.put(region, 0.0);
				}
				resultado.put(region,resultado.get(region)+1);
			}
		}
		return resultado;
		
	}

	@Override
	public Map<String, Vino> calcularVinoMasCaroPorPais() {
		Map<String,Vino> resultado=new HashMap<>();
		for(Vino v:vinos) {
			String pais=v.pais();
			
			if(!resultado.containsKey(pais)) {
				resultado.put(pais,v);
			}else {
				Vino vinoActual=resultado.get(pais);
				
				if(v.precio()>vinoActual.precio()) {
					resultado.put(pais, v);
				}
			}
		}
		return resultado;
		
	}

	@Override
	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(Integer n) {
		SortedMap<String,List<Vino>> resultado= new TreeMap<>();
		for(Vino v:vinos) {
			String pais=v.pais();
			if(!resultado.containsKey(pais)) {
				resultado.put(pais,new ArrayList<>());
			}
			resultado.get(pais).add(v);
		}
		for(String pais:resultado.keySet()) {
			List<Vino> lista=resultado.get(pais);
			lista.sort((v1,v2)->v2.puntos().compareTo(v1.puntos()));
			if(lista.size()>n) {
				resultado.put(pais,lista.subList(0, n));
			}
		}
		return resultado;
	}

	@Override
	public String calcularRegionConMejoresVinos(Integer umbral) {
		Map<String, Double> mapa = calcularCalidadPrecioPorRegionMayorDe(umbral);
		String mejorRegion = null;
		Double maximo = 0.0;
		for (String region : mapa.keySet()) {
			Double cantidad = mapa.get(region);

		        if (cantidad > maximo) {
		            maximo = cantidad;
		            mejorRegion = region;
		        }
		    }

		    return mejorRegion;
		}
	}
	
	
	
	

