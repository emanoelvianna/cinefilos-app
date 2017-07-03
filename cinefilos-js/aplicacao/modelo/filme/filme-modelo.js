(function () {
  'use strict';

  angular
    .module('modelo')
    .factory('modelo.FilmeFactory', Factory);

  Factory.$inject = [];

  function Factory() {
    var self = this;

    /* metodos publicos */
    self.create = create;
    self.fromJsonObject = fromJsonObject;

    function create(titulo, dataLancamento, duracao, diretor, classificacaoIndicativa, idioma, imagem) {
      return new Filme(titulo, dataLancamento, duracao, diretor, classificacaoIndicativa, idioma, imagem);
    }

    function fromJsonObject(jsonObject) {
      return new Filme(jsonObject.titulo, jsonObject.dataLancamento, jsonObject.duracao, jsonObject.diretor, jsonObject.classificacaoIndicativa, jsonObject.idioma, jsonObject.imagem)
    }

    return self;
  }

  function Filme(titulo, dataLancamento, duracao, diretor, classificacaoIndicativa, idioma, imagem) {
    var self = this;

    var _titulo = titulo;
    var _dataLancamento = dataLancamento;
    var _duracao = duracao;
    var _diretor = diretor;
    var _classificacaoIndicativa = classificacaoIndicativa;
    var _idioma = idioma;
    var _imagem = imagem;

    /* metodos publicos */
    self.getTitulo = getTitulo;
    self.getDataLancamento = getDataLancamento;
    self.getDuracao = getDuracao;
    self.getDiretor = getDiretor;
    self.getClassificacaoIndicativa = getClassificacaoIndicativa;
    self.getIdioma = getIdioma;
    self.getImagem = getImagem;
    self.toJson = toJson;

    function getTitulo() {
      return _titulo;
    }

    function getDataLancamento() {
      return _dataLancamento;
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

      json.titulo = _titulo;
      json.dataLancamento = _dataLancamento;
      json.duracao = _duracao;
      json.diretor = _diretor;
      json.classificacaoIndicativa = _classificacaoIndicativa;
      json.idioma = _idioma;
      json.imagem = _imagem;

      return JSON.stringify(json);
    }
  }
}());
