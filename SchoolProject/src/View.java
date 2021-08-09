import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class View extends JFrame {

	private JPanel contentPane;
	private JTextField tekstEmri;
	private JTextField tekstMbiemri;
	private JTextField tekstSasia;
	private JRadioButton radiobtnFamiljar;
	private JRadioButton radiobtnBiznes;
	private JLabel lblInformacion;
	private JTextPane tekstFatura;
	private JButton btnAfisho;
	private JLabel lblVariabel;
	
	//Model dhe Controll therriten ne menyr qe te komunikojn me objektin view.
	//I vetmi objekt qe akseson Model nepermjet funksioneve eshte objekti Controller.
	private Model model;
	private Controller controller;
	/**
	 * @autori:
	 * @versioni:1.0
	 * @data:
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setLocationRelativeTo(null);
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
	public View() {
		setTitle("Sistem Faturimi per Energjine Elektrike App");
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//Per arsye estetike eshte perfshire objekti ImageIcon per te vendosur imazhe udhezues ne labels
		//te ndryshem te projektit.
		JLabel lblNewLabel_1 = new JLabel("");
		Image ikona1 = new ImageIcon(this.getClass().getResource("/ikona_electrike.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(ikona1));
		

		URL iconURL = getClass().getResource("/ikona_electrike.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		
		JLabel lblNewLabel = new JLabel("SISTEM FATURIMI PER ENERGJINE ELEKTRIKE");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		
		//Kjo pjese e kodit gjenerohet vet nga java swing kur punoeht me GUI-n.
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(300)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1454, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		
		JLabel lblEmri = new JLabel("Emri:");
		lblEmri.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmri.setVerticalAlignment(SwingConstants.TOP);
		lblEmri.setForeground(Color.BLACK);
		lblEmri.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		JLabel lblMbiemri = new JLabel("Mbiemri:");
		lblMbiemri.setVerticalAlignment(SwingConstants.TOP);
		lblMbiemri.setHorizontalAlignment(SwingConstants.LEFT);
		lblMbiemri.setForeground(Color.BLACK);
		lblMbiemri.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		JLabel lblSasia = new JLabel("Sasia:");
		lblSasia.setVerticalAlignment(SwingConstants.TOP);
		lblSasia.setHorizontalAlignment(SwingConstants.LEFT);
		lblSasia.setForeground(Color.BLACK);
		lblSasia.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		tekstEmri = new JTextField();
		tekstEmri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblVariabel.setText("[>] Duke shkruajtur emrin...");
				lblVariabel.setForeground(Color.BLACK);
			}
		});
		tekstEmri.setForeground(Color.BLACK);
		tekstEmri.setFont(new Font("Tahoma", Font.BOLD, 33));
		tekstEmri.setColumns(10);
		
		tekstMbiemri = new JTextField();
		tekstMbiemri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblVariabel.setText("[>] Duke shkruajtur mbiemrin...");
				lblVariabel.setForeground(Color.BLACK);
			}
		});
		tekstMbiemri.setForeground(Color.BLACK);
		tekstMbiemri.setFont(new Font("Tahoma", Font.BOLD, 33));
		tekstMbiemri.setColumns(10);
		
		tekstSasia = new JTextField();
		tekstSasia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblVariabel.setText("[>] Duke shkruajtur sasine...");
				lblVariabel.setForeground(Color.BLACK);
			}
		});
		tekstSasia.setForeground(Color.BLACK);
		tekstSasia.setFont(new Font("Tahoma", Font.BOLD, 33));
		tekstSasia.setColumns(10);
		
		
		//Jane perdorur 2 radio butona dhe jane programuar ne menyre te tille
		//Ne momentin qe njeri selektohet tjetri deselektohet.
		radiobtnFamiljar = new JRadioButton("");
		radiobtnFamiljar.setSelected(true);
		radiobtnFamiljar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobtnFamiljar.isSelected()) {
					lblVariabel.setText("[!] Ju zgjodhet statusin familjar!"); //Ky label ndryshon tekstin kur selektohet butoni familjar
					radiobtnBiznes.setSelected(false);
				}
			}
		});
		radiobtnFamiljar.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		//Butoni i dyte eshte ndertuar me te njejten llogjike kodi
		radiobtnBiznes = new JRadioButton("");
		radiobtnBiznes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radiobtnBiznes.isSelected()) {
					lblVariabel.setText("[!] Ju zgjodhet statusin biznes!");
					radiobtnFamiljar.setSelected(false);
				}
			}
		});
		radiobtnBiznes.setToolTipText("");
		radiobtnBiznes.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		//Kod i gjenereuar nga java swing.
		JLabel lblFamiljar = new JLabel("Familjar:");
		lblFamiljar.setVerticalAlignment(SwingConstants.TOP);
		lblFamiljar.setHorizontalAlignment(SwingConstants.LEFT);
		lblFamiljar.setForeground(Color.BLACK);
		lblFamiljar.setFont(new Font("Tahoma", Font.BOLD, 33));
		Image familjar = new ImageIcon(this.getClass().getResource("/familjar.png")).getImage();
		lblFamiljar.setIcon(new ImageIcon(familjar));
		
		JLabel lblBiznes = new JLabel("Biznes:");
		lblBiznes.setVerticalAlignment(SwingConstants.TOP);
		lblBiznes.setHorizontalAlignment(SwingConstants.LEFT);
		lblBiznes.setForeground(Color.BLACK);
		lblBiznes.setFont(new Font("Tahoma", Font.BOLD, 33));
		Image biznes = new ImageIcon(this.getClass().getResource("/biznes.png")).getImage();
		lblBiznes.setIcon(new ImageIcon(biznes));
		
		JLabel lblProfil = new JLabel("Konsumatori");
		Image profil = new ImageIcon(this.getClass().getResource("/profili.png")).getImage();
		lblProfil.setIcon(new ImageIcon(profil));
		
		lblProfil.setVerticalAlignment(SwingConstants.TOP);
		lblProfil.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfil.setForeground(Color.BLACK);
		lblProfil.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		//Butoni afisho ekzekuton funksionet nga objekti Controller.
		btnAfisho = new JButton("AFISHO");
		btnAfisho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Try catch eshte perdorur per te menjanuar erroret dhe per te njoftuar userin nese perdor te dhenat e gabuara.
				try {
					if (tekstEmri.getText().matches("[a-zA-Z]+") && tekstMbiemri.getText().matches("[a-zA-Z]+") ) {
						model = new Model();//Krijohet objekti model
						controller = new Controller(model);//Krijohet objekti controller qe merr si parameter model qe te mund te komunikoj te dhenat me te.
						
						controller.regjistroTeDhenat(tekstEmri.getText(), tekstMbiemri.getText(), //Ketu ekzekutohet funksioni qe regjistron te dhenat i cili merr 4 parametra.
								Float.parseFloat(tekstSasia.getText()), radiobtnFamiljar.isSelected());
						
						tekstFatura.setText(controller.afishoFaturen());//Funksioni afishoFaturen kthen nje vler String qe sherben per te pare faturen.
						
						lblVariabel.setText("[:)] Fatura u afishua!");//Njoftohet useri per ekzekutimin me sukses dhe afishimin e fatures.
						lblVariabel.setForeground(Color.GREEN);
					} else {
						lblVariabel.setText("[:O] Te dhenat jane gabim!!!");
						lblVariabel.setForeground(Color.RED);
					}

					}
					catch(Exception ex) {//Cdo error qe shkaktohet nga futja e te dhenave gabim kapet dhe useri njoftohet qe ti rivendosi ato.
						lblVariabel.setText("[:O] Te dhenat jane gabim!!!");
						lblVariabel.setForeground(Color.RED);
					}
				

			}});
		btnAfisho.setFont(new Font("Tahoma", Font.BOLD, 19));
		Image afisho = new ImageIcon(this.getClass().getResource("/afisho.png")).getImage();
		btnAfisho.setIcon(new ImageIcon(afisho));
		
		JButton btnPastro = new JButton("PASTRO");
		btnPastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//Buttoni Pastro fshin gjith te dhenat nga teksfielded e ndryshme si dhe caktivizon
				tekstEmri.setText("");					//cdo radio button.	
				tekstMbiemri.setText("");
				tekstSasia.setText("");
				tekstFatura.setText("");
				lblVariabel.setText("[x] Te dhenat u fshine!");//useri njoftohet me nje mesazh.
				lblVariabel.setForeground(Color.ORANGE);
			}
		});
		btnPastro.setFont(new Font("Tahoma", Font.BOLD, 19));
		Image pastro = new ImageIcon(this.getClass().getResource("/pastro.png")).getImage();
		btnPastro.setIcon(new ImageIcon(pastro));
		
		JLabel lblkWh = new JLabel("kWh");
		lblkWh.setVerticalAlignment(SwingConstants.TOP);
		lblkWh.setHorizontalAlignment(SwingConstants.LEFT);
		lblkWh.setForeground(Color.BLACK);
		lblkWh.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblMbiemri)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(46)
								.addComponent(lblSasia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblFamiljar)
						.addComponent(lblBiznes)
						.addComponent(lblEmri))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProfil, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(tekstMbiemri, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
							.addComponent(tekstSasia, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(radiobtnFamiljar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(radiobtnBiznes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnAfisho, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnPastro, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
							.addComponent(tekstEmri, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblkWh, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblProfil)
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmri)
						.addComponent(tekstEmri, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMbiemri, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(tekstMbiemri, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblkWh, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblSasia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tekstSasia, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(radiobtnFamiljar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFamiljar))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(radiobtnBiznes, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBiznes, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnPastro, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAfisho, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 205, 170));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 668, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		lblInformacion = new JLabel("INFORMACION!");
		lblInformacion.setVerticalAlignment(SwingConstants.TOP);
		lblInformacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformacion.setForeground(Color.BLACK);
		lblInformacion.setFont(new Font("Tahoma", Font.BOLD, 33));
		Image informacion = new ImageIcon(this.getClass().getResource("/informacion.png")).getImage();
		lblInformacion.setIcon(new ImageIcon(informacion));
		
		lblVariabel = new JLabel("[!] Statusi: Programi eshte aktiv!");
		
		lblVariabel.setVerticalAlignment(SwingConstants.TOP);
		lblVariabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblVariabel.setForeground(Color.BLACK);
		lblVariabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(170)
							.addComponent(lblInformacion, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(37)
							.addComponent(lblVariabel, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(156, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformacion)
					.addGap(43)
					.addComponent(lblVariabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblFatura = new JLabel("Fatura");
		lblFatura.setVerticalAlignment(SwingConstants.TOP);
		lblFatura.setHorizontalAlignment(SwingConstants.LEFT);
		lblFatura.setForeground(Color.BLACK);
		lblFatura.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		Image fatura = new ImageIcon(this.getClass().getResource("/fatura.png")).getImage();
		lblFatura.setIcon(new ImageIcon(fatura));
		
		tekstFatura = new JTextPane();
		tekstFatura.setForeground(Color.BLACK);
		tekstFatura.setFont(new Font("Tahoma", Font.BOLD, 23));
			
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(212, Short.MAX_VALUE)
					.addComponent(lblFatura, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addGap(174))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(46)
					.addComponent(tekstFatura, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFatura)
					.addGap(43)
					.addComponent(tekstFatura, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		
		
		contentPane.setLayout(gl_contentPane);
				
	}
	
	

}
