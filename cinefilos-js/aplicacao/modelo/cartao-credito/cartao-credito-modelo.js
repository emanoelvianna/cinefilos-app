(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.CartaoCreditoFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;
    self.fromJsonObject = fromJsonObject;

    function criar(numero, dataValidade, bandeira, cw) {
      return new CartaoCredito(numero, dataValidade, bandeira, cw);
    }

    function fromJsonObject(jsonObject) {
      return new CartaoCredito(jsonObject.numero, jsonObject.dataValidade, jsonObject.bandeira, jsonObject.cw)
    }

    return self;
  }

  function CartaoCredito(numero) {
    var self = this;

    var _numero = numero;
    var _dataValidade = dataValidade;
    var _bandeira = bandeira;
    var _cw = cw;

    /* metodos publicos */
    self.getNome = getNome;

    function getNumero() {
      return _numero;
    }
    function getDataValidade() {
      return _dataValidade;
    }
    function getBandeira() {
      return _bandeira;
    }

    function toJson() {
      var json = {};

      json.nome = _numero;
      json.nome = _dataValidade;
      json.nome = _bandeira;
      json.nome = _cw;

      return JSON.stringify(json);
    }
  }

}());