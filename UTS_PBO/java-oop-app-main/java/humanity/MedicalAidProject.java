package humanity;

public class MedicalAidProject extends AidProject {
    private String medicalSpecialty;

    public MedicalAidProject(String projectName, String beneficiary, String address, int needAid, String medicalSpecialty) {
        super(projectName, beneficiary, address, needAid);
        this.medicalSpecialty = medicalSpecialty;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }
    @Override
    public void displayProjectInfo() {
        System.out.println("Kategori            : Medis");
        System.out.println("Detail              : " + getMedicalSpecialty());
    }
}
