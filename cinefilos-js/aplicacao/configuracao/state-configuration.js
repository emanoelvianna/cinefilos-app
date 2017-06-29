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
            .state('home.ingresso', {
                url: '/ingresso',
                template: '<ingresso-componente></ingresso-componente>'
            });

        /* Default state (route)
         * $locationProvider.html5Mode(true);
         */
        $urlRouterProvider.otherwise('/home');
    }

}());