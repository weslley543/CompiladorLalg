/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlalg;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.in;
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
    private ArrayList <String> palavrasReservadas;

    public AnalisadorLexico() {
        this.lexemas = new ArrayList();
        this.palavrasReservadas = new ArrayList();
        try{
            Scanner read = new Scanner(new File("C:\\Users\\wesll\\Documents\\NetBeansProjects\\CompiladorLalg\\src\\compiladorlalg\\palavrasReservadas.txt"));
            while(read.hasNextLine()){
                String aux = read.nextLine();
                this.palavrasReservadas.add(aux);
            }
        }catch(FileNotFoundException e){
            throw new Error("Arquivo de palavra reservadas não encontrados");
        }
        
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
    
    public void buscarPalavraReservada(String lexema){
        
        palavrasReservadas.forEach((palavraReservada) -> {
            if(palavraReservada.equals(lexema)){
                this.lexemas.add(new Lexema(lexema,TipoToken.PALAVRA_RESERVADA));
                
            }else{
                this.lexemas.add(new Lexema(lexema, TipoToken.IDENTIFICADOR));
            }
       
        });
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
                        this.buffer.append(cur);
                        continue;
                    }else if(buffer.length()>0){
                        String token = this.buffer.toString();
                        if(token.matches("[0-9]+|[0-9]+\\.[0-9]+|[0-9]+[eE][0-9]+")){
                            aux = new Lexema(token, TipoToken.NUMERO);
                            this.lexemas.add(aux);
                        }else if(token.matches("[A-Za-z_]+[0-9]*")){
                            buscarPalavraReservada(token);
                        }else{
                             lexemas.add(new Lexema(token, TipoToken.ERRO));
                        }
                    }
                    
                    char chr = exp.charAt(coluna);
                    
                    switch(chr){
                        case '+':
                            aux = new Lexema("+", TipoToken.OP_SOMA);
                            lexemas.add(aux);
                            break;
                        case '-': 
                            aux = new Lexema("-", TipoToken.OP_SUB);
                            lexemas.add(aux);
                            break;
                        case '/': 
                            aux = new Lexema("/", TipoToken.OP_DIV);
                            lexemas.add(aux);
                        case '*':
                            aux = new Lexema("*", TipoToken.OP_MUL);
                            lexemas.add(aux);
                        case '<':
                            aux = new Lexema("<", TipoToken.MENOR);
                            lexemas.add(aux);
                        case '>':
                            aux = new Lexema(">", TipoToken.MAIOR);
                            lexemas.add(aux);
                        default: 
                            lexemas.add(new Lexema(Character.toString(chr), TipoToken.ERRO));
                    }
                    
                }
                
                if(this.buffer.length() > 0){
                    String token = this.buffer.toString();
                    if(token.matches("[0-9]+|[0-9]+\\.[0-9]+|[0-9]+[eE][0-9]+")){
                        lexemas.add(new Lexema(token, TipoToken.NUMERO));
                    }else if(token.matches("[A-Za-z_]+[0-9]*")){
                        buscarPalavraReservada(token);
                    }else{
                        lexemas.add(new Lexema(token, TipoToken.ERRO));
                    }
                }
            }
            
            lexemas.forEach((lexema)->{
                System.out.println(lexema.getTipoToken());
            });
            
        }catch(FileNotFoundException e){
            throw new Error("Erro ao abrir arquivo");
        }
    }
    
    
}
