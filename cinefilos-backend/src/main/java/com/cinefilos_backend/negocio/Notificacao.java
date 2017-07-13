package com.cinefilos_backend.negocio;

public class Notificacao {
	private int cod_notificacao;
	private char email;
	private char acesso;
	private String mensagem;
	
	public void setCodNotificacao(int cod_notificacao) { this.cod_notificacao = cod_notificacao; }
	public int getCodNotificacao() { return cod_notificacao; }
	public void setEmail(char email) { this.email = email; }
	public char getEmail() { return email; }
	public void setAcesso(char acesso) { this.acesso = acesso; }
	public char getAcesso() { return acesso; }
	public void setMensagem(String mensagem) { this.mensagem = mensagem; }
	public String getMensagem() { return mensagem; }
}
