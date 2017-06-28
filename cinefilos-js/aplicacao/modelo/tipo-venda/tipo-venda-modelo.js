(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.TipoVendaFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;
    self.fromJsonObject = fromJsonObject;

    function criar(descricao) {
      return new TipoVenda(descricao);
    }

    function fromJsonObject(jsonObject) {
      return new TipoVenda(jsonObject.descricao)
    }

    return self;
  }

  function TipoVenda(descricao) {
    var self = this;

    var _descricao = descricao;

    /* metodos publicos */
    self.getDescricao = getDescricao;

    function getDescricao() {
      return _descricao;
    }

    function toJson() {
      var json = {};

      json.descricao = _descricao;

      return JSON.stringify(json);
    }
  }

}());