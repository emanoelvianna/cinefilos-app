(function () {
  'use strict';

  angular
    .module('comunicacao')
    .factory('comunicacao.usuarioComunicacao', Comunicacao);

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
      });
    }

    return self;
  }

}());