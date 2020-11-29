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
    public void analisadorSintaticoAtribuicao(){
        this.anlLex = new AnalisadorLexico();
        this.lexemas = anlLex.analisadorLexico("C:\\Users\\wesll\\Documents\\NetBeansProjects\\CompiladorLalg\\src\\compiladorlalg\\arquivoTeste.txt");
        String aux = null;
        for(int i=0 ; i<lexemas.size()-1; i++){
            aux="";
            if(lexemas.get(i).getTipoToken() == TipoToken.PALAVRA_RESERVADA){
               i++;
               if(lexemas)
            }
        }
    }
    
}
