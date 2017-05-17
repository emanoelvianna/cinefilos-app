class Sessao {

    constructor(sala, hora) {
        this._sala = sala;
        this._hora = hora;
    }

    get sala() {
        return this._sala;
    }

    get hora() {
        return this._hora;
    }

}