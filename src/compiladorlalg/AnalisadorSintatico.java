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
        this.index = 0;
    }
    
   
    public boolean analisadorSintaticoAtribuicao(String caminho){
        this.anlLex = new AnalisadorLexico();
        this.lexemas = anlLex.analisadorLexico(caminho);
        
        if(programa()){
           return true;
        }
        else{
            throw new Error("Possui algum erro");
        }
    }
    
    public boolean programa(){
        if(lexemas.get(index).getToken().equals("program")){
            index++;
            if(lexemas.get(index).getTipoToken().equals(TipoToken.IDENTIFICADOR)){
                index++;
                if(lexemas.get(index).getTipoToken().equals(TipoToken.PONTO_VIRGULA)){
                    index++;
                    if(bloco()){
                        if(lexemas.get(index).getTipoToken().equals(TipoToken.PONTO))
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean bloco(){
        if(lexemas.get(index).getToken().equals("boolean") || lexemas.get(index).getToken().equals("int")){
            index++;
            if(!parteDeDeclaracoesDeVariaveis()){
                return false;
            }
        }
        if(lexemas.get(index).getToken().equals("procedure")){
            index++;
            if(!parteDeDeclaracoesDeSubrotinas()) return false;
        }
        if(lexemas.get(index).getToken().equals("begin")){
            index++;
            if(!comandoComposto())
                return false;
            else
                return true;
        }
        return false;
    }
    
    public boolean parteDeDeclaracoesDeVariaveis(){
        while(lexemas.get(index).getToken().equals("boolean") || lexemas.get(index).getToken().equals("int")){
            index++;
            if(declaracaoDeVariaveis()){
                if(lexemas.get(index).getToken().equals(";")){
                    index++;
                    if(buscarFimDeclaracao(lexemas.get(index), lexemas.get(index)))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean declaracaoDeVariaveis(){
        if(lexemas.get(index).getTipoToken().equals(TipoToken.IDENTIFICADOR)){
            index++;
            if(listaDeIdentificadores()){
                return true;
            }
        }
        return false;
    }
    
    public boolean listaDeIdentificadores(){
        while(lexemas.get(index).getTipoToken().equals(TipoToken.IDENTIFICADOR)){
            index++;
            if(lexemas.get(index).getToken().equals(",")){
                index++;
            }
        }
        return true;
    }
    
    public boolean parteDeDeclaracoesDeSubrotinas(){
        while(lexemas.get(index).getToken().equals("procedure")){
            if(declaracaoDeProcedimento()){
                if(lexemas.get(index).getToken().equals(";"))
                    index++;
                    return true;
                
            }   
        }
        return false;
    }
    
    public boolean declaracaoDeProcedimento(){
        index++;
        if(lexemas.get(index).getTipoToken().equals("IDENTIFICADOR")){
            index++;
            if(lexemas.get(index).getToken().equals("(")){
                if(!parametrosFormais())
                    return false;
            }
            if(lexemas.get(index).getToken().equals(";")){
                index++;
                return bloco();
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public boolean parametrosFormais(){
        index++;
        if(lexemas.get(index).getToken().equals("var"))
            index++;
        if(lexemas.get(index).getTipoToken().equals(TipoToken.IDENTIFICADOR)){
            if(secaoDeParametrosFormais()){
                while(lexemas.get(index).getToken().equals(";")){
                    index++;
                    if(lexemas.get(index).getToken().equals("var"))
                        index++;
                    if(lexemas.get(index).getTipoToken().equals(TipoToken.IDENTIFICADOR)){
                        if(!secaoDeParametrosFormais()){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                if(lexemas.get(index).getToken().equals(")")){
                    index++;
                    return true;
                }
                else{
                       return false;
                }
            }
            else
                return false;
        }
        else{
            return false;
        }
    }
    
    public boolean secaoDeParametrosFormais(){
        if(listaDeIdentificadores()){
            if(lexemas.get(index).getToken().equals(":")){
                index++;
                if(lexemas.get(index).getToken().equals("int") || lexemas.get(index).getToken().equals("boolean")){
                    index++;
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else
            return false;
    }
    
    public boolean comandoComposto(){
        index++;
        
        if(comando()){
            while(lexemas.get(index).getToken().equals(";")){
                index++;
                if(!comando())
                    return false;
            }
            if(lexemas.get(index).getToken().equals("end")){
                index++;
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    public boolean comando(){
        if(lexemas.get(index).getTipoToken().equals(TipoToken.IDENTIFICADOR)){
            index++;
            if(lexemas.get(index).getToken().equals(":=")){
                index++;
                return expressao();
            }
            if(lexemas.get(index).getToken().equals("(")){
                index++;
                if(listaDeExpressoes()){
                    if(lexemas.get(index).getToken().equals(")")){
                        index++;
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else
                    return false;
            }
            return true;
        }
        else{
            if(lexemas.get(index).getToken().equals("read") || lexemas.get(index).getToken().equals("write")){
                index++;
                if(lexemas.get(index).getToken().equals("(")){
                    index++;
                    if(listaDeExpressoes()){
                        if(lexemas.get(index).getToken().equals(")")){
                            index++;
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    else
                        return false;
                }
                else{
                    return false;
                }
            }
            else{
                if(lexemas.get(index).getToken().equals("begin"))
                    return comandoComposto();
                else{
                    if(lexemas.get(index).getToken().equals("if"))
                        return comandoCondicional();
                    else{
                        if(lexemas.get(index).getToken().equals("while"))
                            return comandoRepetitivo();
                        else{
                            return false;
                        }
                    }
                }
            }
        }
    }
    
    public boolean comandoCondicional(){
        index++;
        if(expressao()){
            if(lexemas.get(index).getToken().equals("then")){
                index++;
                if(comando()){
                    if(lexemas.get(index).getToken().equals("else")){
                        index++;
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
            else{
                return false;
            }
        }
        else
            return false;
    }
    
    public boolean comandoRepetitivo(){
        index++;
        if(expressao()){
            if(lexemas.get(index).getToken().equals("do")){
                index++;
                return comando();
            }
            else{
                return false;
            }
        }
        else
            return false;
    }
    
    public boolean expressao(){
        return true;
    }
    
    public boolean listaDeExpressoes(){
        if(expressao()){
            while(lexemas.get(index).getToken().equals(",")){
                index++;
                if(!expressao())
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
    
}