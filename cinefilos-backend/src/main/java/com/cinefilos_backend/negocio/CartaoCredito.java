package com.cinefilos_backend.negocio;

import java.util.Date;

public class CartaoCredito {
	private int numero;
	private Date dataValidade;
	private String bandeira;
	private int cw;
	Cliente cliente;
	
	public void setNumero(int numero) { this.numero = numero; }
	public int getNumer() { return numero; }
	public void setDataValidade(Date dataValidade) { this.dataValidade = dataValidade; }
	public Date getDataValidade() { return dataValidade; }
	public void setBandeira(String bandeira) { this.bandeira = bandeira; }
	public String getBandeira() { return bandeira; }
	public void setCw(int cw) { this.cw = cw; }
	public int getCw() { return cw; }
}
