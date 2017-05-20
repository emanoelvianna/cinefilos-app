using cinefilos.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Cinefilos.Models
{
    public class Sessao
    {

        public enum Dias { DOMINGO, SEGUNDA, QUARTA, QUINTA, SEXTA, SABADO }

        [Key]
        public int Id_sessao { get; set; }

        public int Id_filmes { get; set; }
        public virtual Filmes Filme { get; set; }

        public int Id_sala { get; set; }
        public virtual Salas Sala { get; set; }

        public DateTime Horario_i { get; set; }

        public DateTime Horario_f { get; set; }

        public Dias Dia { get; set; }

        public DateTime Duracao { get; set; }

      

    }
}