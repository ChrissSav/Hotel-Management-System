import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;

public class ReceptionLogin extends JFrame{
	
	private JLabel label;
	private JTextField username;
	private JPasswordField password;
	private JButton btnNewButton;
	private Driver_gramatia driver = new Driver_gramatia();
	public ReceptionLogin(){
	
		
		getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		username.setOpaque(false);
		username.setBorder(null);
		username.setBounds(378, 257, 221, 35);
		getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		password.setOpaque(false);
		password.setBorder(null);
		password.setBounds(378, 354, 221, 35);
		getContentPane().add(password);
		
		btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(ReceptionLogin.class.getResource("/login/Untitled-1.png")));
		btnNewButton.setBounds(414, 430, 149, 40);
		getContentPane().add(btnNewButton);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ReceptionLogin.class.getResource("/receptionlogin/grrgrh.png")));
		label.setBounds(0, 0, 984, 618);
		getContentPane().add(label);
		
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) { 
				btnNewButton.setIcon(new ImageIcon(AdminLogin.class.getResource("/login/sindesi presd.png")));
				
				if(driver.Check_Rec(username.getText(), password.getText())){
					new Gramatia(username.getText(),GetFromCalendar2());
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"Λάθος Στοιχεία!","Προσοχή!",JOptionPane.WARNING_MESSAGE);
					password.setText("");
				}
			}
			
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	btnNewButton.setIcon(new ImageIcon(AdminLogin.class.getResource("/login/sindesi - hoverd.png")));           
            }
            public void mouseExited(MouseEvent evt) {
            	btnNewButton.setIcon(new ImageIcon(AdminLogin.class.getResource("/login/Untitled-1.png")));            	
            }
        });
		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setBounds((screenWidth-984)/2,(screenHeight-618-30)/2, 984, 618);
		setVisible(true);
		setResizable(false);
	}
	
	
	
	
	public static String GetFromCalendar2(){
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		Calendar cale = Calendar.getInstance();
		return  dateFormat.format(cale.getTime());
	}
}
