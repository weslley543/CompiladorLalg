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
public class CompiladorLalg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnalisadorLexico al = new AnalisadorLexico();
        //al.buscarPalavraReservada("for");
//        al.analisadorLexico("C:\\Users\\giuli\\OneDrive\\Documentos\\teste2.txt");
//        ArrayList <Lexema> lexemas = al.lexemas;
//        
//        for(int i = 0; i < lexemas.size(); i++){
//            System.out.println(lexemas.get(i).token + " - " + lexemas.get(i).getTipoToken());
//        }

        UIPrincipal principal = new UIPrincipal();
        principal.setVisible(true);
    }
    
}
