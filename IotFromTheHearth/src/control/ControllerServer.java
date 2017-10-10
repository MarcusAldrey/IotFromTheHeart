package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Medico;
import model.Paciente;

public class ControllerServer {
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private static ControllerServer instance;
	private static List<Medico> medicos = new ArrayList<Medico>();
	private static List<Paciente> pacientes = new ArrayList<Paciente>();

	private ControllerServer() {

	}

	public static ControllerServer getInstance(){
		if(instance == null)
			instance = new ControllerServer();
		return instance;		 
	}

	public void enviarMensagem(String mensagem) throws IOException {
		output.writeObject(mensagem);
		output.flush();
	}

	public void criarConexao(String IP, int porta) throws IOException {
		socket = new Socket(IP,porta);
		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());
	}

	public Object receberMensagem() throws ClassNotFoundException, IOException{
		return input.readObject();
	}
}
