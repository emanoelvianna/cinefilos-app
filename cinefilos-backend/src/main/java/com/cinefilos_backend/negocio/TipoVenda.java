package com.cinefilos_backend.negocio;

public class TipoVenda {
	private int cod_tipo_venda;
	private String descricao;
	
	public void setCodTipoVenda(int cod_tipo_venda) { this.cod_tipo_venda = cod_tipo_venda; }
	public int getCodTipoVenda() { return cod_tipo_venda; }
	public void setDescricao(String descricao) { this.descricao = descricao; }
	public String getDescricao() { return descricao; }
}
