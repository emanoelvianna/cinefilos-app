package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cinefilos_backend.negocio.IIngressoDao;
import com.cinefilos_backend.negocio.Ingresso;
import com.cinefilos_backend.negocio.Venda;

public class IngressoDao implements IIngressoDao {

	@Override
	public void cadastrarIngresso(Ingresso ingresso) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			PreparedStatement cmd;
			String sql;
			//String sql = "BEGIN TRANSACTION;";

			/*
			 * Inserir registro na tabela de vendas 
			 */			
			
			//cmd = conn.prepareStatement(sql);
			//cmd.executeUpdate();
			
			sql = "INSERT INTO ingresso (valor, no_assento, promocao, necessidades_especiais, cod_sessao) " +
						"VALUES (?, ?, ?, ?, ?)";
			
			cmd = conn.prepareStatement(sql);
			cmd.setDouble(1, ingresso.getValor());
			cmd.setInt(2, ingresso.getNumeroAssento());
			cmd.setBoolean(3, ingresso.isPromocao());
			cmd.setBoolean(4, ingresso.isNecessidadeEspecial());
			cmd.setInt(5, ingresso.getSessao().getCodSessao());
			cmd.executeUpdate();
			
			/*
			 * Inserir ingresso como um item de uma venda
			 */			
			
			//sql = "COMMIT";
			//cmd = conn.prepareStatement(sql);
			//cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			throw new DBException("Falha ao conectar ao BD");
		}
		
	}

	@Override
	public void excluirIngresso(Ingresso ingresso) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ingresso buscarIngressoPorCodigo(int codigo) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingresso BuscarIngressoPelaVenda(Venda venda) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNotaFiscal(Ingresso ingresso) throws DBException {
		// TODO Auto-generated method stub
		return 0;
	}

}
