import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Assembler extends DM{
	private String registerwords[] = new String[200];
	public char Code[] = new char[10000];
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
		//R
		//one register
		registerwords[64] = "mfc0";
		registerwords[65] = "mfhi";
		registerwords[66] = "mflo";
		registerwords[67] = "mthi";
		registerwords[68] = "mtlo";
		//two register
		registerwords[69] = "mtc0";
		registerwords[70] = "div";
		registerwords[71] = "divu";
		registerwords[72] = "mult";
		registerwords[73] = "multu";
		//three register
		registerwords[74] = "add";
		registerwords[75] = "addu";
		registerwords[76] = "sub";
		registerwords[77] = "subu";
		registerwords[78] = "and";
		registerwords[79] = "nor";
		registerwords[80] = "or";
		registerwords[81] = "xor";
		registerwords[82] = "sllv";
		registerwords[83] = "srlv";
		registerwords[84] = "srav";
		registerwords[85] = "slt";
		registerwords[86] = "sltu";
		//I
		//5 immediate
		registerwords[87] = "sll";
		registerwords[88] = "srl";
		registerwords[89] = "sra";
		//16 immediate
		registerwords[90] = "addi";
		registerwords[91] = "addiu";
		registerwords[92] = "andi";
		registerwords[93] = "ori";
		registerwords[94] = "xori";
		registerwords[95] = "slti";
		registerwords[96] = "sltiu";
		//16 offset
		registerwords[97] = "beq";
		registerwords[98] = "bgez";
		registerwords[99] = "bgtz";
		registerwords[100] = "bltz";
		registerwords[101] = "blez";
		registerwords[102] = "bne";
		registerwords[103] = "lb";
		registerwords[104] = "lbu";
		registerwords[105] = "lh";
		registerwords[106] = "lhu";
		registerwords[107] = "lui";
		registerwords[108] = "lw";
		registerwords[109] = "sb";
		registerwords[110] = "sh";
		registerwords[111] = "sw";
		//J
		//26 index
		registerwords[112] = "j";
		//two register
		registerwords[113] = "jal";
		//one register
		registerwords[114] = "jalr";
		registerwords[115] = "jr";
		//BREAK
		registerwords[116] = "break"
		//ERET
		registerwords[117] = "eret"
		//SYSCALL
		registerwords[118] = "syscall"
	}
	public char[] ReadFile(){
		File file = new File("filetest.txt");
		char ch[] = new char[10000];
		try{
			FileReader in = new FileReader(file);
			in.read(ch); 
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ch;
	}
	public void start(){
		MainWindow win = new MainWindow();
		win.Window();
	}
	public void built(){
		Initial();
		Code = ReadFile();
		String strtemp[] = new String[3];
		char chtemp[] = new char[10];
		int partmeterNumber = new int;
		partmeterNumber = 0;
		
		for(int i = 0,j = 0;i < array.length;i++){
			if(Code[i]!=' '&&Code[i]!='\r'&&Code[i]!=','){
				chtemp[j]=Code[i];
				j++;
			}
			else if(Code[i]=='\n'){
				Precondition pre = new Precondition();
				pre.start(k);
			}
			else{
				String str = String(0,j);
				for(int k = 0;k < 200;k++){
					boolean ans = str.equals(registerwords[k]);
					if(partmeterNumber==0){
						Number = k;
					}
					if(ans){
						strtemp[partmeterNumber] = str;
						partmeterNumber++;
					}
				}
			}
		}
	}
}
