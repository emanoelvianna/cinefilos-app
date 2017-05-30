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
    
    public class SessoesController : Controller
    {
        private CinemadbContext db = new CinemadbContext();

        // GET: Sessoes
        public ActionResult Index()
        {
            var sessao = db.Sessao.Include(s => s.Filme).Include(s => s.Sala);
            return View(sessao.ToList());
        }

        // GET: Sessoes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Sessao sessao = db.Sessao.Find(id);

            if (sessao == null)
            {
                return HttpNotFound();
            }
            var sala = sessao.Id_sala;
            var poltronas = db.Poltronas.Where(x => x.Id_sala == sala).Select(x => x);

            ViewBag.p = poltronas.ToList();
            return View(sessao);
        }

        // GET: Sessoes/Create
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Create()
        {
            ViewBag.Id_filmes = new SelectList(db.Filmes, "Id_filmes", "Title");
            ViewBag.Id_sala = new SelectList(db.Salas, "Id_sala", "Nome");
            return View();
        }

        // POST: Sessoes/Create
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Create([Bind(Include = "Id_sessao,Id_filmes,Id_sala,Horario_i,Horario_f,Dia,Duracao")] Sessao sessao)
        {
            if (ModelState.IsValid)
            {
              //  var poltronas = db.Poltronas.Where(x => x.Sala.Id_sala == sessao.Id_sala).Select(x=>x).ToList();
                //sessao.Poltronas = poltronas;

                db.Sessao.Add(sessao);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.Id_filmes = new SelectList(db.Filmes, "Id_filmes", "Title", sessao.Id_filmes);
            ViewBag.Id_sala = new SelectList(db.Salas, "Id_sala", "Nome", sessao.Id_sala);
            return View(sessao);
        }

        // GET: Sessoes/Edit/5
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Sessao sessao = db.Sessao.Find(id);
            if (sessao == null)
            {
                return HttpNotFound();
            }
            ViewBag.Id_filmes = new SelectList(db.Filmes, "Id_filmes", "Title", sessao.Id_filmes);
            ViewBag.Id_sala = new SelectList(db.Salas, "Id_sala", "Nome", sessao.Id_sala);
            return View(sessao);
        }

        // POST: Sessoes/Edit/5
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Edit([Bind(Include = "Id_sessao,Id_filmes,Id_sala,Horario_i,Horario_f,Dia,Duracao")] Sessao sessao)
        {
            if (ModelState.IsValid)
            {
                db.Entry(sessao).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Id_filmes = new SelectList(db.Filmes, "Id_filmes", "Title", sessao.Id_filmes);
            ViewBag.Id_sala = new SelectList(db.Salas, "Id_sala", "Nome", sessao.Id_sala);
            return View(sessao);
        }

        // GET: Sessoes/Delete/5
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Sessao sessao = db.Sessao.Find(id);
            if (sessao == null)
            {
                return HttpNotFound();
            }
            return View(sessao);
        }

        // POST: Sessoes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Administrador, Gerente")]
        public ActionResult DeleteConfirmed(int id)
        {
            Sessao sessao = db.Sessao.Find(id);
            db.Sessao.Remove(sessao);
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
