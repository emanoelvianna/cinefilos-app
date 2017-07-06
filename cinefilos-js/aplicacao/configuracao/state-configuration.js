(function () {

    angular
        .module('principal')
        .config(StateConfiguration);

    StateConfiguration.$inject = [
        '$stateProvider',
        '$urlRouterProvider',
        '$locationProvider'
    ];

    function StateConfiguration($stateProvider, $urlRouterProvider, $locationProvider) {

        $stateProvider
            .state('home', {
                url: '/home',
                views: {
                    'cinefilos-root': {
                        template: '<menu-componente></menu-componente>',
                    }
                }
            })
            .state('home.cadastraUsuario', {
                url: '/cadastro-usuario',
                template: '<cadastro-usuario-componente></cadastro-usuario-componente>'
            })
            .state('home.cadastraFilme', {
                url: '/cadastra-filme',
                template: '<filme-componente></filme-componente>'
            })
            .state('home.listarFilme', {
                url: '/listar-filme',
                template: '<listar-filme-componente></listar-filme-componente>'
            })
            .state('home.mostrarFilme', {
                url: '/mostrar-filme',
                template: '<mostrar-filme-componente></mostrar-filme-componente>',
                params: {
                    filme: null
                }
            })
            .state('home.venderIngresso', {
                url: '/vender-ingresso',
                template: '<ingresso-componente></ingresso-componente>',
                params: {
                    filme: null
                }
            })
            .state('home.backup', {
                url: '/backup',
                template: '<backup-componente></backup-componente>'
            });

        /* Default state (route)
         * $locationProvider.html5Mode(true);
         */
        $urlRouterProvider.otherwise('/home');
    }

}());