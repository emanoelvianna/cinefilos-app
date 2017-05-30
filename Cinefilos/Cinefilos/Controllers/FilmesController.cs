using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Cinefilos.Models;

namespace Cinefilos.Controllers
{
    public class FilmesController : Controller
    {
        private CinemadbContext db = new CinemadbContext();

        // GET: Filmes
        public ActionResult Index()
        {
            var filmes = db.Filmes.Include(f => f.Genero);
            return View(filmes.ToList());
        }

        // GET: Filmes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Filmes filmes = db.Filmes.Find(id);
            if (filmes == null)
            {
                return HttpNotFound();
            }
            return View(filmes);
        }

        // GET: Filmes/Create
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Create()
        {
            ViewBag.Id_genero = new SelectList(db.Generos, "Id_genero", "Name");
            return View();
        }

        // POST: Filmes/Create
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Create([Bind(Include = "Id,Title,ReleaseDate,Director,Id_genero,ImageFile,ImageMimeType,ImageUrl")] Filmes filmes)
        {
            if (ModelState.IsValid)
            {
                db.Filmes.Add(filmes);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.Id_genero = new SelectList(db.Generos, "Id_genero", "Name", filmes.Id_genero);
            return View(filmes);
        }

        // GET: Filmes/Edit/5
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Filmes filmes = db.Filmes.Find(id);
            if (filmes == null)
            {
                return HttpNotFound();
            }
            ViewBag.Id_genero = new SelectList(db.Generos, "Id_genero", "Name", filmes.Id_genero);
            return View(filmes);
        }

        // POST: Filmes/Edit/5
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Edit([Bind(Include = "Id,Title,ReleaseDate,Director,Id_genero,ImageFile,ImageMimeType,ImageUrl")] Filmes filmes)
        {
            if (ModelState.IsValid)
            {
                db.Entry(filmes).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Id_genero = new SelectList(db.Generos, "Id_genero", "Name", filmes.Id_genero);
            return View(filmes);
        }

        // GET: Filmes/Delete/5
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Filmes filmes = db.Filmes.Find(id);
            if (filmes == null)
            {
                return HttpNotFound();
            }
            return View(filmes);
        }

        // POST: Filmes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult DeleteConfirmed(int id)
        {
            Filmes filmes = db.Filmes.Find(id);
            db.Filmes.Remove(filmes);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
