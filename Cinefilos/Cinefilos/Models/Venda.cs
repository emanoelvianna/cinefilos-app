using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Cinefilos.Models
{
    public class Venda
    {
        public enum Forma_pagamento {DINHEIRO,CREDITO,DEBITO }

        [Key]
        public int Id_venda { get; set; }

        [Display(Name = "Forma de Pagamento")]
        public Forma_pagamento F_pagamento{ get; set; }
        [Display(Name = "Data da Venda")]
        public DateTime Data_venda{ get; set; }

        [Display(Name = "Ingressos")]
        public ICollection<Ingressos> Ingressos   { get; set; }

        [Display(Name = "Total")]
        public decimal Total { get; set; }

        [Display(Name = "Cpf")]
        public string Cpf { get; set; }

        [Display(Name = "Id do Usuario")]
        public int Id_user { get; set; }

        [Display(Name = "Nome de Usuario")]
        public string User { get; set; }


    }
}