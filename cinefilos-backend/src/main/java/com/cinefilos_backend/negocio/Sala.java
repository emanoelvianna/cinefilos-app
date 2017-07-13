package com.cinefilos_backend.negocio;

public class Sala {
	private int cod_sala;
	private int numero;
	private int lugares;
	private int status;
	private int fileiras;
	
	public void setCodSala(int cod_sala) { this.cod_sala = cod_sala; }
	public int getCodSala() { return cod_sala; }
	public void setNumero(int numero) { this.numero = numero; }
	public int getNumero() { return numero; }
	public void setLugares(int lugares) { this.lugares = lugares; }
	public int getLugares() { return lugares; }
	public void setStatus(int status) { this.status = status; }
	public int getStatus() { return status; }
	public void setFileiras(int fileiras) { this.fileiras = fileiras; }
	public int getFileiras() { return fileiras; }
}
