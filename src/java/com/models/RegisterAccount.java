/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author twozer00
 */
public class RegisterAccount {
    
    private RegisterClient rgc = new RegisterClient();
    private isClient val = new isClient();
    public void rac(accounts account){
        rgc = new RegisterClient();
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(isClient.path+"accounts.json"));
            JSONArray jsonArray = (JSONArray)obj;
            
            System.out.println(jsonArray);
            
            
            
            JSONObject cl = new JSONObject();
            cl.put("account_number", account.getNaccount());
            cl.put("client_number", account.getNclient());
            cl.put("type", account.getType());
            cl.put("amount", account.getAmount());
            cl.put("date", account.getDate());
            rgc.addAccountToClient(account.getNclient(),account.getNaccount());
            
            
            jsonArray.add(cl);
            //jsonArray.
            
            System.out.println(jsonArray);
            FileWriter file = new FileWriter(isClient.path+"accounts.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegisterAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateNclient(String naccount,String nclient){
        JSONObject acc = val.account("",naccount);
        //acc.replace("client_number", nclient);
        
        
        
    }
    
    
}
