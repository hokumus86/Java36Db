package hokumus.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {

	private DbConnector() {

	}

	static String bilg = "localhost";
	static String port = "5435";
	static String dbAdi = "deneme";
	static String kulAdi = "postgres";
	static String sifre = "root";

	public static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection("jdbc:postgresql://" + bilg+ ":" + port + "/" + dbAdi + "", "" + kulAdi + "", ""	+ sifre);
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn = null;
		}
		System.out.println("Database Baðlantýsý Saðlandý....");

		return conn;
	}

}
