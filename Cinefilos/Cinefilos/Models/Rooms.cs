using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace cinefilos.Models
{
    public class Rooms
    {

        public enum Status { open, close, on_cleaning }

        [Key]
        public int Id { get; set; }

        [Required]
        [Display(Name = "Nome da sala")]
        public string Nome { get; set; }

        [Required]
        [Display(Name = "Quantidade maxima de Lugares")]
        public int Max_qt { get; set; }

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


        //public Rooms(int max) {
        //    list_poltrona = new List<Poltronas>(Max_qt);
        //    for (var i = 0; i < max; i++) {
        //        list_poltrona.Add(new Poltronas(i));
        //    }
        //}

    }
}