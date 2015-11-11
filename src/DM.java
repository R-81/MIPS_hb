public class DM{
	public byte register[] = new byte[32][8];
	public byte RAM[] = new byte[10000];
	private DM{
		for(int i = 0;i < 32;i++){
			for(int j = 0;j < 8;j++){
				register[i] = 0x0;
			}
		}
	}
}