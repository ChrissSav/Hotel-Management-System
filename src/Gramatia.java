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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class Gramatia extends JFrame {

	private JPanel panelTabs;
	private JPanel panelKratisi;
	private JPanel panel_DbKratisi;
	private JPanel panel_DbPelatis;
	private JLabel label;
	private JLabel label_1;
	private JTextField txt_KodikosPelati;
	private JTextField txt_KodKratisis;
	private JTextField txt_ImermKratisis;
	private JTextField txt_KodGramatea;
	private JTextField kostos_room;
	private JTextField kostos_parox;
	private JTextField sinolo_cost;
	private JTextField fpa;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_5;
	private JLabel label_6;
	private JCheckBox cbox_klimatismos;
	private JCheckBox cbox_wifi;
	private JCheckBox cbox_pisina;
	private JCheckBox cbox_parking;
	private JComboBox<String>  cbox_diatrofi;
	private JButton btn_Search_room;
	private JButton btn_anazitisi_pelati;
	private JTextField txt_room_num;
	private JButton tab_kratisi;
	private JButton tab_db_pelatis;
	private JButton tab_db_kratisi;
	private JButton btn_kataxorisi_krat;
	private JSpinner numOfEnil;
	private JSpinner numOfAnil;
	private ArrayList<JButton> buttons = new ArrayList<>();
	private ArrayList<JPanel> panels = new ArrayList<>();
	private JLabel label_8;
	private JLabel label_7;
	private JDateChooser afiksi = new JDateChooser();
	private JDateChooser anaxorisi = new JDateChooser();
	private JScrollPane scrollPane;
	private JTable table_pelates;
	private JButton add_pelati;
	private Driver_gramatia driver = new Driver_gramatia();
	private JTextField txt_searchPelati;
	private JPopupMenu pop ;
	private JTable table_kratisis;
	private JList<String> list;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JScrollPane scrollPane_List;
	private JComboBox<String> cbox_tipos_room;
	private JScrollPane scrollPane_1;
	private JMenuItem select = new JMenuItem(" Επιλογή ");
	private JMenuItem update = new JMenuItem(" Ενημέρωση στοιχείων ");
	private JMenuItem delete = new JMenuItem(" Διαγραφή ");
	private JButton btn_Back ;
	public Gramatia(String kwd,String kod){
		
		getContentPane().setLayout(null);
	//Δημιουργεια του αναδυομενου μενου
		pop = new JPopupMenu();
		pop.add(select);
		pop.add(update);
		pop.add(delete);		
		select.setVisible(false);
		
		

		
		
		
		
		
//Πανελ Β/Δ Πελατών
		
		panel_DbPelatis = new JPanel();
		panel_DbPelatis.setVisible(false);
		
				
				
				
				
				
		//Πανελ Β/Δ Κρατησεων
				panel_DbKratisi = new JPanel();
				panel_DbKratisi.setVisible(false);
				
				

//PanelKratisi
				panelKratisi = new JPanel();
				panels.add(panelKratisi);
				panelKratisi.setBounds(0, 34, 1200, 669);
				getContentPane().add(panelKratisi);
				panelKratisi.setLayout(null);
				
				txt_KodikosPelati = new JTextField();
				txt_KodikosPelati.setForeground(Color.BLACK);
				txt_KodikosPelati.setOpaque(false);
				txt_KodikosPelati.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				txt_KodikosPelati.setColumns(10);
				txt_KodikosPelati.setBorder(null);
				txt_KodikosPelati.setBounds(277, 412, 147, 20);
				panelKratisi.add(txt_KodikosPelati);
				
				txt_KodKratisis = new JTextField();
				txt_KodKratisis.setText(kod);
				txt_KodKratisis.setForeground(Color.BLACK);
				txt_KodKratisis.setEditable(false);
				txt_KodKratisis.setOpaque(false);
				txt_KodKratisis.setFont(new Font("Times New Roman", Font.BOLD, 17));
				txt_KodKratisis.setColumns(10);
				txt_KodKratisis.setBorder(null);
				txt_KodKratisis.setBounds(277, 74, 147, 20);
				panelKratisi.add(txt_KodKratisis);
				
				txt_ImermKratisis = new JTextField();
				txt_ImermKratisis.setForeground(Color.BLACK);
				txt_ImermKratisis.setEditable(false);
				txt_ImermKratisis.setOpaque(false);
				txt_ImermKratisis.setFont(new Font("Times New Roman", Font.BOLD, 16));
				txt_ImermKratisis.setColumns(10);
				txt_ImermKratisis.setBorder(null);
				txt_ImermKratisis.setBounds(277, 116, 147, 20);
				clock(txt_ImermKratisis);
				panelKratisi.add(txt_ImermKratisis);
				
				txt_KodGramatea = new JTextField();
				txt_KodGramatea.setText(kwd);
				txt_KodGramatea.setForeground(Color.BLACK);
				txt_KodGramatea.setEditable(false);
				txt_KodGramatea.setOpaque(false);
				txt_KodGramatea.setFont(new Font("Times New Roman", Font.BOLD, 18));
				txt_KodGramatea.setColumns(10);
				txt_KodGramatea.setBorder(null);
				txt_KodGramatea.setBounds(783, 74, 152, 20);
				panelKratisi.add(txt_KodGramatea);
				
				kostos_room = new JTextField();
				kostos_room.setHorizontalAlignment(SwingConstants.RIGHT);
				kostos_room.setEditable(false);
				kostos_room.setForeground(Color.BLACK);
				kostos_room.setOpaque(false);
				kostos_room.setFont(new Font("Times New Roman", Font.BOLD, 18));
				kostos_room.setColumns(10);
				kostos_room.setBorder(null);
				kostos_room.setBounds(277, 508, 147, 20);
				panelKratisi.add(kostos_room);
				
				kostos_parox = new JTextField();
				kostos_parox.setHorizontalAlignment(SwingConstants.RIGHT);
				kostos_parox.setForeground(Color.BLACK);
				kostos_parox.setEditable(false);
				kostos_parox.setOpaque(false);
				kostos_parox.setFont(new Font("Times New Roman", Font.BOLD, 18));
				kostos_parox.setColumns(10);
				kostos_parox.setBorder(null);
				kostos_parox.setBounds(274, 559, 150, 20);
				panelKratisi.add(kostos_parox);
				
				sinolo_cost = new JTextField();
				sinolo_cost.setHorizontalAlignment(SwingConstants.RIGHT);
				sinolo_cost.setForeground(Color.BLACK);
				sinolo_cost.setEditable(false);
				sinolo_cost.setOpaque(false);
				sinolo_cost.setFont(new Font("Times New Roman", Font.BOLD, 18));
				sinolo_cost.setColumns(10);
				sinolo_cost.setBorder(null);
				sinolo_cost.setBounds(783, 559, 152, 20);
				panelKratisi.add(sinolo_cost);
				
				fpa = new JTextField();
				fpa.setHorizontalAlignment(SwingConstants.RIGHT);
				fpa.setForeground(Color.BLACK);
				fpa.setEditable(false);
				fpa.setOpaque(false);
				fpa.setFont(new Font("Times New Roman", Font.BOLD, 18));
				fpa.setColumns(10);
				fpa.setBorder(null);
				fpa.setBounds(783, 508, 152, 20);
				panelKratisi.add(fpa);
				
				cbox_klimatismos = new JCheckBox("\u039A\u03BB\u03B9\u03BC\u03B1\u03C4\u03B9\u03C3\u03BC\u03CC\u03C2");
				cbox_klimatismos.setBackground(new Color(248, 248, 248));
				cbox_klimatismos.setForeground(new Color(129, 189, 223));
				cbox_klimatismos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				cbox_klimatismos.setBounds(604, 249, 136, 23);
				panelKratisi.add(cbox_klimatismos);
				
				cbox_wifi = new JCheckBox("\u03A0\u03B1\u03C1\u03BF\u03C7\u03AE WiFi");
				cbox_wifi.setForeground(new Color(129, 189, 223));
				cbox_wifi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				cbox_wifi.setBackground(new Color(248, 248, 248));
				cbox_wifi.setBounds(772, 249, 134, 23);
				panelKratisi.add(cbox_wifi);
				
				cbox_pisina = new JCheckBox("\u03A0\u03B9\u03C3\u03AF\u03BD\u03B1");
				cbox_pisina.setForeground(new Color(129, 189, 223));
				cbox_pisina.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				cbox_pisina.setBackground(new Color(248, 248, 248));
				cbox_pisina.setBounds(604, 298, 136, 23);
				panelKratisi.add(cbox_pisina);
				
				cbox_parking = new JCheckBox("\u0398\u03AD\u03C3\u03B7 \u03C3\u03C4\u03AC\u03B8\u03BC\u03B5\u03C5\u03C3\u03B7\u03C2");
				
				cbox_parking.setForeground(new Color(129, 189, 223));
				cbox_parking.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				cbox_parking.setBackground(new Color(248, 248, 248));
				cbox_parking.setBounds(772, 298, 182, 23);
				panelKratisi.add(cbox_parking);
				
				cbox_diatrofi = new JComboBox<String>();
				
				cbox_diatrofi.setForeground(Color.BLACK);
				cbox_diatrofi.addItem("");
				cbox_diatrofi.addItem("Χωρίς διατροφή");	
				cbox_diatrofi.addItem("Μόνο πρωινό");	
				cbox_diatrofi.addItem("Ημιδιατροφή");
				cbox_diatrofi.addItem("Πλήρης διατροφή");	
				cbox_diatrofi.setBackground(new Color(248, 248, 248));
				cbox_diatrofi.setUI(new BasicComboBoxUI());
				cbox_diatrofi.setFocusable(false);
				cbox_diatrofi.setFocusTraversalKeysEnabled(false);
				cbox_diatrofi.setBorder(null);
				cbox_diatrofi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				cbox_diatrofi.setBounds(783, 196, 152, 20);
				panelKratisi.add(cbox_diatrofi);
				
				txt_room_num = new JTextField();
				txt_room_num.setHorizontalAlignment(SwingConstants.CENTER);
				txt_room_num.setForeground(Color.BLACK);
				txt_room_num.setEditable(false);
				txt_room_num.setOpaque(false);
				txt_room_num.setFont(new Font("Times New Roman", Font.BOLD, 22));
				txt_room_num.setColumns(10);
				txt_room_num.setBorder(null);
				txt_room_num.setBounds(783, 416, 152, 20);
				panelKratisi.add(txt_room_num);
				
				numOfEnil = new JSpinner();
				
				numOfEnil.setBackground(new Color(248, 248, 248));
				numOfEnil.setBorder(null);
				numOfEnil.setForeground(new Color(178, 177, 177));
				numOfEnil.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				numOfEnil.setBounds(274, 298, 150, 23);
				panelKratisi.add(numOfEnil);
				
				numOfAnil = new JSpinner();
				numOfAnil.setForeground(new Color(178, 177, 177));
				numOfAnil.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				numOfAnil.setBorder(null);
				numOfAnil.setBackground(new Color(248, 248, 248));
				numOfAnil.setBounds(277, 356, 147, 23);
				panelKratisi.add(numOfAnil);
				
				cbox_tipos_room = new JComboBox<String>();
				cbox_tipos_room.setForeground(Color.BLACK);
				cbox_tipos_room.addItem("");
				cbox_tipos_room.addItem("Μονόκλινο");
				cbox_tipos_room.addItem("Δίκλινο");
				cbox_tipos_room.addItem("Τρίκλινο");
				cbox_tipos_room.addItem("Οικογενειακό");	
				cbox_tipos_room.setBackground(new Color(248, 248, 248));
				cbox_tipos_room.setUI(new BasicComboBoxUI());
				cbox_tipos_room.setFocusable(false);
				cbox_tipos_room.setFocusTraversalKeysEnabled(false);
				cbox_tipos_room.setBorder(null);
				cbox_tipos_room.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				cbox_tipos_room.setBounds(783, 359, 152, 20);
				panelKratisi.add(cbox_tipos_room);
				
	
				
				afiksi.getCalendarButton().setBorder(null);
				afiksi.setForeground(new Color(178, 177, 177));
				afiksi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				afiksi.setBounds(274, 196, 150, 20);
				panelKratisi.add(afiksi);
				
				
				
				anaxorisi.getCalendarButton().setBorder(null);
				anaxorisi.setBorder(null);
				anaxorisi.setBackground(new Color(51,51,51));
				anaxorisi.setForeground(new Color(178, 177, 177));
				anaxorisi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				anaxorisi.setBounds(274, 249, 150, 20);
				panelKratisi.add(anaxorisi);
				
				scrollPane_List = new JScrollPane();
				scrollPane_List.setBounds(1006, 180, 134, 238);
				panelKratisi.add(scrollPane_List);
				
				list = new JList<>(model);
				scrollPane_List.setViewportView(list);
				scrollPane_List.setVisible(false);
				list.setFont(new Font("Times New Roman", Font.BOLD, 20));
				
				btn_kataxorisi_krat = new JButton("");
				btn_kataxorisi_krat.setBorder(null);
				btn_kataxorisi_krat.setActionCommand("tab1");
				btn_kataxorisi_krat.setContentAreaFilled(false);
				btn_kataxorisi_krat.setBorderPainted(false);
				btn_kataxorisi_krat.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
				btn_kataxorisi_krat.setBounds(520, 613, 160, 45);
				panelKratisi.add(btn_kataxorisi_krat);
				
						
						add_pelati = new JButton("");
						add_pelati.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/Add-group-icon.png")));
						add_pelati.setBorder(null);
						add_pelati.setBounds(465, 412, 24, 24);
						panelKratisi.add(add_pelati);
						
						btn_anazitisi_pelati = new JButton("");
						btn_anazitisi_pelati.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/ghtyjty.png")));
						btn_anazitisi_pelati.setBounds(434, 412, 24, 24);
						panelKratisi.add(btn_anazitisi_pelati);
						
						btn_Search_room = new JButton("");	
						btn_Search_room.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/ghtyjty.png")));
						btn_Search_room.setBounds(941, 412, 24, 24);
						panelKratisi.add(btn_Search_room);
						
						label_3 = new JLabel("\u20AC");
						label_3.setForeground(Color.BLACK);
						label_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
						label_3.setBounds(434, 559, 23, 20);
						panelKratisi.add(label_3);
						
						label_5 = new JLabel("\u20AC");
						label_5.setForeground(Color.BLACK);
						label_5.setFont(new Font("Times New Roman", Font.BOLD, 23));
						label_5.setBounds(942, 508, 23, 20);
						panelKratisi.add(label_5);
						
						label_6 = new JLabel("\u20AC");
						label_6.setForeground(Color.BLACK);
						label_6.setFont(new Font("Times New Roman", Font.BOLD, 23));
						label_6.setBounds(942, 559, 23, 20);
						panelKratisi.add(label_6);
						
						label_2 = new JLabel("\u20AC");
						label_2.setForeground(Color.BLACK);
						label_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
						label_2.setBounds(434, 508, 23, 20);
						panelKratisi.add(label_2);
						
						label_1 = new JLabel("");
						label_1.setBounds(0, 0, 1200, 670);
						label_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
						label_1.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/f.png")));
						panelKratisi.add(label_1);
						
						btn_kataxorisi_krat.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								btn_kataxorisi_krat.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kataxorsii_kratis_press.png")));
								if(	CheckAfiski() && CheckAnaxori() && CheckSpinners() && CheckFields())
									Add();
							}
							
						});
						
						btn_kataxorisi_krat.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
								btn_kataxorisi_krat.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kataxorsii_kratis_hoverd.png")));

            }
            public void mouseExited(MouseEvent evt) {
								btn_kataxorisi_krat.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kataxorsii_kratis_normal.png")));
            }

        });
						
						
						
						add_pelati.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								Pelatis p = new Pelatis(txt_KodikosPelati);
							}
						});
						
						

						btn_anazitisi_pelati.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								tab_db_pelatis.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab2_clicked.png")));
								ResetButtons_AndPanels(tab_db_pelatis,panel_DbPelatis);	
								driver.Print_Pelates(table_pelates);
								select.setVisible(true);
							}
						});
						
						
						btn_Search_room.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								scrollPane_List.setVisible(true);
								String kli ="ΟΧΙ";
								String pisina ="ΟΧΙ";
								String wifi ="ΟΧΙ";
								String klina = "0";
								String tipos = "Τυπικό";
								if( cbox_klimatismos.isSelected())
									kli ="ΝΑΙ";
								if( cbox_wifi.isSelected())
									wifi ="ΝΑΙ";
								if( cbox_pisina.isSelected())
									pisina ="ΝΑΙ";
								if( cbox_tipos_room.getSelectedItem().equals("Μονόκλινο"))
									klina ="1";
								else if( cbox_tipos_room.getSelectedItem().equals("Δίκλινο"))
									klina ="2";
								else if( cbox_tipos_room.getSelectedItem().equals("Τρίκλινο"))
									klina ="3";
								else if( cbox_tipos_room.getSelectedItem().equals("Οικογενειακό")){
									tipos = "Οικογενειακό";
									if(!(((int)numOfEnil.getValue() - 1) ==0))
										klina = (((int)numOfEnil.getValue()-1)+(int)numOfAnil.getValue())+"";
									else
										klina = (1+(int)numOfAnil.getValue())+"";
								}				
								driver.Print_DiathesimaRooms(GetFromCalendar(afiksi), GetFromCalendar(anaxorisi),kli, wifi, pisina,model,klina,tipos);
							}
						});
						
						
							
						afiksi.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
							@Override
							 public void propertyChange(PropertyChangeEvent e) {
							     if ("date".equals(e.getPropertyName())) {
							          CheckAfiski();
							     }
							            
							}
						});
						anaxorisi.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
							@Override
							public void propertyChange(PropertyChangeEvent e) {
								if ("date".equals(e.getPropertyName())) {
									CheckAnaxori();
								}
							}
						});
						
						
						list.addMouseListener(new MouseAdapter() {
						    public void mouseClicked(MouseEvent evt) {
						        if (evt.getClickCount() == 2) {
						        	txt_room_num.setText((list.getSelectedValue()));
						        	scrollPane_List.setVisible(false);
						        	kostos_room.setText(driver.GetRoomPrice(txt_room_num.getText()));
						        }
						    }
						});
						
						
						cbox_diatrofi.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent arg0) {
								KostosParoxwn();
							}
						});
						
						cbox_parking.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent arg0) {
								KostosParoxwn();
							}
						});
						

						kostos_room.getDocument().addDocumentListener(new DocumentListener() {
							public void changedUpdate(DocumentEvent e) {
								if (!kostos_room.getText().equals("")){
									SumKostos();
							    } 
							}
							
							public void insertUpdate(DocumentEvent e) {
								if (!kostos_room.getText().equals("")){
									SumKostos();
								} 
							}

							@Override
							public void removeUpdate(DocumentEvent e) {
								// TODO Auto-generated method stub
								
							}
							  });
						kostos_parox.getDocument().addDocumentListener(new DocumentListener() {
							@Override
							public void changedUpdate(DocumentEvent e) {
								if (!kostos_parox.getText().equals("")){
									SumKostos();
								} 
							}
							@Override
							public void insertUpdate(DocumentEvent e) {
								if (!kostos_parox.getText().equals("")){
									SumKostos();
								} 
							}

							@Override
							public void removeUpdate(DocumentEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
				panel_DbKratisi.setBounds(0, 34, 1200, 669);
				getContentPane().add(panel_DbKratisi);
				panel_DbKratisi.setLayout(null);
				
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(20, 83, 1160, 462);
				panel_DbKratisi.add(scrollPane_1);
				
				table_kratisis =  new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
				
					    table_kratisis.setBackground(new Color(217, 217, 217));
					    table_kratisis.setFont(new Font("Times New Roman", Font.PLAIN, 14));
					    scrollPane_1.setViewportView(table_kratisis);
					    table_kratisis.setModel(new DefaultTableModel(
		new Object[][] {
				},
			new String[] {
					"ΚΩΔΙΚΟΣ", "ΗΜΕΡ/ΝΙΑ", "ΚΩΔ. ΓΡΑΜΜΑΤΕΑ", "ΚΩΔ. ΠΕΛΑΤΗ", "ΑΡ. ΔΩΜΑΤΙΟΥ", "ΑΦΙΞΗ", "ΑΝΑΧΩΡΗΣΗ", "ΑΡ. ΕΝΗΛΙΚΩΝ", "ΑΡ. ΑΝΗΛΙΚΩΝ", "ΘΕΣΗ ΣΤΑΘΜΕΥΣΗΣ", "ΔΙΑΤΡΟΦΗ", "ΚΟΣΤΟΣ"
				}
					    		) {
					    	Class[] columnTypes = new Class[] {
					    			String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
					    	};
					    	public Class getColumnClass(int columnIndex) {
					    		return columnTypes[columnIndex];
					    	}
					    });
					    
					    table_kratisis.getColumnModel().getColumn(0).setPreferredWidth(150);
					    table_kratisis.getColumnModel().getColumn(1).setPreferredWidth(150);
					    table_kratisis.getColumnModel().getColumn(2).setPreferredWidth(120);
					    table_kratisis.getColumnModel().getColumn(3).setPreferredWidth(120);
					    table_kratisis.getColumnModel().getColumn(4).setPreferredWidth(100);
					    table_kratisis.getColumnModel().getColumn(5).setPreferredWidth(100);
					    table_kratisis.getColumnModel().getColumn(6).setPreferredWidth(100);
					    table_kratisis.getColumnModel().getColumn(7).setPreferredWidth(90);
					    table_kratisis.getColumnModel().getColumn(8).setPreferredWidth(90);
					    table_kratisis.getColumnModel().getColumn(9).setPreferredWidth(127);
					    table_kratisis.getColumnModel().getColumn(10).setPreferredWidth(115);
					    table_kratisis.getColumnModel().getColumn(11).setPreferredWidth(80);
					    table_kratisis.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					    
			    label_8 = new JLabel("");
			    label_8.setIcon(new ImageIcon(Gramatia.class.getResource("/dbKratisi/databasekratisis.png")));
			    label_8.setBounds(0, 0, 1200, 670);
			    panel_DbKratisi.add(label_8);
		panel_DbPelatis.setBounds(0, 34, 1200, 669);
		getContentPane().add(panel_DbPelatis);
		panel_DbPelatis.setLayout(null);
		
		txt_searchPelati = new JTextField();
		txt_searchPelati.setOpaque(false);
		txt_searchPelati.setHorizontalAlignment(SwingConstants.CENTER);
		txt_searchPelati.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txt_searchPelati.setColumns(10);
		txt_searchPelati.setBorder(null);
		txt_searchPelati.setBounds(324, 549, 552, 35);
		panel_DbPelatis.add(txt_searchPelati);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 83, 1160, 402);
		panel_DbPelatis.add(scrollPane);
		table_pelates = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
		};
		table_pelates.setBackground(new Color(217, 217, 217));
		table_pelates.setBorder(null);
		table_pelates.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(table_pelates);
		table_pelates.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ΟΝΟΜΑ", "ΕΠΩΝΥΜΟ", "ΗΜΕΡ/ΝΙΑ ΓΕΝΝΗΣΗΣ", "ΦΥΛΟ", "ΔΙΕΥΘΥΝΣΗ", "ΠΟΛΗ", "ΤΗΛΕΦΩΝΟ", "Α.Φ.Μ.", "Α.Δ.Τ./ΔΙΑΒΑΤΗΡΙΟ"			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		/*table_pelates.getColumnModel().getColumn(0).setPreferredWidth(120);
		table_pelates.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_pelates.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_pelates.getColumnModel().getColumn(3).setPreferredWidth(70);
		table_pelates.getColumnModel().getColumn(4).setPreferredWidth(150);
		table_pelates.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_pelates.getColumnModel().getColumn(6).setPreferredWidth(100);
		table_pelates.getColumnModel().getColumn(7).setPreferredWidth(110);
		table_pelates.getColumnModel().getColumn(8).setPreferredWidth(122);
		table_pelates.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
		
		label_7 = new JLabel("");
		label_7.setBounds(0, 0, 1200, 670);
		label_7.setIcon(new ImageIcon(Gramatia.class.getResource("/dbPelatis/databasepelates1.png")));
		panel_DbPelatis.add(label_7);
		
		
		//Αναζητηση πελατη
		txt_searchPelati.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		if (txt_searchPelati.getText().equals(""))
	    			driver.Print_Pelates(table_pelates);
	    		else{
	    			driver.Print_Pelates_like(table_pelates,txt_searchPelati.getText().toString());
	    		}
	    			
	    	}
	    });
		
		//Προβολη αναδυομενου μενου		
		table_pelates.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		if(arg0.getButton()==MouseEvent.BUTTON3){
	    			update.setVisible(true);
	    			pop.show(arg0.getComponent(), arg0.getX(), arg0.getY());
	    		}
	    	}
	    });
		
		
//Πανελ Tabs		
		
		panelTabs = new JPanel();
		panelTabs.setBounds(0, 0, 1200, 34);
		getContentPane().add(panelTabs);
		panelTabs.setLayout(null);
		
		tab_kratisi = new JButton("");
		tab_kratisi.setBorder(null);
		tab_kratisi.setActionCommand("tab1");
		tab_kratisi.setContentAreaFilled(false);
		tab_kratisi.setBorderPainted(false);
		tab_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab1_clicked.png")));
		tab_kratisi.setBounds(0, 0, 182, 36);
		panelTabs.add(tab_kratisi);
		
		tab_db_pelatis = new JButton("");
		tab_db_pelatis.setActionCommand("tab2");
		tab_db_pelatis.setBorder(null);
		tab_db_pelatis.setContentAreaFilled(false);
		tab_db_pelatis.setBorderPainted(false);
		tab_db_pelatis.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab2_normal.png")));
		tab_db_pelatis.setBounds(183, 0, 182, 36);
		panelTabs.add(tab_db_pelatis);
		
		tab_db_kratisi = new JButton("");
		tab_db_kratisi.setActionCommand("tab3");
		tab_db_kratisi.setBorder(null);
		tab_db_kratisi.setContentAreaFilled(false);
		tab_db_kratisi.setBorderPainted(false);
		tab_db_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab3_normal.png")));
		tab_db_kratisi.setBounds(365, 0, 180, 36);
		panelTabs.add(tab_db_kratisi);
		
		btn_Back = new JButton("");
		btn_Back.setBorder(null);
		btn_Back.setContentAreaFilled(false);
		btn_Back.setBorderPainted(false);
		btn_Back.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/back_normal.png")));
		btn_Back.setBorder(null);
		btn_Back.setBounds(1117, 0, 62, 32);
		panelTabs.add(btn_Back);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatia/kky.png")));
		label.setBounds(0, 0, 1200, 40);
		panelTabs.add(label);

		
		
//Διαχειρηση των tabs
		
		//Tab1
		buttons.add(tab_kratisi);
		tab_kratisi.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_kratisi,panelKratisi);  	
	        }
	    });		
		
		
		tab_kratisi.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab1_hoverd.png")));
           
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_kratisi))
            		tab_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab1_normal.png")));
            	else{
            		tab_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab1_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab1_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_kratisi))
					tab_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab1_clicked.png")));
            	
			}
        });
		
		//Προβολη αναδυομενου μενου		
		table_kratisis.addMouseListener(new MouseAdapter(){
		@Override
			public void mouseClicked(MouseEvent arg0) {	
				if(arg0.getButton()==MouseEvent.BUTTON3){
					update.setVisible(false);
					pop.show(arg0.getComponent(), arg0.getX(), arg0.getY());
				}
			}
		});
		
		
		
		//Tab2
		tab_db_pelatis.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_db_pelatis,panel_DbPelatis);  	
	        	driver.Print_Pelates(table_pelates);
	        }
	    });		
		
		
		tab_db_pelatis.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_db_pelatis.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab2_hoverd.png")));
           
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_db_pelatis))
            		tab_db_pelatis.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab2_normal.png")));
            	else{
            		tab_db_pelatis.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab2_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_db_pelatis.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab2_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_db_pelatis))
					tab_db_pelatis.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab2_clicked.png")));
            	
			}
        });
		
		
		
		
		//Tab3
		
		tab_db_kratisi.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	ResetButtons_AndPanels(tab_db_kratisi,panel_DbKratisi); 
	        	driver.Print_Kratisis(table_kratisis);
	        }
	    });		
		
		
		tab_db_kratisi.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	tab_db_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab3_hoverd.png")));
           
            }
            public void mouseExited(MouseEvent evt) {
            	if(!buttons.get(0).equals(tab_db_kratisi))
            		tab_db_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab3_normal.png")));
            	else{
            		tab_db_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab3_clicked.png")));
            	}
            	
            	
            }
            public void mousePressed(MouseEvent evt) {
            	tab_db_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab3_press.png")));
            	
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(buttons.get(0).equals(tab_db_kratisi))
					tab_db_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab3_clicked.png")));
            	
			}
        });
		
		//Back button
		
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Back.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/back_pressed.png")));
				dispose();
				new Main_Frame();
			}
		});
		btn_Back.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	btn_Back.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/back_hoverd.png")));
           
            }
           public void mouseExited(MouseEvent evt) {
            	btn_Back.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/back_normal.png")));
            }
        });
	//=========================
		

	//Διαειρηση pop menu	
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(buttons.get(0).getActionCommand().equals("tab2")){
					int column = 8;
					int row = table_pelates.getSelectedRow();
					if(row>=0){
						String value = table_pelates.getModel().getValueAt(row, column).toString();
						String[] options = new String[2];
						options[0] = new String("ΝΑΙ");
						options[1] = new String("ΟΧΙ");
						int n = JOptionPane.showOptionDialog(getContentPane(),"Θέλετε σιγουρα να διαγράψετε το Πελάτη '' "+table_pelates.getModel().getValueAt(row, 1).toString()+" '' με κωδικό '' "+table_pelates.getModel().getValueAt(row, 8).toString()+" '' ;"
								,"ΠΡΟΣΟΧΗ!", 0,JOptionPane.WARNING_MESSAGE,null,options,null);
						if( n == JOptionPane.YES_OPTION){
							driver.Delete_Pelati(value);						
							driver.Print_Pelates(table_pelates);
						}				
					}
				}
				else if(buttons.get(0).getActionCommand().equals("tab3")){
					int column = 0;
					int row = table_kratisis.getSelectedRow();
					if(row>=0){
						String value = table_kratisis.getModel().getValueAt(row, column).toString();
						String[] options = new String[2];
						options[0] = new String("ΝΑΙ");
						options[1] = new String("ΟΧΙ");
						int n = JOptionPane.showOptionDialog(getContentPane(),"Θέλετε σιγουρα να διαγράψετε την κράτηση με κωδικό '' "+table_kratisis.getModel().getValueAt(row, column).toString()+" '' ;"
								,"ΠΡΟΣΟΧΗ!", 0,JOptionPane.WARNING_MESSAGE,null,options,null);
						if( n == JOptionPane.YES_OPTION){
							driver.Delete_Kratisi(value);						
							driver.Print_Kratisis(table_kratisis);
						}				
					}
				}
					
			}			
		});
		
		
		
		//Διαχειρηση της Επιλογης ενος πελατη
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int column = 8;
				int row = table_pelates.getSelectedRow();
				select.setVisible(false);
        		tab_kratisi.setIcon(new ImageIcon(Gramatia.class.getResource("/gramatiaTabs/tab1_clicked.png")));
				ResetButtons_AndPanels(tab_kratisi,panelKratisi);  				
				txt_KodikosPelati.setText(table_pelates.getModel().getValueAt(row, column).toString());
				select.setVisible(false);

			}	
		});
		
		
		//Ενημερωση των στοιχειων του Πελατη
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String onoma ;
				String epitheto;
				String genisi;
				String filo;
				String odos;
				String poli;
				int row = table_pelates.getSelectedRow();
				if(row>=0){
					onoma = table_pelates.getModel().getValueAt(row, 0).toString();
					epitheto = table_pelates.getModel().getValueAt(row, 1).toString();
					genisi = table_pelates.getModel().getValueAt(row, 2).toString();
					filo = table_pelates.getModel().getValueAt(row, 3).toString();
					odos = table_pelates.getModel().getValueAt(row, 4).toString();
					poli = table_pelates.getModel().getValueAt(row, 5).toString();
					String til = table_pelates.getModel().getValueAt(row, 6).toString();
					String afm = table_pelates.getModel().getValueAt(row, 7).toString();
					String adt = table_pelates.getModel().getValueAt(row, 8).toString();
					UpdatePelati up = new UpdatePelati(onoma, epitheto, genisi,  filo,  odos,  poli,  til,  afm
							,  adt,table_pelates);
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
		String icon = "/gramatiaTabs/"+buttons.get(0).getActionCommand()+"_normal.png";
		buttons.get(0).setIcon(new ImageIcon(Gramatia.class.getResource(icon)));
		panels.get(0).setVisible(false);
		panel.setVisible(true);
		buttons.remove(0);
		buttons.add(button);
		panels.remove(0);
		panels.add(panel);
	}
	
	
	
	
	// Η συναρτήσεις ελέγχου πεδίων
	public boolean ChechSpinners(){
		if ((Integer)numOfEnil.getValue()<1){
			JOptionPane.showMessageDialog(null,"Αρνητικός αριθμός Ενηλίκων","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if ((Integer)numOfAnil.getValue()<1){
			JOptionPane.showMessageDialog(null,"Αρνητικός αριθμός Ανηλίκων","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	public boolean CheckSpinners(){
		
		if ((int)numOfEnil.getValue()<=0 || (int)numOfAnil.getValue()<0){
			JOptionPane.showMessageDialog(null,"Σφάλμα Παραθεριστών","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean CheckFields(){
		
		if (txt_KodikosPelati.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Δεν υπάρχει κωδικός Πελάτη!","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (txt_room_num.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Δεν επιλέχθηκε Δωμάτιο!","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (cbox_diatrofi.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Δεν επιλέχθηκε Διατροφή!","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(!driver.Is_in_list("pelates", "adt", txt_KodikosPelati.getText())){
			JOptionPane.showMessageDialog(null,"Δεν υπάρχει πελάτης με αυτόν των κωδικό!","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean TextFields(){
		if (cbox_diatrofi.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε Διατροφή","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (txt_room_num.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε Δωμάτιο","Προσοχή!",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	// Η συναρτηση αυτη υπολογιζει το κοστος των παροχών
	public void KostosParoxwn(){
		int diatrofi=0 ;
		if(cbox_diatrofi.getSelectedItem().equals("Μόνο πρωινό"))
			diatrofi = Integer.parseInt(driver.GetDiatrofiPrice("mono_proino"));
		if(cbox_diatrofi.getSelectedItem().equals("Ημιδιατροφή"))
			diatrofi = Integer.parseInt(driver.GetDiatrofiPrice("imidiatrofi"));
		if(cbox_diatrofi.getSelectedItem().equals("Πλήρης διατροφή"))
			diatrofi = Integer.parseInt(driver.GetDiatrofiPrice("pliris_diatrofi"));
		if(cbox_parking.isSelected())
			diatrofi += driver.GetParkingPrice();
		kostos_parox.setText(diatrofi+"");
	}
	// Η συναρτηση αυτη υπολογιζει το συνολικό κοστος
	public void SumKostos(){
		if (!kostos_room.getText().equals("") && !kostos_parox.getText().equals("")){
			sinolo_cost.setText(YpolTelikouKostosRoom()+Integer.parseInt(kostos_parox.getText())+"");
			float fpaa = Float.parseFloat(sinolo_cost.getText())*driver.GetFpa()/100;
			fpa.setText(fpaa+"");
		}
	}

	//Η συνάρτηση αυτή ελέγχει την ορθή καταχώρηση την ημερομηνίας άφιξης 
	public boolean CheckAfiski(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		if (afiksi.getDate() == null){
			JOptionPane.showMessageDialog(null,"Δεν επιλέχθηκε ημερ/νια ’φιξης!","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		String af = dateFormat.format(afiksi.getDate());
		Calendar cal = Calendar.getInstance();
		String current = dateFormat.format(cal.getTime());
		if(af.compareTo(current)<0){
			String[] options = new String[2];
			options[0] = new String("ΝΑΙ");
			options[1] = new String("ΟΧΙ");
			int n = JOptionPane.showOptionDialog(null,"Η ημερ/νια άφιξης είναι πριν την σημερινή! Θέλετε να συνεχήσετε ;"
					,"ΠΡΟΣΟΧΗ!", 0,JOptionPane.WARNING_MESSAGE,null,options,null);
			if( n == JOptionPane.YES_OPTION){
				return true;
			}
			else
				return false;
		}
		
		return true;
	}
	
	
	//Η συνάρτηση αυτή ελέγχει την ορθή καταχώρηση την ημερομηνίας αναχώρησης 
	public boolean CheckAnaxori(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		if (anaxorisi.getDate() == null){
			JOptionPane.showMessageDialog(null,"Δεν επιλέχθηκε ημερ/νια Αναχώρησης!","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		String an = dateFormat.format(anaxorisi.getDate());
		String afi = dateFormat.format(afiksi.getDate());
		if(an.compareTo(afi)<=0 ){
			JOptionPane.showMessageDialog(null,"Λάθος ημερ/νια Αναχώρησης","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	
	// Η συνάρτηση αυτη καταχωρεί την Κράτηση στην Β/Δ
	public void Add(){
		String car;
		if(cbox_parking.isSelected())
			car = "ΝΑΙ";
		else
			car = "ΟΧΙ";
		driver.ADD_Kratisi(txt_KodKratisis.getText(), txt_ImermKratisis.getText(), txt_KodGramatea.getText(), 
				txt_KodikosPelati.getText(), txt_room_num.getText(),
				GetFromCalendar(afiksi), GetFromCalendar(anaxorisi), numOfEnil.getValue().toString(), numOfAnil.getValue().toString(), 
				car, cbox_diatrofi.getSelectedItem().toString(), sinolo_cost.getText());
	}
	
	
	public String GetFromCalendar(JDateChooser calf){
		SimpleDateFormat dcn = new SimpleDateFormat("dd/MM/yyyy");
		String date = dcn.format(calf.getDate() );	
		return ToUnNormal(date);
	}
	
	
	//Οι συναρτήσεις αυτές κάνουν την απαραίτητη τροποποιήσει στην μορφή της ημερομηνίας ώστε να γίνουν σωστά οι υπολογισμοί
	public  String ToUnNormal(String d){
		char c[] = d.toCharArray(); 
		String etos = String.valueOf(new char[]{ c[6], c[7],c[8],c[9]});
		String mera = String.valueOf(new char[]{ c[0], c[1]});
		String minas = String.valueOf(new char[]{ c[3], c[4]});
		return(etos+"/"+minas+"/"+mera );
		
	}
	public  String ToNormal(String d){
		char c[] = d.toCharArray(); 
		String etos = String.valueOf(new char[]{ c[0], c[1],c[2],c[3]});
		String mera = String.valueOf(new char[]{ c[8], c[9]});
		String minas = String.valueOf(new char[]{ c[5], c[6]});
		return(mera+"/"+minas+"/"+etos );
		
	}
	
	
	
	//Η συνάρτηση αυτή υπολογίζει το κόστος του δωμάτιου σύμφωνα με τα ημέρες διαμονής 
	public int YpolTelikouKostosRoom(){
		Calendar cal1 = afiksi.getCalendar();
		Calendar cal2 = anaxorisi.getCalendar();
		int mera = cal2.get(Calendar.DAY_OF_MONTH) - cal1.get(Calendar.DAY_OF_MONTH);
		int minas = (cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH))*30;
		int etos =  (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR))*365;
		mera += minas +etos;
		if (!kostos_room.getText().equals(""))
			return Integer.parseInt(kostos_room.getText())*mera;
		else
			return 0;
	}
	
	
	public void clock(JTextField label){
		Thread clock = new Thread(){
			public void run(){
				try{
					for(;;){
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String current = dateFormat.format(cal.getTime());
						label.setText(current);
						sleep(500);
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		clock.start();
		
	}
	
}
