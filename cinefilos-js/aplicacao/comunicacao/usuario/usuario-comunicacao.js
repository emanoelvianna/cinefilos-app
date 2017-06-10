(function () {
  'use strict';

  angular
    .module('comunicacao')
    .factory('comunicacao.UsuarioComunicacao', Comunicacao);

  Comunicacao.$inject = [
    '$resource'
  ];

  function Comunicacao($resource) {
    //TODO:
    var SUFFIX = '/participants/:rn/activities';

    var self = this;

    /* Public methods */
    self.criar = criar;

    function criar() {
      var restPrefix = OtusRestResourceContext.getRestPrefix();
      var token = OtusRestResourceContext.getSecurityToken();
      var headers = HeaderBuilderFactory.create(token);

      return $resource({}, {}, {
        cadastrar: {
          method: 'POST',
          url: restPrefix + SUFFIX,
          headers: headers.json,
          params: {
            'login': '@login',
            'senha': '@senha',
          }
        },
        atualizar: {
          method: 'PUT',
          url: restPrefix + SUFFIX + '/:id',
          headers: headers.json,
          params: {
            'login': '@login',
            'senha': '@senha',
          }
        },
        excluir: {
          method: 'PUT',
          url: restPrefix + SUFFIX,
          headers: headers.json,
          params: {
            'login': '@login',
            'senha': '@senha',
          }
        },
        buscar: {
          method: 'GET',
          url: restPrefix + SUFFIX + '/:id',
          headers: headers.json,
          params: {
            'login': '@login',
            'senha': '@senha',
          }
        },
        listar: {
          method: 'GET',
          url: restPrefix + SUFFIX + '/:id',
          headers: headers.json,
        }
      });
    }

    return self;
  }

}());