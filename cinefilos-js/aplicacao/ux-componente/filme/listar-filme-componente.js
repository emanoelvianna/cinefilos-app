(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('listarFilmeComponente', {
      controller: Controller,
      templateUrl: 'aplicacao/ux-componente/filme/listar-filme-template.html'
    });

  Controller.$inject = [];

  function Controller() {
    var self = this;
    self.filmes = ['show de vizinha', 'curtindo a vida adoidado'];

    /* metodos publicos */
    self.$onInit = onInit;
    self.cadastrar = cadastrar;

    function onInit() {

    }

    function cadastrar() {
      console.log("ola");
    }

  }
}());