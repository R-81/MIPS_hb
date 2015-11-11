import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


public class AbsolutePosition extends JFrame {
	public AbsolutePosition() {
		setTitle("MIPS-�����");//���ñ���
		setLayout(null);//ȡ�����ֹ�����
		setBounds(0,0,200,150);//�趨����λ�ô�С
		java.awt.Container c = getContentPane();//������������
		Icon icon_new = new ImageIcon("Image/btn_new.png");
		final JButton b_new = new JButton(icon_new);//������ť
		Icon icon_build = new ImageIcon("Image/btn_build.png");
		final JButton b_build = new JButton(icon_build);
		b_new.setBounds(2,2,33,33);
		b_build.setBounds(37,2,33,33);
		b_build.setEnabled(true);
		b_new.setToolTipText("�½�һ���ļ�");
		b_build.setToolTipText("�����ļ�");
		final JTextArea jt = new JTextArea("",8,6);
		jt.setLineWrap(true);
		b_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.setText("");
				jt.requestFocus();
			}
		});
		b_build.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CreatFile();
				String s = jt.getText().replaceAll("\n", "\r\n");
				try{
					File file = new File("filetest.txt");
					FileWriter out = new FileWriter(file);
					out.write(s);
					out.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}

			private void CreatFile() {
				File file = new File("filetest.txt");
				if(file.exists()){
					file.delete();
					System.out.println("�ļ���ɾ��");
				}
				try{
						file.createNewFile();
						System.out.println("�ļ��Ѵ���");
				}
				catch(Exception e){
						e.printStackTrace();
				}
			}
		});
		jt.setBounds(2,37,500,500);
		c.add(b_new);
		c.add(b_build);
		c.add(jt);
		setVisible(true);//���ڿɼ�
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new AbsolutePosition();
	}
}
