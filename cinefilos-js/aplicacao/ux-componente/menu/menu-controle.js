(function () {
    'use strict';

    angular
        .module('otusDomain.dashboard')
        .controller('menuControle', menuControle);

    menuControle.$inject = [
        '$state'
    ];

    function menuControle($state) {
        var self = this;

        self.go = go;

        function go(params) {
            $state.go(params);
        }

    }

}());