package hokumus.dao;

import hokumus.model.Kullanici;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KullaniciGirisDAO {
	Connection conn = null;

	public KullaniciGirisDAO() {

	}

	public List<Kullanici> getAllUsers() {
		List<Kullanici> kullanicilar = new ArrayList<Kullanici>();
		try {
			conn = DbConnector.getConnection();
			Statement stmt = conn.createStatement();
			String sql = " select usr_name, pass from kullanici  ";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				Kullanici temp = new Kullanici();
				temp.setKullaniciAdi(rs.getString("usr_name"));
				temp.setSifre(rs.getString("pass"));
				kullanicilar.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kullanicilar;
	}

	public Kullanici getKullaniciForUserName(String kullaniciAdi) {
		Kullanici temp = null;
		try {
			conn = DbConnector.getConnection();
			String sql = " select usr_name, pass from kullanici where usr_name= ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kullaniciAdi);
			System.out.println(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(sql);
			if (rs.next()) {
				temp = new Kullanici();
				temp.setKullaniciAdi(rs.getString("usr_name"));
				temp.setSifre(rs.getString("pass"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return temp;
	}
	
	public int KullaniciKaydet(Kullanici temp) {
		int count = 0;
		try {
			conn = DbConnector.getConnection();
			String sql = " insert into kullanici(usr_name,pass) values(?,?)  ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, temp.getKullaniciAdi());
			pstmt.setString(2, temp.getSifre());
			System.out.println(sql);
			count = pstmt.executeUpdate();
			System.out.println(sql);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
