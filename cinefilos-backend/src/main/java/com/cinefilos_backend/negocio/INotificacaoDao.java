package com.cinefilos_backend.negocio;

import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface INotificacaoDao {
	public void cadastrar(Notificacao notificacao) throws DBException;
	public void excluir(Notificacao notificacao) throws DBException;
	public Notificacao buscarPorCodigo(int codigo) throws DBException;
	public List<Notificacao> buscarTodas() throws DBException;
}
