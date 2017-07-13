(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.GeneroFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;
    self.fromJsonObject = fromJsonObject;

    function criar(nome) {
      return new Genero(nome);
    }

    function fromJsonObject(jsonObject) {
      return new Genero(jsonObject.nome)
    }

    return self;
  }

  function Genero(nome) {
    var self = this;

    var _nome = nome;

    /* metodos publicos */
    self.getNome = getNome;

    function getNome() {
      return _nome;
    }

    function toJson() {
      var json = {};

      json.nome = _nome;

      return JSON.stringify(json);
    }
  }

}());