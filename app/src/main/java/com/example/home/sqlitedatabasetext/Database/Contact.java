package com.example.home.sqlitedatabasetext.Database;

/**
 * Created by home on 10/8/2015.
 */
public class Contact {

    private String name,phone,city;
    long id;
    public String getName()
    {
        return name;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getCity()
    {
        return city;
    }
    public long getId()
    {
        return id;

    }
    public void setId(long s)
    {
        id=s;

    }
    public void setName(String s)
    {
        name=s;

    }
    public void setPhone(String s)
    {
        phone=s;

    }
    public void setCity(String s)
    {
        city=s;

    }
    public String toString()
    {
        return name;

    }

}
