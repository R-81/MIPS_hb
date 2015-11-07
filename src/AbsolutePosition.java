
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sun.xml.internal.ws.api.server.Container;


public class AbsolutePosition extends JFrame {
	public AbsolutePosition() {
		setTitle("MIPS-汇编器");//设置标题
		setLayout(null);//取消布局管理器
		setBounds(0,0,200,150);//设定窗体位置大小
		java.awt.Container c = getContentPane();//创建容器对象
		Icon icon_new = new ImageIcon("Image/btn_new.png");
		final JButton b_new = new JButton(icon_new);//创建按钮
		Icon icon_build = new ImageIcon("Image/btn_build.png");
		final JButton b_build = new JButton(icon_build);
		b_new.setBounds(2,2,33,33);
		b_build.setBounds(37,2,33,33);
		b_build.setEnabled(false);
		b_new.setToolTipText("新建一个文件");
		b_build.setToolTipText("编译文件");
		final JTextArea jt = new JTextArea("",8,6);
		jt.setLineWrap(true);
		b_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.setText("");
				jt.requestFocus();
			}
		});
		jt.setBounds(2,37,500,500);
		c.add(b_new);
		c.add(b_build);
		c.add(jt);
		setVisible(true);//窗口可见
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new AbsolutePosition();
	}
}
