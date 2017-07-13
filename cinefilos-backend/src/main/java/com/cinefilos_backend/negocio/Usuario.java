package com.cinefilos_backend.negocio;

public class Usuario {
	private int cod_usuario;
	private String login;
	private String senha;
	private int permissao;
	
	public int getCodUsuario() { return cod_usuario; }
	public void setCodUsuario(int cod_usuario_p) { cod_usuario = cod_usuario_p; }
	public String getLogin() { return login; }
	public void setLogin(String login_p) { login = login_p; }
	public String getSenha() { return senha; }
	public void setSenha(String senha_p) { senha = senha_p; }
	public int getPermissao() { return permissao; }
	public void setPermissao(int permissao_p) { permissao = permissao_p; }
}
