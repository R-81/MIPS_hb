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
			returnNumber = add(parameter1,parameter2,parameter3);
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
	private static int add(int parameter1,int parameter2,int parameter3){
		int tempNumber = 0; 
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
}