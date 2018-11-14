package hokumus.ui;

import hokumus.dao.KullaniciGirisDAO;
import hokumus.model.Kullanici;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KullaniciEkle extends JFrame {
	private JTextField txtKullaniciAdi;
	private JTextField txtSifre;
	JButton btnKaydet;
	private KullaniciGirisDAO db = new KullaniciGirisDAO();

	public KullaniciEkle() {
		initialize();
	}

	private void initialize() {
		setBounds(300, 350, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		label.setBounds(23, 43, 108, 14);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\u015Eifre");
		label_1.setBounds(23, 80, 108, 14);
		getContentPane().add(label_1);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnKaydet.setEnabled(true);
			}
		});
		txtKullaniciAdi.setColumns(10);
		txtKullaniciAdi.setBounds(141, 40, 152, 20);
		getContentPane().add(txtKullaniciAdi);

		txtSifre = new JTextField();
		txtSifre.setColumns(10);
		txtSifre.setBounds(141, 77, 152, 20);
		getContentPane().add(txtSifre);

		btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtKullaniciAdi.getText().equals("")
						|| txtSifre.getText().equals("")) {
					JOptionPane.showMessageDialog(KullaniciEkle.this,
							"Kullanýcý Adý veya Þifre Boþ Geçilemez...!!!");
				} else {
					Kullanici temp = new Kullanici();
					temp.setKullaniciAdi(txtKullaniciAdi.getText());
					temp.setSifre(txtSifre.getText());
					int count = db.KullaniciKaydet(temp);
					if (count > 0) {
						JOptionPane.showMessageDialog(KullaniciEkle.this,
								"Kaydetme Ýþlemi Baþarýyla Tamamlandý..!");
						btnKaydet.setEnabled(false);

					}

					else
						JOptionPane.showMessageDialog(KullaniciEkle.this,
								"Kaydetme Ýþlemi Baþarýsýz..!");
				}

			}
		});
		btnKaydet.setBounds(202, 130, 91, 23);
		getContentPane().add(btnKaydet);

		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciEkle.this.dispose();
			}
		});
		btnIptal.setBounds(92, 130, 91, 23);
		getContentPane().add(btnIptal);

	}
}
