package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Sensor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JSeparator;

public class DataGenerator extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFreq;
	private JTextField textPress;
	private int di = 12, si = 8, freq = 80;
	private JButton btnAddDi;
	private JButton btnLessDi;
	private JButton btnLessSi;
	private JButton btnLessFreq;
	private JButton btnAddFreq;
	private JButton btnAddSi;
	private JTextField textPorta;
	private JTextField textIP;
	private boolean estaTransmitindo;
	private JButton btnStartStop;
	private Timer timer;
	private JTextField txtNome;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataGenerator frame = new DataGenerator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public DataGenerator() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		
		setBounds((screen.width-600)/2, (screen.height-500)/2, 600, 500);
		contentPane = new JPanel();
		this.setTitle("Data generator");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		textFreq = new JTextField();
		textFreq.setBackground(Color.WHITE);
		textFreq.setHorizontalAlignment(SwingConstants.CENTER);
		textFreq.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		textFreq.setText("80");
		textFreq.setBounds(220, 32, 144, 60);
		contentPane.add(textFreq);
		textFreq.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Frequ\u00EAncia card\u00EDaca");
		lblNewLabel.setBounds(10, 0, 564, 21);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		btnLessFreq = new JButton("");
		btnLessFreq.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/minus-symbol-inside-a-circle.png")));
		btnLessFreq.setBounds(374, 62, 30, 30);
		btnLessFreq.addActionListener(this);
		contentPane.add(btnLessFreq);
		
		btnAddFreq = new JButton("");
		btnAddFreq.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/plus.png")));
		btnAddFreq.setBounds(374, 32, 30, 30);
		btnAddFreq.addActionListener(this);
		contentPane.add(btnAddFreq);
		
		JLabel label = new JLabel("");
		label.setBounds(583, 235, 0, 0);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(583, 235, 0, 0);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(583, 235, 0, 0);
		contentPane.add(label_2);
		
		textPress = new JTextField();
		textPress.setHorizontalAlignment(SwingConstants.CENTER);
		textPress.setText("12/8");
		textPress.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		textPress.setBounds(220, 148, 144, 60);
		contentPane.add(textPress);
		textPress.setColumns(10);
		
		btnAddSi = new JButton("");
		btnAddSi.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/plus.png")));
		btnAddSi.setBounds(374, 148, 30, 30);
		btnAddSi.addActionListener(this);
		contentPane.add(btnAddSi);
		
		btnLessSi = new JButton("");
		btnLessSi.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/minus-symbol-inside-a-circle.png")));
		btnLessSi.setBounds(374, 178, 30, 30);
		btnLessSi.addActionListener(this);
		contentPane.add(btnLessSi);
		
		JLabel lblPressoArterial = new JLabel("Press\u00E3o Arterial");
		lblPressoArterial.setBounds(10, 116, 564, 21);
		contentPane.add(lblPressoArterial);
		lblPressoArterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressoArterial.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 238, 564, 21);
		contentPane.add(lblEstado);
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("Em repouso");
		comboBox.addItem("Em movimento");
		comboBox.setBounds(220, 270, 144, 60);
		contentPane.add(comboBox);
		
		btnAddDi = new JButton("");
		btnAddDi.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/plus.png")));
		btnAddDi.setBounds(180, 148, 30, 30);
		btnAddDi.addActionListener(this);
		contentPane.add(btnAddDi);
		
		btnLessDi = new JButton("");
		btnLessDi.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/minus-symbol-inside-a-circle.png")));
		btnLessDi.setBounds(180, 178, 30, 30);
		btnLessDi.addActionListener(this);
		contentPane.add(btnLessDi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 116, 564, 8);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 235, 564, 8);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 341, 564, 8);
		contentPane.add(separator_2);
		
		JLabel lblInformaesDeConexo = new JLabel("Informa\u00E7\u00F5es de conex\u00E3o");
		lblInformaesDeConexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformaesDeConexo.setBounds(10, 360, 159, 14);
		contentPane.add(lblInformaesDeConexo);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(10, 385, 46, 14);
		contentPane.add(lblPorta);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(10, 410, 46, 14);
		contentPane.add(lblIp);
		
		textPorta = new JTextField();
		textPorta.setText("12345");
		textPorta.setBounds(42, 382, 86, 20);
		contentPane.add(textPorta);
		textPorta.setColumns(10);
		
		textIP = new JTextField();
		textIP.setText("10.0.0.106");
		textIP.setColumns(10);
		textIP.setBounds(42, 407, 86, 20);
		contentPane.add(textIP);
		
		btnStartStop = new JButton("Iniciar transmiss\u00E3o");
		btnStartStop.setBounds(220, 381, 144, 43);
		btnStartStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(estaTransmitindo) {
					estaTransmitindo = false;
					btnStartStop.setText("Iniciar Transmiss�o");
					btnStartStop.setForeground(Color.BLACK);
					textIP.setEditable(true);
					textPorta.setEditable(true);
					textIP.setEnabled(true);
					textPorta.setEnabled(true);
					timer.cancel();
					System.out.println("Tramiss�o cancelada");
				}
				else {
					try {
						new Sensor(textIP.getText(), Integer.parseInt(textPorta.getText()));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Algo inesperado aconteceu.");
						e1.printStackTrace();
						return;
					}
					textIP.setEditable(false);
					textPorta.setEditable(false);
					textIP.setEnabled(false);
					textPorta.setEnabled(false);
					estaTransmitindo = true;
					btnStartStop.setText("Transmitindo");
					btnStartStop.setForeground(Color.DARK_GRAY);
					timer = new Timer();
					timer.schedule(new Transmissao(),0,2000);
					System.out.println("Tramiss�o iniciada");
				}					
			}
		});
		contentPane.add(btnStartStop);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 438, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setText("Jo\u00E3o");
		txtNome.setColumns(10);
		txtNome.setBounds(42, 435, 86, 20);
		contentPane.add(txtNome);
	}
	
	private void enviarDados(String mensagem) {
		System.out.println(mensagem);
	}
	
	private void atualizarTextos() {
		textPress.setText(di + "/" + si);	
		textFreq.setText(Integer.toString(freq));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnAddFreq)) {
			freq+=1;
		}
		if(e.getSource().equals(btnLessFreq)) {
			freq-=1;
		}
		if(e.getSource().equals(btnAddSi)) {
			si+=1;
		}
		if(e.getSource().equals(btnLessSi)) {
			si-=1;
		}
		if(e.getSource().equals(btnAddDi)) {
			di+=1;
		}
		if(e.getSource().equals(btnLessDi)) {
			di-=1;
		}
		atualizarTextos();
	}
	
	private class Transmissao extends TimerTask {
        public void run() {
            System.out.println("Sensor " + txtNome.getText() + " enviou " + di + "/" + si + "  " + freq);
        }
    }
}
