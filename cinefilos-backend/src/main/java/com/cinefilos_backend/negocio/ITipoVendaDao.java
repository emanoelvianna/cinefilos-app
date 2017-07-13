package com.cinefilos_backend.negocio;

import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface ITipoVendaDao {
	public void cadastrar(Venda venda) throws DBException;
	public Venda buscarPorCodigo(int codigo) throws DBException;
	public void excluir(Venda venda) throws DBException;
	public List<Venda> listarTodos() throws DBException;
}
