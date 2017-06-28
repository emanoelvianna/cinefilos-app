(function () {
  'use strict';

  angular
    .module('uxComponente')
    .component('filmeComponente', {
      templateUrl: 'aplicacao/ux-componente/filme/filme-template.html',
      controller: Controller,
    });

  Controller.$inject = [
    'modelo.filmeFactory',
    'comunicacao.filmeComunicacao'
  ];

  function Controller(filmeFactory, filmeComunicacao) {
    var self = this;

    self.cadastrar = cadastrar;

    function cadastrar(filme) {
      var novoFilme = new filmeFactory.create(null, filme.titulo, filme.dataLanchamento, filme.duracao, filme.diretor, filme.classificacaoIndicativa, filme.idioma, filme.imagem);
      filmeComunicacao.criar().cadastrar();
      console.log(novoFilme);
    }
  }
}());
