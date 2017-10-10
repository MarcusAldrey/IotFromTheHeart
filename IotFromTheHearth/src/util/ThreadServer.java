package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

import control.ControllerMedico;
import control.ControllerServer;
import exceptions.MensagemInvalidaException;
import model.Paciente;

public class ThreadServer extends Thread {

	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public ThreadServer(Socket socket) throws IOException {
		// TODO Auto-generated constructor stub
		this.setSocket(socket);
		this.input = new ObjectInputStream(socket.getInputStream());
		this.output = new ObjectOutputStream(socket.getOutputStream());
	}

	public void enviarMensagem(Object object) throws IOException{
		output.writeObject(object);
	}

	public Object receberMensagem() throws ClassNotFoundException, IOException{
		return input.readObject();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				String[] mensagem = ((String) input.readObject()).split(","); //Divide a mensagem onde tem vírgula
				//System.out.println(ControllerServer.getInstance().getPacientes().size());
				//for(String m : mensagem)
				//System.out.println(m);
				/*Caso a mensagem venha de um sensor*/
				if(mensagem[0].equals("connect sensor")) {
					if(mensagem.length != 6) {
						System.out.println("Mensagem inválida recebida"); //Se a mensagem possuir a estrutura errada ela não será processada
						return;
					}
					String nome = mensagem[1];
					int sistole = Integer.parseInt(mensagem[2]);
					int diastole = Integer.parseInt(mensagem[3]);
					int frequencia = Integer.parseInt(mensagem[4]);
					String emMovimento = mensagem[5];
					List<Paciente> pacientes = ControllerServer.getInstance().getPacientes();
					Iterator<Paciente> iterator = pacientes.iterator();
					boolean estaNaLista = false;
					/*Caso o paciente já esteja na lista, os valores serão atualizados*/
					while(iterator.hasNext()) {
						Paciente paciente = (Paciente) iterator.next();
						if(paciente.getNome().equals(nome)) {
							paciente.setSistole(sistole);
							paciente.setDiastole(diastole);
							paciente.setFrequencia(frequencia);
							paciente.setEmMovimento(emMovimento);
							estaNaLista = true;
							break;
						}
					}
					/*Caso o paciente não esteja na lista, será adicionado*/
					if(estaNaLista == false) {
						Paciente novo = new Paciente(nome, frequencia, sistole, diastole, emMovimento);
						ControllerServer.getInstance().adicionarPaciente(novo);
					}
					//for(Paciente paciente : pacientes)
						//System.out.println(paciente.getNome()+","+paciente.getSistole()+","+paciente.getDiastole()+","+paciente.getFrequencia()+","+paciente.isEmMovimento());
				}
				
				/*Caso a mensagem venha de um médico*/
				else if(mensagem[0].equals("connect medico")) {
					/* Caso a mensagem seja de um médico, será verificado se ele quer todos os pacientes ou algum especifico */
					if(mensagem[1].equals("info")) {
						/* Caso queira todos, recebera a lista de pacientes, ordenada por risco */
						if(mensagem[2].equals("todos")) {
							String todosOsPacientes = "";
							List<Paciente> pacientes = ControllerServer.getInstance().getPacientes();
							Iterator<Paciente> iterator = pacientes.iterator();
							while(iterator.hasNext()) {
								Paciente paciente = (Paciente) iterator.next();
								String nomePacienteAtual = paciente.getNome();
								todosOsPacientes = todosOsPacientes.concat(nomePacienteAtual+",");					
							}
							System.out.println(todosOsPacientes);
							output.writeObject(todosOsPacientes);
						}
						/* Caso queira algum especifico, receberá o objeto do paciente */
						else {
							List<Paciente> pacientes = ControllerServer.getInstance().getPacientes();
							Iterator<Paciente> iterator = pacientes.iterator();
							boolean pacienteEncontrado = false;
							System.out.println("Recebeu o nome " + mensagem[2]);
							while(iterator.hasNext()) {
								Paciente paciente = (Paciente) iterator.next();
								if(paciente.getNome().equals(mensagem[2])) {
									output.writeObject(paciente.getSistole()+","+paciente.getDiastole()+","+paciente.getFrequencia()+","+paciente.isEmMovimento());
									pacienteEncontrado = true;
									break;
								}
							}
							if(pacienteEncontrado == false)
								output.writeObject("paciente nao encontrado");
						}
					}
				}
				else
					System.out.println("Mensagem inválida recebida");
				
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
