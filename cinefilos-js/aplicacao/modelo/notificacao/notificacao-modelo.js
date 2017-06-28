(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.NotificacaoFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;
    self.fromJsonObject = fromJsonObject;

    function criar(viaEmail, telaAcessao, mensagem) {
      return new Notificacao(viaEmail, telaAcessao, mensagem);
    }

    function fromJsonObject(jsonObject) {
      return new Sessao(jsonObject.viaEmail, jsonObject.telaAcessao, jsonObject.mensagem)
    }

    return self;
  }

  function Notificacao(viaEmail, telaAcessao, mensagem) {
    var self = this;

    var _viaEmail = viaEmail;
    var _telaAcessao = telaAcessao;
    var _mensagem = mensagem;

    /* metodos publicos */
    self.getViaEmail = getViaEmail;
    self.getTelaAcessao = getTelaAcessao;
    self.getMensagem = getMensagem;

    function getViaEmail() {
      return _viaEmail;
    }

    function getTelaAcessao() {
      return _telaAcessao;
    }

    function getMensagem() {
      return _mensagem;
    }

    function toJson() {
      var json = {};

      json.viaEmail = _viaEmail;
      json.telaAcessao = _telaAcessao;
      json.mensagem = _mensagem;

      return JSON.stringify(json);
    }
  }

}());