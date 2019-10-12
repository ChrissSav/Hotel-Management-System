import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Main_Frame extends JFrame{
	public static final int h = 1200;
	public static final int w = 663;
	private JLabel label;
	private JButton btnSecre;
	private JButton btnAdmin;
	
	public Main_Frame(){
		
		
		
		
		
		getContentPane().setLayout(null);
		
		btnSecre = new JButton("");
		btnSecre.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/secret normal.png")));
		btnSecre.setBounds(188, 344, 296, 245);
		btnSecre.setContentAreaFilled(false);
		btnSecre.setBorderPainted(false);
		getContentPane().add(btnSecre);
		
		btnAdmin = new JButton("");
		
		btnAdmin.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/admin normal.png")));
		btnAdmin.setBounds(701, 344, 296, 245);
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBorderPainted(false);
		getContentPane().add(btnAdmin);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/mainn.png")));
		label.setBounds(0, 0, h, w);
		getContentPane().add(label);
		
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AdminLogin();
				dispose();
			}
		});
		
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAdmin.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/admin hoverd.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnAdmin.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/admin normal.png")));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAdmin.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/admin presed.png")));
			}
		});
		
		
		
		
		btnSecre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSecre.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/secret hoverd.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSecre.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/secret normal.png")));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnSecre.setIcon(new ImageIcon(Main_Frame.class.getResource("/MainPanel/secret presd.png")));
			}
		});
		
		btnSecre.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ReceptionLogin();
				
				
			}
			
		});
		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setBounds((screenWidth-h)/2,(screenHeight-w-30)/2, 1186, 663);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
