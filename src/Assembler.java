import java.awt.Insets;

import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.xpath.internal.operations.Or;



public class Assembler {
	private static int Maxpos = 1;
	private static int register[] = new int[32];
	private static String registerwords[] = new String[64];
	private static String inswords[] = new String[Maxpos+1];

	private void Initial(){
		registerwords[0] = "$zero";
		registerwords[1] = "$at";
		registerwords[2] = "$v0";
		registerwords[3] = "$v1";
		registerwords[4] = "$a0";
		registerwords[5] = "$a1";
		registerwords[6] = "$a2";
		registerwords[7] = "$a3";
		registerwords[8] = "$t0";
		registerwords[9] = "$t1";
		registerwords[10] = "$t2";
		registerwords[11] = "$t3";
		registerwords[12] = "$t4";
		registerwords[13] = "$t5";
		registerwords[14] = "$t6";
		registerwords[15] = "$t7";
		registerwords[16] = "$s0";
		registerwords[17] = "$s1";
		registerwords[18] = "$s2";
		registerwords[19] = "$s3";
		registerwords[20] = "$s4";
		registerwords[21] = "$s5";
		registerwords[22] = "$s6";
		registerwords[23] = "$s7";
		registerwords[24] = "$t8";
		registerwords[25] = "$t9";
		registerwords[26] = "$k0";
		registerwords[27] = "$k1";
		registerwords[28] = "$gp";
		registerwords[29] = "$sp";
		registerwords[30] = "$fp";
		registerwords[31] = "$ra";
		registerwords[32] = "$0";
		registerwords[33] = "$1";
		registerwords[34] = "$2";
		registerwords[35] = "$3";
		registerwords[36] = "$4";
		registerwords[37] = "$5";
		registerwords[38] = "$6";
		registerwords[39] = "$7";
		registerwords[40] = "$8";
		registerwords[41] = "$9";
		registerwords[42] = "$10";
		registerwords[43] = "$11";
		registerwords[44] = "$12";
		registerwords[45] = "$13";
		registerwords[46] = "$14";
		registerwords[47] = "$15";
		registerwords[48] = "$16";
		registerwords[49] = "$17";
		registerwords[50] = "$18";
		registerwords[51] = "$19";
		registerwords[52] = "$20";
		registerwords[53] = "$21";
		registerwords[54] = "$22";
		registerwords[55] = "$23";
		registerwords[56] = "$24";
		registerwords[57] = "$25";
		registerwords[58] = "$26";
		registerwords[59] = "$27";
		registerwords[60] = "$28";
		registerwords[61] = "$29";
		registerwords[62] = "$30";
		registerwords[63] = "$31";
		
		
		inswords[0] = "li";
		inswords[1] = "la";
		
	}
	public static void assembler(char ins[]) {
		//�������ж���
		char op[] = new char[5];//
		//��ָ�����add
		char label[] = new char[10];
		//beq����תָ���ñ�ǩ
		char r[] = new char[5];
		int inspos;
		int i = 0;
		for(int j = 0;i<ins.length;i++){
			System.out.println(ins[i]);
			if(ins[i] == ' '||ins[i] == ':'){
				System.out.println("1");
				j = 0;
				i++;
				break;
			}
			else{
				System.out.println("0");
				op[j++] = ins[i];
			}
		}
		System.out.println(op);
		for(inspos = 0;inspos<=1;inspos++)
			if(op.equals(inswords[inspos]))
				break;
		//����������������е�λ��
		if(inspos>Maxpos)
			System.out.println("��"+"��ָ����ڻ����");
		//������Լ�һ���Ҳ���ָ��ı���
		//��ô������󻹿������о�
		if(inspos == 0){
			//liָ��
			for(int j = 0;ins[i]!=',';i++){
				if(ins[i] == ' '&&j == 0)
					continue;
				else if(ins[i] != '$'&& j == 0){
					System.out.println("liָ���ʽ����ȷ");
				}
				else if((ins[i] == '$'&&j == 0)||j != 0){
					r[j++] = ins[i];
				}
				else if(ins[i] == ','){
					i++;
					break;
				}
			}
			int rt = 32;
			for(int j = 0;j<=63;j++)
				if(registerwords[j].equals(r))
					rt = j%32;
			//ȷ��ʹ�üĴ���rt
			int imm = 0;
			for(int mark = 0;i<ins.length;i++){
				if(ins[i] == '-' && mark == 0 && imm == 0)
					mark = 1;
				else if(ins[i] >= '0'&& ins[i] <= '9'){
					imm = imm*10+ins[i]-'0';
				}
				else if(ins[i] == ';'){
					i++;
					break;
				}
				else {
					System.out.println("liָ������������");
				}
			}
			String imm16 = Integer.toHexString(imm);
			imm = Integer.parseInt(imm16);
			System.out.println(imm);
			register[rt] = imm;
		}
		}
}