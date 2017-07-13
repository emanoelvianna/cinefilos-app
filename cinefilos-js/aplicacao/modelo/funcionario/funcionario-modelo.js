(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.FuncionarioFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.criar = criar;
    self.fromJsonObject = fromJsonObject;

    function criar(cargo, nome, dataNascimento, estado, cidade, bairro, logradouro, sexo, telefone) {
      return new Funcionario(cargo, nome, dataNascimento, estado, cidade, bairro, logradouro, sexo, telefone);
    }

    function fromJsonObject(jsonObject) {
      return new Cliente(jsonObject.cargo, jsonObject.nome, jsonObject.dataNascimento, jsonObject.estado, jsonObject.cidade, jsonObject.bairro, jsonObject.logradouro, jsonObject.sexo, jsonObject.telefone);
    }

    return self;
  }

  function Funcionario(cargo, nome, dataNascimento, estado, cidade, bairro, logradouro, sexo, telefone) {
    var self = this;

    var _cargo = cargo;
    var _nome = nome;
    var _dataNascimento = dataNascimento;
    var _estado = estado;
    var _cidade = cidade;
    var _bairro = bairro;
    var _logradouro = logradouro;
    var _sexo = sexo;
    var _telefone = telefone;

    /* metodos publicos */
    self.getCargo = getCargo;
    self.getNome = getNome;
    self.getDataNascimento = getDataNascimento;
    self.getEstado = getEstado;
    self.getCidade = getCidade;
    self.getBairro = getBairro;
    self.getLogradouro = getLogradouro;
    self.getSexo = getSexo;
    self.getTelefone = getTelefone;

    function getCargo() {
      return _cargo;
    }

    function getNome() {
      return _nome;
    }

    function getDataNascimento() {
      return _dataNascimento;
    }

    function getEstado() {
      return _dataNascimento;
    }

    function getCidade() {
      return _dataNascimento;
    }

    function getBairro() {
      return _dataNascimento;
    }

    function getLogradouro() {
      return _dataNascimento;
    }

    function getSexo() {
      return _dataNascimento;
    }

    function getTelefone() {
      return _dataNascimento;
    }

    function toJson() {
      var json = {};

      json.cargo = _cargo;
      json.nome = _nome;
      json.dataNascimento = _dataNascimento;
      json.estado = _estado;
      json.cidade = _cidade;
      json.bairro = _bairro;
      json.logradouro = _logradouro;
      json.sexo = _sexo;
      json.telefone = _telefone;

      return JSON.stringify(json);
    }
  }

}());