package com.cinefilos_backend.negocio;

import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface IUsuarioDao {
	public void cadastrar(Usuario usuario) throws DBException;
	public Usuario buscarPorCodigo(int codigo) throws DBException;
	public void excluirUsuario(Usuario usuario) throws DBException;
	public void atualizar(Usuario usuario) throws DBException;
	public List<Usuario> listarTodos() throws DBException;
}
