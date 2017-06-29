(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('cadastroUsuarioComponente', {
      templateUrl: 'aplicacao/ux-componente/usuario/cadastro-usuario-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    'UserFactory',
    'modelo.UsuarioFactory'
  ];

  function Controller(UserFactory, UsuarioFactory) {
    var self = this;

    /* metodos publicos */
    self.cadastrar = cadastrar;

    function cadastrar(usuario) {
       UserFactory.update(usuario);
     var novoUsuario = new UsuarioFactory.criar(usuario.login, usuario.senha);
    }
  }
}());
