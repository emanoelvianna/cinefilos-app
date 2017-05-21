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

       public enum Status_filme { EM_EXIBICAO, EM_BREVE, FORA}

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



        [StringLength(60, MinimumLength = 3)]
        public string Director { get; set; }

        [Display(Name = "Status")]
        public Status_filme Sts { get; set; }

        [Display(Name = "Duração")]
        public int Duracao { get; set; }



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