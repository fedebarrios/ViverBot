package viverbot.Model;

public enum NivelRiego {
	NULO(0),
	AUMENTAR(-1),
	BAJAR(-2),
	NORMAL(3),
	NEUTRO(3),
	
    NIVEL1(1),
	NIVEL2(2),
	NIVEL3(3),/*NORMAL*/
	NIVEL4(4),
	NIVEL5(5);
	
    private final int cantidadEspecifico; //Peso específico
	
	NivelRiego (int pesoEspecifico) { 
	      this.cantidadEspecifico = pesoEspecifico;
	} //Cierre del constructor
	
	
	
    public int getPesoEspecifico() { 
    	return cantidadEspecifico; 
    }
    
    
    public NivelRiego nivelar(NivelRiego nivelR){
    	NivelRiego n = nivelR;
    	if(getPesoEspecifico()!=0){
    		switch (nivelR){
    		case AUMENTAR:
    		n=evaluaPeso(getPesoEspecifico()+1);
    		break;
    		case BAJAR:
   		 	n=evaluaPeso(getPesoEspecifico()-1);
   		 	break;
    		case NULO:
    		n=NivelRiego.NULO;
    		break;
    		case NORMAL:
         	n=evaluaPeso(getPesoEspecifico());;	
    		break;
    		case NEUTRO:    	
       		n=evaluaPeso(getPesoEspecifico());;	
    		break;
    		}
    	}else{
    		n=NivelRiego.NULO;
    	}
       	
    	return n;
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
/*    	if(getPesoEspecifico()-nivelR.getPesoEspecifico()<0){
    		return NIVEL1;
    	}else if(getPesoEspecifico()-nivelR.getPesoEspecifico()>5){
    		return NIVEL5;
    	}
*/