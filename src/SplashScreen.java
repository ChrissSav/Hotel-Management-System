import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SplashScreen extends JFrame {

	private JLabel label;

	public SplashScreen() {
		
		
		
		
		
		
		
		getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(SplashScreen.class.getResource("/login/2.jpg")));
		label.setBounds(0, 0, 1200, 543);
		getContentPane().add(label);
		
		
		Thread clock = new Thread(){
			public void run(){
				try{
					
						sleep(1500);
						dispose();
						new Main_Frame();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		clock.start();
		
		setUndecorated(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setBounds((screenWidth-1200)/2,(screenHeight-543-33)/2, 1200, 543);
		setVisible(true);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
