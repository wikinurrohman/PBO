package humanity;

public abstract class AidProject {
    private static int idCounter = 1;
    private int id;
    private String projectName;
    private String beneficiary;
    private String address;
    private int needAid;
    private int collectedDonation;
    private boolean completed;

    public AidProject(String projectName, String beneficiary, String address, int needAid) {
        this.id = idCounter++;
        this.projectName = projectName;
        this.beneficiary = beneficiary;
        this.address = address;
        this.needAid = needAid;
        this.collectedDonation = 0;
        this.completed = false;
    }
    
    public abstract void displayProjectInfo();

    public int getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public String getAddress() {
        return address;
    }

    public int getNeedAid() {
        return needAid;
    }

    public int getCollectedDonation() {
        return collectedDonation;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void addDonation(int amount) {
        collectedDonation += amount;
        if (collectedDonation >= needAid) {
            completed = true;
        }
    }

    public void completeProject() {
        completed = true;
    }
}