public class DM{
	//int only have 0 and 1
	public  static int register[][] = new int[38][32];
	//register[32]=PC;register[33]=HI;register[34]=LO;
	//register[35],register[36],register[37]are temporary registers;
	//low bit 0;high bit 31;
	public static int Overflow = 0;
	public static int RAM[] = new int[10000];
	public DM(){
		for(int i = 0;i < 38;i++){
			for(int j = 0;j < 32;j++){
				register[i][j] = 0;
			}
		}
	}
}