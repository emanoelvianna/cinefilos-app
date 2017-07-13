package com.cinefilos_backend.negocio;

import com.cinefilos_backend.persistencia.DBException;

public interface ICartaoCreditoDao {
	public void cadastrar(CartaoCredito cartao) throws DBException;
	public void excluir(CartaoCredito cartao) throws DBException;
	public CartaoCredito buscarPorCodigo(int codigo) throws DBException;
	public CartaoCredito buscarPorNumero(int numero) throws DBException;
}
