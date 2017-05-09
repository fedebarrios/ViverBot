package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.EstadoAlturaAnormal;
import viverbot.Controlador.Verificacion.EstadoAlturaDefectuosa;
import viverbot.Controlador.Verificacion.EstadoAlturaNoComparada;
import viverbot.Controlador.Verificacion.EstadoAlturaNormal;
import viverbot.Controlador.Verificacion.EstadoAlturaPerfecta;
import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.Controlador.Verificacion.StrategyAnalisisAltura;
import viverbot.Controlador.Verificacion.StrategyMetroDown;
import viverbot.Controlador.Verificacion.StrategySeguimientoNull;
import viverbot.DTO.PlantaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.Fecha;
import viverbot.Model.GuardadorAltura;
import viverbot.Modelo.Magnitudes.Altura;
import viverbot.Modelo.Magnitudes.EmptyAltura;
import viverbot.Modelo.Medicion.AnalizadorAltura;

public class AnalizadorAlturaTest {
	
	@Test
	public void EstadoDefectuoso(){
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		PlantaDTO planta = new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.analizar(new Altura(10,"cm"), new Altura(20,"cm"), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaDefectuosa);
	}
	
	@Test
	public void EstadoNormal(){
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		PlantaDTO planta = new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.analizar(new Altura(19,"cm"), new Altura(20,"cm"), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaNormal);
	}
	
	@Test
	public void EstadoAnormal(){
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		PlantaDTO planta = new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.analizar(new Altura(16,"cm"), new Altura(20,"cm"), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaAnormal);
	}
	
	@Test
	public void EstadoPerfecto(){
		StrategyAnalisisAltura estrategia = new StrategyAnalisisAltura();
		PlantaDTO planta = new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategia.analizar(new Altura(50,"cm"), new Altura(20,"cm"), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaPerfecta);
	}
	
	@Test
	public void EstrategiaMetroRoto(){
		PlanificadorAltura planificador = PlanificadorAltura.getInstance();
		AnalizadorAltura analizador = new AnalizadorAltura(GuardadorAltura.getInstance());
		IAnalisisAltura estrategia = analizador.getStrategy(new Altura(-10,"cm"), new Altura(4,"cm"));
		assertTrue(estrategia instanceof StrategyMetroDown);
	}
	
	@Test
	public void EstadoNoComparada(){
		StrategyMetroDown estrategiaMetro = new StrategyMetroDown();
		PlantaDTO planta = new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategiaMetro.analizar(new Altura(-5,"cm"), new Altura(20,"cm"), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaNoComparada);
	}
	
	@Test
	public void EstadoNoComparada2(){
		StrategySeguimientoNull estrategiaSeguimiento = new StrategySeguimientoNull();
		PlantaDTO planta = new PlantaDTO(1, 10, new UbicacionDTO(1,5), new Fecha(04, 05, 2017));
		EstadoAltura estadoDevuelto = estrategiaSeguimiento.analizar(new Altura(45,"cm"), new EmptyAltura(), planta);
		assertTrue(estadoDevuelto instanceof EstadoAlturaNoComparada);
	}
	
	@Test
	public void EstrategiaNadaContraQueComparar(){
		PlanificadorAltura planificador = PlanificadorAltura.getInstance();
		AnalizadorAltura analizador = new AnalizadorAltura(GuardadorAltura.getInstance());
		IAnalisisAltura estrategia = analizador.getStrategy(new Altura(4,"cm"), new EmptyAltura());
		assertTrue(estrategia instanceof StrategySeguimientoNull);
	}
	
	@Test
	public void EstrategiaSePuedeAnalizar(){
		PlanificadorAltura planificador = PlanificadorAltura.getInstance();
		AnalizadorAltura analizador = new AnalizadorAltura(GuardadorAltura.getInstance());
		IAnalisisAltura estrategia = analizador.getStrategy(new Altura(10,"cm"), new Altura(4,"cm"));
		assertTrue(estrategia instanceof StrategyAnalisisAltura);
	}
	
	
}
