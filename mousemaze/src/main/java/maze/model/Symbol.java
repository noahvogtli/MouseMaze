package maze.model;

public enum Symbol 
{

    M("Mouse"),
    B("Bush"),
    P("Path"),
    C("Cheese"),
    G("Grass");


    private String name;

    private Symbol(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    

}
