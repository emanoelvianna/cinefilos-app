(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('ingressoComponente', {
      templateUrl: 'aplicacao/ux-componente/ingresso/ingresso-template.html',
      controller: Controller,
    });

  Controller.$inject = [];

  function Controller() {
    var self = this;

    self.cadastrar = cadastrar;

    function cadastrar(ingresso) {
    }
  }
} ());
