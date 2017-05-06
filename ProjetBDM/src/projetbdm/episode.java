/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbdm;

import java.sql.*;

/**
 *
 * @author Yann
 */
public class episode implements SQLData
{
    String sql_type;
     int id;
     String date;
     String nom;
     String synopsis;
     String genre;
     int duree;
     int numero;
    public episode(){}
    @Override
    public String getSQLTypeName() throws SQLException
    {
       return "yv965015.PBDM_Episode_Type";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException
    {
        sql_type = typeName;
        id=stream.readInt();
        date=stream.readString();
        nom=stream.readString();
        this.synopsis=stream.readString();
        this.genre=stream.readString();
        this.duree=stream.readInt();
        this.numero=stream.readInt();
        
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException
    {
        stream.writeInt(id);
        stream.writeString(date);
        stream.writeString(nom);
        stream.writeString(synopsis);
        stream.writeString(genre);
        stream.writeInt(duree);
        stream.writeInt(numero);
    }
    
}
