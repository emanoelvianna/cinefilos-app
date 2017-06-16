(function () {
    'use strict';

    angular
        .module('modelo')
        .factory('modelo.ingressoFactory', Factory);

    Factory.$inject = [];

    function Factory() {
        var self = this;

        /* metodos publicos */
        self.create = create;
        self.fromJsonObject = fromJsonObject;

        function create(codigo, valor, numeroAssento, promocao, notaFiscal, necessidadeEspecial) {
            return new Ingresso(codigo, valor, numeroAssento, promocao, notaFiscal, necessidadeEspecial);
        }

        function fromJsonObject(jsonObject) {
            return new Ingresso(jsonObject.codigo, jsonObject.valor, jsonObject.numeroAssento, jsonObject.promocao, jsonObject.necessidadeEspecial)
        }

        return self;
    }

    function Ingresso(codigo, valor, numeroAssento, promocao, notaFiscal, necessidadeEspecial) {
        var self = this;

        var _codigo = codigo;
        var _valor = valor;
        var _numeroAssento = numeroAssento;
        var _promocao = promocao;
        var _notaFiscal = notaFiscal;
        var _necessidadeEspecial = necessidadeEspecial;

        /* metodos publicos */
        self.getValor = getValor;
        self.getCodigo = getCodigo;
        self.getNumeroAssento = getNumeroAssento;
        self.getPromocao = getPromocao;
        self.getNotaFiscal = getNotaFiscal;
        self.getNecessidadeEspecial = getNecessidadeEspecial;
        self.fromJsonObject = fromJsonObject;

        function getValor() {
            return _valor;
        }

        function getCodigo() {
            return _codigo;
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

        function toJson() {
            var json = {};

            json.codigo = _codigo;
            json.valor = _valor;
            json.numeroAssento = _numeroAssento;
            json.promocao = _promocao;
            json.notaFiscal = _notaFiscal;
            json.necessidadeEspecial = _necessidadeEspecial;

            return JSON.stringify(json);
        }
    }
}());
