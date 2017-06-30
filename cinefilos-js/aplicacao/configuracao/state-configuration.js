(function () {

    angular
        .module('principal')
        .config(StateConfiguration);


    StateConfiguration.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];

    function StateConfiguration($stateProvider, $urlRouterProvider, $locationProvider) {

        $stateProvider
            .state('home', {
                url: '/home',
                views: {
                    'cinefilos-root': {
                        template: '<menu></menu>',
                    }
                }
            })
            .state('home.cadastraUsuario', {
                url: '/cadastro-usuario',
                template: '<cadastro-usuario-componente></cadastro-usuario-componente>'
            })
            .state('home.cadastraFilme', {
                url: '/cadastro-filme',
                template: '<filme-componente></filme-componente>'
            })
            .state('home.venderIngresso', {
                url: '/vender-ingresso',
                template: '<vender-ingresso-componente></vender-ingresso-componente>'
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