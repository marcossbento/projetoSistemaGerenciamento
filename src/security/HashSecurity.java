package security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HashSecurity {
    public String execute(String senha, int modifier){
        if(senha == null) return null;
        
           String senhaHash = "";
        try {
            MessageDigest md  = MessageDigest.getInstance("SHA-256");
            senha += String.valueOf(modifier);
            
            senhaHash = new BigInteger(1,md.digest(senha.getBytes("UTF-8"))).toString(16);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(HashSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  senhaHash;
   }
}

