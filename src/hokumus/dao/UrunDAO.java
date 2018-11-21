package hokumus.dao;

import hokumus.model.Urunler;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UrunDAO {
	Connection conn;

	public int urunKaydet(Urunler temp) {

		int count = 0;
		try {
			conn = DbConnector.getConnection();
			String sql = " insert into urunler (urunadi, fiyat,ulke) values(?,?,?)  ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(2, temp.getFiyat());
			pstmt.setString(3, temp.getMesei());
			pstmt.setString(1, temp.getUrunAdi());
			System.out.println(sql);
			count = pstmt.executeUpdate();
			System.out.println(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
