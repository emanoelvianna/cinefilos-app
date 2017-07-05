package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.cinefilos_backend.negocio.Filme;
import com.cinefilos_backend.negocio.ISessaoDAO;
import com.cinefilos_backend.negocio.Sessao;

public class SessaoDao implements ISessaoDAO {

	@Override
	public void cadastrar(Sessao sessao) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Sessao sessao) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sessao buscarPorCodigo(int codigo) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sessao buscarPorHorario(Time horario) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sessao buscarPorData(Date data) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sessao> listarTodas() throws DBException {
		List<Sessao> lista = new ArrayList<Sessao>();
		Sessao s = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_sessao, horario_sessao, data_sessao, cod_filme, "+
						"cod_sala, cod_idioma, legendado FROM sessoes";
					
			Statement cmd = conn.createStatement();
			ResultSet rs = cmd.executeQuery(sql);
			
			while(rs.next()) {
				s = new Sessao();
				FilmeDAO filmeDAO = new FilmeDAO();
				s.setCodSessao(rs.getInt("cod_sessao"));
				s.setHorario(rs.getTime("horario_sessao"));
				s.setData(rs.getDate("data_sessao"));
				s.setCodIdioma(rs.getInt("cod_idioma"));
				s.setFilme(filmeDAO.buscarPorCodigo(rs.getInt("cod_filme")));
				//s.setLegendado(rs.getCharacterStream("legendado"));
				lista.add(s);
			}
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return lista;

	
	
	}

}
