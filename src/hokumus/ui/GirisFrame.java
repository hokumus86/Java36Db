package hokumus.ui;

import hokumus.dao.KullaniciGirisDAO;
import hokumus.model.Kullanici;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		setBounds(300, 350, 300, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		 
		
		JLabel lblKulAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKulAdi.setBounds(10, 68, 108, 14);
		getContentPane().add(lblKulAdi);
		
		JLabel lblSifre = new JLabel("\u015Eifre");
		lblSifre.setBounds(10, 105, 108, 14);
		getContentPane().add(lblSifre);
		
		txtKulAdi = new JTextField();
		txtKulAdi.setText("hokumus");
		txtKulAdi.setBounds(128, 65, 152, 20);
		getContentPane().add(txtKulAdi);
		txtKulAdi.setColumns(10);
		
		txtSifre = new JTextField();
		txtSifre.setText("123");
		txtSifre.setBounds(128, 102, 152, 20);
		getContentPane().add(txtSifre);
		txtSifre.setColumns(10);
		
		JButton btnGiris = new JButton("Giri\u015F");
		
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kullanici temp =db.getUser(txtKulAdi.getText());
				if(temp!=null){
					if(temp.getSifre().equals(txtSifre.getText())){
						AnaEkran frames = new AnaEkran();
						frames.setVisible(true);
						GirisFrame.this.dispose();
					}
					else {
						JOptionPane.showMessageDialog(GirisFrame.this, "Þifre Hatalý");
					}
				}
				else {
					JOptionPane.showMessageDialog(GirisFrame.this, "Böyle Bir Kullanýcý Yok...!");
				}
				
				
				
				
//				Kullanici user = db.getKullaniciForUserName(txtKulAdi.getText());
//				if(user !=null){
//					if(user.getSifre().equals(txtSifre.getText())){
//						AnaEkran ana = new AnaEkran();
//						ana.setVisible(true);
//						GirisFrame.this.setVisible(false);
//						
//					}
//					else {
//						JOptionPane.showMessageDialog(GirisFrame.this, "Þifre Hatalý");
//					}
//				}
//				else {
//					JOptionPane.showMessageDialog(GirisFrame.this, "Böyle Bir Kullanýcý Yok...!");
//				}
//				List<Kullanici> users = db.getAllUsers();
//				for (Kullanici temp : users) {
//					if(temp.getKullaniciAdi().equals(txtKulAdi.getText())){
//						kullaniciVarmi = true;
//						if(temp.getSifre().equals(txtSifre.getText())){
//							sifreDogrumu= true;
//							JOptionPane.showMessageDialog(GirisFrame.this, "Hoþgeldiniz ... Sayýn "+ txtKulAdi.getText());
//							break;
//						}
//					}					
//					
//				}
//				if(!kullaniciVarmi){
//					JOptionPane.showMessageDialog(GirisFrame.this, "Böyle Bir Kullanýcý Yok...!");
//				}
//				else if(!sifreDogrumu) {
//					JOptionPane.showMessageDialog(GirisFrame.this, "Þifre Hatalý");
//				}
			}
		});
		btnGiris.setBounds(189, 155, 91, 23);
		getContentPane().add(btnGiris);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setBounds(79, 155, 91, 23);
		getContentPane().add(btnIptal);
		setTitle("Giriþ");
		
		 
	}
}
