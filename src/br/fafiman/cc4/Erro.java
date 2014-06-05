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
public class Erro {
    public String codigo;
    public String mensagem;

    public Erro(String codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Erro{" + "codigo=" + codigo + ", mensagem=" + mensagem + '}';
    }
    
    
    
}
