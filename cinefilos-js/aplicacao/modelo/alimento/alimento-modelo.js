(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.AlimentoFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;
    self.fromJsonObject = fromJsonObject;

    function criar(nome, valor, categoria, marca, dataValidade, dataFabricacao) {
      return new Alimento(nome, valor, categoria, marca, dataValidade, dataFabricacao);
    }

    function fromJsonObject(jsonObject) {
      return new Alimento(jsonObject.nome, jsonObject.valor, jsonObject.categoria, jsonObject.marca, jsonObject.dataValidade, jsonObject.dataFabricacao)
    }

    return self;
  }

  function Alimento(nome, valor, categoria, marca, dataValidade, dataFabricacao) {
    var self = this;

    var _nome = nome;
    var _valor = valor;
    var _categoria = categoria;
    var _marca = marca;
    var _dataValidade = dataValidade;
    var _dataFabricacao = dataFabricacao;

    /* metodos publicos */
    self.getNome = getNome;
    self.getValor = getValor;
    self.getCategoria = getCategoria;
    self.getMarca = getMarca;
    self.getDataValidade = getDataValidade;
    self.getDataFabricacao = getDataFabricacao;
    self.toJson = toJson;

    function getNome() {
      return _nome;
    }

    function getValor() {
      return _valor;
    }

    function getCategoria() {
      return _categoria;
    }

    function getMarca() {
      return _marca;
    }

    function getDataValidade() {
      return _dataValidade;
    }

    function getDataFabricacao() {
      return _dataFabricacao;
    }

    function toJson() {
      var json = {};

      json.nome = _nome;
      json.valor = _valor;
      json.categoria = _categoria;
      json.marca = _marca;
      json.dataValidade = _dataValidade;
      json.dataFabricacao = _dataFabricacao;

      return JSON.stringify(json);
    }
  }

}());