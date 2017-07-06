package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cinefilos_backend.negocio.ISalaDao;
import com.cinefilos_backend.negocio.Sala;

public class SalaDao implements ISalaDao {

	@Override
	public void cadastrar(Sala sala) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Sala sala) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sala buscarPorCodigo(int codigo) throws DBException {
		Sala s = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_sala, numero, lugares, status, fileiras "
					+ "FROM salas WHERE cod_sala=?";					
			
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1, codigo);
			ResultSet rs = cmd.executeQuery();
			
			while(rs.next()) {
				s = new Sala();
				s.setCodSala(rs.getInt("cod_sala"));
				s.setNumero(rs.getInt("numero"));
				s.setLugares(rs.getInt("lugares"));
				s.setStatus(rs.getInt("status"));
				s.setFileiras(rs.getInt("fileiras"));
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new DBException("Falha ao conectar ao BD");
		}
		return s;

	}

	@Override
	public Sala buscarPorStatus(int status) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sala> listarTodas() throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

}
