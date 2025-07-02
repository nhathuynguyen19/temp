package View;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BO.SinhVienABO;
import BO.SinhVienBBO;
import Bean.SinhVienABean;
import Bean.SinhVienBBean;
import FileManager.QuanLyFile;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tablesva;
	public static JTable tablesvb;
	public static SinhVienABO abo = new SinhVienABO();
	public static SinhVienBBO bbo = new SinhVienBBO();
	public static QuanLyFile qlf = new QuanLyFile();
	
	public static void InsertTableA(ArrayList<SinhVienABean> ds) {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("maSinhVien");
		model.addColumn("hoTen");
		model.addColumn("diemWin");
		model.addColumn("diemWord");
		model.addColumn("diemTB");
		
		for (SinhVienABean sv : ds) {
			Object[] temp = new Object[5];
			
			temp[0] = sv.getMaSinhVien();
			temp[1] = sv.getHoTen();
			temp[2] = sv.getDiemWin();
			temp[3] = sv.getDiemWord();
			temp[4] = ((sv.getDiemWin() + sv.getDiemWord()) / 2);
			
			model.addRow(temp);
		}
		
		tablesva.setModel(model);
	}
	
	public static void InsertTableB(ArrayList<SinhVienBBean> ds) {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("maSinhVien");
		model.addColumn("hoTen");
		model.addColumn("diemExcel");
		model.addColumn("diemPowerPoint");
		model.addColumn("diemWeb");
		model.addColumn("diemTB");
		
		for (SinhVienBBean sv : ds) {
			Object[] temp = new Object[6];
			
			temp[0] = sv.getMaSinhVien();
			temp[1] = sv.getHoTen();
			temp[2] = sv.getDiemExcel();
			temp[3] = sv.getDiemPowerPoint();
			temp[4] = sv.getDiemWeb();
			temp[5] = ((sv.getDiemExcel() + sv.getDiemPowerPoint() + sv.getDiemWeb()) / 3);
			
			model.addRow(temp);
		}
		
		tablesvb.setModel(model);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					InsertTableA(qlf.loadSinhVienAFromFile());
					InsertTableB(qlf.loadSinhVienBFromFile());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane_1 = new JScrollPane();
		tablesvb = new JTable();
		JButton btnLoadFile = new JButton("Load file");
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(SinhVienABean sv : qlf.loadSinhVienAFromFile()) {
						try {
							abo.insert(sv);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(sv.toString());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					for(SinhVienBBean sv : qlf.loadSinhVienBFromFile()) {
						try {
							bbo.insert(sv);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(sv.toString());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFind ff = new FrmFind();
				ff.setVisible(true);
				ArrayList<SinhVienABean> dsa = new ArrayList<SinhVienABean>();
				ArrayList<SinhVienBBean> dsb = new ArrayList<SinhVienBBean>();
				InsertTableA(dsa);
				InsertTableB(dsb);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 492);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane.setBounds(229, 94, 495, 292);
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		tablesva = new JTable();
		scrollPane.setViewportView(tablesva);
		
		tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		scrollPane_1.setViewportView(tablesvb);
		
		btnLoadFile.setBounds(229, 397, 89, 23);
		contentPane.add(btnLoadFile);
		
		btnFind.setBounds(328, 397, 89, 23);
		contentPane.add(btnFind);
	}
}
