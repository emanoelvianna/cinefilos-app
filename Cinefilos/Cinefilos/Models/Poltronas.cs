﻿using System;
using System.ComponentModel.DataAnnotations;

namespace cinefilos.Models
{
    public class Poltronas
    {
        public enum Status_Poltrona { LIVRE, OCUPADA, QUEBRADA }

        [Key]
        public int Id { get; set; }

      
        [Display(Name = "Status da Poltrona")]
        public Status_Poltrona Status { get; set; }

       
        [Display(Name = "Poltrona")]
        public string Nome_p { get; set; }

        [Display(Name = "Sala")]

        public int Id_sala { get; set; }
        public virtual Salas Sala { get; set; }

       
    }
}