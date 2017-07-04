package com.cinefilos_backend.negocio;

import java.sql.Date;

public class Funcionario {
	private int cod_funcionario;
	private String cargo;
	private String nome;
	private Date dataNascimento;
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private char sexo;
	private int telefone;
	Usuario usuario;
	
	public void setCodFuncionario(int cod_funcionario) { this.cod_funcionario = cod_funcionario; }
	public int getCodFuncionario() { return cod_funcionario; }
	public void setCargo(String cargo) { this.cargo = cargo; }
	public String getCargo() { return cargo; }
	public void setNome(String nome) { this.nome = nome; }
	public String getNome() { return nome; }
	public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }
	public Date getDataNascimento() { return dataNascimento; }
	public void setEstado(String estado) { this.estado = estado; }
	public String getEstado() { return estado; }
	public void setCidade(String cidade) { this.cidade = cidade; }
	public String getCidade() { return cidade; }
	public void setBairro(String bairro) { this.bairro = bairro; }
	public String getBairro() { return bairro; }
	public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
	public String getLogradouro() { return logradouro; }
	public void setSexo(char sexo) { this.sexo = sexo; }
	public char getSexo() { return sexo; }
	public void setTelefone(int telefone) { this.telefone = telefone; }
	public int getTelefone() { return telefone; }
	public void setUsuario(Usuario usuario) { this.usuario = usuario; }
	public Usuario getUsuario() { return usuario; }
}
