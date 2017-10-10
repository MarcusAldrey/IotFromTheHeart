package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerMedico;
import control.ControllerServer;
import model.Paciente;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DoctorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPorta;
	private JTextField textPorta;
	private JLabel lblIp;
	private JTextField textIP;
	private String[] pacientesCriticos;
	private JTable table;
	protected JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorView frame = new DoctorView();
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
	public DoctorView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		
		setBounds((screen.width-600)/2, (screen.height-500)/2, 600, 550);
		this.setTitle("Doctor View");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBounds(169, 14, 89, 46);
		btnConectar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ControllerMedico.getInstance().criarConexao(textIP.getText(), Integer.parseInt(textPorta.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel criar conex�o");
					e1.printStackTrace();
					return;
				}
				btnConectar.setText("Conectado");
			}
		});
		contentPane.add(btnConectar);
		
		lblPorta = new JLabel("Porta:");
		lblPorta.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPorta.setBounds(10, 14, 61, 14);
		contentPane.add(lblPorta);
		
		textPorta = new JTextField();
		textPorta.setText("12345");
		textPorta.setColumns(10);
		textPorta.setBounds(59, 11, 100, 20);
		contentPane.add(textPorta);
		
		lblIp = new JLabel("IP:");
		lblIp.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblIp.setBounds(10, 43, 61, 14);
		contentPane.add(lblIp);
		
		textIP = new JTextField();
		textIP.setText("10.0.0.106");
		textIP.setColumns(10);
		textIP.setBounds(59, 40, 100, 20);
		contentPane.add(textIP);
		
		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setBounds(10, 479, 249, 20);
		contentPane.add(comboBox);
		
		JLabel lblPacientesCrticos = new JLabel("Pacientes cr\u00EDticos:");
		lblPacientesCrticos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPacientesCrticos.setBounds(10, 95, 150, 14);
		contentPane.add(lblPacientesCrticos);
		
		JLabel lblOutrosPacientes = new JLabel("Outros pacientes:");
		lblOutrosPacientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOutrosPacientes.setBounds(10, 454, 150, 14);
		contentPane.add(lblOutrosPacientes);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(279, 4, 2, 495);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DoctorView.class.getResource("/view/if_3_2104702.png")));
		label.setBounds(291, 59, 150, 128);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DoctorView.class.getResource("/view/if_100_Pressure_Reading_183415.png")));
		label_1.setBounds(291, 209, 150, 128);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(DoctorView.class.getResource("/view/if_running_172541.png")));
		label_2.setBounds(291, 372, 150, 128);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("0");
		label_3.setFont(new Font("Roboto", Font.PLAIN, 24));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(430, 76, 112, 111);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("0/0");
		label_4.setFont(new Font("Roboto", Font.PLAIN, 24));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(430, 209, 112, 128);
		contentPane.add(label_4);
		
		JLabel lblEmMovimento = new JLabel("...");
		lblEmMovimento.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblEmMovimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmMovimento.setBounds(430, 372, 112, 127);
		contentPane.add(lblEmMovimento);
		
		JLabel lblInformaesDoPaciente = new JLabel("Nenhum paciente selecionado");
		lblInformaesDoPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformaesDoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformaesDoPaciente.setBounds(291, 14, 283, 42);
		contentPane.add(lblInformaesDoPaciente);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 76, 249, 8);
		contentPane.add(separator_1);
				
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(169, 91, 89, 23);
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					pacientesCriticos = ControllerMedico.getInstance().getPacientes();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel receber a lista de clientes");
					e1.printStackTrace();
					return;
				}
				System.out.println(pacientesCriticos.length);
				list = new JList(pacientesCriticos);
				list.setVisibleRowCount(10);
				list.setBounds(10, 144, 249, 299);
				contentPane.add(list);
				list.repaint();
			}
		});
		contentPane.add(btnAtualizar);				
		
		
	}
}
