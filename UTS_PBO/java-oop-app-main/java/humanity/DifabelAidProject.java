package humanity;

public class DifabelAidProject extends AidProject {
    private String disabilityType;

    public DifabelAidProject(String projectName, String beneficiary, String address, int needAid, String disabilityType) {
        super(projectName, beneficiary, address, needAid);
        this.disabilityType = disabilityType;
    }

    public String getDisabilityType() {
        return disabilityType;
    }
    @Override
    public void displayProjectInfo() {
        System.out.println("Kategori            : Difabel");
        System.out.println("Detail              : " + getDisabilityType());
    }
}
