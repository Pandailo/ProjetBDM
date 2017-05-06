/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

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

    public String getSql_type()
    {
        return sql_type;
    }

    public void setSql_type(String sql_type)
    {
        this.sql_type = sql_type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public void setSynopsis(String synopsis)
    {
        this.synopsis = synopsis;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getDuree()
    {
        return duree;
    }

    public void setDuree(int duree)
    {
        this.duree = duree;
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public Ref getSaison()
    {
        return saison;
    }

    public void setSaison(Ref saison)
    {
        this.saison = saison;
    }
     Ref saison;
    public episode(){}
    @Override
    public String getSQLTypeName() throws SQLException
    {
       return "YV965015.PBDM_EPISODE_TYPE";
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
        this.nom=stream.readString();
        this.numero=stream.readInt();
        saison=stream.readRef();
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
