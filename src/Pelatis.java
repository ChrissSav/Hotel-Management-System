import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;
import com.toedter.calendar.JDateChooser;

public class Pelatis extends JFrame{
	public static final int h = 1200;
	public static final int w = 670;
	private JLabel label;
	private JTextField txt_onoma;
	private JTextField txt_genisi;
	private JTextField txt_odos;
	private JTextField txt_adt;
	private JTextField txt_til;
	private JTextField txt_epitheto;
	private JTextField txt_poli;
	private JTextField txt_afm;
	private ArrayList<JTextField> list = new ArrayList<>();
	private JButton btnNewButton;
	private JComboBox<String> combo_filo;
	private Driver_gramatia driver = new Driver_gramatia();
	public Pelatis(JTextField txt){
		
		
		
		
		
		getContentPane().setLayout(null);
		txt_onoma = new JTextField();
		txt_onoma.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_onoma.setOpaque(false);
		txt_onoma.setBorder(null);
		txt_onoma.setBounds(275, 83, 207, 33);
		getContentPane().add(txt_onoma);
		txt_onoma.setColumns(10);
		
		txt_genisi = new JTextField();
		txt_genisi.setOpaque(false);
		txt_genisi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_genisi.setColumns(10);
		txt_genisi.setBorder(null);
		txt_genisi.setBounds(275, 185, 207, 33);
		getContentPane().add(txt_genisi);
		
		txt_odos = new JTextField();
		txt_odos.setOpaque(false);
		txt_odos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_odos.setColumns(10);
		txt_odos.setBorder(null);
		txt_odos.setBounds(275, 289, 207, 33);
		getContentPane().add(txt_odos);
		
		txt_adt = new JTextField();
		txt_adt.setOpaque(false);
		txt_adt.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_adt.setColumns(10);
		txt_adt.setBorder(null);
		txt_adt.setBounds(275, 490, 207, 33);
		getContentPane().add(txt_adt);
		 
		txt_til = new JTextField();
		txt_til.setOpaque(false);
		txt_til.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_til.setColumns(10);
		txt_til.setBorder(null);
		txt_til.setBounds(275, 391, 207, 33);
		getContentPane().add(txt_til);
		 
		txt_epitheto = new JTextField();
		txt_epitheto.setOpaque(false);
		txt_epitheto.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_epitheto.setColumns(10);
		txt_epitheto.setBorder(null);
		txt_epitheto.setBounds(712, 83, 207, 33);
		getContentPane().add(txt_epitheto);
		 
		txt_poli = new JTextField();
		txt_poli.setOpaque(false);
		txt_poli.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_poli.setColumns(10);
		txt_poli.setBorder(null);
		txt_poli.setBounds(712, 289, 207, 33);
		getContentPane().add(txt_poli);
		 
		txt_afm = new JTextField();
		txt_afm.setOpaque(false);
		txt_afm.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_afm.setColumns(10);
		txt_afm.setBorder(null);
		txt_afm.setBounds(712, 391, 207, 33);
		getContentPane().add(txt_afm);
		  
		btnNewButton = new JButton("");
		btnNewButton.setActionCommand("tab1");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Pelatis.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(512, 575, 160, 45);
		getContentPane().add(btnNewButton);
		 
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
		combo_filo.setBounds(714, 185, 207, 33);
		getContentPane().add(combo_filo);
		  
		list.add(txt_adt);
		list.add(txt_epitheto);
		list.add(txt_genisi);
		list.add(txt_odos);
		list.add(txt_onoma);
		list.add(txt_poli);
		list.add(txt_til);
		label = new JLabel("");
		label.setIcon(new ImageIcon(Pelatis.class.getResource("/gramatia/pelatis3.png")));
		label.setBounds(0, 0, 1200, 670);
		getContentPane().add(label);
		
		
		   btnNewButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					btnNewButton.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kataxorsii_kratis_press.png")));
					if(ChechFields()){
						if(driver.ADD_Pelati(txt_onoma.getText(), txt_epitheto.getText(), txt_genisi.getText(), combo_filo.getSelectedItem().toString(), 
								txt_odos.getText(), txt_poli.getText(), txt_til.getText(), txt_afm.getText(), txt_adt.getText())>0){
							txt.setText(txt_adt.getText());
							dispose();
						}
					}
				}
				
			});
			
		   btnNewButton.addMouseListener(new MouseAdapter() {
	            
	            public void mouseEntered(MouseEvent evt) {
	            	btnNewButton.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kataxorsii_kratis_hoverd.png")));

	            }
	            public void mouseExited(MouseEvent evt) {
	            	btnNewButton.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
	            }

	        });
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setBounds((screenWidth-h)/2,(screenHeight-w-30)/2, h, w);
		setVisible(true);
		setResizable(false);
	}
	
	
	
	
	//Έλεγχος Πεδίων
	public boolean ChechFields(){
		int l=0;
		for(l=0; l<list.size(); l++){
			if(list.get(l).getText().equals("")){
				JOptionPane.showMessageDialog(null,"Υπάρχουν κενά πεδία","Σφάλμα",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		if(combo_filo.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Υπάρχουν κενά πεδία","Σφάλμα",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if(!CheckValidateDate(txt_genisi.getText())){
			JOptionPane.showMessageDialog(null,"Εσφαλμένη καταχώρηση ημερ/νιας γέννησης","Σφάλμα",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if(txt_afm.getText().length()!=0 && txt_afm.getText().length()!=9){
			JOptionPane.showMessageDialog(null,"Λάθος Α.Φ.Μ. (9 Ψηφία)","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else{
			return true;
		}
		
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
