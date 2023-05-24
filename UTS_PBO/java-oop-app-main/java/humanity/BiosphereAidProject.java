package humanity;

public class BiosphereAidProject extends AidProject {
    private String biosphereType;

    public BiosphereAidProject(String projectName, String beneficiary, String address, int needAid, String biosphereType) {
        super(projectName, beneficiary, address, needAid);
        this.biosphereType = biosphereType;
    }

    public String getBiosphereType() {
        return biosphereType;
    }
    @Override
    public void displayProjectInfo() {
        System.out.println("Kategori            : Lingkungan");
        System.out.println("Detail              : " + getBiosphereType());
    }
}
