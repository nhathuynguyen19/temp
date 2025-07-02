package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BO.SinhVienABO;
import BO.SinhVienBBO;
import Bean.SinhVienABean;
import Bean.SinhVienBBean;
import FileManager.QuanLyFile;

import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmFind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public SinhVienABO abo = new SinhVienABO();
	public SinhVienBBO bbo = new SinhVienBBO();
	public QuanLyFile qlf = new QuanLyFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFind frame = new FrmFind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmFind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(98, 52, 227, 22);
		contentPane.add(textField);
		
		Button button = new Button("FIND");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoTen = textField.getText().strip();
				ArrayList<SinhVienABean> dsa = new ArrayList<SinhVienABean>();
				ArrayList<SinhVienBBean> dsb = new ArrayList<SinhVienBBean>();
				FrmTest.InsertTableA(dsa);
				FrmTest.InsertTableB(dsb);
				try {
					if (abo.find(hoTen) != null) {
						ArrayList<SinhVienABean> ds = new ArrayList<SinhVienABean>();
						SinhVienABean sv = abo.find(hoTen);
						ds.add(sv);
						FrmTest.InsertTableA(ds);
					} else if (bbo.find(hoTen) != null) {
						ArrayList<SinhVienBBean> ds = new ArrayList<SinhVienBBean>();
						SinhVienBBean sv = (SinhVienBBean) bbo.find(hoTen);
						ds.add(sv);
						FrmTest.InsertTableB(ds);
					} else {
						System.out.println("Khong tim thay sinh vien voi hoTen like " + hoTen);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(98, 80, 70, 22);
		contentPane.add(button);
	}
}
