import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame{
	
	private JPanel panelReception;
	private JPanel panelTabs;
	private JLabel label;
	private JLabel label_1;
	private JButton tab_recep;
	private JButton tab_room;
	private JButton tab_db_recep;
	private JButton tab_db_room;
	private JPanel panelDomatia;
	private JPanel panelDBreception;
	private JPanel panelDBdomatia;
	private JPanel panelTimi;
	private JButton button_AddReception;
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
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private ArrayList<JButton> buttons = new ArrayList<>();
	private ArrayList<JTextField> fields = new ArrayList<>();
	private ArrayList<JPanel> panels = new ArrayList<>();
	private JButton btn_addRooms;
	private JTable table_rooms;
	private JScrollPane scrollPane;
	private JSpinner spinner_klines;
	private JTextField txt_id;
	private JComboBox<String> cbox_tipos;
	private JComboBox<String> cBox_klimatismos;
	private JComboBox<String> cBox_pisina;
	private JComboBox<String> cBox_wifi;
	private JScrollPane scrollPane_1;
	private JTable table_Reception;
	private JTextField txt_search_recep;
	private JLabel label_6;
	private Driver_admin driver = new Driver_admin();
	private JPopupMenu pop ;
	private JLabel lblNewLabel;
	private ArrayList<JComboBox> list = new ArrayList<>();
	private ArrayList<JSpinner> spinners = new ArrayList<>();
	private JButton tab_timi;
	private JLabel label_5 ;
	private JSpinner sp_ac;
	private JSpinner sp_pool;
	private JSpinner sp_wifi;
	private JSpinner sp_parking;
	private JSpinner sp_proino;
	private JSpinner sp_imidiatrofi;
	private JSpinner sp_plirisDiatrofi;
	private JSpinner sp_kanoniko;
	private JSpinner sp_oikogeniako;
	private JSpinner sp_klinas;
	private JSpinner sp_fpa;
	private JButton btn_timi;
	private JTextField txt_room_timi;
	private JTextField txt_searchRoom;
	private JButton btn_back;
	
	public Admin(){
		

		pop = new JPopupMenu();
		JMenuItem update = new JMenuItem(" Ενημέρωση στοιχείων ");
		JMenuItem delete = new JMenuItem(" Διαγραφή ");
		pop.add(update);
		pop.add(delete);
		panelDBreception = new JPanel();
		panelDBreception.setVisible(false);
		
		
		
		



		
//Πανελ Β/Δ Δωματιων
		panelDBdomatia = new JPanel();
		txt_searchRoom = new JTextField();
		txt_searchRoom.setOpaque(false);
		txt_searchRoom.setHorizontalAlignment(SwingConstants.CENTER);
		txt_searchRoom.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txt_searchRoom.setColumns(10);
		txt_searchRoom.setBorder(null);
		txt_searchRoom.setBounds(324, 549, 552, 35);
		panelDBdomatia.add(txt_searchRoom);
		panelDBdomatia.setVisible(false);
		panelDomatia = new JPanel();
		panelDomatia.setVisible(false);
		panelTimi = new JPanel();
		panelTimi.setVisible(false);
		//====================
				
			
		panelTimi.setBounds(0, 36, 1200, 670);
		getContentPane().add(panelTimi);
		panelTimi.setLayout(null);
		
		
//Πανελ Τιμη
		
		
		
		
		sp_ac = new JSpinner();
		sp_ac.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_ac.setBounds(268, 127, 227, 30);
		panelTimi.add(sp_ac);
		
		sp_pool = new JSpinner();
		sp_pool.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_pool.setBounds(268, 188, 227, 30);
		panelTimi.add(sp_pool);
		
		sp_wifi = new JSpinner();
		sp_wifi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_wifi.setBounds(268, 246, 227, 30);
		panelTimi.add(sp_wifi);
		
		sp_parking = new JSpinner();
		sp_parking.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_parking.setBounds(268, 396, 227, 30);
		panelTimi.add(sp_parking);
		
		sp_proino = new JSpinner();
		sp_proino.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_proino.setBounds(857, 130, 227, 30);
		panelTimi.add(sp_proino);
		
		sp_imidiatrofi = new JSpinner();
		sp_imidiatrofi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_imidiatrofi.setBounds(857, 190, 227, 30);
		panelTimi.add(sp_imidiatrofi);
		
		sp_plirisDiatrofi = new JSpinner();
		sp_plirisDiatrofi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_plirisDiatrofi.setBounds(857, 247, 227, 30);
		panelTimi.add(sp_plirisDiatrofi);
		
		sp_kanoniko = new JSpinner();
		sp_kanoniko.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_kanoniko.setBounds(857, 394, 227, 30);
		panelTimi.add(sp_kanoniko);
		
		sp_oikogeniako = new JSpinner();
		sp_oikogeniako.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_oikogeniako.setBounds(857, 455, 227, 30);
		panelTimi.add(sp_oikogeniako);
		
		sp_klinas = new JSpinner();
		sp_klinas.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_klinas.setBounds(857, 518, 227, 30);
		panelTimi.add(sp_klinas);
		
		btn_timi = new JButton("");
		btn_timi.setContentAreaFilled(false);
		btn_timi.setBorderPainted(false);
		btn_timi.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
		btn_timi.setOpaque(false);
		btn_timi.setBorder(null);
		btn_timi.setBounds(520, 590, 160, 45);
		panelTimi.add(btn_timi);
		
		sp_fpa = new JSpinner();
		sp_fpa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sp_fpa.setBounds(268, 518, 227, 30);
		panelTimi.add(sp_fpa);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Admin.class.getResource("/adminpanels/timologigsi.png")));
		label_5.setBounds(0, 0, 1200, 670);
		panelTimi.add(label_5);
		
		spinners.add(sp_ac);
		spinners.add(sp_pool);
		spinners.add(sp_wifi);
		spinners.add(sp_parking);
		spinners.add(sp_proino);
		spinners.add(sp_imidiatrofi);
		spinners.add(sp_plirisDiatrofi);
		spinners.add(sp_kanoniko);
		spinners.add(sp_oikogeniako);
		spinners.add(sp_klinas);
		spinners.add(sp_fpa);
		
	//Διαχειρηση κουμπιου
		
		btn_timi.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btn_timi.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_press.png")));
				if(CheckSpinners(spinners)){
				//	if(LoadTimi()>0 && Refresh_Times()){
					if(LoadTimi()>0){
						if(Refresh_Times()){
							JOptionPane.showMessageDialog(null,"Επιτυχής ενημέρωση.","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
						}	
					}
					else{
						JOptionPane.showMessageDialog(null,"Ανεπιτυχής ενημέρωση.","Προσοχή!",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		btn_timi.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btn_timi.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_hoverd.png")));

			}
			public void mouseExited(MouseEvent evt) {
				btn_timi.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
			}
		});
		panelDomatia.setBounds(0, 36, 1200, 670);
		getContentPane().add(panelDomatia);
		panelDomatia.setLayout(null);		
		//======================================
				
		//Πανελ Δωματιο
			
			//Δηλωση Μεταβλητων
				
			txt_id = new JTextField();
			txt_id.setOpaque(false);
			txt_id.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			txt_id.setColumns(10);
			txt_id.setBorder(null);
			txt_id.setBounds(323, 86, 226, 29);
			panelDomatia.add(txt_id);
			txt_id.setColumns(10);
			
			btn_addRooms = new JButton("");
			btn_addRooms.setContentAreaFilled(false);
			btn_addRooms.setBorderPainted(false);
			btn_addRooms.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
			btn_addRooms.setOpaque(false);
			btn_addRooms.setBorder(null);
			btn_addRooms.setBounds(520, 590, 160, 45);
			panelDomatia.add(btn_addRooms);
			
			spinner_klines = new JSpinner();
			spinner_klines.setBorder(null);
			spinner_klines.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			spinner_klines.setBounds(323, 221, 226, 29);
			panelDomatia.add(spinner_klines);
			
			cbox_tipos = new JComboBox<String>();
			cbox_tipos.setForeground(Color.BLACK);
			cbox_tipos.addItem("");
			cbox_tipos.addItem("Τυπικό");
			cbox_tipos.addItem("Οικογενειακό");
			cbox_tipos.setBackground(new Color(248, 248, 248));
			cbox_tipos.setUI(new BasicComboBoxUI());
			cbox_tipos.setFocusable(false);
			cbox_tipos.setFocusTraversalKeysEnabled(false);
			cbox_tipos.setBorder(null);
			cbox_tipos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			cbox_tipos.setBorder(null);
			cbox_tipos.setOpaque(false);
			cbox_tipos.setBounds(323, 154, 226, 29);
			panelDomatia.add(cbox_tipos);
			
			cBox_klimatismos = new JComboBox<String>();
			cBox_klimatismos.setForeground(Color.BLACK);
			cBox_klimatismos.addItem("");
			cBox_klimatismos.addItem("ΝΑΙ");
			cBox_klimatismos.addItem("ΟΧΙ");
			cBox_klimatismos.setBackground(new Color(248, 248, 248));
			cBox_klimatismos.setUI(new BasicComboBoxUI());
			cBox_klimatismos.setFocusable(false);
			cBox_klimatismos.setFocusTraversalKeysEnabled(false);
			cBox_klimatismos.setBorder(null);
			cBox_klimatismos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			cBox_klimatismos.setBorder(null);
			cBox_klimatismos.setOpaque(false);
			cBox_klimatismos.setBounds(323, 293, 226, 29);
			panelDomatia.add(cBox_klimatismos);
			
			cBox_pisina =  new JComboBox<String>();
			cBox_pisina.setForeground(Color.BLACK);
			cBox_pisina.addItem("");
			cBox_pisina.addItem("ΝΑΙ");
			cBox_pisina.addItem("ΟΧΙ");
			cBox_pisina.setBackground(new Color(248, 248, 248));
			cBox_pisina.setUI(new BasicComboBoxUI());
			cBox_pisina.setFocusable(false);
			cBox_pisina.setFocusTraversalKeysEnabled(false);
			cBox_pisina.setBorder(null);
			cBox_pisina.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			cBox_pisina.setBorder(null);
			cBox_pisina.setOpaque(false);
			cBox_pisina.setBounds(323, 365, 226, 29);
			panelDomatia.add(cBox_pisina);
			
			cBox_wifi =  new JComboBox<String>();
			
			cBox_wifi.setForeground(Color.BLACK);
			cBox_wifi.addItem("");
			cBox_wifi.addItem("ΝΑΙ");
			cBox_wifi.addItem("ΟΧΙ");
			cBox_wifi.setBackground(new Color(248, 248, 248));
			cBox_wifi.setUI(new BasicComboBoxUI());
			cBox_wifi.setFocusable(false);
			cBox_wifi.setFocusTraversalKeysEnabled(false);
			cBox_wifi.setBorder(null);
			cBox_wifi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			cBox_wifi.setBorder(null);
			cBox_wifi.setOpaque(false);
			cBox_wifi.setBounds(323, 439, 226, 29);
			panelDomatia.add(cBox_wifi);
			
			txt_room_timi = new JTextField();
			txt_room_timi.setEditable(false);
			txt_room_timi.setOpaque(false);
			txt_room_timi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			txt_room_timi.setColumns(10);
			txt_room_timi.setBorder(null);
			txt_room_timi.setBounds(323, 509, 226, 29);
			panelDomatia.add(txt_room_timi);
			
			label_6 = new JLabel("\u20AC");
			label_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
			label_6.setBounds(555, 509, 23, 29);
			panelDomatia.add(label_6);
			
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(Admin.class.getResource("/adminpanels/dvmatia.png")));
			label_2.setBounds(0, 0, 1200, 670);
			panelDomatia.add(label_2);	
			
	///======

	btn_addRooms.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btn_addRooms.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_press.png")));
				list.add(cBox_klimatismos);
				list.add(cBox_pisina);
				list.add(cBox_wifi);
				list.add(cbox_tipos);
				if(CheckFields_Rooms(list)){
					
					driver.ADD_Room(txt_id.getText(), cbox_tipos.getSelectedItem().toString(), 
							spinner_klines.getValue()+"", cBox_klimatismos.getSelectedItem().toString()
							,  cBox_pisina.getSelectedItem().toString(),  cBox_wifi.getSelectedItem().toString(),txt_room_timi.getText().toString());
					
				}
			}
	});
	
	btn_addRooms.addMouseListener(new MouseAdapter() {
        
        public void mouseEntered(MouseEvent evt) {
        	btn_addRooms.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_hoverd.png")));

        }
        public void mouseExited(MouseEvent evt) {
        	btn_addRooms.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
        }

    });
	
	
	//Καταχωρηση τιμής στο Δωμάτιο
	cBox_wifi.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			SetTimi();			
		}
	});
	cbox_tipos.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			SetTimi();			
		}
	});
	cBox_klimatismos.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			SetTimi();			
		}
	});
	cBox_pisina.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			SetTimi();			
		}
	});
	spinner_klines.addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
			SetTimi();			
	        }
	    });	
		panelReception = new JPanel();
		panelReception.setBounds(0, 36, 1200, 670);
		panels.add(panelReception);
		getContentPane().add(panelReception);
		panelReception.setLayout(null);
		
		
// Πανελ Reception 	
	
	//Δηλωση μεταβλητών
	
	
	txt_onoma = new JTextField();
	fields.add(txt_onoma);
	txt_onoma.setBorder(null);
	txt_onoma.setOpaque(false);
	txt_onoma.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_onoma.setBounds(255, 87, 190, 29);
	panelReception.add(txt_onoma);
	txt_onoma.setColumns(10);
	
	txt_genisi = new JTextField();
	fields.add(txt_genisi);
	txt_genisi.setOpaque(false);
	txt_genisi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_genisi.setColumns(10);
	txt_genisi.setBorder(null);
	txt_genisi.setBounds(255, 183, 190, 29);
	panelReception.add(txt_genisi);
	
	txt_odos = new JTextField();
	fields.add(txt_odos);
	txt_odos.setOpaque(false);
	txt_odos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_odos.setColumns(10);
	txt_odos.setBorder(null);
	txt_odos.setBounds(255, 281, 190, 29);
	panelReception.add(txt_odos);
	
	txt_til = new JTextField();
	fields.add(txt_til);
	txt_til.setOpaque(false);
	txt_til.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_til.setColumns(10);
	txt_til.setBorder(null);
	txt_til.setBounds(255, 387, 190, 29);
	panelReception.add(txt_til);
	
	txt_adt = new JTextField();
	fields.add(txt_adt);
	txt_adt.setOpaque(false);
	txt_adt.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_adt.setColumns(10);
	txt_adt.setBorder(null);
	txt_adt.setBounds(255, 483, 190, 29);
	panelReception.add(txt_adt);
	
	txt_afm = new JTextField();
	fields.add(txt_afm);
	txt_afm.setOpaque(false);
	txt_afm.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_afm.setColumns(10);
	txt_afm.setBorder(null);
	txt_afm.setBounds(636, 483, 190, 29);
	panelReception.add(txt_afm);
	
	txt_amka = new JTextField();
	fields.add(txt_amka);
	txt_amka.setOpaque(false);
	txt_amka.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_amka.setColumns(10);
	txt_amka.setBorder(null);
	txt_amka.setBounds(636, 387, 190, 29);
	panelReception.add(txt_amka);
	
	txt_poli = new JTextField();
	fields.add(txt_poli);
	txt_poli.setOpaque(false);
	txt_poli.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_poli.setColumns(10);
	txt_poli.setBorder(null);
	txt_poli.setBounds(636, 281, 190, 29);
	panelReception.add(txt_poli);
	
	txt_epitheto = new JTextField();
	fields.add(txt_epitheto);
	txt_epitheto.setOpaque(false);
	txt_epitheto.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_epitheto.setColumns(10);
	txt_epitheto.setBorder(null);
	txt_epitheto.setBounds(636, 87, 190, 29);
	panelReception.add(txt_epitheto);
	
	txt_username = new JTextField();
	fields.add(txt_username);
	txt_username.setHorizontalAlignment(SwingConstants.CENTER);
	txt_username.setOpaque(false);
	txt_username.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	txt_username.setColumns(10);
	txt_username.setBorder(null);
	txt_username.setBounds(970, 281, 190, 29);
	panelReception.add(txt_username);
	
	password = new JPasswordField();
	password.setHorizontalAlignment(SwingConstants.CENTER);
	password.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	password.setOpaque(false);
	password.setBorder(null);
	password.setBounds(970, 387, 190, 29);
	panelReception.add(password);
	
	
	chbx_kwdikou= new JCheckBox("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u039A\u03C9\u03B4\u03B9\u03BA\u03BF\u03CD");
	chbx_kwdikou.setForeground(new Color(178, 177, 177));
	chbx_kwdikou.setBackground(new Color(248, 248, 248));
	chbx_kwdikou.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	chbx_kwdikou.setBounds(970, 433, 190, 29);
	panelReception.add(chbx_kwdikou);
	
	
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
	panelReception.add(combo_filo);
	
	lblNewLabel = new JLabel("π.χ. 12/03/2018");
	lblNewLabel.setForeground(new Color(117, 184, 221));
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel.setBounds(255, 155, 116, 23);
	panelReception.add(lblNewLabel);
	
	button_AddReception = new JButton("");
	button_AddReception.setContentAreaFilled(false);
	button_AddReception.setBorderPainted(false);
	button_AddReception.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
	button_AddReception.setOpaque(false);
	button_AddReception.setBorder(null);
	button_AddReception.setBounds(520, 590, 160, 45);
	panelReception.add(button_AddReception);
	
//Διαχειρηση συμβαντων οταν επιλεχθει το κουμπι "Καταχωρηση Γραμματεα"
	button_AddReception.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			button_AddReception.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_press.png")));
			if(CheckFields(fields)){
				driver.ADD_Employee(txt_onoma.getText(), txt_epitheto.getText(), txt_genisi.getText(), combo_filo.getSelectedItem().toString(), txt_odos.getText(), txt_poli.getText(), 
					txt_til.getText(), txt_amka.getText(), txt_adt.getText(), txt_afm.getText(), txt_username.getText(),password.getText());
				CleanFields(fields);
			}
		}
	});
	
	button_AddReception.addMouseListener(new MouseAdapter() {
        
        public void mouseEntered(MouseEvent evt) {
        	button_AddReception.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_hoverd.png")));

        }
        public void mouseExited(MouseEvent evt) {
        	button_AddReception.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
        }

    });
	label = new JLabel("");
	label.setBounds(0, 0, 1200, 670);
	label.setIcon(new ImageIcon(Admin.class.getResource("/adminpanels/gramatia.png")));
	panelReception.add(label);
	
	
	
// Εμφανισει του κωδικου γραμματεα κατα την δηλωση του 
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
		panelDBdomatia.setBounds(0, 36, 1200, 670);
		getContentPane().add(panelDBdomatia);
		panelDBdomatia.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 63, 1160, 400);
		panelDBdomatia.add(scrollPane);
		
		table_rooms = new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		table_rooms.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ΚΩΔΙΚΟΣ","ΤΥΠΟΣ","ΑΡ. ΚΛΙΝΩΝ","ΚΛΙΜΑΤΙΣΜΟΣ","ΠΙΣΙΝΑ","ΠΑΡΟΧΗ WIFI","ΤΙΜΗ"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
		table_rooms.setBackground(new Color(217, 217, 217));
		table_rooms.setOpaque(false);
		table_rooms.setOpaque(false);
		table_rooms.setBorder(null);
		table_rooms.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(table_rooms);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Admin.class.getResource("/adminpanels/DBrooms1.png")));
		label_4.setBounds(0, 0, 1200, 670);
		panelDBdomatia.add(label_4);
		
		
		//Αναζητηση πελατη
		txt_searchRoom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txt_searchRoom.getText().equals(""))
					driver.Print_Rooms(table_rooms);
				else{
					driver.Print_Rooms_Like(table_rooms,txt_searchRoom.getText().toString());
				}    			
			}
		});
		
		
		
//Διαχειρη του αναδυομενου μενου
		table_rooms.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getButton()==MouseEvent.BUTTON3)
					pop.show(arg0.getComponent(), arg0.getX(), arg0.getY());
			}
		});
		panelDBreception.setBounds(0, 36, 1200, 670);
		getContentPane().add(panelDBreception);
		panelDBreception.setLayout(null);
		
	    
//Πανελ Β/Δ  Reception
	    
	    //Δηλωση μεταβλητών
	    txt_search_recep = new JTextField();
	    txt_search_recep.setHorizontalAlignment(SwingConstants.CENTER);
	    txt_search_recep.setOpaque(false);
	    txt_search_recep.setFont(new Font("Times New Roman", Font.PLAIN, 24));
	    txt_search_recep.setBorder(null);
	    txt_search_recep.setBounds(325, 549, 552, 35);
	    txt_search_recep.setColumns(10);
	    panelDBreception.add(txt_search_recep);
	    
	    
	    scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(20, 63, 1160, 411);
	    panelDBreception.add(scrollPane_1);
	    
	    table_Reception = new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    table_Reception.setModel(new DefaultTableModel(
	    		new Object[][] {
	    		},
	    		new String[] {
	    				"ΟΝΟΜΑ", "ΕΠΩΝΥΜΟ", "ΗΜΕΡ/ΝΙΑ ΓΕΝΝΗΣΗΣ", "ΦΥΛΟ", "ΔΙΕΥΘΥΝΣΗ", "ΠΟΛΗ", "ΤΗΛΕΦΩΝΟ", "Α.Μ.Κ.Α","Α.Δ.Τ.","Α.Φ.Μ.","Username","Password"
	    		}
	    	) {
	    		Class[] columnTypes = new Class[] {
	    			String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,Object.class
	    		};
	    		public Class getColumnClass(int columnIndex) {
	    			return columnTypes[columnIndex];
	    		}
	    	});
	    
	    
	    table_Reception.getColumnModel().getColumn(0).setPreferredWidth(120);
	    table_Reception.getColumnModel().getColumn(1).setPreferredWidth(120);
	    table_Reception.getColumnModel().getColumn(2).setPreferredWidth(150);
	    table_Reception.getColumnModel().getColumn(3).setPreferredWidth(90);
	    table_Reception.getColumnModel().getColumn(4).setPreferredWidth(150);
	    table_Reception.getColumnModel().getColumn(5).setPreferredWidth(100);
	    table_Reception.getColumnModel().getColumn(6).setPreferredWidth(100);
	    table_Reception.getColumnModel().getColumn(7).setPreferredWidth(90);
	    table_Reception.getColumnModel().getColumn(8).setPreferredWidth(90);
	    table_Reception.getColumnModel().getColumn(9).setPreferredWidth(80);
	    table_Reception.getColumnModel().getColumn(10).setPreferredWidth(120);
	    table_Reception.getColumnModel().getColumn(11).setPreferredWidth(120);
	    table_Reception.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    
	    
	    table_Reception.setBackground(new Color(217, 217, 217));
	    table_Reception.setOpaque(false);
	    table_Reception.setOpaque(false);
	    table_Reception.setBorder(null);
	    table_Reception.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    scrollPane_1.setViewportView(table_Reception);
	    
	    label_3 = new JLabel("");
	    label_3.setIcon(new ImageIcon(Admin.class.getResource("/adminpanels/Database.png")));
	    label_3.setBounds(0, 0, 1200, 670);
	    panelDBreception.add(label_3);
	    
	    
	    
//Αναζητηση γραμματεα
	    txt_search_recep.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		if (txt_search_recep.getText().equals(""))
	    			driver.Print_Employees(table_Reception);
	    		else{
	    			driver.Print_Emplyees_like(table_Reception,txt_search_recep.getText().toString());
	    		}
	    			
	    	}
	    });
	    //Διαχειρη του αναδυομενου μενου
	    table_Reception.addMouseListener(new MouseAdapter(){
	    @Override
	    public void mouseClicked(MouseEvent arg0) {
	    	if(arg0.getButton()==MouseEvent.BUTTON3)
	    	   	pop.show(arg0.getComponent(), arg0.getX(), arg0.getY());
	    	}
	    }); 
		
		panelTabs = new JPanel();
		panelTabs.setBounds(0, 0, 1200, 36);
		getContentPane().add(panelTabs);
		panelTabs.setLayout(null);
		
//===================================
		
		
		
		
		getContentPane().setLayout(null);
		
//Πανελ Tabs
		
		
		tab_recep = new JButton("");
		tab_recep.setBorder(null);
		tab_recep.setActionCommand("tab1");
		tab_recep.setContentAreaFilled(false);
		tab_recep.setBorderPainted(false);
		tab_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab1_clicked.png")));
		tab_recep.setBounds(0, 0, 182, 36);
		panelTabs.add(tab_recep);
		
		
		
		tab_room = new JButton("");
		tab_room.setActionCommand("tab2");
		tab_room.setBorder(null);
		tab_room.setContentAreaFilled(false);
		tab_room.setBorderPainted(false);
		tab_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab2_normal.png")));
		tab_room.setBounds(183, 0, 182, 36);
		panelTabs.add(tab_room);
		
		tab_db_recep = new JButton("");
		tab_db_recep.setActionCommand("tab3");
		tab_db_recep.setBorder(null);
		tab_db_recep.setContentAreaFilled(false);
		tab_db_recep.setBorderPainted(false);
		tab_db_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab3_normal.png")));
		tab_db_recep.setBounds(365, 0, 182, 36);
		panelTabs.add(tab_db_recep);
		
		tab_db_room = new JButton("");
		tab_db_room.setActionCommand("tab4");
		tab_db_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab4_normal.png")));
		tab_db_room.setContentAreaFilled(false);
		tab_db_room.setBorderPainted(false);
		tab_db_room.setBorder(null);
		tab_db_room.setBounds(546, 0, 182, 36);
		panelTabs.add(tab_db_room);
		
		tab_timi = new JButton("");
		tab_timi.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab5_normal.png")));
		tab_timi.setActionCommand("tab5");
		tab_timi.setContentAreaFilled(false);
		tab_timi.setBorderPainted(false);
		tab_timi.setBorder(null);
		tab_timi.setBounds(728, 0, 182, 36);
		panelTabs.add(tab_timi);
		
		btn_back = new JButton("");
		btn_back.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/back_normal.png")));
		btn_back.setContentAreaFilled(false);
		btn_back.setBorderPainted(false);
		btn_back.setBorder(null);
		btn_back.setBounds(1117, 0, 62, 32);
		panelTabs.add(btn_back);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/gramatia/kky.png")));
		label_1.setBounds(0, 0, 1200, 36);
		panelTabs.add(label_1);
		
		
//Διαχειρηση Tabs
		
		//tab1
		buttons.add(tab_recep);
		tab_recep.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_recep,panelReception);  	
	        }
	    });		
		
		
		tab_recep.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab1_hoverd.png")));
           
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_recep))
            		tab_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab1_normal.png")));
            	else{
            		tab_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab1_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab1_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_recep))
					tab_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab1_clicked.png")));
            	
			}
        });
		
		
		
		//tab2
		tab_room.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_room,panelDomatia);  	
	        	txt_id.setText(driver.Get_max_room_number());
	        }
	    });		
		
		
		tab_room.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab2_hoverd.png")));
           
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_room))
            		tab_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab2_normal.png")));
            	else{
            		tab_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab2_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab2_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_room))
					tab_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab2_clicked.png")));
            	
			}
        });
		
		//tab3
		tab_db_recep.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_db_recep,panelDBreception); 
	        	Refresh_Data(table_Reception);
	        }
	    });		
		
		
		tab_db_recep.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_db_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab3_hoverd.png")));
            	
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_db_recep))
            		tab_db_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab3_normal.png")));
            	else{
            		tab_db_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab3_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_db_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab3_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_db_recep))
					tab_db_recep.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab3_clicked.png")));
            	
			}
        });
		
		
		//tab4
		tab_db_room.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_db_room,panelDBdomatia); 
	        	driver.Print_Rooms(table_rooms);
	        }
	    });		
		
		
		tab_db_room.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_db_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab4_hoverd.png")));
           
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_db_room))
            		tab_db_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab4_normal.png")));
            	else{
            		tab_db_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab4_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_db_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab4_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_db_room))
					tab_db_room.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab4_clicked.png")));
            	
			}
        });
		
		
		//tab5
		
		
		
		
		tab_timi.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_timi,panelTimi); 
	        }
	    });		
		
		
		tab_timi.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_timi.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab5_hoverd.png")));
            	LoadTimiData();
           
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_timi))
            		tab_timi.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab5_normal.png")));
            	else{
            		tab_timi.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab5_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_timi.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab5_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_timi))
					tab_timi.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/tab5_clicked.png")));
            	
			}
        });
		
		
		
		//Tab back
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_back.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/back_pressed.png")));
				dispose();
				new Main_Frame();
			}
		});
		btn_back.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	btn_back.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/back_hoverd.png")));
           
            }
           public void mouseExited(MouseEvent evt) {
        	   btn_back.setIcon(new ImageIcon(Admin.class.getResource("/adminTabs/back_normal.png")));
            }
        });
		
		
		
		
//Διαχειρηση των επιλογων του αναδυομενου μενου
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(buttons.get(0).getActionCommand().equals("tab4")){
					int column = 0;
					int row = table_rooms.getSelectedRow();
					if(row>=0){
						String value = table_rooms.getModel().getValueAt(row, column).toString();
						String[] options = new String[2];
						options[0] = new String("ΝΑΙ");
						options[1] = new String("ΟΧΙ");
						int n = JOptionPane.showOptionDialog(getContentPane(),"Θέλετε σιγουρα να διαγράψετε το Δωμάτιο << "+table_rooms.getModel().getValueAt(row, column).toString()+" >> ;"
								,"ΠΡΟΣΟΧΗ!", 0,JOptionPane.WARNING_MESSAGE,null,options,null);
						if( n == JOptionPane.YES_OPTION){
							driver.Delete_Room(value);						
							driver.Print_Rooms(table_rooms);
						}				
					}
				}
				else{
					int column = 8;
					int row = table_Reception.getSelectedRow();
					if(row>=0){
						String value = table_Reception.getModel().getValueAt(row, column).toString();
						String[] options = new String[2];
						options[0] = new String("ΝΑΙ");
						options[1] = new String("ΟΧΙ");
						int n = JOptionPane.showOptionDialog(getContentPane(),"Θέλετε σιγουρα να διαγράψετε τον "+table_Reception.getModel().getValueAt(row, column).toString()+" "+table_Reception.getModel().getValueAt(row, 1).toString()+" ;"
								,"ΠΡΟΣΟΧΗ!", 0,JOptionPane.WARNING_MESSAGE,null,options,null);
						if( n == JOptionPane.YES_OPTION){
							driver.Delete_Employee(value);
							
							driver.Print_Employees(table_Reception);
						}				
					}
				}
			}			
		});
		
		
		
		
		update.addActionListener(new ActionListener(){			
			@Override
				public void actionPerformed(ActionEvent arg0) {
				String onoma ;
				String epitheto;
				String genisi;
				String filo;
				String odos;
				String poli;
				if(buttons.get(0).getActionCommand().equals("tab3")){
					int row = table_Reception.getSelectedRow();
					if(row>=0){
						onoma = table_Reception.getModel().getValueAt(row, 0).toString();
						epitheto = table_Reception.getModel().getValueAt(row, 1).toString();
						genisi = table_Reception.getModel().getValueAt(row, 2).toString();
						filo = table_Reception.getModel().getValueAt(row, 3).toString();
						odos = table_Reception.getModel().getValueAt(row, 4).toString();
						poli = table_Reception.getModel().getValueAt(row, 5).toString();
						String til = table_Reception.getModel().getValueAt(row, 6).toString();
						String amka = table_Reception.getModel().getValueAt(row, 7).toString();
						String adt = table_Reception.getModel().getValueAt(row, 8).toString();
						String afm = table_Reception.getModel().getValueAt(row, 9).toString();
						String username = table_Reception.getModel().getValueAt(row, 10).toString();
						String password = table_Reception.getModel().getValueAt(row, 11).toString();
						UpdateReception up = new UpdateReception(onoma, epitheto, genisi,  filo,  odos,  poli,  til,  amka
							,  adt,  afm,  username, password,table_Reception);
					}
				}
				else{
					int row = table_rooms.getSelectedRow();
					onoma = table_rooms.getModel().getValueAt(row, 0).toString();
					epitheto = table_rooms.getModel().getValueAt(row, 1).toString();
					genisi = table_rooms.getModel().getValueAt(row, 2).toString();
					filo = table_rooms.getModel().getValueAt(row, 3).toString();
					odos = table_rooms.getModel().getValueAt(row, 4).toString();
					poli = table_rooms.getModel().getValueAt(row, 5).toString();
					String timi = table_rooms.getModel().getValueAt(row, 6).toString();
					UpdateRoom up = new UpdateRoom(onoma, epitheto, genisi,  filo,  odos,  poli,timi, table_rooms);	
				}
			}		
		});
		
		
		
		
		
		
		
		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setBounds((screenWidth-1200)/2,(screenHeight-734-33)/2, 1200, 734);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// Η συνάρτηση αυτή είναι υπεύθυνη για την εναλλαγή των καρτελών και την ανανέωση των εικονιδίων των Tabs
	public void ResetButtons_AndPanels(JButton button,JPanel panel){
		String icon = "/adminTabs/"+buttons.get(0).getActionCommand()+"_normal.png";
		buttons.get(0).setIcon(new ImageIcon(Admin.class.getResource(icon)));
		panels.get(0).setVisible(false);
		panel.setVisible(true);
		buttons.remove(0);
		buttons.add(button);
		panels.remove(0);
		panels.add(panel);
	}
	// Η συναρτηση αυτη ειναι υπευθυνη για την ανανεψση του πινακα των Υπαλληλων
	public void Refresh_Data(JTable table){
		driver.Print_Employees(table);
	}
	//Συναρτη ελεγχου πεδιων
	public boolean CheckFields(ArrayList<JTextField> ar){
		int i=0;
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
	
	public boolean CheckFields_Rooms(ArrayList<JComboBox> ar){
		int i=0;
		while (i<ar.size()){			
			if((ar.get(i).getSelectedItem().toString()).equals("")  ){
				JOptionPane.showMessageDialog(null,"Υπάρχουν κενά πεδία.","Προσοχή!",JOptionPane.WARNING_MESSAGE);
				return false;
			}				
			i++;
		};
		if ((Integer)spinner_klines.getValue()<1){
			JOptionPane.showMessageDialog(null,"Αρνητικός αριθμός κλινών","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean CheckSpinners(ArrayList<JSpinner> ar){
		int i=0;
		while (i<ar.size()){
			if((Integer)ar.get(i).getValue() < 0 ){
				JOptionPane.showMessageDialog(null,"Υπάρχουν αρνητικά πεδία.","Προσοχή!",JOptionPane.WARNING_MESSAGE);
				return false;
			}				
			i++;
		};
		return true;		
	}
	
	public boolean CleanSpinners(ArrayList<JSpinner> ar){
		int i=0;
		while (i<ar.size()){
			ar.get(i).setValue(0);			
			i++;
		};
		return true;		
	}
	
	//Η συναρτηση αυτην φορτονει τις τιμες κατα την εκκινηση του Frame
	public void LoadTimiData(){
		ArrayList<String> list = new ArrayList<>();
		driver.GetTimi(list);
		sp_ac.setValue(Integer.parseInt(list.get(0)));
		sp_pool.setValue(Integer.parseInt(list.get(1)));
		sp_wifi.setValue(Integer.parseInt(list.get(2)));
		sp_proino.setValue(Integer.parseInt(list.get(3)));
		sp_imidiatrofi.setValue(Integer.parseInt(list.get(4)));
		sp_plirisDiatrofi.setValue(Integer.parseInt(list.get(5)));
		sp_parking.setValue(Integer.parseInt(list.get(6)));
		sp_kanoniko.setValue(Integer.parseInt(list.get(7)));
		sp_oikogeniako.setValue(Integer.parseInt(list.get(8)));
		sp_klinas.setValue(Integer.parseInt(list.get(9)));
		sp_fpa.setValue(Integer.parseInt(list.get(10)));

	}
	
	public int LoadTimi(){
		return driver.UpdateTimi(sp_ac.getValue()+"", sp_pool.getValue()+"", sp_wifi.getValue()+"",
				sp_proino.getValue()+"", sp_imidiatrofi.getValue()+"",sp_plirisDiatrofi.getValue()+"", 
				sp_parking.getValue()+"", sp_kanoniko.getValue()+"", sp_oikogeniako.getValue()+"", sp_klinas.getValue()+"",sp_fpa.getValue()+"");
	}
	
	//Η συναρτηση αυτη υπολογιζει και καταχωρει την τιμη του εκαστοτε δωματιου
	public void SetTimi(){
		int i = driver.SetRoomPrice(cBox_klimatismos.getSelectedItem().toString(),cBox_pisina.getSelectedItem().toString(), 
				cBox_wifi.getSelectedItem().toString(), spinner_klines.getValue().toString(), cbox_tipos.getSelectedItem().toString());
		if(i>0){
			txt_room_timi.setText(i+"");
		}
		else{
			JOptionPane.showMessageDialog(null,"Σφάλμα!","Προσοχή!",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	//Η συναρτηση αυτη ανανεωνει τις τιμες των δωματιων
	public boolean Refresh_Times(){
		int i = driver.NumOfRooms();
		int price=0;
		String p[][] = new String[i][7];
		driver.Print_Rooms_For_Update(p);
		for(int j=0; j<i; j++){
			price = driver.SetRoomPrice(p[j][3],p[j][4],p[j][5],p[j][2],p[j][1]);		
			if(driver.SetRoomPricee(price, p[j][0])==-1){
				System.out.println("Error");
				return false;
			}
		}
		return true;
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