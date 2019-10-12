import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Driver_gramatia {
	
	private Connection myConn;
	private Statement myStm;
	private ResultSet myRes;
	
	public Driver_gramatia(){
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db","user","user1234");
			myStm = myConn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int ADD_Pelati(String onoma, String epitheto, String genisi, String filo, String odos, String 
			poli, String til, String afm, String adt){	
		int  i=0;
		
		try {
			String sql = "INSERT INTO pelates (onoma,epitheto,genisi,filo,odos,poli,til,afm,adt) VALUES (?,?,?,?,?,?,?,?,?);"  ;
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (!Is_in_list("pelates","adt",adt)){
				pst.setString(1, onoma);
				pst.setString(2, epitheto);
				pst.setString(3, genisi);
				pst.setString(4, filo);
				pst.setString(5, odos);
				pst.setString(6, poli);
				pst.setString(7, til);
				pst.setString(8, afm);
				pst.setString(9, adt);
				i=pst.executeUpdate();
				if(i>0)
					JOptionPane.showMessageDialog(null,"Καταχωρίθηκε ο Πελάτης.","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"Υπάρχει ειδή Υπάλληλος με αυτά τα στοιχεία","Ενημέρωση",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return i;
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
	
	
	
	
	public boolean Delete_Pelati(String adt){
		String sql = "delete from pelates where adt = ?";
		try {
			PreparedStatement pst = myConn.prepareStatement(sql);
			pst.setString(1, adt);
			if(pst.executeUpdate()<1){
				JOptionPane.showMessageDialog(null,"Δεν ήταν δυνατή η διαγραφή του πελάτη με Α.Δ.Τ. "+adt+" .","Προσοχή",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		JOptionPane.showMessageDialog(null,"Επιτυχής Διαγραφή.","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
	
	public int GetParkingPrice(){
		int i=0;
		try {
			myRes = myStm.executeQuery("select parking from timologisi");
			if(myRes.next()){
				i = Integer.parseInt(myRes.getString("parking"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	
	public String GetRoomPrice(String id){
		try {
			String sql = "select timi from rooms where id = '"+id+"';";
			String l = sql;
			myRes = myStm.executeQuery(l);
			if(myRes.next()){
					return (myRes.getString("timi"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String GetDiatrofiPrice(String id){
		try {
			String sql = "select +"+id+" from timologisi ;";
			String l = sql;
			myRes = myStm.executeQuery(l);
			if(myRes.next()){
					return (myRes.getString(id));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public int GetFpa(){
		try {
			myRes = myStm.executeQuery("SELECT fpa from timologisi where id ='1';");
			if(myRes.next()){
					return Integer.parseInt(myRes.getString("fpa"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int ADD_Kratisi(String id, String imerominia, String gramat, String pelatis, String room,String afiksi, String 
			anaxorisi, String enilikes, String anilika, String amaski, String diatrofi,String kostos){	
		int  i=0;
		try {
			String sql = "INSERT INTO kratisis (id,imerominia,id_gramatea,id_pelati,id_room,afiksi,anaxorisi,enilikes,anilika,amaksi,diatrofi,kostos) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);"  ;
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (!Is_in_list("kratisis","id",id)){
				pst.setString(1, id);
				pst.setString(2, imerominia);
				pst.setString(3, gramat);
				pst.setString(4, pelatis);
				pst.setString(5, room);
				pst.setString(6, afiksi);
				pst.setString(7, anaxorisi);
				pst.setString(8, enilikes);
				pst.setString(9, anilika);
				pst.setString(10, amaski);
				pst.setString(11, diatrofi);
				pst.setString(12, kostos);			
				i=pst.executeUpdate();
				if(i>0)
					JOptionPane.showMessageDialog(null,"Καταχωρίθηκε η κράτηση.","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"Υπάρχει ειδή κράτηση με αυτά τα στοιχεία","Ενημέρωση",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return i;
	}
	public void Print_Kratisis(JTable table){
		try {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			myRes = myStm.executeQuery("select * from kratisis");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[12];
			while(myRes.next()){
				row[0] =  myRes.getString("id");
				row[1] =  myRes.getString("imerominia");
				row[2] =  myRes.getString("id_gramatea");
				row[3] =  myRes.getString("id_pelati");
				row[4] =  myRes.getString("id_room");
				row[5] =  ToNormal(myRes.getString("afiksi"));
				row[6] =  ToNormal(myRes.getString("anaxorisi")) ;
				row[7] =  myRes.getString("enilikes");
				row[8] =  myRes.getString("anilika");
				row[9] =  myRes.getString("amaksi");
				row[10] =  myRes.getString("diatrofi");
				row[11] =  myRes.getString("kostos")+" €";
				model.addRow(row);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public boolean Delete_Kratisi(String id){
		String sql = "delete from kratisis where id = ?";
		try {
			PreparedStatement pst = myConn.prepareStatement(sql);
			pst.setString(1, id);
			if(pst.executeUpdate()<1){
				JOptionPane.showMessageDialog(null,"Δεν ήταν δυνατή η διαγραφή της κράτησης με κωδικό "+id+" .","Προσοχή",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		JOptionPane.showMessageDialog(null,"Επιτυχής Διαγραφή.","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
	
	public int UpdatePelati(String onoma, String epitheto, String genisi, String filo, String odos, String 
			poli, String til, String afm, String adt  ){	
		int  i=0;
		try {
			String sql = "update pelates set onoma = ?,epitheto = ?,genisi = ?,filo=?,odos=?,poli=?,til=?,afm=? where adt = ?;"  ;
			PreparedStatement pst = myConn.prepareStatement(sql);
			if (Is_in_list("pelates","adt",adt)){
				pst.setString(1, onoma);
				pst.setString(2, epitheto);
				pst.setString(3, genisi);
				pst.setString(4, filo);
				pst.setString(5, odos);
				pst.setString(6, poli);
				pst.setString(7, til);
				pst.setString(8, afm);
				pst.setString(9, adt);
				i=pst.executeUpdate();
				if(i>0)
					JOptionPane.showMessageDialog(null,"Ενημερώθηκε ο Πελάτης.","Ενημέρωση",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"Σφάλμα ενημέρωσης!","Ενημέρωση",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return i;
	}
	
	
	
	public void Print_DiathesimaRooms(String afiksi,String anaxorisi,String ac,String wifi,String pool,DefaultListModel<String> model,String klines,String tipos){
		try {
			String sql = "select id from rooms where id not in (select id_room from kratisis where (afiksi<='"+afiksi+"' and '"+afiksi+"'<=anaxorisi) or ( afiksi<='"+anaxorisi+"' and '"+anaxorisi+"'<=anaxorisi) or ('"+afiksi+"'<=afiksi and '"+anaxorisi+"'>=anaxorisi)) and";
			String sql2 = " klimatismos = '"+ac+"' and wifi = '"+wifi+"' and pisina ='"+pool+"' and klines = '"+klines+"'"+" and tipos = '"+tipos+"';";
			String l = sql+sql2;
			//System.out.println(l);
			myRes = myStm.executeQuery(l);
			model.clear();
			while(myRes.next()){
				model.addElement(myRes.getString("id"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
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
	
	public boolean Check_Rec(String username,String password ){
		try {
			String sql = "select username from employees where username = '"+username+"' and password = '"+password+"'";
			String l = sql;
			myRes = myStm.executeQuery(l);
			if(myRes.next()){
				return true;
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void Print_Pelates(JTable table){
		try {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			myRes = myStm.executeQuery("select * from pelates");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[9];
			while(myRes.next()){
				row[0] =  myRes.getString("onoma");
				row[1] =  myRes.getString("epitheto");
				row[2] =  myRes.getString("genisi");
				row[3] =  myRes.getString("filo");
				row[4] =  myRes.getString("odos");
				row[5] =  myRes.getString("poli");
				row[6] =  myRes.getString("til");
				row[7] =  myRes.getString("afm");
				row[8] =  myRes.getString("adt");
				
				model.addRow(row);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void Print_Pelates_like(JTable table,String text){
		try {
			((DefaultTableModel) table.getModel()).setNumRows(0);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String sql = "select * from pelates where onoma like  '%"+text+"%' or epitheto like '%"+text+"%'";
			myRes = myStm.executeQuery(sql);
			Object[] row = new Object[9];		
			while(myRes.next()){
				row[0] =  myRes.getString("onoma");
				row[1] =  myRes.getString("epitheto");
				row[2] =  myRes.getString("genisi");
				row[3] =  myRes.getString("filo");
				row[4] =  myRes.getString("odos");
				row[5] =  myRes.getString("poli");
				row[6] =  myRes.getString("til");
				row[7] =  myRes.getString("afm");
				row[8] =  myRes.getString("adt");
				model.addRow(row);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
