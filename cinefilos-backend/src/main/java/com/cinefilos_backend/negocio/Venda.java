package com.cinefilos_backend.negocio;

import java.sql.Date;

public class Venda {
	private int cod_venda;
	private Date data;
	private int formaPagamento;
	Funcionario funcionario;
	
	public void setCodVenda(int cod_venda) { this.cod_venda = cod_venda; }
	public int getCodVenda() { return cod_venda; }
	public void setData(Date data) { this.data = data; }
	public Date getData() { return data; }
	public void setFormaPagamento(int formaPagamento) { this.formaPagamento = formaPagamento; }
	public int getFormaPagamento() { return formaPagamento; }
	public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
	public Funcionario getFuncionario() { return funcionario; }
}
