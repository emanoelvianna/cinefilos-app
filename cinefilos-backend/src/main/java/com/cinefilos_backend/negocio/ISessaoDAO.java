package com.cinefilos_backend.negocio;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.cinefilos_backend.persistencia.DBException;

public interface ISessaoDAO {
	public void cadastrar(Sessao sessao) throws DBException;
	public void excluir(Sessao sessao) throws DBException;
	public Sessao buscarPorCodigo(int codigo) throws DBException;
	public Sessao buscarPorHorario(Time horario) throws DBException;
	public Sessao buscarPorData(Date data) throws DBException;
	public List<Sessao> listarTodas() throws DBException;
}
