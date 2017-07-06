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
    '$stateParams'
  ];

  function Controller($state, $stateParams) {
    var self = this;

    /* metodos publicos */
    self.$onInit = onInit;

    function onInit() {
      console.log($stateParams);
    }
  }
}());