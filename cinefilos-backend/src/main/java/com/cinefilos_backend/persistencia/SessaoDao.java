package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.cinefilos_backend.negocio.IIdiomaDao;
import com.cinefilos_backend.negocio.ISessaoDAO;
import com.cinefilos_backend.negocio.Sessao;

public class SessaoDao implements ISessaoDAO {

	@Override
	public void cadastrar(Sessao sessao) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "INSERT INTO sessoes (horario_sessao, data_sessao, cod_filme, cod_sala, cod_idioma, legendado) " +
						"VALUES (?, ?, ?, ?, ?, ?)";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setTime(1, sessao.getHorario());
			cmd.setDate(2, sessao.getData());
			cmd.setInt(3, sessao.getFilme().getCodFilme());
			cmd.setInt(4,  sessao.getSala().getCodSala());
			cmd.setInt(5, sessao.getIdioma().getCodIdioma());
			cmd.setInt(6, sessao.getLegendado());
			cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			throw new DBException("Falha ao conectar ao BD");
		}
		
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

		IIdiomaDao idiomaDao = new IdiomaDao();
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_sessao, horario_sessao, data_sessao, cod_filme, "+
						"cod_sala, cod_idioma, legendado FROM sessoes";
					
			Statement cmd = conn.createStatement();
			ResultSet rs = cmd.executeQuery(sql);
			
			while(rs.next()) {
				s = new Sessao();

				FilmeDAO filmeDAO = new FilmeDAO();
				SalaDao salaDao = new SalaDao();
				
				s.setCodSessao(rs.getInt("cod_sessao"));
				s.setHorario(rs.getTime("horario_sessao"));
				s.setData(rs.getDate("data_sessao"));
				s.setIdioma(idiomaDao.buscarPorCodigo(rs.getInt("cod_idioma")));
				s.setFilme(filmeDAO.buscarPorCodigo(rs.getInt("cod_filme")));
				s.setSala(salaDao.buscarPorCodigo(rs.getInt("cod_sala")));
				s.setLegendado(rs.getInt("legendado"));
				lista.add(s);
			}
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return lista;

	
	
	}

}
