package com.cinefilos_backend.negocio;
import java.sql.Date;
import java.sql.Time;

public class Sessao {
	private int cod_sessao;
	private Time horario;
	private Date data;
	Filme filme;
	Sala sala;
	private int cod_idioma;
	private char legendado;
	
	public void setCodSessao(int cod_sessao) { this.cod_sessao = cod_sessao; }
	public int getCodSessao() { return cod_sessao; }
	public void setHorario(Time horario) { this.horario = horario; }
	public Time getHorario() { return horario; }
	public void setData(Date data) { this.data = data; }
	public Date getData() { return data; }
	public void setFilme(Filme filme) { this.filme = filme; }
	public Filme getFile() { return filme; }
	public void setSala(Sala sala) { this.sala = sala; }
	public Sala getSala() { return sala; }
	public void setCodIdioma(int cod_idioma) { this.cod_idioma = cod_idioma; }
	public int getCodIdioma() { return cod_idioma; }
	public void setLegendado(char legendado) { this.legendado = legendado; }
	public char getLegendado() { return legendado; }
}
