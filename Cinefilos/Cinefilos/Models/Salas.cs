using Cinefilos.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace cinefilos.Models
{
    public class Salas

    {

        public enum Status { ABERTA, FECHADA, EM_USO}

        [Key]
        [Column("Id_sala")]
        public int Id_sala { get; set; }

        [Required]
        [Display(Name = "Nome da sala")]
        public string Nome { get; set; }
        //[Display(Name = "Quantidade maxima de Lugares")]
       // public int Max_qt { get; set; }
        [Required]
        [Display(Name = "Fileiras")]
        public int Fileira { get; set; }

        [Required]
        [Display(Name = "Lugares")]
        public int Lugares { get; set; }

        [Display(Name = "Status da sala")]
        public Status Sts { get; set; }

        [Display(Name = "Lista de Poltronas")]
        public virtual ICollection<Poltronas> Poltronas { get; set; }

        public virtual ICollection<Sessao> Sessao { get; set; }

        //public Salas(int max) {
        //    list_poltrona = new List<Poltronas>(Max_qt);
        //    for (var i = 0; i < max; i++) {
        //        list_poltrona.Add(new Poltronas(i));
        //    }
        //}

    }
}