(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('menu', {
      controller: Controller,
      templateUrl: 'aplicacao/ux-componente/menu/menu-template.html'
    });

  Controller.$inject = [];

  function Controller() {
    var self = this;

    /* metodos publicos */
    self.$onInit = onInit;

    function onInit() {

    }

  }
}());