(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('finalizarVenda', {
      templateUrl: 'aplicacao/ux-componente/ingresso/finalizar-venda/finalizar-venda-template.html',
      controller: Controller,
      bindings: {
        numero: '<'
      }
    });

  Controller.$inject = [
    'modelo.IngressoFactory',
    'IngressoComunicacaoFactory'
  ];

  function Controller(IngressoFactory, IngressoComunicacaoFactory) {
    var self = this;

    self.cadastrar = cadastrar;

    self.filmes = [
      'Show de vizinha',
      'vivendo a vida adoidado'
    ];

    function cadastrar(ingresso) {
      var novoIngresso = new IngressoFactory.create(ingresso.valor, self.numero, ingresso.promocao, ingresso.notaFiscal, ingresso.necessidadeEspecial);
      IngressoComunicacaoFactory.cadastrar(novoIngresso.toJson());
      console.log(novoIngresso);
    }
  }
}());