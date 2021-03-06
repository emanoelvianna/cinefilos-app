(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('ingressoComponente', {
      templateUrl: 'aplicacao/ux-componente/ingresso/ingresso-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    '$mdDialog',
    '$scope',
    '$rootElement',
    '$stateParams',
    'modelo.IngressoFactory',
    'IngressoComunicacaoFactory',
  ];

  function Controller($mdDialog, $scope, $rootElement, $stateParams, IngressoFactory, IngressoComunicacaoFactory) {
    var self = this;
    self.filme;

    self.comprar = comprar;
    self.quantidadePoltronas = quantidadePoltronas;

    function onInit() {
      
    }

    function comprar(numero) {
      $scope.numero = numero;
      $scope.filme = $stateParams.filme;
      finalizarCompra();
    }

    function finalizarCompra(ev) {
      // Appending dialog to document.body to cover sidenav in docs app
      $mdDialog.show({
        template: '<finalizar-venda numero="numero"></finalizar-venda>',
        scope: $scope,
        preserveScope: true,
        clickOutsideToClose: true
      });
    }

    function quantidadePoltronas() {
      return new Array(40);
    }
  }
}());
