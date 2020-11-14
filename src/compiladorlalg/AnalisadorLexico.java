/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlalg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wesll
 */
public class AnalisadorLexico {
    public ArrayList <Lexema> lexemas;
    public StringBuffer buffer;
    private Scanner sc;

    public AnalisadorLexico(ArrayList<Lexema> lexemas) {
        this.lexemas = new ArrayList();
    }

    public ArrayList<Lexema> getLexemas() {
        return lexemas;
    }

    public void setLexemas(ArrayList<Lexema> lexemas) {
        this.lexemas = lexemas;
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
    
    public void analisadorLexico (String diretorio){
        try{
            int linha = 1;
            this.sc = new Scanner(new File(diretorio));
            Lexema aux =null;
            
            while(sc.hasNextLine()){
                String exp = sc.nextLine();
                int coluna;
                this.buffer = new StringBuffer();
                for(coluna = 0; coluna<exp.length(); coluna++){
                    String cur = exp.substring(coluna, coluna+1);
                    if(cur.matches("[0-9.a-zA-Z_]")){
                        buffer.append(cur);
                        continue;
                    }else if(buffer.length()>0){
                        String token = this.buffer.toString();
                        if(token.matches("[0-9]+|[0-9]+\\.[0-9]+|[0-9]+[eE][0-9]+")){
                            aux = new Lexema(token, TipoToken.NUMERO);
                        }
                    }
                    
                }
            }
            
        }catch(FileNotFoundException e){
            throw new Error("Erro ao abrir arquivo");
        }
    }
    
    
}
