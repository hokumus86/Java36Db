package hokumus.ui;

import hokumus.dao.DbConnector;
import hokumus.dao.KullaniciGirisDAO;
import hokumus.model.Kullanici;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class GirisFrame extends JFrame{
	private JTextField txtKulAdi;
	private JTextField txtSifre;
	boolean kullaniciVarmi= false;
	boolean sifreDogrumu= false;
	KullaniciGirisDAO db = new KullaniciGirisDAO();
	public GirisFrame() {
		setBounds(300, 350, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		 
		
		JLabel lblKulAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKulAdi.setBounds(28, 126, 152, 14);
		getContentPane().add(lblKulAdi);
		
		JLabel lblSifre = new JLabel("\u015Eifre");
		lblSifre.setBounds(28, 151, 152, 14);
		getContentPane().add(lblSifre);
		
		txtKulAdi = new JTextField();
		txtKulAdi.setBounds(190, 123, 152, 20);
		getContentPane().add(txtKulAdi);
		txtKulAdi.setColumns(10);
		
		txtSifre = new JTextField();
		txtSifre.setBounds(190, 148, 152, 20);
		getContentPane().add(txtSifre);
		txtSifre.setColumns(10);
		
		JButton btnGiris = new JButton("Giri\u015F");
		
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Kullanici> users = db.getAllUsers();
				for (Kullanici temp : users) {
					if(temp.getKullaniciAdi().equals(txtKulAdi.getText())){
						kullaniciVarmi = true;
						if(temp.getSifre().equals(txtSifre.getText())){
							sifreDogrumu= true;
							JOptionPane.showMessageDialog(GirisFrame.this, "Hoþgeldiniz ... Sayýn "+ txtKulAdi.getText());
							break;
						}
					}					
					
				}
				if(!kullaniciVarmi){
					JOptionPane.showMessageDialog(GirisFrame.this, "Böyle Bir Kullanýcý Yok...!");
				}
				else if(!sifreDogrumu) {
					JOptionPane.showMessageDialog(GirisFrame.this, "Þifre Hatalý");
				}
			}
		});
		btnGiris.setBounds(251, 206, 91, 23);
		getContentPane().add(btnGiris);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(150, 206, 91, 23);
		getContentPane().add(btnIptal);
		setTitle("Db Connectin Java");
		
		 
	}
}
