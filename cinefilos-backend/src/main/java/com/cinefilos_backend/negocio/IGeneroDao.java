package com.cinefilos_backend.negocio;

import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface IGeneroDao {
	public void cadastrar(Genero genero) throws DBException;
	public Genero buscaPorNome(String nome) throws DBException;
	public Genero buscaPorCodigo(int codigo) throws DBException;
	public void excluir(Genero genero) throws DBException;
	public List<Genero> listarTodos() throws DBException;
}
