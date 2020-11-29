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
        if(text.length()== 0){
            System.out.println("Análise vazia");
            return;
        }
        
        String [] declaracaoVariaveis = text.split(";");
        
        for (String declaracaoVariavel : declaracaoVariaveis) {
            for(int i =0; i<declaracaoVariavel.length(); i++){
                String atual = declaracaoVariavel.substring(i, i+1);
                System.out.println(atual);
            }  
        }
    }
    
}
