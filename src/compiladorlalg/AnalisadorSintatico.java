/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlalg;

import java.util.ArrayList;

/**
 *
 * @author wesll
 */
public class AnalisadorSintatico {
    public ArrayList <Lexema> lexemas;
    
    
    public void analisarDeclaracaoVariavel(String text){
        String [] declaracaoVariaveis = text.split(";");
        String tokenAnterior, tokenAtual;
        tokenAnterior = declaracaoVariaveis[0];
        tokenAtual = declaracaoVariaveis[1];
        for(int i =1; i<=declaracaoVariaveis.length; i++ ){
            System.out.println(tokenAnterior);
            tokenAnterior = tokenAtual;
           
        }
    }
    
}
