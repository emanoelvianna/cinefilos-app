(function () {
    'use strict';

    angular
        .module('modelo')
        .factory('modelo.SessaoFactory', Factory);

    Factory.$inject = [];

    function Factory() {
        var self = this;

        /* metodos publicos */
        self.create = create;
        self.fromJsonObject = fromJsonObject;

        function create(horarioSessao, dataSessao) {
            return new Sessao(horarioSessao, dataSessao);
        }

        function fromJsonObject(jsonObject) {
            return new Sessao(jsonObject.horarioSessao, jsonObject.dataSessao)
        }

        return self;
    }

    function Sessao(horarioSessao, dataSessao) {
        var self = this;

        var _horarioSessao = horarioSessao;
        var _dataSessao = dataSessao;

        /* metodos publicos */
        self.getHorarioSessao = getHorarioSessao;
        self.getDataSessao = getDataSessao;
        self.toJson = toJson;

        function getHorarioSessao() {
            return _horarioSessao;
        }

        function getDataSessao() {
            return _dataSessao;
        }

        function toJson() {
            var json = {};

            json.codigo = _codigo;
            json.horarioSessao = _horarioSessao;
            json.dataSessao = _dataSessao;

            return JSON.stringify(json);
        }
    }
}());
