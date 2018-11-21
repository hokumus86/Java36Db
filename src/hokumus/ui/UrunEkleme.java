package hokumus.ui;

import hokumus.dao.UrunDAO;
import hokumus.model.Urunler;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UrunEkleme extends JFrame{
	private JTextField txtUrunAdi;
	private JTextField txtFiyati;
	private JTextField txtUlke;
	
	UrunDAO db = new UrunDAO();
	
	
	public UrunEkleme() {
		intialize();
	}

	private void intialize() {
		setBounds(200, 150, 350, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblrnAd = new JLabel("\u00DCr\u00FCn Ad\u0131");
		lblrnAd.setBounds(41, 68, 95, 14);
		getContentPane().add(lblrnAd);
		
		JLabel lblFiyat = new JLabel("Fiyat\u0131");
		lblFiyat.setBounds(41, 93, 95, 14);
		getContentPane().add(lblFiyat);
		
		JLabel lbllkesi = new JLabel("Men\u015Fei");
		lbllkesi.setBounds(41, 118, 95, 14);
		getContentPane().add(lbllkesi);
		
		txtUrunAdi = new JTextField();
		txtUrunAdi.setBounds(172, 65, 129, 20);
		getContentPane().add(txtUrunAdi);
		txtUrunAdi.setColumns(10);
		
		txtFiyati = new JTextField();
		txtFiyati.setColumns(10);
		txtFiyati.setBounds(172, 90, 129, 20);
		getContentPane().add(txtFiyati);
		
		txtUlke = new JTextField();
		txtUlke.setColumns(10);
		txtUlke.setBounds(172, 118, 129, 20);
		getContentPane().add(txtUlke);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(45, 179, 91, 23);
		getContentPane().add(btnIptal);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Urunler model = new Urunler();
				model.setUrunAdi(txtUrunAdi.getText());
				model.setFiyat(Integer.parseInt(txtFiyati.getText()));
				model.setMesei(txtUlke.getText());
				int count =db.urunKaydet(model);
				if(count >0){
					JOptionPane.showMessageDialog(UrunEkleme.this, "Urun Baþarýyla Eklendi");
				}
				else 
					JOptionPane.showMessageDialog(UrunEkleme.this, "Urun Ekleme Baþarýsýz Oldu...!");
			}
		});
		btnKaydet.setBounds(187, 179, 91, 23);
		getContentPane().add(btnKaydet);
		
	}
}
