package fp.vino;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class FactoriaVinos {
	
	public static Vinoteca leerVinoteca(String fichero) {
		Vinoteca res = null;
		try {
		List<Vino> vinos = Files.lines(Paths.get(fichero))
		.skip(1)
		.map(linea -> parsearVino(linea))
		.collect(Collectors.toList());
		res = new VinotecaBucles(vinos);
		} catch (IOException e) {
		System.out.println("No se ha encontrado el fichero " +
		fichero);
		e.printStackTrace();
		}
		return res;
		}
	
	private static Vino parsearVino(String lineaCSV) {
		String[] campos=lineaCSV.split(",");
		Checkers.check("la linea no contiene 5 campos", campos.length==5);
		String pais =campos[0].trim();
		String region=campos[1].trim();
		Integer puntos=Integer.parseInt(campos[2].trim());
		Double precio=Double.parseDouble(campos[3].trim());
		String uva= campos[4].trim();
		return new Vino(pais,region,puntos,precio,uva);
		
	}

}
