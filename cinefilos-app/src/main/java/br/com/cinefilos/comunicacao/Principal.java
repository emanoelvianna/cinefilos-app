package br.com.cinefilos.comunicacao;

import java.sql.Connection;

import br.com.cinefilos.persistencia.Conexao;

public class Principal {
	public static void main(String[] args) throws Exception {
		Connection connection = Conexao.getConnection();
		
	}
}
