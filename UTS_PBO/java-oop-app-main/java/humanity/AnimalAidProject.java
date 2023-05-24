package humanity;

public class AnimalAidProject extends AidProject {
    private String animalType;

    public AnimalAidProject(String projectName, String beneficiary, String address, int needAid, String animalType) {
        super(projectName, beneficiary, address, needAid);
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }
    @Override
    public void displayProjectInfo() {
        System.out.println("Kategori            : Hewan");
        System.out.println("Detail              : " + getAnimalType());
    }
}
