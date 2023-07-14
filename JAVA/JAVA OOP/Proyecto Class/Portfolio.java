import java.util.ArrayList;

public class Portfolio {
    private Project projects;

    public Portfolio( Project projects){
        this.projects = projects;
    }
    public Project getProjects(){
        return projects;
    }
    public double getPortfolioCost(){
        return projects.getInitialCost();
    }
    public String showPortfolio(){
        return "Portfolio: " + projects.elevatorPitch(projects.getName(), projects.getInitialCost(),projects.getDescription());  
    }
}
