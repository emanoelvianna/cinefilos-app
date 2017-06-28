(function () {
  'use strict';

  angular
    .module('comunicacao')
    .factory('comunicacao.filmeComunicacao', Comunicacao);

  Comunicacao.$inject = [
    '$resource'
  ];

  function Comunicacao($resource) {
    //TODO:
    var REST_PREFIX = 'http://10.32.162.133:8080/cinefilos-app'
    var SUFFIX = '/filmes/cadastrar';

    var self = this;

    /* Public methods */
    self.criar = criar;

    function criar() {
        
      return $resource({}, {}, {
        cadastrar: {
          method: 'POST',
          url: REST_PREFIX + SUFFIX,
          headers: headers.json,
          params: {
            'login': '@login',
            'senha': '@senha',
          }
        }
      });
    }

    return self;
  }

}());