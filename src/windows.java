import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class windows extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton jb=new JButton();
	private JButton xj=new JButton();
	private JButton he=new JButton();
	private JButton ru=new JButton();
	private JButton ro=new JButton();
	private JButton sa=new JButton();
	private JButton op=new JButton();
	private JTextArea jt = new JTextArea();
	private JScrollPane sp = new JScrollPane(jt);
	public void CreateWindows(){
		URL urljb = windows.class.getResource("jb.png");
		Icon iconjb = new ImageIcon(urljb);
		jb.setIcon(iconjb);
		jb.setToolTipText("编译");
		jb.setOpaque(false);
		jb.setMargin(new Insets(0,0,0,0));
		jb.setEnabled(false);
		
		URL urlop = windows.class.getResource("op.png");
		Icon iconop = new ImageIcon(urlop);
		op.setIcon(iconop);
		op.setToolTipText("打开文件");
		op.setOpaque(false);
		op.setMargin(new Insets(0,0,0,0));
		op.setEnabled(false);
		
		URL urlsa = windows.class.getResource("save.png");
		Icon iconsa = new ImageIcon(urlsa);
		sa.setIcon(iconsa);
		sa.setToolTipText("保存");
		sa.setOpaque(false);
		sa.setMargin(new Insets(0,0,0,0));
		
		URL urlxj = windows.class.getResource("xj.png");
		Icon iconxj = new ImageIcon(urlxj);
		xj.setIcon(iconxj);
		xj.setToolTipText("新建");
		xj.setOpaque(false);
		xj.setMargin(new Insets(0,0,0,0));
		
		URL urlhe = windows.class.getResource("he.png");
		Icon iconhe = new ImageIcon(urlhe);
		he.setIcon(iconhe);
		he.setToolTipText("帮助");
		he.setOpaque(false);
		he.setMargin(new Insets(0,0,0,0));
		
		URL urlru = windows.class.getResource("run.png");
		Icon iconru = new ImageIcon(urlru);
		ru.setIcon(iconru);
		ru.setToolTipText("运行");
		ru.setOpaque(false);
		ru.setMargin(new Insets(0,0,0,0));
		ru.setEnabled(false);
		
		URL urlro = windows.class.getResource("runone.png");
		Icon iconro = new ImageIcon(urlro);
		ro.setIcon(iconro);
		ro.setToolTipText("运行一条");
		ro.setOpaque(false);
		ro.setMargin(new Insets(0,0,0,0));
		ro.setEnabled(false);
		
		JFrame jf = new JFrame();
		jf.setTitle("MIPS汇编器");
		jf.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout(0,1,0));
		JPanel p2 = new JPanel(new BorderLayout());
		p1.add(he);
		p1.add(xj);
		p1.add(op);
		p1.add(sa);
		p1.add(jb);
		p1.add(ru);
		p1.add(ro);
		p2.add(sp);
		Container container = jf.getContentPane();
		container.add(BorderLayout.NORTH,p1);
		container.add(p2);
		sa.addActionListener(new saAction());
		jb.addActionListener(new jbAction());
		xj.addActionListener(new xjAction());
		op.addActionListener(new opAction());
		container.setBackground(Color.white);
		jf.setVisible(true);
		jf.setSize(300,300);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	class jbAction implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			ru.setEnabled(true);
			ro.setEnabled(true);
		}
	}
	class xjAction implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			jt.setText("");
			ru.setEnabled(false);
			ro.setEnabled(false);
			jb.setEnabled(false);
		}
	}
	class opAction implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			console con = new console();
			con.ReadFile();
			jTextArea.setText(new String(byt, 0, len));
		}
	}
	class saAction extends windows implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			File file = new File("word.txt");
			if(!file.exists()){
				try{
					file.createNewFile();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			try{
				FileWriter out = new FileWriter(file);
				String s = jt.getText();
				out.write(s);
				out.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			jb.setEnabled(true);
		}
	}
	public static void main(String args[]){
		new windows().CreateWindows();
	}
}