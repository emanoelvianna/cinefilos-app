using cinefilos.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Cinefilos.Models
{
    public class CinemadbContext : DbContext
    {
        public CinemadbContext() : base("CinemadbContext2") { }
        public DbSet<Salas> Salas { get; set; }
        public DbSet<Filmes> Filmes { get; set; }
        public DbSet<Generos> Generos { get; set; }
        public DbSet<Poltronas> Poltronas { get; set; }
        public DbSet<Sessao> Sessao { get; set; }



    }

}

