(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.UsuarioFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;

    function criar(login, senha) {
      return new Usuario(login, senha);
    }

    return self;
  }

  function Usuario(login, senha) {
    var self = this;

    var _login = login;
    var _senha = senha;

    /* Public methods */
    self.getLogin = getLogin;
    self.getSenha = getSenha;
    self.toJson = toJson;

    function getLogin() {
      return _login;
    }

    function getSenha() {
      return _senha;
    }

    function toJson() {
      var json = {};

      json.login = _login;
      json.senha = _senha;

      return JSON.stringify(json);
    }
  }

}());