(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.filmeFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.create = create;
    self.fromJsonObject = fromJsonObject;

    function create(codigo, titulo, dataLanchamento, duracao, diretor, classificacaoIndicativa, idioma, imagem) {
      return new Filme(codigo, titulo, dataLanchamento, duracao, diretor, classificacaoIndicativa, idioma, imagem);
    }

    function fromJsonObject(jsonObject) {
      return new Filme(jsonObject.codigo, jsonObject.titulo, jsonObject.dataLanchamento, jsonObject.duracao, jsonObject.diretor, jsonObject.classificacaoIndicativa, jsonObject.idioma, jsonObject.imagem)
    }

    return self;
  }

  function Filme(codigo, titulo, dataLanchamento, duracao, diretor, classificacaoIndicativa, idioma, imagem) {
    var self = this;

    var _codigo = codigo;
    var _titulo = titulo;
    var _dataLanchamento = dataLanchamento;
    var _duracao = duracao;
    var _diretor = diretor;
    var _classificacaoIndicativa = classificacaoIndicativa;
    var _idioma = idioma;
    var _imagem = imagem;

    /* metodos publicos */
    self.getCodigo = getCodigo;
    self.getTitulo = getTitulo;
    self.getDataLanchamento = getDataLanchamento;
    self.getDuracao = getDuracao;
    self.getDiretor = getDiretor;
    self.getClassificacaoIndicativa = getClassificacaoIndicativa;
    self.getIdioma = getIdioma;
    self.getImagem = getImagem;
    self.toJson = toJson;

    function getCodigo() {
      return _codigo;
    }

    function getTitulo() {
      return _titulo;
    }

    function getDataLanchamento() {
      return _dataLanchamento;
    }

    function getDuracao() {
      return _duracao;
    }

    function getDiretor() {
      return _diretor;
    }

    function getClassificacaoIndicativa() {
      return _classificacaoIndicativa;
    }

    function getIdioma() {
      return _idioma;
    }

    function getImagem() {
      return _imagem;
    }

    function toJson() {
      var json = {};

      json.codigo = _codigo;
      json.titulo = _titulo;
      json.dataLanchamento = _dataLanchamento;
      json.duracao = _duracao;
      json.diretor = _diretor;
      json.classificacaoIndicativa = _classificacaoIndicativa;
      json.idioma = _idioma;
      json.imagem = _imagem;

      return JSON.stringify(json);
    }
  }
}());
