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
    public AnalisadorSintatico(){
        lexemas = null;
        
    }
    public void analisadorSintatico(){
        this.anlLex = new AnalisadorLexico();
        this.lexemas = anlLex.analisadorLexico("C:\\Users\\wesll\\Documents\\NetBeansProjects\\CompiladorLalg\\src\\compiladorlalg\\arquivoTeste.txt");
        for(int i=1 ; i< lexemas.size()-1; i++){
           if(lexemas.get(i-1).getTipoToken() == TipoToken.PALAVRA_RESERVADA){
               while(lexemas.get(i).tipoToken != TipoToken.IDENTIFICADOR || lexemas.get(i).tipoToken != TipoToken.VIRGULA ){
                if(lexemas.get(i).tipoToken == TipoToken.PONTO_VIRGULA){
                    if()
                    break;
                 }
                i++;
               }
           }
        }
    }
    
}
