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
    public class IngressosController : Controller
    {
        private CinemadbContext db = new CinemadbContext();

        // GET: Ingressos
        public ActionResult Index()
        {
            var ingressos = db.Ingressos.Include(i => i.Sessao).Include(i => i.Venda);
            return View(ingressos.ToList());
        }

        // GET: Ingressos/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ingressos ingressos = db.Ingressos.Find(id);
            if (ingressos == null)
            {
                return HttpNotFound();
            }
            return View(ingressos);
        }

        // GET: Ingressos/Create
        public ActionResult Create()
        {
            ViewBag.Id_sessao = new SelectList(db.Sessao, "Id_sessao", "Id_sessao");
            ViewBag.Id_venda = new SelectList(db.Venda, "Id_venda", "Cpf");
            return View();
        }

        // POST: Ingressos/Create
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id_ingresso,Id_sessao,Horario,Valor,Id_venda,Tipo_ingresso")] Ingressos ingressos)
        {
            if (ModelState.IsValid)
            {
                db.Ingressos.Add(ingressos);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.Id_sessao = new SelectList(db.Sessao, "Id_sessao", "Id_sessao", ingressos.Id_sessao);
            ViewBag.Id_venda = new SelectList(db.Venda, "Id_venda", "Cpf", ingressos.Id_venda);
            return View(ingressos);
        }

        // GET: Ingressos/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ingressos ingressos = db.Ingressos.Find(id);
            if (ingressos == null)
            {
                return HttpNotFound();
            }
            ViewBag.Id_sessao = new SelectList(db.Sessao, "Id_sessao", "Id_sessao", ingressos.Id_sessao);
            ViewBag.Id_venda = new SelectList(db.Venda, "Id_venda", "Cpf", ingressos.Id_venda);
            return View(ingressos);
        }

        // POST: Ingressos/Edit/5
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id_ingresso,Id_sessao,Horario,Valor,Id_venda,Tipo_ingresso")] Ingressos ingressos)
        {
            if (ModelState.IsValid)
            {
                db.Entry(ingressos).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Id_sessao = new SelectList(db.Sessao, "Id_sessao", "Id_sessao", ingressos.Id_sessao);
            ViewBag.Id_venda = new SelectList(db.Venda, "Id_venda", "Cpf", ingressos.Id_venda);
            return View(ingressos);
        }

        // GET: Ingressos/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Ingressos ingressos = db.Ingressos.Find(id);
            if (ingressos == null)
            {
                return HttpNotFound();
            }
            return View(ingressos);
        }

        // POST: Ingressos/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Ingressos ingressos = db.Ingressos.Find(id);
            db.Ingressos.Remove(ingressos);
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
