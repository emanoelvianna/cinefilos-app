(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('mostrarFilmeComponente', {
      controller: Controller,
      templateUrl: 'aplicacao/ux-componente/filme/mostrar/mostrar-filme-template.html'
    });

  Controller.$inject = [
    '$state',
    '$stateParams',
    'SessaoComunicacaoFactory'
  ];

  function Controller($state, $stateParams, SessaoComunicacaoFactory) {
    var self = this;
    self.sessoes;
    self.filme;
    self.imagePath;

    /* metodos publicos */
    self.$onInit = onInit;
    self.comprar = comprar;

    function onInit() {
      resolverSessoes();
      self.filme = $stateParams.filme;
      self.imagePath = $stateParams.filme.imagem_cartaz_path;
    }

    function comprar() {
      $state.go('home.venderIngresso', { filme: self.filme });
    }

    function resolverSessoes() {
      SessaoComunicacaoFactory.listar().$promise.then(function (data) {
        self.sessoes = data.sessoes.filter(function (elem, i, array) {
          return self.filme.titulo === elem.filme.titulo;
        });
      });
    }
  }
}());