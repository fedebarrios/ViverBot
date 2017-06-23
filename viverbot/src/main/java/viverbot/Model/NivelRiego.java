package viverbot.Model;

public enum NivelRiego {
	NIVELNULO(0),
	
    NIVEL1(1),
	NIVEL2(2),
	NIVEL3(3),
	NIVEL4(4),
	NIVEL5(5),

	NIVELNEUTRO(3);
	
    private final int cantidadEspecifico; //Peso específico
	
	NivelRiego (int pesoEspecifico) { 
	      this.cantidadEspecifico = pesoEspecifico;
	} 
	
    public int getPesoEspecifico() { 
    	return cantidadEspecifico; 
    }

    public NivelRiego aumentar(){
    	if (getPesoEspecifico()!=0) 
    		return evaluaPeso(getPesoEspecifico()+1); 
    	else
    		return NIVELNULO;
    }
    
    public NivelRiego bajar(){
    	if (getPesoEspecifico()!=0) 
    		return evaluaPeso(getPesoEspecifico()-1); 
    	else
    		return NIVELNULO;    
    }
    
    private NivelRiego evaluaPeso(int peso){
    	NivelRiego n=NIVEL1;

    	if(peso<1 || peso>5)
    		n=NivelRiego.values()[this.ordinal()];
    	else 
    		n=NivelRiego.values()[peso];
		
    	return n;
    }
    
}
