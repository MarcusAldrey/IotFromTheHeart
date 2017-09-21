package control;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.DataGenerator;
import view.DoctorView;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		JFrame frame = new DataGenerator();
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
		frame.setVisible(true);
	}

}
