import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateReception extends JFrame {
	private ArrayList<JTextField> fields = new ArrayList<>();
	private JButton button_1;
	private JTextField txt_onoma;
	private JTextField txt_genisi;
	private JTextField txt_odos;
	private JTextField txt_til;
	private JTextField txt_adt;
	private JTextField txt_afm;
	private JTextField txt_amka;
	private JTextField txt_poli;
	private JTextField txt_epitheto;
	private JTextField txt_username;
	private JPasswordField password;
	private JCheckBox chbx_kwdikou;
	private JComboBox<String> combo_filo ;
	private JLabel label ;
	private JLabel lblNewLabel;
	private Driver_admin driver = new Driver_admin();
	
	public UpdateReception(String onoma, String epitheto, String genisi, String filo, String odos, String poli, String til, String amka
			, String adt, String afm, String username,String ppassword,JTable table){
		
		
		
		button_1 = new JButton("");		
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setIcon(new ImageIcon(UpdateReception.class.getResource("/update/enimerosi_kratis_normal.png")));
		button_1.setOpaque(false);
		button_1.setBorder(null);
		button_1.setBounds(517, 573, 160, 45);
		getContentPane().add(button_1);
		
		
		
		
		
		txt_onoma = new JTextField();
		fields.add(txt_onoma);
		txt_onoma.setBorder(null);
		txt_onoma.setOpaque(false);
		txt_onoma.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_onoma.setBounds(255, 87, 190, 29);
		getContentPane().add(txt_onoma);
		
		txt_genisi = new JTextField();
		fields.add(txt_genisi);
		txt_genisi.setOpaque(false);
		txt_genisi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_genisi.setColumns(10);
		txt_genisi.setBorder(null);
		txt_genisi.setBounds(255, 183, 190, 29);
		getContentPane().add(txt_genisi);
		
		txt_odos = new JTextField();
		fields.add(txt_odos);
		txt_odos.setOpaque(false);
		txt_odos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_odos.setColumns(10);
		txt_odos.setBorder(null);
		txt_odos.setBounds(255, 281, 190, 29);
		getContentPane().add(txt_odos);
		
		txt_til = new JTextField();
		fields.add(txt_til);
		txt_til.setOpaque(false);
		txt_til.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_til.setColumns(10);
		txt_til.setBorder(null);
		txt_til.setBounds(255, 387, 190, 29);
		getContentPane().add(txt_til);
		
		txt_adt = new JTextField();
		fields.add(txt_adt);
		txt_adt.setOpaque(false);
		txt_adt.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_adt.setColumns(10);
		txt_adt.setBorder(null);
		txt_adt.setBounds(255, 483, 190, 29);
		getContentPane().add(txt_adt);
		
		txt_afm = new JTextField();
		fields.add(txt_afm);
		txt_afm.setOpaque(false);
		txt_afm.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_afm.setColumns(10);
		txt_afm.setBorder(null);
		txt_afm.setBounds(636, 483, 190, 29);
		getContentPane().add(txt_afm);
		
		txt_amka = new JTextField();
		fields.add(txt_amka);
		txt_amka.setOpaque(false);
		txt_amka.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_amka.setColumns(10);
		txt_amka.setBorder(null);
		txt_amka.setBounds(636, 387, 190, 29);
		getContentPane().add(txt_amka);
		
		txt_poli = new JTextField();
		fields.add(txt_poli);
		txt_poli.setOpaque(false);
		txt_poli.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_poli.setColumns(10);
		txt_poli.setBorder(null);
		txt_poli.setBounds(636, 281, 190, 29);
		getContentPane().add(txt_poli);
		
		txt_epitheto = new JTextField();
		fields.add(txt_epitheto);
		txt_epitheto.setOpaque(false);
		txt_epitheto.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_epitheto.setColumns(10);
		txt_epitheto.setBorder(null);
		txt_epitheto.setBounds(636, 87, 190, 29);
		getContentPane().add(txt_epitheto);
		
		txt_username = new JTextField();
		fields.add(txt_username);
		txt_username.setHorizontalAlignment(SwingConstants.CENTER);
		txt_username.setOpaque(false);
		txt_username.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_username.setColumns(10);
		txt_username.setBorder(null);
		txt_username.setBounds(948, 281, 190, 29);
		getContentPane().add(txt_username);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		password.setOpaque(false);
		password.setBorder(null);
		password.setBounds(948, 387, 190, 29);
		getContentPane().add(password);
		
		
		chbx_kwdikou= new JCheckBox("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u039A\u03C9\u03B4\u03B9\u03BA\u03BF\u03CD");
		chbx_kwdikou.setForeground(new Color(178, 177, 177));
		chbx_kwdikou.setBackground(new Color(248, 248, 248));
		chbx_kwdikou.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chbx_kwdikou.setBounds(948, 433, 190, 29);
		getContentPane().add(chbx_kwdikou);
		
		
		combo_filo = new JComboBox<String>();
		combo_filo.addItem("");
		combo_filo.addItem("ΑΝΔΡΑΣ");	
		combo_filo.addItem("ΓΥΝΑΙΚΑ");	
		combo_filo.setForeground(Color.BLACK);
		combo_filo.setBackground(new Color(248, 248, 248));
		combo_filo.setUI(new BasicComboBoxUI());
		combo_filo.setFocusable(false);
		combo_filo.setFocusTraversalKeysEnabled(false);
		combo_filo.setBorder(null);
		combo_filo.setOpaque(false);
		combo_filo.setBorder(null);
		combo_filo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		combo_filo.setBounds(636, 183, 190, 29);
		getContentPane().add(combo_filo);
		
		lblNewLabel = new JLabel("π.χ. 12/03/2018");
		lblNewLabel.setForeground(new Color(117, 184, 221));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(255, 155, 116, 23);
		getContentPane().add(lblNewLabel);
		
		getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(UpdateReception.class.getResource("/update/gramatiaEnimerosi.png")));
		label.setBounds(0, 0, 1200, 670);
		getContentPane().add(label);
		

		
		txt_onoma.setText(onoma);
		txt_epitheto.setText(epitheto); 
		txt_genisi.setText(genisi);
		combo_filo.setSelectedItem(filo);
		txt_odos.setText(odos); 
		txt_poli.setText(poli);
		txt_til.setText(til);
		txt_amka.setText(amka); 
		txt_adt.setText(adt);
		txt_afm.setText(afm); 
		txt_username.setText(username); 
		password.setText(ppassword);
		
		//================
		chbx_kwdikou.addItemListener( new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED){
					password.setEchoChar((char)0);
				}
				else{
					password.setEchoChar('●');
				}	
			}	
		});
		
		
		
		button_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int flag;
				button_1.setIcon(new ImageIcon(UpdateReception.class.getResource("/update/enimerosi_kratis_press.png")));
				if(CheckFields(fields)){
					flag = driver.Update_Employee(txt_onoma.getText(), txt_epitheto.getText(), txt_genisi.getText(), combo_filo.getSelectedItem().toString(), txt_odos.getText(), txt_poli.getText(), 
						txt_til.getText(), txt_amka.getText(), txt_adt.getText(), txt_afm.getText(), txt_username.getText(),password.getText());
					if (flag > 0){
						JOptionPane.showMessageDialog(null,"Ενημερώθηκε ο Υπάλληλος με επιτυχία","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
						CleanFields(fields);
						driver.Print_Employees(table);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Σφάλμα !","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
		
		button_1.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	button_1.setIcon(new ImageIcon(UpdateReception.class.getResource("/update/enimerosi_kratis_hoverd.png")));

            }
            public void mouseExited(MouseEvent evt) {
            	button_1.setIcon(new ImageIcon(UpdateReception.class.getResource("/update/enimerosi_kratis_normal.png")));
            }

        });
		

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setBounds((screenWidth-1200)/2,(screenHeight-670-33)/2, 1200, 670);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public boolean CheckFields(ArrayList<JTextField> ar){
		int i=0;
		System.out.println(ar.size());
		while (i<ar.size()){
			if(ar.get(i).getText().equals("") || combo_filo.getSelectedItem().toString().equals("") || password.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Υπάρχουν κενά πεδία.","Προσοχή!",JOptionPane.WARNING_MESSAGE);
				return false;
			}				
			i++;
		};
		if (txt_afm.getText().length()!= 9){
			JOptionPane.showMessageDialog(null,"Λάθος Α.Φ.Μ. (9 Ψηφία)","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (txt_amka.getText().length()!= 11){
			JOptionPane.showMessageDialog(null,"Λάθος Α.Μ.Κ.Α. (11 Ψηφία)","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}	
		else if(!CheckValidateDate(txt_genisi.getText())){
			JOptionPane.showMessageDialog(null,"Εσφαλμένη καταχώρηση ημερ/νιας γέννησης","Σφάλμα",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else{
			return true;
		}
	}
	
	public void CleanFields(ArrayList<JTextField> ar){
		int i=0;
		while (i<ar.size()){
			ar.get(i).setText("");				
			i++;
		};
		password.setText("");
		combo_filo.setSelectedItem("");	
	}
	

	//Ελεγχος Ημερομηνιας γεννησης
	public static boolean CheckValidateDate(String strDate) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern ( "dd/MM/uuuu" );
		try {
			LocalDate ld = LocalDate.parse ( strDate , f );
			return true;
		} catch ( DateTimeParseException e ) {
			return false;
		}
	}
}
