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
    public class VendasController : Controller
    {
        private CinemadbContext db = new CinemadbContext();

        // GET: Vendas
        public ActionResult Index()
        {
            return View(db.Venda.ToList());
        }

        // GET: Vendas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Venda venda = db.Venda.Find(id);
            if (venda == null)
            {
                return HttpNotFound();
            }
            return View(venda);
        }

        // GET: Vendas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Vendas/Create
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id_venda,F_pagamento,Data_venda,Total,Cpf,Id_user,User")] Venda venda)
        {
            if (ModelState.IsValid)
            {
                db.Venda.Add(venda);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(venda);
        }

        // GET: Vendas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Venda venda = db.Venda.Find(id);
            if (venda == null)
            {
                return HttpNotFound();
            }
            return View(venda);
        }

        // POST: Vendas/Edit/5
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id_venda,F_pagamento,Data_venda,Total,Cpf,Id_user,User")] Venda venda)
        {
            if (ModelState.IsValid)
            {
                db.Entry(venda).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(venda);
        }

        // GET: Vendas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Venda venda = db.Venda.Find(id);
            if (venda == null)
            {
                return HttpNotFound();
            }
            return View(venda);
        }

        // POST: Vendas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Venda venda = db.Venda.Find(id);
            db.Venda.Remove(venda);
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

        public ActionResult AdicionarCarrinho(int id)
        {
            // Ao invés de colocar uma lista de ítens de Design, vamos colocar
            // Um objeto da entidade Pedido, que já possui List<ItemDesign>.
            // List<ItemDesign> carrinho = Session["Carrinho"] != null ? (List<ItemDesign>)Session["Carrinho"] : new List<ItemDesign>();
            Venda carrinho = Session["Carrinho"] != null ? (Venda)Session["Carrinho"] : new Venda();

            var sessao = db.Sessao.Find(id);

            if (sessao != null)
            {
                var ingresso = new Ingressos();
                ingresso.Id_sessao = sessao.Id_sessao;
                ingresso.Horario = TimeSpan.FromTicks(sessao.Horario_i.Ticks);
                ingresso.Sala = sessao.Sala;
                //ingresso.Venda.Id_venda = carrinho.Id_venda;
                ingresso.Venda = carrinho;



                // Esta linha não precisa. O EF é espertinho e preenche pra você.
                // itemDesign.IdDesign = design.IdDesign;

                //if (carrinho.Ingressos.FirstOrDefault(x => x.Id_sessao == sessao.Id_sessao) != null)
                //{
                //    carrinho.Ingressos.FirstOrDefault(x => x.Id_sessao == sessao.Id_sessao)Qtd += 1;
                //}

                //else
                //{
                //    carrinho.Ingressos.Add(ingresso);
                //}

                // Aqui podemos fazer o cálculo do valor


                carrinho.Ingressos.Add(ingresso);
                carrinho.Total = carrinho.Ingressos.Select(i => i.Valor).Sum();

                Session["Carrinho"] = carrinho;
            }

            return RedirectToAction("Carrinho");
        }

        public ActionResult Carrinho()
        {
            Venda carrinho = Session["Carrinho"] != null ? (Venda)Session["Carrinho"] : new Venda();

            return View(carrinho);
        }


    }
}
