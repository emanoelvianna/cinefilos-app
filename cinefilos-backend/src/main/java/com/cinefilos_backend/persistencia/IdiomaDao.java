package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinefilos_backend.negocio.IIdiomaDao;
import com.cinefilos_backend.negocio.Idioma;

public class IdiomaDao implements IIdiomaDao {

	@Override
	public Idioma buscarPorCodigo(int codigo) throws DBException {
		Idioma i = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_idioma, nome FROM idiomas WHERE cod_idioma=?";					
			
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1, codigo);
			ResultSet rs = cmd.executeQuery();
			
			while(rs.next()) {
				i = new Idioma();
				i.setCodIdioma(rs.getInt("cod_idioma"));
				i.setNome(rs.getString("nome"));
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new DBException("Falha ao conectar ao BD");
		}
		return i;
	}

}
