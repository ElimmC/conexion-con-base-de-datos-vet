/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;

/**
 *
 * @author Gerardo Emmanuel
 */
public class cUsuario {

    private String _nombre = "";
    private String _apellidos = "";
    private String _mail = "";
    private char _genero = 'x';
    private int _idUsr = 0;
    private String _error = "";
    private boolean _valido = false;

    public cUsuario() {

    }

    public cUsuario(int idusr) {

        /*
        conectamos bd y validamos que exita el idusr
         */
        if (idusr == 1) {
            this._valido = true;
            this._idUsr = 1;
            this._error = "ok";
        }
    }

    public cUsuario(String usr, String psw) {
        /*
        metodo simulado para cambiar despues a la bd
         */

        if (usr.equals("elProfe") && psw.equals("4im7")) {
            this._valido = true;
            this._idUsr = 1;
            this._error = "ok";
        }
    }

    public int IDUSR() {
        return this._idUsr;
    }

    public boolean validaUsr() {
        /*
        conectamos a bd y regresamos
         */
        

        //de la base de datos
        if (this._idUsr == 1) {
            this._valido = true;
            this._error = "el papu de los papus pro +100000 lince";
        }
        else{
            this._error = "mal msj de lbd";
        }

        return this._valido;
    }

    public int registraUsr() {
        return this._idUsr;
    }

    public String ERROR() {
        return this._error;
    }

    public boolean RgistraUSR(String Nombre, String Apellidos
    , String pswd, String Email, char Genero, String fecha){
        
        BD.cDatos conex = new BD.cDatos();
        
        try{
            conex.conectar();
        
            ResultSet rsguarda = conex.consulta("call spGuardaCliente(0, '"+Nombre+"', 'Osiris x2');");
        
            if(rsguarda.next()){
                
                if (rsguarda.getString("msj").equals("Cliente guardado con exito")) {

                int rgesoDelSP = 2;//poner el sp
                this._idUsr = rgesoDelSP;
                this._error = rsguarda.getString("msj");

            }
            }
            
        
        }
        catch(Exception xxxxD){
            
        }
        if(this._idUsr>0){
            this._valido = true;
        }
        
        return this._valido;
    }
}
