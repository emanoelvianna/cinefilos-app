var comunicacao = angular.module('comunicacao', ['ngResource']);

var baseUrl = 'http://localhost:8080';

/* usuário */
comunicacao.factory('UsuarioComunicacaoFactory', function ($resource) {
    return $resource({}, {}, {
        listar: { url: baseUrl + '/cinefilos_app/filmes/listar', method: 'GET', params: { id: '@id' } },
        cadastrar: { url: baseUrl + '/cinefilos_app/usuarios/cadastrar', method: 'POST', params: { id: '@id' } },
        excluir: { url: baseUrl + '/cinefilos_app/usuarios/cadastrar', method: 'DELETE', params: { id: '@id' } }
    })
});

/* filme */
comunicacao.factory('FilmeComunicacaoFactory', function ($resource) {
    return $resource(baseUrl + '/ngdemo/web/users', {}, {
        listar: { url: baseUrl + '/cinefilos_app/filmes/listar', method: 'GET', params: { id: '@id' } },
        cadastrar: { url: baseUrl + '/cinefilos_app/filmes/cadastrar', method: 'POST', params: { id: '@id' } },
        excluir: { url: baseUrl + '/cinefilos_app/filmes/excluir', method: 'DELETE', params: { id: '@id' } }
    })
});

/* ingresso */
comunicacao.factory('IngressoComunicacaoFactory', function ($resource) {
    return $resource(baseUrl + '/ngdemo/web/users', {}, {
        listar: { url: baseUrl + '/cinefilos_app/ingressos/listar', method: 'GET', params: { id: '@id' } },
        cadastrar: { url: baseUrl + '/cinefilos_app/ingressos/cadastrar', method: 'POST', params: { id: '@id' } },
        excluir: { url: baseUrl + '/cinefilos_app/ingressos/excluir', method: 'DELETE', params: { id: '@id' } }
    })
});

/* backup */
comunicacao.factory('BackupComunicacaoFactory', function ($resource) {
    return $resource({}, {}, {
        listarBackups: { url: baseUrl + '/cinefilos_app/backup/listarBackup', method: 'GET', params: { id: '@id' } },
        fazerBackup: { url: baseUrl + '/cinefilos_app/backup/fazerBackup', method: 'POST', params: { id: '@id' } },
        restaurarBackup: { url: baseUrl + '/cinefilos_app/backup/restaurarBackup', method: 'DELETE', params: { id: '@id' } }
    })
});

