(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('finalizarVenda', {
      templateUrl: 'aplicacao/ux-componente/ingresso/finalizar-venda/finalizar-venda-template.html',
      controller: Controller,
      bindings: {
        numero: '<',
        sessao: '<'
      }
    });

  Controller.$inject = [
    'modelo.IngressoFactory',
    'IngressoComunicacaoFactory',
    'FilmeComunicacaoFactory'
  ];

  function Controller(IngressoFactory, IngressoComunicacaoFactory, FilmeComunicacaoFactory) {
    var self = this;
    self.sessao = 0;
    self.filmes;

    self.$onInit = onInit;
    self.cadastrar = cadastrar;



    function onInit() {
      FilmeComunicacaoFactory.listar().$promise.then(function (data) {
        self.filmes = data.filmes;
      });
    }

    function cadastrar(ingresso) {
      var novoIngresso = new IngressoFactory.create(ingresso.valor, self.numero, ingresso.promocao, ingresso.notaFiscal, ingresso.necessidadeEspecial, self.sessao);
      IngressoComunicacaoFactory.cadastrar(novoIngresso.toJson());
    }
  }
}());