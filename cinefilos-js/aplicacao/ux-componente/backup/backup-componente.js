(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('backupComponente', {
      templateUrl: 'aplicacao/ux-componente/backup/backup-template.html',
      controller: Controller,
    });

  Controller.$inject = [];

  function Controller() {
    var self = this;

    self.cadastrar = cadastrar;

    self.datas = ['22-01-2017', '02-04-2017']

    function cadastrar(filme) {
    }
  }
}());
