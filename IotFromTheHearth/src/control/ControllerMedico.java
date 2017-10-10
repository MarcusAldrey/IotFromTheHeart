package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import exceptions.MedicoNaoEncontradoException;
import model.Paciente;

public class ControllerMedico {
	
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private static ControllerMedico instance;
	private List<Paciente> pacientes;
	
	private ControllerMedico() {
	}
	
	public void criarConexao(String IP, int porta) throws IOException {
		socket = new Socket(IP,porta);
		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());
	}
	
	public static ControllerMedico getInstance() {
		if(instance == null)
			instance = new ControllerMedico();
		return instance;
	}
	
	public void logar(String usuario, String senha) throws IOException, MedicoNaoEncontradoException, ClassNotFoundException {
		output.writeObject("CONNECT MEDICO,LOGIN,"+usuario+","+senha);
		while(true){
			if(input.readObject() == "true")
				throw new MedicoNaoEncontradoException();
			return;
		}
	}
	
	public Paciente receberPacientedoServidor(Integer id) {
		return null;
	}
	
	public List<Paciente> receberPacientesdoServidor() {
		return null;
	}

	/**
	 * @return the pacientes
	 */
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	/**
	 * @param pacientes the pacientes to set
	 */
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	
		
}
