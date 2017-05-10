package viverbot.Model;

public enum NivelRiego {
	NIVELNULO(0),
	NIVELNORMAL(3),
	NIVELNEUTRO(3),
	
    NIVEL1(1),
	NIVEL2(2),
	NIVEL3(3),/*NORMAL*/
	NIVEL4(4),
	NIVEL5(5);
	
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
    	
    	if(peso<0){
    		n= NIVEL1;
    	}else if(peso>5){
    		n= NIVEL5;
    	}
    	
		switch (peso){
		case 1:
		n= NIVEL1;
		break;
		case 2:
		n=NIVEL2;
		break;
		case 3:
		n=NIVEL3;		
		break;
		case 4:
		n=NIVEL4;		
		break;
		case 5:    	
		n=NIVEL5;		
		break;
		}
		
    	return n;
    }
    
    
    
}
