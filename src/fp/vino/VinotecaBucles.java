package fp.vino;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
	
	
	
	

}
