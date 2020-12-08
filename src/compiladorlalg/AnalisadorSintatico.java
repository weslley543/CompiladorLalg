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
    public AnalisadorLexico anlLex;
    public int index;
    public AnalisadorSintatico(){
        lexemas = null;
        this.index =1;
    }
    
   
    public void analisadorSintaticoAtribuicao(String caminho){
        this.anlLex = new AnalisadorLexico();
      this.lexemas = anlLex.analisadorLexico(caminho);
      
//        System.out.println("Lexemas");
//        for(int i = 0; i < lexemas.size(); i++){
//            System.out.println(lexemas.get(i).getTipoToken() + " " + lexemas.get(i).getToken());
//        }
        
        if(lexemas.get(0).getTipoToken() != TipoToken.PALAVRA_RESERVADA){
            throw new Error("Erro na declaração de variáveis a cadeia deve iniciar com um indentificador de tipos");
        }
        
        for(; this.index<lexemas.size(); this.index++){
            
            if(!buscarFimDeclaracao(lexemas.get(index-1), lexemas.get(index))){
                System.out.println("ERRO");
                throw new Error("Erro na declaração de variáveis");
            }
           
  
        }
    }
    
     public boolean buscarFimDeclaracao(Lexema lexAnt, Lexema lexProx){
        if((lexAnt.getTipoToken() == TipoToken.IDENTIFICADOR && lexProx.getTipoToken() == TipoToken.VIRGULA) || ( lexAnt.getTipoToken() == TipoToken.VIRGULA && lexProx.getTipoToken() == TipoToken.IDENTIFICADOR )){
           System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true; 
        }else if(lexAnt.getTipoToken() == TipoToken.IDENTIFICADOR && lexProx.getTipoToken() == TipoToken.PONTO_VIRGULA){
            System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true;
        }else if(lexAnt.getTipoToken() == TipoToken.PONTO_VIRGULA && lexProx.getTipoToken() == TipoToken.PALAVRA_RESERVADA){
            System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true;
        }else if(lexAnt.getTipoToken() == TipoToken.PALAVRA_RESERVADA && lexProx.getTipoToken() == TipoToken.IDENTIFICADOR){
            System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true;
        }
        System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
        
        return false;
    }
    
}
