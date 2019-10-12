import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class AdminLogin extends JFrame {
	
public static final int h = 923;
public static final int w = 580;

	private JLabel label;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	public AdminLogin(){
		
		
		
		
		
		
		getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setForeground(Color.BLACK);
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setFont(new Font("Times New Roman", Font.BOLD, 24));
		username.setBorder(null);
		username.setBounds(351, 249, 216, 27);
		getContentPane().add(username);
		username.setOpaque(false);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 24));
		passwordField.setBorder(null);
		passwordField.setBounds(351, 348, 216, 27);
		passwordField.setOpaque(false);
		getContentPane().add(passwordField);
		
		btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(AdminLogin.class.getResource("/login/Untitled-1.png")));
		btnNewButton.setBounds(384, 400, 149, 40);
		getContentPane().add(btnNewButton);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AdminLogin.class.getResource("/login/login1.png")));
		label.setBounds(0, 0, 926, 579);
		getContentPane().add(label);
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) { 
				btnNewButton.setIcon(new ImageIcon(AdminLogin.class.getResource("/login/sindesi presd.png")));
				if(username.getText().equals("admin") && passwordField.getText().equals("admin")){
					dispose();
					new Admin();
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Λάθος Στοιχεία!","Προσοχή!",JOptionPane.WARNING_MESSAGE);
					passwordField.setText("");
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
		setResizable(false);
		setBounds((screenWidth-h)/2,(screenHeight-w-30)/2, h, w);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}