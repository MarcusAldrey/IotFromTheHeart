package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;

public class DataGenerator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		textField.setText("102");
		textField.setBounds(220, 43, 144, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Frequ\u00EAncia card\u00EDaca");
		lblNewLabel.setBounds(10, 11, 564, 21);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/minus-symbol-inside-a-circle.png")));
		button.setBounds(374, 73, 30, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/plus.png")));
		button_1.setBounds(374, 43, 30, 30);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setBounds(583, 235, 0, 0);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(583, 235, 0, 0);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(583, 235, 0, 0);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("14/8");
		textField_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		textField_1.setBounds(220, 146, 144, 60);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/plus.png")));
		button_3.setBounds(374, 146, 30, 30);
		contentPane.add(button_3);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(DataGenerator.class.getResource("/view/minus-symbol-inside-a-circle.png")));
		button_2.setBounds(374, 176, 30, 30);
		contentPane.add(button_2);
		
		JLabel lblPressoArterial = new JLabel("Press\u00E3o Arterial");
		lblPressoArterial.setBounds(10, 114, 564, 21);
		contentPane.add(lblPressoArterial);
		lblPressoArterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressoArterial.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 217, 564, 21);
		contentPane.add(lblEstado);
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("Em repouso");
		comboBox.addItem("Em movimento");
		comboBox.setBounds(220, 249, 144, 60);
		contentPane.add(comboBox);
	}
}
