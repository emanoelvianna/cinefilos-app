using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Cinefilos.Models
{
    public class Generos


    {
        [Key]
        public int Id_genero { get; set; }

        [Required]
        public string Name { get; set; }
       
        public virtual ICollection<Filmes> Filmes { get; set; }

    }
}