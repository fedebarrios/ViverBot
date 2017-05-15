package viverbot.Model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Stack;
import org.junit.Test;

import viverbot.DTO.Arista;
import viverbot.DTO.TerrenoDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AnalizadorCaminoMinimo;

public class AnalizadorCaminoMinimoTest {
	private AnalizadorCaminoMinimo analizadorCamino;
	
	private UbicacionDTO[][] inicializar(int x, int y){
		UbicacionDTO[][] ubicaciones = new UbicacionDTO[x][y];
		int indice=0;
		for (int i = 0; i < ubicaciones.length; i++) {
			for (int j = 0; j < ubicaciones.length; j++) {
				ubicaciones[i][j] = new UbicacionDTO(i,j,indice);
				indice++;
			}
		}
		return ubicaciones;
	}
	
	@Test
	public void analizarCaminoMinimoTest() {
		UbicacionDTO[][] ubicaciones = inicializar(4,4);
		TerrenoDTO terreno = new TerrenoDTO(ubicaciones, new Temperatura(2.5));
		analizadorCamino = new AnalizadorCaminoMinimo(terreno);
		ArrayList<Arista> camino = analizadorCamino.caminoMinimo(1, 14);
		for (int i = 0; i < camino.size(); i++) {
			System.out.print("->"+camino.get(i).getUbicacionA().getIndice());
			if((i+1)==camino.size()){
				System.out.print("->"+camino.get(i).getUbicacionB().getIndice());
			}
		}
	}
	
	@Test
	public void analizarCaminoMinimoTest2() {
		UbicacionDTO[][] ubicaciones = inicializar(4,4);
		TerrenoDTO terreno = new TerrenoDTO(ubicaciones, new Temperatura(2.5));
		analizadorCamino = new AnalizadorCaminoMinimo(terreno);
		ArrayList<Arista> camino = analizadorCamino.caminoMinimo(1, 14);
		assertEquals(camino.size(),4);
	}

}
