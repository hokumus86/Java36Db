package hokumus.dao;

import hokumus.model.Kullanici;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KullaniciGirisDAO {
	Connection conn = null;

	public KullaniciGirisDAO() {

	}

	public List<Kullanici> getAllUsers() {
		List<Kullanici> kullanicilar= new ArrayList<Kullanici>();
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

}
