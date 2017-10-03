package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Controller {
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private static Controller instance;

	private Controller() {

	}

	public static Controller getInstance(){
		if(instance == null)
			instance = new Controller();
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
