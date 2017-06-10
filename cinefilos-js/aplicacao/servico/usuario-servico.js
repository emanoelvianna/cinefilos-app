(function () {
  'use strict';

  angular
    .module('servico')
    .service('servico.UsuarioServico', Service);

  Service.$inject = [
    'modelo.UsuarioFactory',
    'comunicacao.UsuarioComunicacao'
  ];

  function Service(UsuarioFactory, UsuarioComunicacao) {
    var self = this;

    /* Public methods */
    self.cadastrarUsuario = cadastrarUsuario;

    function cadastrarUsuario(usuario) {
      var novoUsuario = new UsuarioFactory.criar(usuario.login, usuario.senha);
      //UsuarioComunicacao.create().cadastrar();
      return novoUsuario;
    }
  }
}());