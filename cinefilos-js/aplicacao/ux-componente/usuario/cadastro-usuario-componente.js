(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('cadastroUsuarioComponente', {
      templateUrl: 'aplicacao/ux-componente/usuario/cadastro-usuario-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    'UsuarioComunicacaoFactory',
    'modelo.UsuarioFactory'
  ];

  function Controller(UsuarioComunicacaoFactory, UsuarioFactory) {
    var self = this;

    /* metodos publicos */
    self.cadastrar = cadastrar;

    function cadastrar(usuario) {
      var novoUsuario = new UsuarioFactory.criar(usuario.login, usuario.senha);
      UsuarioComunicacaoFactory.cadastrar(novoUsuario.toJson());
      console.log(novoUsuario);
    }
  }
}());
