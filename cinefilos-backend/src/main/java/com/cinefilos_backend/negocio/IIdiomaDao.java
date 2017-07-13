package com.cinefilos_backend.negocio;

import com.cinefilos_backend.persistencia.DBException;

public interface IIdiomaDao {
	public Idioma buscarPorCodigo(int codigo) throws DBException;
}
