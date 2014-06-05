/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fafiman.cc4;

/**
 *
 * @author munifgebarajunior
 */
public class Regra {

    public String estadoOrigem;
    public String simbolo;
    public String estadoDestino;

    public Regra(String estadoOrigem, String simbolo, String estadoDestino) {
        this.estadoOrigem = estadoOrigem;
        this.simbolo = simbolo;
        this.estadoDestino = estadoDestino;
    }

    @Override
    public String toString() {
        return estadoOrigem + "," + simbolo + "->" + estadoDestino;
    }

}
