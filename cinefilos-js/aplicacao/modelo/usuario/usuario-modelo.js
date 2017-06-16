(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.usuarioFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;

    function criar(codigo, login, senha) {
      return new Usuario(codigo, login, senha);
    }

    return self;
  }

  function Usuario(codigo, login, senha) {
    var self = this;

    var _codigo = codigo;
    var _login = login;
    var _senha = senha;

    /* metodos publicos */
    self.getCodigo = getCodigo;
    self.getLogin = getLogin;
    self.getSenha = getSenha;
    self.toJson = toJson;

    function getCodigo() {
      return _codigo;
    }

    function getLogin() {
      return _login;
    }

    function getSenha() {
      return _senha;
    }

    function toJson() {
      var json = {};

      json.codigo = _codigo;
      json.login = _login;
      json.senha = _senha;

      return JSON.stringify(json);
    }
  }

}());