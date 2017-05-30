namespace Cinefilos.Migrations
{
    using Cinefilos.Models;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class ConfigurationA : DbMigrationsConfiguration<Cinefilos.Models.CinemadbContext>
    {
        public ConfigurationA()
        {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(Cinefilos.Models.CinemadbContext context)
        {
            #region
            context.Generos.AddOrUpdate(
               g => g.Name,

               new Generos { Name = "Action" },
               new Generos { Name = "Adventure" },
               new Generos { Name = "Animation" },
               new Generos { Name = "Comedy" },
               new Generos { Name = "Romantic Comedy" },
               new Generos { Name = "Crime" },
               new Generos { Name = "Drama" },
               new Generos { Name = "Sci-Fi" },
               new Generos { Name = "Romance" },
               new Generos { Name = "Fantasy" },
               new Generos { Name = "Sport" },
               new Generos { Name = "Western" },
               new Generos { Name = "Thriller" },
               new Generos { Name = "Family" }

               );
            context.SaveChanges();

            #endregion
            //  var Filmes = new List<Filmes> {


            context.Filmes.AddOrUpdate(
                  f => f.Title,

                    new Filmes
                    {
                        Title = "When Harry Met Sally",
                        ReleaseDate = DateTime.Parse("1989-1-11"),
                        Director = "Rob Reiner",
                        Duracao = 107,
                        Id_genero = 19,

                    },
                    new Filmes
                    {
                        Title = "Ghostbusters",
                        ReleaseDate = DateTime.Parse("1984-3-13"),
                        Director = "Ivan Reitman",
                        Duracao = 180,
                        Id_genero = 18,

                    },
                    new Filmes
                    {
                        Title = "Ghostbusters 2",
                        ReleaseDate = DateTime.Parse("1986-2-23"),
                        Director = "Ivan Reitman",
                        Duracao = 107,
                        Id_genero = 18,

                    },
                    new Filmes
                    {
                        Title = "Rio Bravo",
                        ReleaseDate = DateTime.Parse("1959-4-15"),
                        Director = "Howard Hawks",
                        Duracao = 90,
                        Id_genero = 26,

                    }

            //new Filmes
            //{
            //    Title = "Star Wars - O Despertar da Força",
            //    ReleaseDate = DateTime.Parse("2015-12-17"),
            //    Director = "J. J. Abrams",
            //    Id_genero = 8,

            //},

            //new Filmes
            //{
            //    Title = "Interstellar",
            //    ReleaseDate = DateTime.Parse("2014-1-6"),
            //    Director = "Christopher Nolan",
            //    Id_genero = 8,

            //},

            //new Filmes
            //{
            //    Title = "Spectre",
            //    ReleaseDate = DateTime.Parse("2015-11-5"),
            //    Director = "Sam Mendes",
            //    Id_genero = 1,

            //}
            );

            #region
            //new Filmes {
            //    Title = "The Shawshank Redemption",
            //    ReleaseDate = DateTime.Parse("10/14/1994"),
            //    Director = "Frank Darabont",
            //    Id = context.Generos.Single(g => g.Name == "Drama").Id,

            //},
            //new Filmes { Title = "The Godfather", Director = "Francis Ford Coppola", ReleaseDate = DateTime.Parse("3/24/1972"), Id = context.Generos.Single(g => g.Name == "Drama").Id },
            //new Filmes { Title = "Pulp Fiction", Director = "Quentin Tarantino", ReleaseDate = DateTime.Parse("10/14/1994"), Id = context.Generos.Single(g => g.Name == "Thriller").Id },
            //new Filmes { Title = "Schindlers List", Director = "Steven Spielberg", ReleaseDate = DateTime.Parse("2/4/1994"), Id = context.Generos.Single(g => g.Name == "Drama").Id },
            //new Filmes { Title = "The Dark Knight", Director = "Christopher Nolan", ReleaseDate = DateTime.Parse("7/18/2008"), Id = context.Generos.Single(g => g.Name == "Action").Id },
            //new Filmes { Title = "The Lord of the Rings: The Return of the King", Director = "Peter Jackson", ReleaseDate = DateTime.Parse("12/17/2003"), Id = context.Generos.Single(g => g.Name == "Action").Id },
            //new Filmes { Title = "Star Wars", Director = "George Lucas", ReleaseDate = DateTime.Parse("5/25/1977"), Id = context.Generos.Single(g => g.Name == "Action").Id },
            //new Filmes { Title = "The Matrix", Director = "The Wachowski Brothers", ReleaseDate = DateTime.Parse("3/31/1999"), Id = context.Generos.Single(g => g.Name == "Sci-Fi").Id },
            //new Filmes { Title = "Forrest Gump", Director = "Robert Zemeckis", ReleaseDate = DateTime.Parse("7/6/1994"), Id = context.Generos.Single(g => g.Name == "Comedy").Id },
            //new Filmes { Title = "Monty Python and the Holy Grail", Director = " Terry Gilliam & Terry Jones", ReleaseDate = DateTime.Parse("5/23/1975"), Id = context.Generos.Single(g => g.Name == "Comedy").Id },
            //new Filmes { Title = "2001: A Space Odyssey", Director = "Stanley Kubrick", ReleaseDate = DateTime.Parse("4/29/1968"), Id = context.Generos.Single(g => g.Name == "Sci-Fi").Id },
            //new Filmes { Title = "Back to the Future", Director = "Robert Zemeckis", ReleaseDate = DateTime.Parse("1/22/1989"), Id = context.Generos.Single(g => g.Name == "Family").Id },
            //new Filmes { Title = "Monsters Inc", Director = "Pete Docter & David Silverman", ReleaseDate = DateTime.Parse("11/2/2001"), Id = context.Generos.Single(g => g.Name == "Family").Id }


            //);


            //   // context.Filmes.AddRange(Filmes);
            //   context.SaveChanges();
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //

            #endregion


        }///
    }
}

