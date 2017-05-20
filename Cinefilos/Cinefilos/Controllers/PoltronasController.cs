using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Cinefilos.Models;
using cinefilos.Models;

namespace Cinefilos.Controllers
{
    public class PoltronasController : Controller
    {
        private CinemadbContext db = new CinemadbContext();

        // GET: Poltronas
        public ActionResult Index()
        {
            var poltronas = db.Poltronas.Include(p => p.Sala);
            return View(poltronas.ToList());
        }

        // GET: Poltronas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Poltronas poltronas = db.Poltronas.Find(id);
            if (poltronas == null)
            {
                return HttpNotFound();
            }
            return View(poltronas);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        //

        // GET: Poltronas/Create
        public ActionResult Create_all()
        {
            Drop_all_chars();
            CinemadbContext contx = new CinemadbContext();
            var pol = new List<Poltronas>();
            var x = db.Salas;
            if (ModelState.IsValid)
            {
                char f = 'a';
                foreach (var y in x)
                {
                    var t = 0;
                    for (var i = 0; i < y.Fileira; i++)
                    {
                        for (var j = 0; j < y.Lugares; j++)
                        {
                            pol.Add(new Poltronas
                            {
                                Id = t,
                                Id_sala = y.Id_sala,
                                Nome_p = f + j.ToString(),
                            }
                            );
                            t++;
                        }
                        f++;
                    }
                    pol.ForEach(s => contx.Poltronas.Add(s));
                    contx.SaveChanges();
                }
                ViewBag.erro = "ok";
                return RedirectToAction("Index");
            }
            return View();
        }

        public ActionResult Create_by_room(int id_r, int f, int l)
        {
            Drop_chars_room(id_r);

            CinemadbContext contx = new CinemadbContext();
            var pol = new List<Poltronas>();
            var sala = db.Salas.Find(id_r);
            var fileira = sala.Fileira;
            var lugar = sala.Lugares;
            char s = 'a';

            int? idaux;
            if (db.Poltronas.ToList().Count() > 0)
            {

                idaux = db.Poltronas.OrderByDescending(x => x.Id).First().Id;

            }
            else
            {
                idaux = 0;
            }

            int id = 1 + (int)idaux;
            if (ModelState.IsValid)
            {
                for (var i = 0; i < fileira; i++)
                {
                    for (var j = 1; j <= lugar; j++)
                    {
                        pol.Add(new Poltronas
                        {
                            Id = id,
                            Id_sala = sala.Id_sala,
                            Nome_p = s + j.ToString(),
                        });
                        id++;
                    }
                    s++;

                }
                pol.ForEach(itens => contx.Poltronas.Add(itens));
                contx.SaveChanges();


                ViewBag.erro = "ok";
                return RedirectToAction("Index");
            }

            ViewBag.erro = "erro";
            return View();

        }




        public ActionResult Delete_all()
        {
            Drop_all_chars();
            return RedirectToAction("Index");
        }

        protected void Drop_chars_room(int id)
        {
            CinemadbContext context = new CinemadbContext();
            context.Poltronas.RemoveRange(context.Poltronas.Where(x => x.Id_sala == id).Select(x => x));
            context.SaveChanges();
        }
        protected void Drop_all_chars()
        {
            CinemadbContext context = new CinemadbContext();
            context.Poltronas.RemoveRange(context.Poltronas.Select(x => x));
            context.SaveChanges();
        }
    }
}
