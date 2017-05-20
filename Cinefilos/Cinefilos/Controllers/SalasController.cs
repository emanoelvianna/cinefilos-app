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
    public class SalasController : Controller
    {
        private CinemadbContext db = new CinemadbContext();

        // GET: Salas
        public ActionResult Index()
        {
            return View(db.Salas.ToList());
        }

        // GET: Salas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Salas Salas = db.Salas.Find(id);
            if (Salas == null)
            {
                return HttpNotFound();
            }
            return View(Salas);
        }

        // GET: Salas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Salas/Create
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Nome,Fileira,Lugares,Sts")] Salas Salas)
        {
            if (ModelState.IsValid)
            {
                db.Salas.Add(Salas);
                db.SaveChanges();

                return RedirectToAction("Create_by_room", "Poltronas", new { id_r = Salas.Id_sala, f = Salas.Fileira, l = Salas.Lugares });

               // return RedirectToAction("Index");
            }

            return View(Salas);
        }

        // GET: Salas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Salas Salas = db.Salas.Find(id);
            if (Salas == null)
            {
                return HttpNotFound();
            }
            return View(Salas);
        }

        // POST: Salas/Edit/5
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id_sala,Nome,Fileira,Lugares,Sts")] Salas Salas)
        {
            if (ModelState.IsValid)
            {
                db.Entry(Salas).State = EntityState.Modified;
                db.SaveChanges();

                return RedirectToAction("Create_by_room", "Poltronas", new { id_r = Salas.Id_sala, f = Salas.Fileira, l = Salas.Lugares });

               // return RedirectToAction("Index");
            }
            return View(Salas);
        }

        // GET: Salas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Salas Salas = db.Salas.Find(id);
            if (Salas == null)
            {
                return HttpNotFound();
            }
            return View(Salas);
        }

        // POST: Salas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Salas Salas = db.Salas.Find(id);
            db.Salas.Remove(Salas);
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
