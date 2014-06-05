/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fafiman.cc4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author munifgebarajunior
 */
public class CC4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            String arquivos[] = {"teste0.CC4", "teste1.CC4", "teste2.CC4", "teste3.CC4", "teste4.CC4", "teste5.CC4"};
            for (String arquivo : arquivos) {
                List<Token> tokens = getTokens("exemplos/" + arquivo);
                //mostraTokens(tokens);
                analiseSintatica(tokens);
                System.out.println("\n\n");
            }

        } else if (args.length == 1) {
            System.out.println("Compilando " + args[0]);
            //mostraArquivo(args[0]);
            List<Token> tokens = getTokens(args[0]);
            analiseSintatica(tokens);
            //mostraTokens(tokens);

        } else {
            System.out.println("Você deve utilizar java CC4 nomedoarquivo.cc4");
        }
    }

    public static void mostraTokens(List<Token> tokens) {
        for (Token s : tokens) {
            System.out.println(s);
        }
    }

    private static List<Token> getTokens(String nomeArquivo) {
        List<Token> aRetornar = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            while ((linha = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linha, "^ =*,+-/<>", true);
                String aspas = null;
                while (st.hasMoreTokens()) {
                    String texto = st.nextToken();
                    if (texto.startsWith("\"")) {
                        aspas = texto;
                        continue;
                    } else if (texto.endsWith("\"")) {

                        texto = aspas + texto;
                        aspas = null;
                    } else if (aspas != null) {

                        aspas = aspas + texto;
                        continue;
                    } else {
                        texto = texto.trim();
                    }
                    if (texto.isEmpty()) {
                        continue;
                    }
                    Token tk = new Token();
                    tk.texto = texto;
                    tk.simbolo = "coisa";
                    aRetornar.add(classificaToken(tk));
                }
                Token tk = new Token();
                tk.texto = "|ENTER|";
                tk.simbolo = "coisa";
                aRetornar.add(classificaToken(tk));
            }
        } catch (Exception ex) {
            System.out.println("Arquivo não encontrado:" + nomeArquivo);
        }
        return aRetornar;
    }

    private static void mostraArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Arquivo não encontrado:" + nomeArquivo);
        }
    }

    private static Token classificaToken(Token tk) {
        for (String palavraReservada : Constantes.RESERVADAS) {
            if (palavraReservada.equals(tk.texto)) {
                tk.simbolo = palavraReservada.toUpperCase();
            }
        }
        for (String palavraReservada : Constantes.SIMBOLOS) {
            if (palavraReservada.equals(tk.texto)) {
                tk.simbolo = "OPERADOR";
            }
        }

        if ("|ENTER|".equals(tk.texto)) {
            tk.simbolo = "ENTER";
        }
        if (tk.texto.startsWith("\"")) {
            tk.simbolo = "MENSAGEM";
        }
        for (int i = 0; i < 10; i++) {
            if (tk.texto.startsWith(""+i)) {
                tk.simbolo = "LITERAL";
            }
        }

        if (tk.simbolo.equals("coisa")) {
            tk.simbolo = "IDENTIFICADOR";
        }
        return tk;
    }
    
    


    private static void analiseSintatica(List<Token> tokens) {
        

    }

}
