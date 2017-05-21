using cinefilos.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Cinefilos.Models
{
    public class Ingressos
    {
        [Key]
        public int Id_ingresso { get; set; }

        [Display(Name ="Id")]
        public int Id_sessao { get; set; }
        public virtual Sessao Sessao { get; set; }

        [Display(Name = "Horario")]
        public TimeSpan Horario { get; set; }

        //[Display(Name = "Sala")]
        //public int Id_sala { get; set; }
        public virtual  Salas Sala  { get; set; }

        //[Display(Name = "Poltrona")]
        //public int Id { get; set; }
        public virtual Poltronas Poltrona { get; set; }

        [Display(Name = "Valor")]
        public decimal Valor { get; set; }

        public int Id_venda { get; set; }
        public virtual Venda Venda { get; set; }

        public Tipo Tipo_ingresso { get; set; }

        public enum Tipo {INTEIRA,ESTUDANTE,SENHOR,MEIA_ENTRADA }


    }
}