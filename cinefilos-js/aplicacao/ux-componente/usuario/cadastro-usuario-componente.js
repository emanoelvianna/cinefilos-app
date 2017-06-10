(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('cadastroUsuarioComponente', {
      templateUrl: 'aplicacao/ux-componente/usuario/cadastro-usuario-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    'servico.UsuarioServico',
    '$mdToast'
  ];

  function Controller(UsuarioServico, $mdToast) {
    var self = this;
    var MENSAGEM_SENHA = 'Senha está diferente da confirmação!'
    var _errorMensagem = $mdToast.simple().textContent(MENSAGEM_SENHA);

    /* metodos publicos */
    self.cadastrar = cadastrar;

    function cadastrar(usuario) {
      if (_validarSenha(usuario.senha, usuario.confirmacao))
        return new UsuarioServico.cadastrarUsuario(usuario);
      else
        throw new Error('Senha está diferente da confirmação!');
    }

    function _validarSenha(senha, confirmacao) {
      return senha === confirmacao;
    }

    function _erro() {
      $mdToast.show(_errorMensagem);
    }
  }
}());
