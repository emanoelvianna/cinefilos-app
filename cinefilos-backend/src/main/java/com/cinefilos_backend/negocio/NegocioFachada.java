package com.cinefilos_backend.negocio;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.cinefilos_backend.persistencia.DBException;
import com.cinefilos_backend.persistencia.FilmeDAO;
import com.cinefilos_backend.persistencia.UsuarioDao;
import com.cinefilos_backend.negocio.Filme;
import com.google.gson.Gson;


@Path("/")
public class NegocioFachada {
	public static final String CINEFILOS_BACKEND_CONFIG = "//opt//cinefilos//etc//cinefilos-backend-config.json";
	public BackendConfig backendConfig = BackendConfig.loadConfig(CINEFILOS_BACKEND_CONFIG);
	public Backup backup = new Backup();
	
	@Inject
	
	@GET
	@Path("/helloworld")
	@Produces({ "application/json" })
	public String hello() {
		return "{ \"message\": \"Hello Cinefilos!\"}";		
	}
	
	@GET
	@Path("/filmes/listar")
	@Produces({ "application/json" })
	public String buscarTodosFilmes() {
		IFilmesDAO db = new FilmeDAO();
		Gson gson = new Gson();
		String json = null;
		
		List<Filme> filmes = null;
		
		try {
			filmes = db.listarTodos();
			json = gson.toJson(filmes);
		} catch(DBException e) {
			return "{ \"message\": \"Erro ao conectar no BD.\" }";
		}
		return "{ \"filmes\": " + json + "}";
	}
	
	
	@POST
	@Path("/filmes/cadastrar")
	@Consumes({ "application/json"})
	public Response cadastrarFilme(Filme filme) {
		String result = "Filme criado " + filme;
		
		IFilmesDAO db = new FilmeDAO();
		System.out.println("Criando filme ....");
		
		try {
			db.cadastrar(filme);
		} catch(DBException e) {
			result = "Falha ao criar filme";
			return Response.status(400).entity(result).build();
		}
		
		return Response.status(201).entity(result).build();
	}
	
	
	@PUT
	@Path("/filmes/atualizar")
	@Consumes({ "application/json" })
	public Response atualizarFilme(Filme filme) {
		String result = "Filme " + filme.getTitulo() + " atualizado";
		
		IFilmesDAO db = new FilmeDAO();
		
		try {
			db.atualizar(filme);
		} catch(DBException e) {
			result = "Falha ao criar filme";
			return Response.status(400).entity(result).build();
		}
		
		return Response.status(201).entity(result).build();

	}
	
	
	@DELETE
	@Path("/filmes/excluir")
	@Consumes({ "application/json" })
	public Response excluirFilme(Filme filme) {
		String result = "Filme " + filme.getTitulo() + " excluido";
		
IFilmesDAO db = new FilmeDAO();
		
		try {
			db.excluir(filme);
		} catch(DBException e) {
			result = "Falha ao excluir filme";
			return Response.status(400).entity(result).build();
		}
		
		return Response.status(200).entity(result).build();
	}
	

	/*
	 * Usuario
	 */
	
	@GET
	@Path("/usuarios/listar")
	@Produces({ "application/json" })
	public String buscarTodosUsuarios() {
		IUsuarioDao db = new UsuarioDao();
		Gson gson = new Gson();
		String json = null;
		
		List<Usuario> usuarios = null;
		
		try {
			usuarios = db.listarTodos();
			json = gson.toJson(usuarios);
		} catch(DBException e) {
			return "{ \"message\": \"Erro ao conectar no BD.\" }";
		}
		return "{ \"usuarios\": " + json + "}";
	}
	
	
	@POST
	@Path("/usuarios/cadastrar")
	@Consumes({ "application/json"})
	public Response cadastrarUsuario(Usuario usuario) {
		String result = "Usuario criado " + usuario;
		
		IUsuarioDao db = new UsuarioDao();
		System.out.println("Criando usuario ....");
		
		try {
			db.cadastrar(usuario);
		} catch(DBException e) {
			result = "Falha ao criar usuario";
			return Response.status(400).entity(result).build();
		}
		
		return Response.status(201).entity(result).build();
	}
	
	
	@PUT
	@Path("/usuarios/atualizar")
	@Consumes({ "application/json" })
	public Response atualizarUsuario(Usuario usuario) {
		String result = "Usuario " + usuario.getLogin() + " atualizado";
		
		IUsuarioDao db = new UsuarioDao();
		
		try {
			db.atualizar(usuario);
		} catch(DBException e) {
			result = "Falha ao criar filme";
			return Response.status(400).entity(result).build();
		}
		
		return Response.status(201).entity(result).build();

	}
	
	
	@DELETE
	@Path("/usuarios/excluir")
	@Consumes({ "application/json" })
	public Response excluir(Usuario usuario) {
		String result = "Usuario " + usuario.getLogin() + " excluido";
		
		IUsuarioDao db = new UsuarioDao();
		
		try {
			db.excluirUsuario(usuario);
		} catch(DBException e) {
			result = "Falha ao excluir usuario";
			return Response.status(400).entity(result).build();
		}
		
		return Response.status(200).entity(result).build();
	}
	
	
	/*
	 * 
	 * Backup
	 * 
	 */
	
	@GET
	@Path("/fazerBackup")
	@Produces({ "application/json" })
	public String fazerBackup() {
		return backup.fazerBackup();		
	}
	
	@GET
	@Path("/listarBackup")
	@Produces({ "application/json" })
	public String listarBackup() {
		return backup.listarBackup();
	}
	
	
	@GET
	@Path("/restaurarBackup/{filename}")
	@Produces({ "application/json" })
	public String restaurarBackup(@PathParam("filename") String input) {
		return backup.restaurarBackup(input);
	}
}
