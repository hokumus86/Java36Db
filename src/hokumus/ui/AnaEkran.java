package hokumus.ui;

import hokumus.dao.KullaniciGirisDAO;
import hokumus.model.Kullanici;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;

public class AnaEkran extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;
	KullaniciGirisDAO db = new KullaniciGirisDAO();
	
	public AnaEkran() {
		setBounds(300, 350, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		initialize();
		
		
	}

	private void initialize() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 492, 21);
		getContentPane().add(menuBar);
		
		JMenu menuDosya = new JMenu("Dosya");
		menuBar.add(menuDosya);
		
		JMenuItem menuItemKulaniciEkle = new JMenuItem("Kullan\u0131c\u0131 Ekle");
		menuItemKulaniciEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciEkle kekle = new  KullaniciEkle();
				kekle.setVisible(true);
			}
		});
		menuDosya.add(menuItemKulaniciEkle);
		
		JMenuItem menuItemFirmaEkle = new JMenuItem("Firma Ekle");
		menuDosya.add(menuItemFirmaEkle);
		
		JMenuItem menuItemUrunEkleme = new JMenuItem("\u00DCr\u00FCn Ekleme");
		menuItemUrunEkleme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UrunEkleme temp = new UrunEkleme();
				temp.setVisible(true);
			}
		});
		menuDosya.add(menuItemUrunEkleme);
		
		JMenu menuCikis = new JMenu("\u00C7\u0131k\u0131\u015F");
		menuBar.add(menuCikis);
		
		JMenuItem menuItemHakkinda = new JMenuItem("Hakk\u0131nda");
		menuItemHakkinda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(AnaEkran.this, "Vektorel yazýlým Db Uygulamasý Java-36 Sýnýfý Tarafýndan yapýlmýþtýr.");
			}
		});
		menuCikis.add(menuItemHakkinda);
		
		JMenuItem menuItemKapat = new JMenuItem("Program\u0131 Kapat");
		menuItemKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuCikis.add(menuItemKapat);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder());
		scrollPane.setBounds(10, 113, 472, 267);
		getContentPane().add(scrollPane);
		
		
		table = new JTable();
		
		scrollPane.setRowHeaderView(table);
		
		JButton btnGetUsers = new JButton("Kullanicilari Getir");
		btnGetUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Kullanici> users = db.getAllUsers();
				String[] [] data =new String[users.size()][2];
				for (int i = 0; i<users.size(); i++) {
					data[i][0]= users.get(i).getKullaniciAdi();
					data[i][1]= users.get(i).getSifre();					
				}
				
				String[] colName =new String[] { "Kullan\u0131c\u0131 Ad\u0131", "Sifre"};
				DefaultTableModel model = new DefaultTableModel(data, colName);
				table.setModel(model);
				
			}
		});
		btnGetUsers.setBounds(10, 391, 472, 23);
		getContentPane().add(btnGetUsers);
		
	}
}
