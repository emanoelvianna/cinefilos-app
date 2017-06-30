(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('finalizarVendaIngressoComponente', {
      templateUrl: 'aplicacao/ux-componente/ingresso/finalizar-venda/finalizar-venda-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    'modelo.IngressoFactory'
  ];

  function Controller(IngressoFactory) {
    var self = this;

    self.cadastrar = cadastrar;

    self.filmes = [
      'Show de vizinha',
      'vivendo a vida adoidado'
    ]

    function cadastrar(ingresso) {
      var novoIngresso = new IngressoFactory.create(ingresso.valor, ingresso.numeroAssento, ingresso.promocao, ingresso.notaFiscal, ingresso.necessidadeEspecial);
      console.log(novoIngresso);
    }
  }
}());