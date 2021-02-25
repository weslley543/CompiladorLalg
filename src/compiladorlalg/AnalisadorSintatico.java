/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlalg;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JTextPane;

/**
 *
 * @author wesll
 */
public class AnalisadorSintatico {
    private static String erroSintatico;
    private static ArrayList<Lexema> tokens; 
    private static Lexico lex;
    
    public static ArrayList<Lexema> analisadorSintatico(String codigoFonte, JTextPane text) throws IOException{
        lex = lex = new Lexico (new StringReader(codigoFonte));
        tokens = new ArrayList<Lexema>();
        erroSintatico = "";
        analisadorLexico();
        
        if(programa()){
            text.setText("O código está correto sintaticaente");
            text.setBackground(java.awt.Color.green);
        }
        else
        {
            text.setText(erroSintatico);
            text.setBackground(java.awt.Color.red);
            while(!token().equals("FIM"))
                analisadorLexico();
            tokens.remove(tokens.size()-1);
        }
        
        return tokens;
        
        
        
    }
    
    public static boolean programa() throws IOException{
        if(lexema().equals("program"))
        {
            analisadorLexico();
            if(token().equals("IDENTIFICADOR")){
                analisadorLexico();
                if(lexema().equals(";")){
                    analisadorLexico();
                    if(bloco()){
                        if(lexema().equals(".")){
                            return true;
                        }
                        else
                        {
                            erroSintatico = "Esperado '.' na linha " + linha() + " coluna " + coluna();
                            return false;
                        }
                    }
                    else 
                        return false;
                    
                }
                else
                {
                    erroSintatico = "Esperado ';' na linha " + linha() + " coluna " + coluna();
                    return false;
                }
            }
            else
            {
                erroSintatico = "Esperado um identificador do programa na linha " + linha() + " coluna " + coluna();
                return false;
            }
            
        }
        else
        {
            erroSintatico = "Esperada a palavra chave 'program' na linha " + linha() + " coluna " + coluna();
            return false;
        }
        
    }
    
    public static boolean bloco() throws IOException{
        if(lexema().equals("boolean") || lexema().equals("int")){
            if(!parteDeDeclaracoesDeVariaveis())
                return false;
        }
        if(lexema().equals("procedure")){
            if(!parteDeDeclaracoesDeSubrotinas())
                return false;
            
        }
        
        if(lexema().equals("begin")){
            if(!comandoComposto())
                return false;
            else
                return true;
        }
        else{
            erroSintatico = "Esperada a palavra chave 'begin' na linha " + linha() + " coluna " + coluna();
            return false;
        }
    }
    
    public static boolean parteDeDeclaracoesDeVariaveis() throws IOException{
        
        while(lexema().equals("boolean") || lexema().equals("int")){
            if(declaracaoDeVariaveis()){
                    if(lexema().equals(";")){
                        analisadorLexico();
                    }
                    else{
                        erroSintatico = "Esperado ';' na linha " + linha() + " coluna " + coluna();
                        
                        return false;
                    }
            }
            else
                return false;
        }
        return true;   
    }
    
    
    public static boolean declaracaoDeVariaveis() throws IOException{
        analisadorLexico();
        if(token().equals("IDENTIFICADOR")){
            if(listaDeIdentificadores())
                return true;
            else
                return false;
        }
        else{
            erroSintatico = "Esperado um identificador na linha " + linha() + " coluna " + coluna();
            return false;
        }
        
    }
    
    public static boolean listaDeIdentificadores() throws IOException{
        while(token().equals("IDENTIFICADOR")){
            analisadorLexico();
            if(lexema().equals(",")){
                analisadorLexico();
            }
        }
        return true;
    }
    
    public static boolean parteDeDeclaracoesDeSubrotinas() throws IOException{
        while(lexema().equals("procedure")){
            if(declaracaoDeProcedimento()){
                if(lexema().equals(";"))
                    analisadorLexico();
                else
                {
                    erroSintatico = "Esperado ';' na linha " + linha() + " coluna " + coluna();
                    
                    return false;
                }
            }
            else
                return false;
                
        }
        return true;
    }
    
    public static boolean declaracaoDeProcedimento() throws IOException{
        analisadorLexico();
        if(token().equals("IDENTIFICADOR"))
        {
            analisadorLexico();
            if(lexema().equals("(")){
                if(!parametrosFormais())
                    return false;
            }
            if(lexema().equals(";"))
            {
                analisadorLexico();
                return bloco();
                
            }
            else
            {
                erroSintatico = "Esperado ';' na linha " + linha() + " coluna " + coluna();
                
                return false;
            }
        }
        else
        {
            erroSintatico = "Esperado um identificador na linha " + linha() + " coluna " + coluna();
            return false;
        }
    }
    
    public static boolean parametrosFormais() throws IOException{
        analisadorLexico();
        if(lexema().equals("var"))
            analisadorLexico();
        if(token().equals("IDENTIFICADOR"))
        {
            if(secaoDeParametrosFormais()){
                while(lexema().equals(";"))
                {
                    analisadorLexico();
                    if(lexema().equals("var"))
                        analisadorLexico();
                    if(token().equals("IDENTIFICADOR")){
                        if(!secaoDeParametrosFormais()){
                            return false;
                        }
                    }
                    {
                        erroSintatico = "Esperado um identificador na linha " + linha() + " coluna " + coluna();
                        return false;
                    }
                }
                if(lexema().equals(")"))
                {
                    analisadorLexico();
                    return true;
                }
                else
                {
                        erroSintatico = "Esperado ')' na linha " + linha() + " coluna " + coluna();
                       return false;
                }
            }
            else
                return false;
        }
        else
        {
            erroSintatico = "Esperado um identificador na linha " + linha() + " coluna " + coluna();
            return false;
        }
        
    }
    
    public static boolean secaoDeParametrosFormais() throws IOException{
        
        if(listaDeIdentificadores()){
            if(lexema().equals(":")){
                analisadorLexico();
                if(lexema().equals("int") || lexema().equals("boolean")){
                    analisadorLexico();
                    return true;
                }
                else
                {
                    erroSintatico = "Esperado um tipo de dado (int ou boolean) na linha " + linha() + " coluna " + coluna();
                    return false;
                }
            }
            else
            {
                erroSintatico = "Esperado ':' na linha " + linha() + " coluna " + coluna();
                return false;
            }
        }
        else
            return false;
        
    }
    
    public static boolean comandoComposto() throws IOException{
        analisadorLexico();
        if(comando()){
            while(lexema().equals(";")){
                analisadorLexico();
                if(!comando())
                    return false;
            }
            if(lexema().equals("end"))
            {
                analisadorLexico();
                return true;
            }
            else
            {
                erroSintatico = "Esperada palavra chave 'end' na linha " + linha() + " coluna " + coluna();
                return false;
            }
        }
        return false;
    }
    
    public static boolean comando() throws IOException{
        if(token().equals("IDENTIFICADOR"))
        {
            analisadorLexico();
            if(lexema().equals(":=")){
                analisadorLexico();
                return expressao();
            }
            if(lexema().equals("(")){
                analisadorLexico();
                if(listaDeExpressoes()){
                    if(lexema().equals(")")){
                        analisadorLexico();
                        return true;
                    }
                    else
                    {
                        erroSintatico = "Esperado ')' na linha " + linha() + " coluna " + coluna();
                        return false;
                    }
                }
                else
                    return false;
            }
            return true;
        }
        else
        {
            if(lexema().equals("read") || lexema().equals("write")){
                analisadorLexico();
                if(lexema().equals("(")){
                    analisadorLexico();
                    if(listaDeExpressoes()){
                        if(lexema().equals(")")){
                            analisadorLexico();
                            return true;
                        }
                        else
                        {
                            erroSintatico = "Esperado ')' na linha " + linha() + " coluna " + coluna();
                            return false;
                        }
                    }
                    else
                        return false;
                }
                else
                {
                    erroSintatico = "Esperado '(' na linha " + linha() + " coluna " + coluna();
                    return false;
                }
            }
            else
            {
                if(lexema().equals("begin"))
                    return comandoComposto();
                else
                {
                    if(lexema().equals("if"))
                        return comandoCondicional();
                    else
                    {
                        if(lexema().equals("while"))
                            return comandoRepetitivo();
                        else{
                            erroSintatico = "Esperado um comando na linha " + linha() + " coluna " + coluna();
                            return false;
                        }
                    }
                }
            }
        }
    }
    
    public static boolean comandoCondicional() throws IOException{
        analisadorLexico();
        if(expressao()){
            if(lexema().equals("then")){
                analisadorLexico();
                if(comando()){
                    if(lexema().equals("else")){
                        analisadorLexico();
                        if(comando())
                            return true;
                        else
                            return false;
                    }
                    else
                        return true;
                }
                else
                    return false;
            }
            else
            {
                erroSintatico = "Esperada palavra chave 'then' na linha " + linha() + " coluna " + coluna();
                return false;
            }
        }
        else
            return false;
    }
    
    public static boolean comandoRepetitivo() throws IOException{
        analisadorLexico();
        if(expressao()){
            if(lexema().equals("do")){
                analisadorLexico();
                return comando();
            }
            else
            {
                erroSintatico = "Esperada palavra chave 'do' na linha " + linha() + " coluna " + coluna();
                return false;
            }
        }
        else
            return false;
    }
    
    public static boolean expressao() throws IOException{
        if(expressaoSimples()){
            if(token().length() >= 14 && token().substring(0, 13).equals("OP RELACIONAL")){
                
                analisadorLexico();
                return expressaoSimples();
            }
            else
                return true;
        }
        else
            return false;
    }
    
    public static boolean expressaoSimples() throws IOException{
        if(lexema().equals("+") || lexema().equals("-"))
            analisadorLexico();
        if(termo()){
            while(lexema().equals("+") || lexema().equals("-") || lexema().equals("or")){
                analisadorLexico();
                if(!termo())
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    
    public static boolean termo() throws IOException{
        if(fator()){
            while(lexema().equals("*") || lexema().equals("div") || lexema().equals("and")){
                analisadorLexico();
                if(!fator())
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    
    public static boolean fator() throws IOException{
        if(token().equals("IDENTIFICADOR")|| lexema().equals("true") || lexema().equals("false"))
        {
            analisadorLexico();
            return true;
        }
        else{
            if(token().equals("NUMERO INTEIRO")){
                analisadorLexico();
                return true;
            }
            else
            {
                if(lexema().equals("(")){
                    analisadorLexico();
                    if(expressao()){
                        if(lexema().equals(")")){
                            analisadorLexico();
                            return true;
                                  
                        }
                        else
                        {
                            erroSintatico = "Esperado ')' na linha " + linha() + " coluna " + coluna();
                            return false;
                        }
                        
                    }
                    else
                        return false;
                }
                else
                {
                    if(lexema().equals("not")){
                        analisadorLexico();
                        return fator();
                    }
                    else{
                        erroSintatico = "Ausência de um fator na linha " + linha() + " coluna " + coluna();
                        return false;
                    }
                }
            }
        }
    }
    
    public static boolean listaDeExpressoes() throws IOException{
        if(expressao()){
            while(lexema().equals(","))
            {
                analisadorLexico();
                if(!expressao())
                    return false;
            }
            return true;
        }
        else
            return false;
    }
           
    
    public static void analisadorLexico() throws IOException{
        Lexema novo = lex.token();
        if(novo == null)
        //o comando abaixo adiciona um token "Fim" para indicar que acabou o código
        //são calculadas as linha e a coluna do final do código a partir da posição do útlimo token
        {
            if(tokens.size() > 0)
                tokens.add(new Lexema ("FIM", "", linha() - 1, coluna() + lexema().length() - 1));
            else
                tokens.add(new Lexema ("FIM", "", 0, 0));
        }
            
        else{
            tokens.add(novo);
            if(token().equals("COMENTARIO"))
               analisadorLexico();
        } 
            
 

        
    }
    
    public static String lexema(){
        return tokens.get(tokens.size()-1).getLexema();
    }
    
    public static String token(){
        return tokens.get(tokens.size()-1).getToken();
    }
    
    public static int linha(){
        if(tokens.size() > 0)
            return tokens.get(tokens.size()-1).getLinha() + 1;
        else
            return 1;
    }
    
    public static int coluna (){
        if(tokens.size() > 0)
            return tokens.get(tokens.size()-1).getColuna() + 1;
        else
            return 1;
    }
    
}