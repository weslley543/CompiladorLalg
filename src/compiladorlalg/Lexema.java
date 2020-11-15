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
public class Lexema {
   public String token;
   public TipoToken tipoToken;
   public int linhaLida;
   public int colunaLida;

    public Lexema(String token, TipoToken tipoToken) {
        this.token = token;
        this.tipoToken = tipoToken;
    }
    
    public Lexema(String token, TipoToken tipoToken, int nLinha, int nColuna) {
        this.token = token;
        this.tipoToken = tipoToken;
        this.linhaLida = nLinha;
        this.colunaLida = nColuna;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TipoToken getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoToken tipoToken) {
        this.tipoToken = tipoToken;
    }

    public int getLinhaLida() {
        return linhaLida;
    }

    public void setLinhaLida(int linhaLida) {
        this.linhaLida = linhaLida;
    }

    public int getColunaLida() {
        return colunaLida;
    }

    public void setColunaLida(int colunaLida) {
        this.colunaLida = colunaLida;
    }

    
   
}
