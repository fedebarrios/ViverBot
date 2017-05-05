package viverbot.Model;

public enum NivelRiego {
	AUMENTAR(1),
	BAJAR(-1),
	NULO(0),
	NORMAL(3),
	
    NIVEL1(1),
	NIVEL2(2),
	NEUTRO(3),/*NORMAL*/
	NIVEL4(4),
	NIVEL5(5);
	
    private final int cantidadEspecifico; //Peso específico de la madera
	
	NivelRiego (int pesoEspecifico) { 
	      this.cantidadEspecifico = pesoEspecifico;
	} //Cierre del constructor
	
	
	
    public int getPesoEspecifico() { return cantidadEspecifico; }
    
    
    public NivelRiego nivelar(NivelRiego nivelR){
    	if(getPesoEspecifico()-nivelR.getPesoEspecifico()<0){
    		return NIVEL1;
    	}else if(getPesoEspecifico()-nivelR.getPesoEspecifico()>5){
    		return NIVEL5;
    	}
    	return nivelR;
    }
	
}
