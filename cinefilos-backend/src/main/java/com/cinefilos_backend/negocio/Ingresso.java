package com.cinefilos_backend.negocio;

public class Ingresso {
	private int cod_ingresso;
	private double valor;
	private int numeroAssento;
	private boolean promocao;
	private int notaFiscal;
	private boolean necessidadeEspecial;
	private Sessao sessao;
	
	public void setCodIngresso(int cod_ingresso) { this.cod_ingresso = cod_ingresso; }
	public int getCodIngresso() { return cod_ingresso; }
	
	public void setValor(double valor) { this.valor = valor; }
	public double getValor() { return valor; }
	
	public void setNumeroAssento(int numeroAssento) { this.numeroAssento = numeroAssento; }
	public int getNumeroAssento() { return numeroAssento; }
	
	public void setPromocao(boolean promocao) { this.promocao = promocao; }
	public boolean isPromocao() { return promocao; }
	
	public void setNotaFiscal(int notaFiscal) { this.notaFiscal = notaFiscal; }
	public int getNotaFiscal() { return notaFiscal; }
	
	public void setNecessidadeEspecial(boolean necessidadeEspecial) { this.necessidadeEspecial = necessidadeEspecial; }
	public boolean isNecessidadeEspecial() { return necessidadeEspecial; }
	
	public void setSessao(Sessao sessao) { this.sessao = sessao; }
	public Sessao getSessao() { return sessao; }
}
