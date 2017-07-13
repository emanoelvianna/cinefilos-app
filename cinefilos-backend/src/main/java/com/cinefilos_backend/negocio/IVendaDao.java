package com.cinefilos_backend.negocio;

import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface IVendaDao {
	public void cadastrar(Venda venda, Funcionario funcionario) throws DBException;
	public Venda buscaPorCodigo(int codigo) throws DBException;
	public void excluir(Venda venda) throws DBException;
	public List<Venda> listarTodos() throws DBException;	
}
