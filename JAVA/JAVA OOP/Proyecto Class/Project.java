public class Project{
    private String name;
    private String description;
    private double initialCost;

    public Project(){
    }
    public Project(String name) {
        this.name = name;
    }
     public Project(String name,String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
      public String getDescription(){
        return description;
    }
      public void setDescription(String description){
        this.description = description;
    }
     public double getInitialCost(){
        return initialCost;
    }
    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }
        public String elevatorPitch(String name, double initialCost ,String description){
        return "Nombre: " + this.name + "(" + this.initialCost +") : "  + "Descripcion: " + this.description;
    }
}