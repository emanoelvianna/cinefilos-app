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
            return View(db.Poltronas.ToList());
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

        // GET: Poltronas/Create
        public ActionResult Create()
        {


            CinemadbContext contx = new CinemadbContext();
            var pol = new List<Poltronas>();
            var x = db.Rooms;


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
                                Id_room = y.Id,
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
            //if (ModelState.IsValid)
            //{
            //    db.Poltronas.Add(poltronas);
            //    db.SaveChanges();
            //    return RedirectToAction("Index");
            //}
            ViewBag.erro = "erro";
            return View();
            //return View();
        }

        public ActionResult Createp(int id_r, int f, int l )
        {
            CinemadbContext contx = new CinemadbContext();
            var pol = new List<Poltronas>();
            var x = db.Rooms;
            
            
            if (ModelState.IsValid)
            {

                char q = 'a';
                foreach (var y in x)
                {
                    var t = 0;
                    for (var i = 0; i < y.Fileira; i++)
                    {

                        for (var j = 0; j < y.Lugares; j++)
                        {

                            pol.Add(new Poltronas
                            {
                                Id = q,
                                Id_room = y.Id,
                                Nome_p = f + j.ToString(),
                            }
                            );



                            q++;



                        }
                        f++;

                    }

                    pol.ForEach(s => contx.Poltronas.Add(s));
                    contx.SaveChanges();

                }
                ViewBag.erro = "ok";
                return RedirectToAction("Index");
            }
            //if (ModelState.IsValid)
            //{
            //    db.Poltronas.Add(poltronas);
            //    db.SaveChanges();
            //    return RedirectToAction("Index");
            //}
            ViewBag.erro = "erro";
            return View();
            //return View();
        }

        // POST: Poltronas/Create
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Poltronas poltronas)
        {
            poltronas = new Poltronas();
            //var x = db.Rooms;


            //if (ModelState.IsValid)
            //{
            //    char f = 'a';
            //    foreach (var y in x)
            //    {
            //        poltronas.Id_room = y.Id;
            //        for (var i = 0; i < y.Fileira; i++)
            //        {

            //            for (var j = 0; j < y.Lugares; j++)
            //            {
            //                poltronas.Nome_p = f + j.ToString();
            //                db.Poltronas.Add(poltronas);
            //                db.SaveChangesAsync();

            //            }
            //            f++;

            //        }


            //    }

            //return RedirectToAction("Index");
            //}
            //if (ModelState.IsValid)
            //{
            //    db.Poltronas.Add(poltronas);
            //    db.SaveChanges();
            //    return RedirectToAction("Index");
            //}

            return View();
        }

        // GET: Poltronas/Edit/5
        public ActionResult Edit(int? id)
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

        // POST: Poltronas/Edit/5
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Id_room")] Poltronas poltronas)
        {
            if (ModelState.IsValid)
            {
                db.Entry(poltronas).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(poltronas);
        }

        // GET: Poltronas/Delete/5
        public ActionResult Delete(int? id)
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

        // POST: Poltronas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Poltronas poltronas = db.Poltronas.Find(id);
            db.Poltronas.Remove(poltronas);
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
