(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('venderIngressoComponente', {
      templateUrl: 'aplicacao/ux-componente/ingresso/vender-ingresso-template.html',
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
      //filmeComunicacao.criar().cadastrar();
      console.log(novoIngresso);
    }
  }
}());
