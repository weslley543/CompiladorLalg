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
            File palavraReservada = new File("src/compiladorlalg/palavrasReservadas.txt");
            Scanner read = new Scanner(palavraReservada);
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
    
    public void buscarPalavraReservada(String lexema, int linha, int coluna){
        
        for(int i = 0; i < palavrasReservadas.size(); i++){
            if(palavrasReservadas.get(i).equals(lexema)){
                this.lexemas.add(new Lexema(lexema, TipoToken.PALAVRA_RESERVADA, linha, coluna));
                break;
            } 
            else if((i + 1 == palavrasReservadas.size())){
                this.lexemas.add(new Lexema(lexema, TipoToken.IDENTIFICADOR, linha, coluna));
            }
        }
    }
    
    
    public ArrayList<Lexema> analisadorLexico (String diretorio){
        try{
            
            int linha = 1;
            this.sc = new Scanner(new File(diretorio));
            System.out.println(sc);
            Lexema aux =null;
            System.out.println(diretorio);
            while(sc.hasNextLine()){
                String exp = sc.nextLine();
                int coluna;
                this.buffer = new StringBuffer();
                ArrayList<Integer> colunas = new ArrayList();
                for(coluna = 0; coluna<exp.length(); coluna++){
                    String cur = exp.substring(coluna, coluna+1);
                    if(cur.matches("[0-9.a-zA-Z_]")){
                        this.buffer.append(cur);
                        colunas.add(coluna);
                        continue;
                    }else if(buffer.length()>0){
                        String token = this.buffer.toString();
                        if(token.matches("[0-9]+|[0-9]+\\.[0-9]+|[0-9]+[eE][0-9]+")){
                            aux = new Lexema(token, TipoToken.NUMERO, linha, coluna);
                            this.lexemas.add(aux);
                        }else if(token.matches("[A-Za-z_]+[0-9]*")){
                            buscarPalavraReservada(token, linha, coluna);
                        }else{
                             lexemas.add(new Lexema(token, TipoToken.ERRO, linha, colunas.get(0)));
                        }
                    }
                    
                    char chr = exp.charAt(coluna);
                    
                    switch(chr){
                        case '+':
                            aux = new Lexema("+", TipoToken.OP_SOMA, linha, coluna);
                            lexemas.add(aux);
                            break;
                        case '-': 
                            aux = new Lexema("-", TipoToken.OP_SUB, linha, coluna);
                            lexemas.add(aux);
                            break;
                        case '/': 
                            aux = new Lexema("/", TipoToken.OP_DIV, linha, coluna);
                            lexemas.add(aux);
                            break;
                        case '*':
                            aux = new Lexema("*", TipoToken.OP_MUL, linha, coluna);
                            lexemas.add(aux);
                            break;
                        case '<':
                            aux = new Lexema("<", TipoToken.MENOR, linha, coluna);
                            lexemas.add(aux);
                            break;
                        case '>':
                            aux = new Lexema(">", TipoToken.MAIOR, linha, coluna);
                            lexemas.add(aux);
                            break;
                        case ' ':
                            this.buffer.delete(0, this.buffer.length());
                            break;
                        case ';':
                            aux = new Lexema(";", TipoToken.PONTO_VIRGULA, linha, coluna);
                            lexemas.add(aux);
                            break;
                        case ',':
                            aux = new Lexema(",", TipoToken.VIRGULA, linha, coluna);
                            lexemas.add(aux);
                            break;
                        default: 
                            lexemas.add(new Lexema(Character.toString(chr), TipoToken.ERRO, linha, coluna));
                    }
                    
                    int size = colunas.size();
                    for(int j = 0; j < size; j++){
                        colunas.remove(0);
                    }
                    
                }
                
                if(this.buffer.length() > 0){
                    String token = this.buffer.toString();
                    if(token.matches("[0-9]+|[0-9]+\\.[0-9]+|[0-9]+[eE][0-9]+")){
                        lexemas.add(new Lexema(token, TipoToken.NUMERO, linha, 0));
                    }else if(token.matches("[A-Za-z_]+[0-9]*")){
                        buscarPalavraReservada(token, linha, 0);
                    }else{
                        lexemas.add(new Lexema(token, TipoToken.ERRO, linha, 0));
                    }
                    
                    this.buffer.delete(0, this.buffer.length());
                }
                linha++;
            }
            
            return lexemas;
        }catch(FileNotFoundException e){
            throw new Error("Erro ao abrir arquivo");
        }
    }
    
    
}
