namespace Cinefilos.Migrations
{
    using Microsoft.AspNet.Identity;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using Models;
    using System.Web.Security;
    using Microsoft.AspNet.Identity.EntityFramework;

    internal sealed class Configuration : DbMigrationsConfiguration<Cinefilos.Models.ApplicationDbContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(Cinefilos.Models.ApplicationDbContext context)
        {
            context.Roles.AddOrUpdate(r => r.Name,
             new IdentityRole
             {
                 Name = "Administrador"
             }
         );
            context.Roles.AddOrUpdate(r => r.Name,
               new IdentityRole
               {
                   Name = "Atendente"
               }
           );

            context.Roles.AddOrUpdate(r => r.Name,
               new IdentityRole
               {
                   Name = "Cliente"
               }
           );
            context.Roles.AddOrUpdate(r => r.Name,
              new IdentityRole
              {
                  Name = "Gerente"
              }
          );
           

            var hasher = new PasswordHasher();
            context.Users.AddOrUpdate(p => p.Email,
                new ApplicationUser
                {
                    Email = "admin@cinema.com",
                    UserName = "admin@cinema.com",
                    PasswordHash = hasher.HashPassword("Pass@word1"),
                    LockoutEnabled = true,
                });
            context.Users.AddOrUpdate(p => p.Email,
               new ApplicationUser
               {
                   Email = "lucifer@cinema.com",
                   UserName = "lucifer@cinema.com",
                   PasswordHash = hasher.HashPassword("Pass@word1"),
                   LockoutEnabled = true,
               });
            context.Users.AddOrUpdate(p => p.Email,
               new ApplicationUser
               {
                   Email = "odin@cinema.com",
                   UserName = "odin@cinema.com",
                   PasswordHash = hasher.HashPassword("Pass@word1"),
                   LockoutEnabled = true,


               });

            context.Users.AddOrUpdate(p => p.Email,
               new ApplicationUser
               {
                   Email = "orfeu@cinema.com",
                   UserName = "orfeu@cinema.com",
                   PasswordHash = hasher.HashPassword("Pass@word1"),
                   LockoutEnabled = true,
               });


            ApplicationUser user = context.Users.Where(u => u.UserName.Equals("admin@cinema.com", StringComparison.CurrentCultureIgnoreCase)).FirstOrDefault();
            var UserManager = new UserManager<ApplicationUser>(new UserStore<ApplicationUser>(context));
            UserManager.AddToRole(user.Id, "Administrador");
            UserManager.UpdateSecurityStamp(user.Id);
            user.LockoutEnabled = true;


            user = context.Users.Where(u => u.UserName.Equals("lucifer@cinema.com", StringComparison.CurrentCultureIgnoreCase)).FirstOrDefault();
            UserManager = new UserManager<ApplicationUser>(new UserStore<ApplicationUser>(context));
            UserManager.AddToRole(user.Id, "Gerente");
            UserManager.UpdateSecurityStamp(user.Id);
            user.LockoutEnabled = true;

            user = context.Users.Where(u => u.UserName.Equals("odin@cinema.com", StringComparison.CurrentCultureIgnoreCase)).FirstOrDefault();
            UserManager = new UserManager<ApplicationUser>(new UserStore<ApplicationUser>(context));
            UserManager.AddToRole(user.Id, "Atendente");
            UserManager.UpdateSecurityStamp(user.Id);
            user.LockoutEnabled = true;

            user = context.Users.Where(u => u.UserName.Equals("orfeu@cinema.com", StringComparison.CurrentCultureIgnoreCase)).FirstOrDefault();
            UserManager = new UserManager<ApplicationUser>(new UserStore<ApplicationUser>(context));
            UserManager.AddToRole(user.Id, "Cliente");
            UserManager.UpdateSecurityStamp(user.Id);
            user.LockoutEnabled = true;




        }
    }
}
