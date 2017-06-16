(function () {
  'use strict';

  angular
    .module('servico')
    .factory('servico.filmeServico', Service);

  Service.$inject = [
    'modelo.filmeFactory'
  ];

  function Service(FilmeFactory) {
    var self = this;

    /* Public methods */
    self.cadastrarFilme = cadastrarFilme;

    function cadastrarFilme(filme) {

    }
  }
}());