/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlalg;

/**
 *
 * @author wesll
 */
public class Lexema {private String lexema;
    private String token;
    private int linha;
    private int coluna;

    public Lexema(String token, String lexema, int linha, int coluna) {
        this.lexema = lexema;
        this.token = token;
        this.linha = linha;
        this.coluna = coluna;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public String getLexema() {
        return lexema;
    }

    public String getToken() {
        return token;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
