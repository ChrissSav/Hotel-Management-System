import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Driver_admin {
	
	private Connection myConn;
	private Statement myStm;
	private ResultSet myRes;
	
	public Driver_admin(){
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db","user","user1234");
			myStm = myConn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void ADD_Employee(String onoma, String epitheto, String genisi, String filo, String odos, String poli, String til, String amka
			, String adt, String afm, String username,String password){		
		try {
			String sql = "INSERT INTO employees (onoma,epitheto,genisi,filo,odos,poli,til,amka,adt,afm,username,password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);"  ;
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (!Is_in_list("employees","adt",adt)){
				pst.setString(1, onoma);
				pst.setString(2, epitheto);
				pst.setString(3, genisi);
				pst.setString(4, filo);
				pst.setString(5, odos);
				pst.setString(6, poli);
				pst.setString(7, til);
				pst.setString(8, amka);
				pst.setString(9, adt);
				pst.setString(10, afm);
				pst.setString(11, username);
				pst.setString(12, password);
				int  i=pst.executeUpdate();
				if(i>0)
					JOptionPane.showMessageDialog(null,"Καταχωρίθηκε ο Υπάλληλος","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"Υπάρχει ειδή Υπάλληλος με αυτά τα στοιχεία","Ενημέρωση",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public boolean Is_in_list(String table,String key_filed,String key){
		String sql = "select * from "+table+" where "+key_filed+" = '"+key+"'";
		try {
			myRes = myStm.executeQuery(sql);
			return myRes.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public void Print_Employees(JTable table){
		try {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			myRes = myStm.executeQuery("select * from employees");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[12];
			while(myRes.next()){
				row[0] =  myRes.getString("onoma");
				row[1] =  myRes.getString("epitheto");
				row[2] =  myRes.getString("genisi");
				row[3] =  myRes.getString("filo");
				row[4] =  myRes.getString("odos");
				row[5] =  myRes.getString("poli");
				row[6] =  myRes.getString("til");
				row[7] =  myRes.getString("amka");
				row[8] =  myRes.getString("adt");
				row[9] =  myRes.getString("afm");
				row[10] = myRes.getString("username");
				row[11] = myRes.getString("password");
				model.addRow(row);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void Print_Emplyees_like(JTable table,String text){
		try {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String sql = "select * from employees where adt like  '%"+text+"%' or epitheto like '%"+text+"%'";
			myRes = myStm.executeQuery(sql);
			Object[] row = new Object[11];
			
			while(myRes.next()){
				row[0] =  myRes.getString("onoma");
				row[1] =  myRes.getString("epitheto");
				row[2] =  myRes.getString("genisi");
				row[3] =  myRes.getString("filo");
				row[4] =  myRes.getString("odos");
				row[5] =  myRes.getString("poli");
				row[6] =  myRes.getString("til");
				row[7] =  myRes.getString("amka");
				row[8] =  myRes.getString("adt");
				row[9] =  myRes.getString("afm");
				row[10] = myRes.getString("username");
				model.addRow(row);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void Delete_Employee(String adt){
		String sql = "delete from employees where adt = ?";
		try {
			PreparedStatement pst = myConn.prepareStatement(sql);
			pst.setString(1, adt);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public String Get_max_room_number(){
		String sql = " SELECT MAX(CAST(id AS SIGNED INTEGER)) as max_id FROM rooms";
		String max = "1";
		try {
			myRes = myStm.executeQuery(sql);
			if (myRes.next()) {
				max = (Integer.parseInt(myRes.getString("max_id")) + 1)+"";
				return max;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return max;
	}
	
	
	public void ADD_Room(String id, String tipos, String klines, String klimatismos, String pisina, String wifi,String timi){		
		try {
			String sql = "INSERT INTO rooms (id,tipos,klines,klimatismos,pisina,wifi,timi) VALUES (?,?,?,?,?,?,?);";
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (!Is_in_list("rooms","id",id)){
				pst.setString(1, id);
				pst.setString(2, tipos);
				pst.setString(3, klines);
				pst.setString(4, klimatismos);
				pst.setString(5, pisina);
				pst.setString(6, wifi);
				pst.setString(7, timi);
				int  i=pst.executeUpdate();		
				if(i>0)
					JOptionPane.showMessageDialog(null,"Καταχωρίθηκε το Δωμάτιο","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"Υπάρχει ειδή Δωμάτιο με αυτό το νούμερο","Ενημέρωση",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	
	public void Print_Rooms(JTable table){
		try {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			myRes = myStm.executeQuery("SELECT * FROM rooms order by (CAST(id AS SIGNED INTEGER));");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[7];
			while(myRes.next()){
				row[0] =  myRes.getString("id");
				row[1] =  myRes.getString("tipos");
				row[2] =  myRes.getString("klines");
				row[3] =  myRes.getString("klimatismos");
				row[4] =  myRes.getString("pisina");
				row[5] =  myRes.getString("wifi");
				row[6] =  myRes.getString("timi")+" €";
				model.addRow(row);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void Delete_Room(String id){
		String sql = "delete from rooms where id = ?";
		try {
			PreparedStatement pst = myConn.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void Print_Rooms_Like(JTable table,String text){
		try {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String sql = "select * from rooms where id like  '%"+text+"%'";
			myRes = myStm.executeQuery(sql);
			Object[] row = new Object[7];		
			while(myRes.next()){
				row[0] =  myRes.getString("id");
				row[1] =  myRes.getString("tipos");
				row[2] =  myRes.getString("klines");
				row[3] =  myRes.getString("klimatismos");
				row[4] =  myRes.getString("pisina");
				row[5] =  myRes.getString("wifi");
				row[6] =  myRes.getString("timi")+" €";
				model.addRow(row);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int Update_Employee(String onoma, String epitheto, String genisi, String filo, String odos, String poli, String til, String amka
			, String adt, String afm, String username,String password){	
		int i =0;
		try {
			String sql = "update employees set onoma = ?,epitheto = ?,genisi =?,filo = ?,odos = ?,poli = ?,til = ? , "
					+ "amka =?, afm =?,username =?,password =? where adt =?;";
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (Is_in_list("employees","adt",adt)){
				pst.setString(1, onoma);
				pst.setString(2, epitheto);
				pst.setString(3, genisi);
				pst.setString(4, filo);
				pst.setString(5, odos);
				pst.setString(6, poli);
				pst.setString(7, til);
				pst.setString(8, amka);
				pst.setString(9, afm);
				pst.setString(10, username);
				pst.setString(11, password);
				pst.setString(12, adt);
				i=pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return i;
	}
	
	
	public int Update_Room(String id, String tipos, String klines, String klimatismos, String pisina, String wifi,String timi){	
		int i =0;
		try {
			String sql = "update rooms set tipos = ?,klines =?,klimatismos = ?,pisina = ?,wifi = ? ,timi =? where id =?;";
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (Is_in_list("rooms","id",id)){
				pst.setString(1, tipos);
				pst.setString(2, klines);
				pst.setString(3, klimatismos);
				pst.setString(4, pisina);
				pst.setString(5, wifi);
				pst.setString(6,timi);
				pst.setString(7, id);
				
				i=pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return i;
	}
	public int UpdateTimi(String klimatismos, String pisina, String wifi,String mono_proino, String imidiatrofi,
			String pliris_diatrofi, String parking,String kanoniko,String oikogeniako,String timi_klinas,String fpa){		
		int i =0;
		try {
			String sql = "update timologisi set klimatismos = ?,pisina=?,wifi=?,mono_proino=?,imidiatrofi=?,"
					+ "pliris_diatrofi=?,  parking=?, kanoniko=?, oikogeniako=?, timi_klinas=? ,fpa = ?where id = 1;"  ;
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (Is_in_list("timologisi","id","1")){
				pst.setString(1, klimatismos);
				pst.setString(2, pisina);
				pst.setString(3, wifi);
				pst.setString(4, mono_proino);
				pst.setString(5, imidiatrofi);
				pst.setString(6, pliris_diatrofi);
				pst.setString(7, parking);
				pst.setString(8, kanoniko);
				pst.setString(9, oikogeniako);
				pst.setString(10,timi_klinas);
				pst.setString(11,fpa);
				i=pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return i;
	}
	
	public void GetTimi(ArrayList<String> array){
		try {
			myRes = myStm.executeQuery("select * from timologisi");
			if(myRes.next()){
				array.add(myRes.getString("klimatismos"));
				array.add(myRes.getString("pisina"));
				array.add(myRes.getString("wifi"));
				array.add(myRes.getString("mono_proino"));
				array.add(myRes.getString("imidiatrofi"));
				array.add(myRes.getString("pliris_diatrofi"));
				array.add(myRes.getString("parking"));
				array.add(myRes.getString("kanoniko"));
				array.add(myRes.getString("oikogeniako"));
				array.add(myRes.getString("timi_klinas"));	
				array.add(myRes.getString("fpa"));		
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int SetRoomPrice(String klim,String pisina,String wifi,String klina,String tipos){
		int klimm = 0, pisinaa = 0, wifii = 0, tiposs,klinaa=0;
		try {
			myRes = myStm.executeQuery("select * from timologisi");
			if(myRes.next()){
				if(klim.equals("ΝΑΙ")){
					klimm= Integer.parseInt(myRes.getString("klimatismos"));
				}
				if(pisina.equals("ΝΑΙ")){
					pisinaa=Integer.parseInt(myRes.getString("pisina"));
				}
				if(wifi.equals("ΝΑΙ")){
					wifii=Integer.parseInt(myRes.getString("wifi"));
				}
				klinaa =Integer.parseInt(myRes.getString("timi_klinas"))*Integer.parseInt(klina);
				if (tipos.equals("Οικογενειακό")){
					tiposs=Integer.parseInt(myRes.getString("oikogeniako"));
				}
				else{
					tiposs=Integer.parseInt(myRes.getString("kanoniko"));
				}
				return klimm+pisinaa+wifii+klinaa+tiposs;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void Print_Rooms_For_Update(String p[][]){
		try {
			myRes = myStm.executeQuery("select * from rooms");
			int i=0;
			while(myRes.next()){
				p[i][0] =  myRes.getString("id");
				p[i][1] =  myRes.getString("tipos");
				p[i][2] =  myRes.getString("klines");
				p[i][3] =  myRes.getString("klimatismos");
				p[i][4] =  myRes.getString("pisina");
				p[i][5] =  myRes.getString("wifi");
				p[i][6] =  myRes.getString("timi");
				i++;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public int NumOfRooms(){
		try {
			myRes = myStm.executeQuery("SELECT COUNT(*) as num FROM rooms;");
			if(myRes.next()){
				return Integer.parseInt(myRes.getString("num"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int SetRoomPricee(int price,String id){
		int i;
		try {
			String sql = "update rooms set timi=? where id =?"  ;
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (Is_in_list("rooms","id",id)){
				pst.setString(1, price+"");
				pst.setString(2, id);						
				i=pst.executeUpdate();
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
