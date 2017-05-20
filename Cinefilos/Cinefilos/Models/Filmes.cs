using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Cinefilos.Models
{
    public class Filmes
    {
        [Key]
        [Column("Id_filmes")]
        public int Id_filmes { get; set; }

        [Required]
        [StringLength(60, MinimumLength = 3)]
        public string Title { get; set; }

        [Required]
        [Display(Name = "Release Date")]
        // [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:MM/dd/yyyy}", ApplyFormatInEditMode = true)]
        public DateTime ReleaseDate { get; set; }

        [Display(Name = "Duração")]
        public float Duracao { get; set; }


        [StringLength(60, MinimumLength = 3)]
        public string Director { get; set; }
        
        public int Id_genero { get; set; }
        public virtual Generos Genero { get; set; }

        [Display(Name = "Upload image")]
        public byte[] ImageFile { get; set; }
        public string ImageMimeType { get; set; }

        [Display(Name = "Image link")]
        [DataType(DataType.ImageUrl)]
        public String ImageUrl { get; set; }


        public virtual ICollection<Sessao> Sessao { get; set; }



    }
}