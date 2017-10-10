package model;

public class Paciente implements Comparable<Object>{
	
	private int frequencia;
	private int sistole;
	private int diastole;
	private boolean emMovimento;
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(this.getDiastole() > ((Paciente) o).getDiastole())
			return 1;
		else if(this.getSistole() > ((Paciente) o).getSistole())
			return 1;
		else if(this.getFrequencia() > ((Paciente) o).getFrequencia())
			return 1;
		return 0;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public int getSistole() {
		return sistole;
	}

	public void setSistole(int sistole) {
		this.sistole = sistole;
	}

	public int getDiastole() {
		return diastole;
	}

	public void setDiastole(int diastole) {
		this.diastole = diastole;
	}

	public boolean isEmMovimento() {
		return emMovimento;
	}

	public void setEmMovimento(boolean emMovimento) {
		this.emMovimento = emMovimento;
	}
	
}
