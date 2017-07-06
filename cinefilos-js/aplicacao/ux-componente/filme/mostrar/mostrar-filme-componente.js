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
    self.imagePath = 'aplicacao/recurso/imagem/poster.jpg';

    self.sessoes = [
      { 'horario': '02:00:00 PM', 'data': 'jul 3, 2017' },
      { 'horario': '02:00:00 PM', 'data': 'jul 3, 2017' }
    ];

    /* metodos publicos */
    self.$onInit = onInit;

    function onInit() {
      self.filme = $stateParams.filme;
      console.log(self.filme);
    }
  }
}());