(function () {
    'use strict';

    angular
        .module('modelo')
        .factory('modelo.sessaoFactory', Factory);

    Factory.$inject = [];

    function Factory() {
        var self = this;

        /* metodos publicos */
        self.create = create;
        self.fromJsonObject = fromJsonObject;

        function create(codigo, horarioSessao, dataSessao) {
            return new Sessao(codigo, horarioSessao, dataSessao);
        }

        function fromJsonObject(jsonObject) {
            return new Sessao(jsonObject.codigo, jsonObject.horarioSessao, jsonObject.dataSessao)
        }

        return self;
    }

    function Sessao(codigo, horarioSessao, dataSessao) {
        var self = this;

        var _codigo = codigo;
        var _horarioSessao = horarioSessao;
        var _dataSessao = dataSessao;

        /* metodos publicos */
        self.getCodigo = getCodigo;
        self.getHorarioSessao = getHorarioSessao;
        self.getDataSessao = getDataSessao;
        self.toJson = toJson;

        function getCodigo() {
            return _codigo;
        }

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
