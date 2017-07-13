(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('backupComponente', {
      templateUrl: 'aplicacao/ux-componente/backup/backup-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    '$http',
    '$mdDialog',
    'BackupComunicacaoFactory'
  ];

  function Controller($http, $mdDialog, BackupComunicacaoFactory) {
    var self = this;
    self.datas = [];
    self.dataSelecionada;

    self.realizar = realizar;
    self.restaurar = restaurar;
    self.listar = listar;

    init();

    function init() {
      listar();
    }

    function realizar() {
      BackupComunicacaoFactory.fazerBackup().$promise.then(function (data) {
        mensagemDeRealizacao();
        listar();
      });
    }

    function restaurar() {
      httpGet(buscarUrl());
    }

    function listar() {
      BackupComunicacaoFactory.listarBackups().$promise.then(function (data) {
        self.datas = data.backups;
      });
    }

    function buscarUrl() {
      var result = self.datas.filter(function (elem, i, array) {
        return elem.data === self.dataSelecionada;
      });
      return result[0].restore_url;
    }

    function httpGet(theUrl) {
      $http.get(theUrl)
        .then(function (response) {
          mensagemDeRestauracao();
        });
    }

    function mensagemDeRealizacao() {
      alert = $mdDialog.alert()
        .content('Sucesso, o backup de forma imediata foi realizado!')
        .ok('Fechar');

      $mdDialog
        .show(alert)
        .finally(function () {
          alert = undefined;
        });
    }

    function mensagemDeRestauracao() {
      alert = $mdDialog.alert()
        .content('Sucesso, a restauração do backup realizada!!')
        .ok('Fechar');

      $mdDialog
        .show(alert)
        .finally(function () {
          alert = undefined;
        });
    }
  }
}());
