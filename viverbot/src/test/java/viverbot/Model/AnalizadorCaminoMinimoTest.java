package viverbot.Model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.Arista;
import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Medicion.AnalizadorCaminoMinimo;

public class AnalizadorCaminoMinimoTest {
	private AnalizadorCaminoMinimo analizadorCamino;
	private TerrenoDAO terrenoDAO = TerrenoDAO.getInstance();
	
	@Test
	public void analizarCaminoMinimoTest() {
		terrenoDAO.construirTerreno(4, 4);
		analizadorCamino = new AnalizadorCaminoMinimo();
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
		terrenoDAO.construirTerreno(4, 4);
		analizadorCamino = new AnalizadorCaminoMinimo();
		ArrayList<Arista> camino = analizadorCamino.caminoMinimo(1, 14);
		assertEquals(camino.size(),4);
	}

}
