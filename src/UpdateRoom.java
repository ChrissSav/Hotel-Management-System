import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class UpdateRoom  extends JFrame{
	
	private JLabel label;
	private JSpinner spinner_klines;
	private JTextField txt_id;
	private JTextField txt_room_timi;
	private ArrayList<JComboBox> list = new ArrayList<>();
	private JComboBox<String> cbox_tipos;
	private JComboBox<String> cBox_klimatismos;
	private JComboBox<String> cBox_pisina;
	private JComboBox<String> cBox_wifi;
	private JButton btn_enimeosi;
	private Driver_admin driver = new Driver_admin();
	
	
	
	public UpdateRoom(String id, String tipos, String klines, String klimatismos, String pisina, String wifi,String timi,JTable table){
		
		
		
		getContentPane().setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setOpaque(false);
		txt_id.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_id.setColumns(10);
		txt_id.setBorder(null);
		txt_id.setBounds(323, 86, 226, 29);
		getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		btn_enimeosi = new JButton("");
		btn_enimeosi.setContentAreaFilled(false);
		btn_enimeosi.setBorderPainted(false);
		btn_enimeosi.setIcon(new ImageIcon(UpdateRoom.class.getResource("/update/enimerosi_kratis_normal.png")));
		btn_enimeosi.setOpaque(false);
		btn_enimeosi.setBorder(null);
		btn_enimeosi.setBounds(517, 571, 160, 45);
		getContentPane().add(btn_enimeosi);
		
		spinner_klines = new JSpinner();
		spinner_klines.setBorder(null);
		spinner_klines.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		spinner_klines.setBounds(323, 221, 226, 29);
		getContentPane().add(spinner_klines);
		
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
		getContentPane().add(cbox_tipos);
		
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
		getContentPane().add(cBox_klimatismos);
		
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
		getContentPane().add(cBox_pisina);
		
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
		getContentPane().add(cBox_wifi);
		
		
		txt_room_timi = new JTextField();
		txt_room_timi.setText(timi);
		txt_room_timi.setEditable(false);
		txt_room_timi.setOpaque(false);
		txt_room_timi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_room_timi.setColumns(10);
		txt_room_timi.setBorder(null);
		txt_room_timi.setBounds(323, 509, 226, 29);
		getContentPane().add(txt_room_timi);
		
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(UpdateRoom.class.getResource("/update/dvmatiaEnimerosi.png")));
		label.setBounds(0, 0, 1200, 670);
		getContentPane().add(label);
		
		txt_id.setText(id);
		cbox_tipos.setSelectedItem(tipos);
		spinner_klines.setValue(Integer.parseInt(klines));
		cBox_klimatismos.setSelectedItem(klimatismos);
		cBox_pisina.setSelectedItem(pisina);
		cBox_wifi.setSelectedItem(wifi);
		list.add(cBox_klimatismos);
		list.add(cBox_pisina);
		list.add(cBox_wifi);
		list.add(cbox_tipos);
		
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
		
		
		
		
		btn_enimeosi.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int flag;
				btn_enimeosi.setIcon(new ImageIcon(UpdateRoom.class.getResource("/update/enimerosi_kratis_press.png")));
				if(CheckFields(list)){
					flag = driver.Update_Room(txt_id.getText(),cbox_tipos.getSelectedItem().toString(),spinner_klines.getValue().toString(),
							cBox_klimatismos.getSelectedItem().toString(),cBox_pisina.getSelectedItem().toString(),cBox_wifi.getSelectedItem().toString(),txt_room_timi.getText());
					if (flag > 0){
						JOptionPane.showMessageDialog(null,"Ενημερώθηκε το Δωμάτιο με επιτυχία","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
						driver.Print_Rooms(table);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Σφάλμα ενημέρωσης δωματίου!","Ενημέρωση",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
		
		btn_enimeosi.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent evt) {
            	btn_enimeosi.setIcon(new ImageIcon(UpdateRoom.class.getResource("/update/enimerosi_kratis_hoverd.png")));

            }
            public void mouseExited(MouseEvent evt) {
            	btn_enimeosi.setIcon(new ImageIcon(UpdateRoom.class.getResource("/update/enimerosi_kratis_normal.png")));
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
	
	
	public boolean CheckFields(ArrayList<JComboBox> ar){
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
	
	public void SetTimi(){
		int i = driver.SetRoomPrice(cBox_klimatismos.getSelectedItem().toString(),cBox_pisina.getSelectedItem().toString(), 
				cBox_wifi.getSelectedItem().toString(), spinner_klines.getValue().toString(), cbox_tipos.getSelectedItem().toString());
		if(i>0){
			txt_room_timi.setText(i+" €");
		}
		else{
			JOptionPane.showMessageDialog(null,"Σφάλμα!(Στον καθοριζμό τιμής","Προσοχή!",JOptionPane.WARNING_MESSAGE);
		}
	}
}
