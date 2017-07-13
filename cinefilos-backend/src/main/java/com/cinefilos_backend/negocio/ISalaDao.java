package com.cinefilos_backend.negocio;

import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface ISalaDao {
	public void cadastrar(Sala sala) throws DBException;
	public void excluir(Sala sala) throws DBException;
	public Sala buscarPorCodigo(int codigo) throws DBException;
	public Sala buscarPorStatus(int status) throws DBException;
	public List<Sala> listarTodas() throws DBException;
}
