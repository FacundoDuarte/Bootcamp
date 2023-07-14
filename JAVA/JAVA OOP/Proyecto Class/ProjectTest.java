public class ProjectTest{
    public static void main(String[] args) {
        Project project = new Project();
        Project project2 = new Project("Proyecto 2");
        Project project3 = new Project("Proyecto 3", "Descripcion del proyecto 3");

         project.setName("Proyecto 1");
         String nameProject1 = project.getName();
        project.setDescription("Descripcion del proyecto 1");
        String descriptionProject1 = project.getDescription();
        project.setInitialCost(20);
        double initialCostProject1 = project.getInitialCost();

        System.out.println(project.elevatorPitch(nameProject1, initialCostProject1,descriptionProject1));

        Portfolio portfolio = new Portfolio(project);
        System.out.println(portfolio.getPortfolioCost());
        System.out.println(portfolio.showPortfolio());
    }
}