(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('filmeComponente', {
      templateUrl: 'aplicacao/ux-componente/filme/filme-template.html',
      controller: Controller,
    });

  Controller.$inject = [];

  function Controller() {
    var self = this;
  }
}());
