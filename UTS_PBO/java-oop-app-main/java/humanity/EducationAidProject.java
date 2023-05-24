package humanity;

public class EducationAidProject extends AidProject {
    private String targetGrade;

    public EducationAidProject(String projectName, String beneficiary, String address, int needAid, String targetGrade) {
        super(projectName, beneficiary, address, needAid);
        this.targetGrade = targetGrade;
    }

    public String getTargetGrade() {
        return targetGrade;
    }
    @Override
    public void displayProjectInfo() {
        System.out.println("Kategori            : Medis");
        System.out.println("Detail              : " + getTargetGrade());
    }
}
