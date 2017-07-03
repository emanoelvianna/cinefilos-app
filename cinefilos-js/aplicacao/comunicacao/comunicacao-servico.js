var services = angular.module('comunicacao', ['ngResource']);

var baseUrl = 'http://localhost:8080';

services.factory('DummyFactory', function ($resource) {
    return $resource(baseUrl + '/ngdemo/web/dummy', {}, {
        query: { method: 'GET', params: {} }
    })
});

services.factory('UsersFactory', function ($resource) {
    return $resource(baseUrl + '/ngdemo/web/users', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST', headers: { 'Access-Control-Allow-Origin': '*' } }
    })
});

services.factory('UserFactory', function ($resource) {
    return $resource({}, {}, {
        show: { method: 'GET' },
        atualizar: { url: baseUrl + '/cinefilos_app/usuarios/cadastrar', method: 'POST', params: { id: '@id' } },
        //atualizar: { url:baseUrl + '/cinefilos_app/usuarios/cadastrar', method: 'POST', headers: {'Accept': '/'}, params: {id: '@id'} },
        delete: { method: 'DELETE', params: { id: '@id' } }
    })
});
