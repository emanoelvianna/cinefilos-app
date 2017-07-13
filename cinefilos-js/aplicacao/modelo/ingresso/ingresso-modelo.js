(function () {
    'use strict';

    angular
        .module('modelo')
        .factory('modelo.IngressoFactory', Factory);

    Factory.$inject = [];

    function Factory() {
        var self = this;

        /* metodos publicos */
        self.create = create;
        self.fromJsonObject = fromJsonObject;

        function create(valor, numeroAssento, promocao, notaFiscal, necessidadeEspecial, codSessao) {
            return new Ingresso(valor, numeroAssento, promocao, notaFiscal, necessidadeEspecial, codSessao);
        }

        function fromJsonObject(jsonObject) {
            return new Ingresso(jsonObject.valor, jsonObject.numeroAssento, jsonObject.promocao, jsonObject.necessidadeEspecial, jsonObject.codSessao)
        }

        return self;
    }

    function Ingresso(valor, numeroAssento, promocao, notaFiscal, necessidadeEspecial, codSessao) {
        var self = this;

        var _valor = valor;
        var _numeroAssento = numeroAssento;
        var _promocao = promocao;
        var _notaFiscal = notaFiscal;
        var _necessidadeEspecial = necessidadeEspecial;
        var _cod_sessao = codSessao;

        /* metodos publicos */
        self.getValor = getValor;
        self.getNumeroAssento = getNumeroAssento;
        self.getPromocao = getPromocao;
        self.getNotaFiscal = getNotaFiscal;
        self.getNecessidadeEspecial = getNecessidadeEspecial;
        self.toJson = toJson;

        function getValor() {
            return _valor;
        }

        function getNumeroAssento() {
            return _numeroAssento;
        }

        function getPromocao() {
            return _promocao;
        }

        function getNotaFiscal() {
            return _notaFiscal;
        }

        function getNecessidadeEspecial() {
            return _necessidadeEspecial;
        }

        function getCodSessao() {
            return _cod_sessao;
        }

        function toJson() {
            var json = {};

            json.valor = _valor;
            json.numeroAssento = _numeroAssento;
            json.promocao = _promocao;
            json.notaFiscal = _notaFiscal;
            json.necessidadeEspecial = _necessidadeEspecial;
            json.cod_sessao = _cod_sessao;

            return JSON.stringify(json);
        }
    }
}());
