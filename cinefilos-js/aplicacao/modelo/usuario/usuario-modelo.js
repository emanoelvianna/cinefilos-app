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
    self.fromJsonObject = fromJsonObject;

    function criar(login, senha, permissao) {
      return new Usuario(login, senha, permissao);
    }

    function fromJsonObject(jsonObject) {
      return new TipoVenda(jsonObject.login, jsonObject.senha, jsonObject.permissao)
    }

    return self;
  }

  function Usuario(login, senha, permissao) {
    var self = this;

    var _login = login;
    var _senha = senha;
    var _permissao = permissao;

    /* metodos publicos */
    self.getLogin = getLogin;
    self.getSenha = getSenha;
    self.getPermissao = getPermissao;
    self.toJson = toJson;

    function getLogin() {
      return _login;
    }

    function getSenha() {
      return _senha;
    }

    function getPermissao() {
      return _permissao;
    }

    function toJson() {
      var json = {};

      json.codigo = _codigo;
      json.login = _login;
      json.senha = _senha;
      json.permissao = _permissao;

      return JSON.stringify(json);
    }
  }

}());