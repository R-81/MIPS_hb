public class DM{
	//int only have 0 and 1
	public static int register[][] = new int[40][32];
	//register[32]=PC;register[33]=HI;register[34]=LO;
	//register[35],register[36],register[37],register[38],register[39]
	//are temporary registers;
	//low bit 0;high bit 31;
	public static int CoregisterCP0[][] = new int[32][32];
	//CP0
	//special registers
	//Э������һ��ͨ��������ʾ��������һ����ѡ������������ָ���ĳ����չ��
	//ӵ���봦����������ļĴ�����MIPS32�ܹ��ṩ�����4��Э���������ֱ���CP0-CP3��
	//Э������CP0����ϵͳ���ƣ�CP1��CP3�������㴦��Ԫ����CP2�����������ض�ʵ�֡�
	//��CP0���Э���������ǿ�ѡ�ġ�
	//Э������CP0�ľ��������У�����CPU����״̬�����ٻ�����ơ��쳣���ơ�
	//�洢����Ԫ���Ƶȡ�CP0ͨ�������ڲ���һϵ�мĴ������������������
	public static int Overflow = 0;
	public static int RAM[] = new int[10000];
	public DM(){
		for(int i = 0;i < 40;i++){
			for(int j = 0;j < 32;j++){
				register[i][j] = 0;
			}
		}
		for(int i = 0;i < 32;i++){
			for(int j = 0;j < 32;j++){
				CoregisterCP0[i][j] = 0;
			}
		}
	}
}