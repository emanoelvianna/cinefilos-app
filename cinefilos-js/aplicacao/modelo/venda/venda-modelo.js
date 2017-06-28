(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.Venda', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;
    self.fromJsonObject = fromJsonObject;

    function criar(dataVenda, formaPagamento) {
      return new Venda(dataVenda, formaPagamento);
    }

    function fromJsonObject(jsonObject) {
      return new Venda(jsonObject.dataVenda, jsonObject.formaPagamento)
    }

    return self;
  }

  function Venda(dataVenda, formaPagamento) {
    var self = this;

    var _dataVenda = dataVenda;
    var _formaPagamento = formaPagamento;

    /* metodos publicos */
    self.getDataVenda = getDataVenda;
    self.getFormaPagamento = getFormaPagamento;

    function getDataVenda() {
      return _dataVenda;
    }

    function getFormaPagamento() {
      return _formaPagamento;
    }

    function toJson() {
      var json = {};

      json.dataVenda = _dataVenda;
      json.formaPagamento = _formaPagamento;

      return JSON.stringify(json);
    }
  }

}());