/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlalg;

import java.io.IOException;
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
    
   
    public void analisadorSintaticoAtribuicao(String caminho) throws IOException{
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
        
        if(programa(caminho)){
            System.out.println("deu certo");
        }
        else{
            System.out.println("deu merda");
        }
    }
    
    public boolean programa(String caminho) throws IOException{
        if(lexema().equals("program")){
            anlLex.analisadorLexico(caminho);
            if(token().equals("IDENTIFICADOR")){
                anlLex.analisadorLexico(caminho);
                if(lexema().equals(";")){
                    anlLex.analisadorLexico(caminho);
                    if(bloco(caminho)){
                        if(lexema().equals(".")){
                            return true;
                        }
                        else
                        {
                            System.out.println("Deu problema");
                            return false;
                        }
                    }
                    else 
                        return false;
                    
                }
                else
                {
                    System.out.println("Deu problema");
                    return false;
                }
            }
            else
            {
                System.out.println("Deu problema");
                return false;
            }
            
        }
        else
        {
            System.out.println("Deu problema");
            return false;
        }
        
    }
    
    public boolean bloco(String caminho) throws IOException{
        if(lexema().equals("boolean") || lexema().equals("int")){
            if(!parteDeDeclaracoesDeVariaveis(caminho))
                return false;
        }
        if(lexema().equals("procedure")){
            if(!parteDeDeclaracoesDeSubrotinas(caminho))
                return false;
            
        }
        
        if(lexema().equals("begin")){
            if(!comandoComposto(caminho))
                return false;
            else
                return true;
        }
        else{
            System.out.println("Deu problema");
            return false;
        }
    }
    
    public boolean parteDeDeclaracoesDeVariaveis(String caminho) throws IOException{
        
        while(lexema().equals("boolean") || lexema().equals("int")){
            if(declaracaoDeVariaveis(caminho)){
                    if(lexema().equals(";")){
                        anlLex.analisadorLexico(caminho);
                    }
                    else{
                        System.out.println("Deu problema");
                        
                        return false;
                    }
            }
            else
                return false;
        }
        return true;   
    }
    
    public boolean declaracaoDeVariaveis(String caminho) throws IOException{
        anlLex.analisadorLexico(caminho);
        if(token().equals(TipoToken.IDENTIFICADOR)){
            if(listaDeIdentificadores(caminho))
                return true;
            else
                return false;
        }
        else{
            System.out.println("Deu merda");
            return false;
        }
        
    }
    
    public boolean listaDeIdentificadores(String caminho) throws IOException{
        while(token().equals(TipoToken.IDENTIFICADOR)){
            anlLex.analisadorLexico(caminho);
            if(lexema().equals(",")){
                anlLex.analisadorLexico(caminho);
            }
        }
        return true;
    }
    
    public boolean parteDeDeclaracoesDeSubrotinas(String caminho) throws IOException{
        while(lexema().equals(TipoToken.PALAVRA_RESERVADA)){
            if(declaracaoDeProcedimento(caminho)){
                if(lexema().equals(";"))
                    anlLex.analisadorLexico(caminho);
                else
                {
                    System.out.println("Deu problema");
                    return false;
                }
            }
            else
                return false;
                
        }
        return true;
    }
    
    public boolean declaracaoDeProcedimento(String caminho) throws IOException{
        anlLex.analisadorLexico(caminho);
        if(token().equals(TipoToken.IDENTIFICADOR)){
            anlLex.analisadorLexico(caminho);
            if(lexema().equals("(")){
                if(!parametrosFormais(caminho))
                    return false;
            }
            if(lexema().equals(";"))
            {
                anlLex.analisadorLexico(caminho);
                return bloco(caminho);
                
            }
            else
            {
                System.out.println("Deu merda");
                
                return false;
            }
        }
        else
        {
            System.out.println("Deu merda");
            return false;
        }
    }
    
    public boolean parametrosFormais(String caminho) throws IOException{
        anlLex.analisadorLexico(caminho);
        if(lexema().equals("var"))
            anlLex.analisadorLexico(caminho);
        if(token().equals("IDENTIFICADOR"))
        {
            if(secaoDeParametrosFormais(caminho)){
                while(lexema().equals(";"))
                {
                    anlLex.analisadorLexico(caminho);
                    if(lexema().equals("var"))
                        anlLex.analisadorLexico(caminho);
                    if(token().equals("IDENTIFICADOR")){
                        if(!secaoDeParametrosFormais(caminho)){
                            return false;
                        }
                    }
                    {
                        System.out.println("Deu merda");
                        return false;
                    }
                }
                if(lexema().equals(")"))
                {
                    anlLex.analisadorLexico(caminho);
                    return true;
                }
                else
                {
                        System.out.println("Deu merda");
                       return false;
                }
            }
            else
                return false;
        }
        else
        {
            System.out.println("Deu merda");
            return false;
        }
        
    }
    
    public boolean secaoDeParametrosFormais(String caminho) throws IOException{
        
        if(listaDeIdentificadores(caminho)){
            if(lexema().equals(":")){
                anlLex.analisadorLexico(caminho);
                if(lexema().equals("int") || lexema().equals("boolean")){
                    anlLex.analisadorLexico(caminho);
                    return true;
                }
                else
                {
                    System.out.println("deu merda");
                    return false;
                }
            }
            else
            {
                System.out.println("deu merda");
                return false;
            }
        }
        else
            return false;
        
    }
    
    public boolean comandoComposto(String caminho) throws IOException{
        anlLex.analisadorLexico(caminho);
        if(comando(caminho)){
            while(lexema().equals(";")){
                anlLex.analisadorLexico(caminho);
                if(!comando(caminho))
                    return false;
            }
            if(lexema().equals("end"))
            {
                anlLex.analisadorLexico(caminho);
                return true;
            }
            else
            {
                System.out.println("deu merda");
                return false;
            }
        }
        return false;
    }
    
    public boolean comando(String caminho) throws IOException{
        if(token().equals("IDENTIFICADOR"))
        {
            anlLex.analisadorLexico(caminho);
            if(lexema().equals(":=")){
                anlLex.analisadorLexico(caminho);
                return expressao(caminho);
            }
            if(lexema().equals("(")){
                anlLex.analisadorLexico(caminho);
                if(listaDeExpressoes(caminho)){
                    if(lexema().equals(")")){
                        anlLex.analisadorLexico(caminho);
                        return true;
                    }
                    else
                    {
                        System.out.println("Deu merda");
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
                anlLex.analisadorLexico(caminho);
                if(lexema().equals("(")){
                    anlLex.analisadorLexico(caminho);
                    if(listaDeExpressoes(caminho)){
                        if(lexema().equals(")")){
                            anlLex.analisadorLexico(caminho);
                            return true;
                        }
                        else
                        {
                            System.out.println("deu merda");
                            return false;
                        }
                    }
                    else
                        return false;
                }
                else
                {
                    System.out.println("deu merda");
                    return false;
                }
            }
            else
            {
                if(lexema().equals("begin"))
                    return comandoComposto(caminho);
                else
                {
                    if(lexema().equals("if"))
                        return comandoCondicional(caminho);
                    else
                    {
                        if(lexema().equals("while"))
                            return comandoRepetitivo(caminho);
                        else{
                            System.out.println("deu merda");
                            return false;
                        }
                    }
                }
            }
        }
    }
    
    public boolean comandoCondicional(String caminho) throws IOException{
        anlLex.analisadorLexico(caminho);
        if(expressao(caminho)){
            if(lexema().equals("then")){
                anlLex.analisadorLexico(caminho);
                if(comando(caminho)){
                    if(lexema().equals("else")){
                        anlLex.analisadorLexico(caminho);
                        if(comando(caminho))
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
                System.out.println("deu merda");
                return false;
            }
        }
        else
            return false;
    }
    
    public boolean comandoRepetitivo(String caminho) throws IOException{
        anlLex.analisadorLexico(caminho);
        if(expressao(caminho)){
            if(lexema().equals("do")){
                anlLex.analisadorLexico(caminho);
                return comando(caminho);
            }
            else
            {
                System.out.println("deu merda");
                return false;
            }
        }
        else
            return false;
    }
    
    public boolean expressao(String caminho) throws IOException{
        if(expressaoSimples(caminho)){
            if(token().length() >= 14 && token().substring(0, 13).equals("OP RELACIONAL")){
                
                anlLex.analisadorLexico(caminho);
                return expressaoSimples(caminho);
            }
            else
                return true;
        }
        else
            return false;
    }
    
    public boolean expressaoSimples(String caminho) throws IOException{
        if(lexema().equals("+") || lexema().equals("-"))
            anlLex.analisadorLexico(caminho);
        if(termo(caminho)){
            while(lexema().equals("+") || lexema().equals("-") || lexema().equals("or")){
                anlLex.analisadorLexico(caminho);
                if(!termo(caminho))
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    
    public boolean termo(String caminho) throws IOException{
        if(fator(caminho)){
            while(lexema().equals("*") || lexema().equals("div") || lexema().equals("and")){
                anlLex.analisadorLexico(caminho);
                if(!fator(caminho))
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    
    public boolean fator(String caminho) throws IOException{
        if(token().equals("IDENTIFICADOR")|| lexema().equals("true") || lexema().equals("false"))
        {
            anlLex.analisadorLexico(caminho);
            return true;
        }
        else{
            if(token().equals("NUMERO INTEIRO")){
                anlLex.analisadorLexico(caminho);
                return true;
            }
            else
            {
                if(lexema().equals("(")){
                    anlLex.analisadorLexico(caminho);
                    if(expressao(caminho)){
                        if(lexema().equals(")")){
                            anlLex.analisadorLexico(caminho);
                            return true;
                                  
                        }
                        else
                        {
                            System.out.println("Deu merda");
                            return false;
                        }
                        
                    }
                    else
                        return false;
                }
                else
                {
                    if(lexema().equals("not")){
                        anlLex.analisadorLexico(caminho);
                        return fator(caminho);
                    }
                    else{
                        System.out.println("deu merda");
                        return false;
                    }
                }
            }
        }
    }
    
    public boolean listaDeExpressoes(String caminho) throws IOException{
        if(expressao(caminho)){
            while(lexema().equals(","))
            {
                anlLex.analisadorLexico(caminho);
                if(!expressao(caminho))
                    return false;
            }
            return true;
        }
        else
            return false;
    }
           
    
    
     public boolean buscarFimDeclaracao(Lexema lexAnt, Lexema lexProx){
        if((lexAnt.getTipoToken() == TipoToken.IDENTIFICADOR && lexProx.getTipoToken() == TipoToken.VIRGULA) || ( lexAnt.getTipoToken() == TipoToken.VIRGULA && lexProx.getTipoToken() == TipoToken.IDENTIFICADOR )){
           //System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true; 
        }else if(lexAnt.getTipoToken() == TipoToken.IDENTIFICADOR && lexProx.getTipoToken() == TipoToken.PONTO_VIRGULA){
            //System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true;
        }else if(lexAnt.getTipoToken() == TipoToken.PONTO_VIRGULA && lexProx.getTipoToken() == TipoToken.PALAVRA_RESERVADA){
            //System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true;
        }else if(lexAnt.getTipoToken() == TipoToken.PALAVRA_RESERVADA && lexProx.getTipoToken() == TipoToken.IDENTIFICADOR){
            //System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
            return true;
        }
        //System.out.println(lexAnt.getToken()+ " "+ lexProx.getToken());
        
        return false;
    }
     
     public String lexema(){
        return lexemas.get(lexemas.size()-1).getToken();
    }
     
     public String token(){
        return lexemas.get(lexemas.size()-1).getToken();
    }
    
}
