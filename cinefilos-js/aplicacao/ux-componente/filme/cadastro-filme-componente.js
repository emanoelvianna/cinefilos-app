(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('filmeComponente', {
      templateUrl: 'aplicacao/ux-componente/filme/cadastro-filme-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    'modelo.FilmeFactory',
    'FilmeComunicacaoFactory',
    'GeneroComunicacaoFactory'
  ];

  function Controller(filmeFactory, FilmeComunicacaoFactory, GeneroComunicacaoFactory) {
    var self = this;
    self.generos = [];

    self.cadastrar = cadastrar;

    init();

    function init() {
      getGeneros();
    }

    function cadastrar(filme) {
      var novoFilme = new filmeFactory.create(filme.titulo, filme.dataLancamento, filme.duracao, filme.diretor, filme.classificacaoIndicativa, filme.idioma, filme.imagem);
      FilmeComunicacaoFactory.cadastrar(novoFilme.toJson())
    }

    function getGeneros() {
      GeneroComunicacaoFactory.listar().$promise.then(function (data) {
        console.log(data);
        self.generos = data.generos;
      });
    }


  }
}());
