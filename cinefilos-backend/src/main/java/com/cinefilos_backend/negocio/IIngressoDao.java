package com.cinefilos_backend.negocio;

import com.cinefilos_backend.persistencia.DBException;

public interface IIngressoDao {
	public void cadastrarIngresso(Ingresso ingresso) throws DBException;
	public void excluirIngresso(Ingresso ingresso) throws DBException;
	public Ingresso buscarIngressoPorCodigo(int codigo) throws DBException;
	public Ingresso BuscarIngressoPelaVenda(Venda venda) throws DBException;
	public int getNotaFiscal(Ingresso ingresso) throws DBException;
}
