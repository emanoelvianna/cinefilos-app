var services = angular.module('comunicacao', ['ngResource']);

var baseUrl = 'http://10.32.148.49\\:8080';

services.factory('DummyFactory', function ($resource) {
    return $resource(baseUrl + '/ngdemo/web/dummy', {}, {
        query: { method: 'GET', params: {} }
    })
});

services.factory('UsersFactory', function ($resource) {
    return $resource(baseUrl + '/ngdemo/web/users', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('UserFactory', function ($resource) {
    return $resource(baseUrl + '/cinefilos-app/filmes/atualizar', {}, {
        show: { method: 'GET' },
        atualizar: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});