package com.cinefilos_backend.negocio;

import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface IFuncionarioDao {
	public void cadastrar(Funcionario funcionario) throws DBException;
	public void excluir(Funcionario funcionario) throws DBException;
	public Funcionario buscarPorCodigo(int codigo) throws DBException;
	public Funcionario buscarPorNome(String nome) throws DBException;
	public List<Funcionario> buscarTodos() throws DBException;
}
