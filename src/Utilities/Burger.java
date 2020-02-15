package Utilities;


import java.io.Serializable;
/**
 * A Serializable Burger class
 */
public class Burger implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name;

    /**
     * A constructor
     *
     * @param name
     *           the burger name
     */
    public Burger(String name)
    {
        this.name = name;
    }

    /**
     * Getter for burger name
     *
     * @return the burger name
     */
    public String getName()
    {
        return name;
    }

    /**
     * A string representation of a burger
     *
     * @return a string representation of a burger
     */
    @Override
    public String toString()
    {
        return "Burger: " + name;
    }

    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof Burger))
            return false;
        Burger b = (Burger) obj;
        return name.equalsIgnoreCase(b.name);
    }
}

