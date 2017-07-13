package com.cinefilos_backend.negocio;

import java.util.List;
import com.cinefilos_backend.persistencia.DBException;



public interface IFilmeDao {
	public void cadastrar(Filme filme) throws DBException;
	public void excluir(Filme filme) throws DBException;
	public void atualizar(Filme filme) throws DBException;
	public Filme buscarPorNome(String nome) throws DBException;
	public Filme buscarPorCodigo(int codigo) throws DBException;
	public List<Filme> listarTodos() throws DBException;
}
