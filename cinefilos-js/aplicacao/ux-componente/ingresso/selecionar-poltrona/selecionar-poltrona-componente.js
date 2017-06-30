(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('venderIngressoComponente', {
      templateUrl: 'aplicacao/ux-componente/ingresso/selecionar-poltrona/selecionar-poltrona-template.html',
      controller: Controller,
      bindings: {
        numero: '<'
      }
    });

  Controller.$inject = [
    'modelo.IngressoFactory',
    '$mdDialog'
  ];

  function Controller(IngressoFactory, $mdDialog) {
    var self = this;

    self.comprar = comprar;

    self.filmes = [
      'Show de vizinha',
      'vivendo a vida adoidado'
    ];

    function comprar(ev) {
      $mdDialog.show({
        template: '<finalizar-venda-ingresso-componente></finalizar-venda-ingresso-componente>',
      });
    };
  }
}());
