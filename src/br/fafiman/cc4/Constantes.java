/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fafiman.cc4;

import java.util.HashMap;

/**
 *
 * @author Anderson
 */
public class Constantes {

    public static final String RESERVADAS[] = {"programa", "variaveis", "procedimento", "escrever", "ler",
        "repetir", "se", "fazer", "entao", "senao", "fimse", "fimrepetir", "fimprocedimento", "retorna",
        "inteiro", "enquanto"};

    public static final String SIMBOLOS[] = {"+", "-", "*", "/", "?", "!", "==", "=", ",", "<",
        "!=", ">", "<=", ">="};

    public static final Regra[] regras = {
        new Regra("q0", "PROGRAMA", "q1"), new Regra("q0", "IDENTIFICADOR", "e1"), new Regra("q1", "IDENTIFICADOR", "q2")
    /*
     PARTE 7
     q2->q3 [label="ENTER"];
     q3->q4 [label="VARIAVEIS"];
     q3->q5 [label="PROCEDIMENTO"];
     q4->q6 [label="ENTER"];
     q4->q4 [label="identificador"];
     PARTE 6
     q5->q7 [label="identificador"];
     q6->q5 [label="PROCEDIMENTO"];
     q7->q8 [label="ENTER"];
     q8->q9 [label="RETORNA"];
     q8->q8 [label="ENTER"];
     
     PARTE 5            
     q8->q11 [label="identificador"];
     q9->q10 [label="identificador"];
     q10->q15 [label="ENTER"];
     q11->q12 [label="="];
     q11->q8 [label="ENTER"];
     q12->q13 [label="identificador"];
     
     PARTE 4
     q12->q14 [label="literal"];
     q13->q8 [label="ENTER"];
     q13->q12 [label="operador"];
     q14->q12 [label="operador"];
     q14->q8 [label="ENTER"];
     q15->q16 [label="FIMPROCEDIMENTO"];
     q17->q999 [label="FIMARQUIVO"];
     
            
            
     PARTE 3
     q17->q5 [label="PROCEDIMENTO"];
     q16->q17 [label="ENTER"];
     q8->q20 [label="SE"];
     q8->q30 [label="LER"];
     q30->q31 [label="identificador"];
     q31->q8 [label="ENTER"];
     q8->q40 [label="ESCREVER"];
     q40->q41 [label="identificador"];
     
            
     PARTE 2
     q40->q43 [label=‚ÄúMENSAGEM‚Äù];
     q41->q8 [label="ENTER"];
     q43->q8 [label="ENTER"];
     q8->q50 [label="ENQUANTO"];
     q8->q22 [label="FIMSE"];
     q8->q16 [label="FIMPROCEDIMENTO"];
     
            
            
     PARTE 1
     q8->q21 [label="SENAO"];
     q21->q8 [label="ENTER"];
     q22->q8 [label="ENTER"];
     q20->q14 [label="IDENTIFICADOR"];
     }


     */

    };

    public static final Erro[] erros = {
        new Erro("e0", "Erro indefinido"),
        new Erro("e1", "Esperando PROGRAMA")
    };

}
