public class DM{
	//int only have 0 and 1
	public  static int register[][] = new int[35][32];
	//register[32]=PC;register[33]=HI;register[34]=LO;
	public static int Overflow = 0;
	public static int RAM[] = new int[10000];
	public DM(){
		for(int i = 0;i < 35;i++){
			for(int j = 0;j < 32;j++){
				register[i][j] = 0;
			}
		}
		register[5][1]=1;
		register[6][2]=1;
	}
}