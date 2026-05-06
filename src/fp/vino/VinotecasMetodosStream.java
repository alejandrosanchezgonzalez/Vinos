package fp.vino;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class VinotecasMetodosStream {
	
    	// Obtener el vino más caro del catálogo y devolver su país junto con el propio vino. 
		public static Entry<String, Vino> obtenerPaisConVinoMasCaro(List<Vino> vinos) {

			// TODO
			return null;
		}
	 
		// Obtener el Top N de regiones de un país dado, ordenadas por puntuación media, considerando solo
		// los vinos cuya puntuación supere un umbral mínimo.
		public static List<Entry<String, Double>> obtenerNRegionesPaisPorPuntuacionMedia(List<Vino> vinos, String pais,  Integer umbralPuntos,Integer n) {
			// TODO
			return null;
		}

		// Obtener, para cada país, los N vinos más baratos ordenados por precio ascendente. 
	   public static Map<String, List<Vino>> obtenerNVinosMasBaratosPorPais(List<Vino> vinos,Integer n) {

			// TODO
			return null;
		}
	   
	   // Crear un mapa de vinos usando como clave una combinación de país y uva ("Pais" + " - " + "Uva"), 
	   // conservando el vino con mayor puntuación en caso de colisión.
	   public  static Map<String, Vino> mapearVinoPorPaisYUva(List<Vino> vinos) {

			// TODO
			return null;
	   	}

	   // Crear el mapa de vinos anterior, pero devuelve el resultado ordenado de mayor a menor puntuación.
	   public static Map<String, Vino> mapearVinoPorPaisYUvaOrdenadoPorPuntos(List<Vino> vinos) {

			// TODO
			return null;
	   }

	   // Calcular, para cada país, un índice (ranking) de calidad/precio definido como la puntuación media 
	   // dividida entre el precio medio.
	   public static Map<String, Double> rankingCalidadPrecioPorPais(List<Vino> vinos) {
		   
			// TODO
			return null;
		}

	   // Obtener el ranking anterior, pero ordenado de países de mejor a peor según su índice de calidad/precio.
	   public static List<Map.Entry<String, Double>> rankingOrdenadoCalidadPrecioPorPais(List<Vino> lista_vinos) {

			// TODO
			return null;
	     }
	  
	   // Mostrar las estadísticas completas de puntuación (cantidad, mínimo, máximo, suma y media) 
	   // de una región determinada.	   
	   public static void obtenerEstadisticasDePuntosPorRegion(List<Vino> vinos, String region) {

			// TODO
	   }
	   
	   public static void main(String[] args) {

			List<Vino> lista_vinos = List.of(
					new Vino("EEUU", "California", 92, 635.0, "Cabernet Sauvignon"),					
					new Vino("EEUU", "California", 93, 90.0, "Sauvignon Blanc"), 					
					new Vino("EEUU", "California", 92, 560.0, "Pinot Noir"),					
					new Vino("EEUU", "Oregon", 94, 65.0, "Pinot Noir"),
					new Vino("España", "Toro", 95, 73.0, "Tinta de Toro"),
					new Vino("España", "Toro", 92, 65.0, "Garnacha"),
					new Vino("España", "Toro", 92, 110.0, "Tempranillo"),
					new Vino("España", "Valdepeñas", 94, 30.0, "Tempranillo"),
					new Vino("España", "Rioja", 92, 18.5, "Tempranillo"),
					new Vino("España", "Rioja", 88, 9.0, "Garnacha"),
					new Vino("España", "Ribera del Duero", 94, 35.0, "Tempranillo"),
					new Vino("España", "Rueda", 90, 6.5, "Verdejo"), 
					new Vino("Francia", "Provence", 94, 66.0, "Provence red blend"),
					new Vino("Francia", "Burdeos", 93, 440.0, "Cabernet Sauvignon"),
					new Vino("Francia", "Burdeos", 89, 22.0, "Merlot"),
					new Vino("Francia", "Champagne", 91, 50.0, "Chardonnay"),
					new Vino("Italia", "Toscana", 94, 45.0, "Sangiovese"), 
					new Vino("Italia", "Piemonte", 90, 20.0, "Nebbiolo"));

			 // Encontrar el vino más caro de todos y devolver su país y el vino 
		    System.out.println("=== Vino más caro ===");
		    System.out.println(obtenerPaisConVinoMasCaro(lista_vinos)); 
			
			// Obtener Top N regiones por puntuacion media del pais indicado y con puntos por encima del umbral 
		    System.out.println("\n=== Top 3 regiones por puntuacion media de España y con puntos por encima de 92 ===");
		    List <Entry <String, Double>> lista1 = obtenerNRegionesPaisPorPuntuacionMedia(lista_vinos, "España", 92, 3);
		    if (lista1 != null) 
		    	lista1.forEach(entry ->System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
 		    
			// Obtener Top N vinos más baratos por país
		    System.out.println("\n=== Top 3 vinos más baratos por país ===");
		    Map <String, List <Vino>> map1 = obtenerNVinosMasBaratosPorPais(lista_vinos, 3);
		    if (map1 != null) 
		    		map1.forEach((pais, lista) -> 
		    				{System.out.println(pais);
		                	 lista.forEach(v ->System.out.println("  " + v.precio() + "€ - " + v.uva()));
		    				});

		    // Mapear vino por clave compuesta País - Uva
		    System.out.println("\n=== Mapa País - Uva → Vino (mejor puntuado) ===");
		    mapearVinoPorPaisYUva(lista_vinos)
		            .forEach((clave, vino) ->
		                    System.out.println(clave + " -> " + vino.puntos() + " puntos"));

		    // Mapear vino por clave compuesta País - Uva y ordenado por puntos
		    System.out.println("\n=== Mapa País - Uva -> Vino (mejor puntuado; ordenado por puntos) ===");
		    mapearVinoPorPaisYUvaOrdenadoPorPuntos(lista_vinos)
		            .forEach((clave, vino) ->
		                    System.out.println(clave + " -> " + vino.puntos() + " puntos"));
		    
		    // Ranking calidad/precio
		    System.out.println("\n=== Ranking calidad/precio por país ===");
		    rankingCalidadPrecioPorPais(lista_vinos)
		            .forEach((pais, ratio) ->
		                    System.out.printf("%s -> %.2f%n", pais, ratio));

		    // Ranking ordenado calidad/precio por pais
		    System.out.println("\n=== Ranking ORDENADO calidad/precio por país ===");
		    rankingOrdenadoCalidadPrecioPorPais(lista_vinos)
		            .forEach(entry ->
		                    System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));

		    // Estadísticas de puntos por región
		    System.out.println("\n=== Estadísticas de puntos para Toro ===");
		    obtenerEstadisticasDePuntosPorRegion(lista_vinos, "Toro");
		}
}