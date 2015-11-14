public class R extends DM{
	private static int MaxBit = 32;
	public static int start(int instruction,int parameter1,int parameter2,int parameter3){
		int returnNumber=0; 
		if(parameter1>31){
			parameter1 -= 32;
		}
		if(parameter2>31){
			parameter2 -= 32;
		}
		if(parameter3>31){
			parameter3 -= 32;
		}
		if(instruction==74){
			returnNumber = add(parameter1,parameter2,parameter3,0);
		}
		else if(instruction==75){
			returnNumber = addu(parameter1,parameter2,parameter3,0);
		}
		else if(instruction==76){
			returnNumber = sub(parameter1,parameter2,parameter3);
		}
		else if(instruction==77){
			returnNumber = subu(parameter1,parameter2,parameter3);
		}
		else{
			returnNumber = 1;
		}
		return returnNumber;
	}
	public static int start(int instruction,int parameter1,int parameter2){
		int returnNumber=0; 
		if(parameter1>31){
			parameter1 -= 32;
		}
		if(parameter2>31){
			parameter2 -= 32;
		}
		else{
			returnNumber = 1;
		}
		return returnNumber;
	}
	public static int start(int instruction,int parameter1){
		int returnNumber=0; 
		if(parameter1>31){
			parameter1 -= 32;
		}
		else{
			returnNumber = 1;
		}
		return returnNumber;
	}
	private static int add(int parameter1,int parameter2,int parameter3,int tempNumber){
		int temp30 = 0;
		int calculatorNumber = 0;
		for(int i=0;i<MaxBit;i++){
			calculatorNumber=0;
			if(tempNumber==1){
				calculatorNumber++;
			}
			if(register[parameter2][i]==1){
				calculatorNumber++;
			}
			if(register[parameter3][i]==1){
				calculatorNumber++;
			}
			if(calculatorNumber==3){
				register[parameter1][i]=1;
				tempNumber=1;
			}
			else if(calculatorNumber==2){
				register[parameter1][i]=0;
				tempNumber=1;
			}
			else if(calculatorNumber==1){
				register[parameter1][i]=1;
				tempNumber=0;
			}
			else if(calculatorNumber==0){
				register[parameter1][i]=0;
				tempNumber=0;
			}
			if(i==30){
				temp30=tempNumber;
			}
			else if(i==31){
				Overflow = temp30^tempNumber;//XOR
			}
		}
		return 0;
	}
	private static int addu(int parameter1,int parameter2,int parameter3,int tempNumber){ 
		int calculatorNumber = 0;
		for(int i=0;i<MaxBit;i++){
			calculatorNumber=0;
			if(tempNumber==1){
				calculatorNumber++;
			}
			if(register[parameter2][i]==1){
				calculatorNumber++;
			}
			if(register[parameter3][i]==1){
				calculatorNumber++;
			}
			if(calculatorNumber==3){
				register[parameter1][i]=1;
				tempNumber=1;
			}
			else if(calculatorNumber==2){
				register[parameter1][i]=0;
				tempNumber=1;
			}
			else if(calculatorNumber==1){
				register[parameter1][i]=1;
				tempNumber=0;
			}
			else if(calculatorNumber==0){
				register[parameter1][i]=0;
				tempNumber=0;
			}
		}
		return 0;
	}
	private static int sub(int parameter1,int parameter2,int parameter3){
		if(register[parameter2][31]==0){
			for(int i=0;i<32;i++){
				register[36][i]=register[parameter2][i];
			}
		}
		else{
			register[36][31]=1;
			for(int i=0;i<31;i++){
				register[36][i]=1^register[parameter2][i];
			}
			addu(36,36,0,1);
		}
		if(register[parameter3][31]==1){
			register[35][31]=0;
			for(int i=0;i<31;i++){
				register[35][i]=register[parameter3][i];
			}
		}
		else{
			register[35][31]=1;
			for(int i=0;i<31;i++){
				register[35][i]=1^register[parameter3][i];
			}
			addu(35,35,0,1);
		}
		add(37,36,35,0);
		if(register[37][31]==1){
			for(int i=0;i<31;i++){
				register[37][i]=1^register[37][i];
			}
			addu(37,37,0,1);
		}
		for(int i=0;i < 32;i++){
			register[parameter1][i] = register[37][i];
		}
		return 0;
	}
	private static int subu(int parameter1,int parameter2,int parameter3){
		if(register[parameter2][31]==0){
			for(int i=0;i<32;i++){
				register[36][i]=register[parameter2][i];
			}
		}
		else{
			register[36][31]=1;
			for(int i=0;i<31;i++){
				register[36][i]=1^register[parameter2][i];
			}
			addu(36,36,0,1);
		}
		if(register[parameter3][31]==1){
			register[35][31]=0;
			for(int i=0;i<31;i++){
				register[35][i]=register[parameter3][i];
			}
		}
		else{
			register[35][31]=1;
			for(int i=0;i<31;i++){
				register[35][i]=1^register[parameter3][i];
			}
			addu(35,35,0,1);
		}
		addu(37,35,36,0);
		if(register[37][31]==1){
			for(int i=0;i<31;i++){
				register[37][i]=1^register[37][i];
			}
			addu(parameter1,37,0,1);
		}
		return 0;
	}
}