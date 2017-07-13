(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('listarFilmeComponente', {
      controller: Controller,
      templateUrl: 'aplicacao/ux-componente/filme/listar/listar-filme-template.html'
    });

  Controller.$inject = [
    '$state',
    'FilmeComunicacaoFactory'
  ];

  function Controller($state, FilmeComunicacaoFactory) {
    var self = this;
    self.filmes;

    /* metodos publicos */
    self.$onInit = onInit;
    self.navegar = navegar;

    function onInit() {
      FilmeComunicacaoFactory.listar().$promise.then(function (retorno) {
        self.filmes = retorno.filmes;
      });
    }

    function navegar(filme) {
      $state.go('home.mostrarFilme', { filme: filme });
    }

  }
}());