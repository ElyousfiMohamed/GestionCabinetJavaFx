/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IMetier;

import DataBaseConnexion.SingletonConnexionDB;
import java.sql.Connection;

/**
 *
 * @author ELYOUSFI
 */
public class IMetierImpl implements IMetier{
    private Connection conn;

    public IMetierImpl() {
        conn = SingletonConnexionDB.getConnection();
    }
    
    
    
}
