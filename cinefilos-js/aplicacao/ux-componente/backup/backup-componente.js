(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('backupComponente', {
      templateUrl: 'aplicacao/ux-componente/backup/backup-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    '$mdDialog',
    'BackupComunicacaoFactory'
  ];

  function Controller($mdDialog, BackupComunicacaoFactory) {
    var self = this;
    self.datas = [];

    self.fazer = fazer;
    self.restaurar = restaurar;
    self.listar = listar;

    /*
    self.datas = [
      { "data": "02/07/2017 21:32:13", "arquivo": "cinefilos-backup-20170702213213.sql" },
      { "data": "02/07/2017 21:32:51", "arquivo": "cinefilos-backup-20170702213251.sql" },
      { "data": "02/07/2017 22:09:28", "arquivo": "cinefilos-backup-20170702220928.sql" }
    ]
    */

    listar();

    function fazer() {
      var data = new Date();
      BackupComunicacaoFactory.fazerBackup();
      mensagemDeRealizacao();
    }

    function restaurar(data) {
      BackupComunicacaoFactory.restaurarBackup(data);
      mensagemDeRestauracao();
    }

    function listar() {
      self.datas = BackupComunicacaoFactory.listarBackups();

      console.log(self.datas);
    //  return self.datas;
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
