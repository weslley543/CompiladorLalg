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

    public Lexema(String token, TipoToken tipoToken) {
        this.token = token;
        this.tipoToken = tipoToken;
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

  
   
}
