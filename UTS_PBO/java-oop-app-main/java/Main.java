import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import humanity.*;

public class Main {
    private static List<AidProject> projects = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int menuOption = 0;
        while (menuOption != 6) {
            displayMenu();
            menuOption = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (menuOption) {
                case 1:
                    donateToProject();
                    System.out.println();
                    break;
                case 2:
                    proposeNewProject();
                    System.out.println();
                    break;
                case 3:
                    closeProject();
                    System.out.println();
                    break;
                case 4:
                    showAvailableProjects();
                    System.out.println();
                    break;
                case 5:
                    showProjectDetails();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("======================================");
                    System.out.println("||        Mengakhiri program        ||");
                    System.out.println("======================================");
                    break;
                default:
                    System.out.println("Opsi menu tidak sesuai (1-6)");
                    scanner.nextLine();
                    clearScreen();
                    System.out.println();
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("======================================");
        System.out.println("||  Aplikasi Bantuan untuk Negeri   ||");
        System.out.println("======================================");
        System.out.println("1. Donasi");
        System.out.println("2. Ajukan galang dana");
        System.out.println("3. Tutup galang dana");
        System.out.println("4. Tampilkan galang dana tersedia");
        System.out.println("5. Informasi detail galang dana");
        System.out.println("6. Akhiri");
        System.out.print("Pilih Menu: ");
    }

    private static void donateToProject() {
        if (projects.isEmpty()) {
            System.out.println("Belum ada galang dana yang diinisiasi.");
            scanner.nextLine();
            clearScreen();
            return;
        }

        System.out.print("Masukkan project ID: ");
        int projectId = scanner.nextInt();
        scanner.nextLine();

        AidProject project = findProjectById(projectId);
        if (project == null) {
            System.out.println("Galang dana tidak ditemukan...");
            scanner.nextLine();
            clearScreen();
            return;
        }

        if (project.isCompleted()) {
            System.out.println("Donasi tidak berhasil, galang dana telah berakhir...");
            scanner.nextLine();
            clearScreen();
            return;
        }

        System.out.print("Nominal donasi (> 10,000): ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        if (amount < 10000) {
            System.out.println("Nominal minimal donasi adalah 10,000...");
            scanner.nextLine();
            clearScreen();
            return;
        }

        project.addDonation(amount);
        System.out.println("Transaksi donasi berhasil ditambahkan");
        scanner.nextLine();
        clearScreen();
    }

    private static void proposeNewProject() {
        System.out.println("========================================");
        System.out.println("||      Ajukan Penggalangan Dana      ||");
        System.out.println("========================================");
        System.out.print("Nama proyek       : ");
        String projectName = scanner.nextLine();
    
        System.out.print("Penerima manfaat  : ");
        String beneficiary = scanner.nextLine();
    
        System.out.print("Alamat penerima   : ");
        String address = scanner.nextLine();
    
        System.out.print("Donasi yang dibutuhkan: ");
        int needAid = scanner.nextInt();
        scanner.nextLine();
    
        boolean validCategory = false;
        int category = 0;
        AidProject newProject = null;
    
        while (!validCategory) {
            System.out.println("--- Daftar Kategori ---");
            System.out.println("1. Medis");
            System.out.println("2. Edukasi");
            System.out.println("3. Lingkungan");
            System.out.println("4. Hewan");
            System.out.println("5. Difabel");
            System.out.print("Kategori: ");
            category = scanner.nextInt();
            scanner.nextLine();
    
            switch (category) {
                case 1:
                    System.out.print("Spesialis medis: ");
                    String medicalSpecialty = scanner.nextLine();
                    newProject = new MedicalAidProject(projectName, beneficiary, address, needAid, medicalSpecialty);
                    validCategory = true;
                    break;
                case 2:
                    System.out.print("Tingkat Pendidikan: ");
                    String targetGrade = scanner.nextLine();
                    newProject = new EducationAidProject(projectName, beneficiary, address, needAid, targetGrade);
                    validCategory = true;
                    break;
                case 3:
                    System.out.print("Detail Lingkungan: ");
                    String biosphereDetails = scanner.nextLine();
                    newProject = new BiosphereAidProject(projectName, beneficiary, address, needAid, biosphereDetails);
                    validCategory = true;
                    break;
                case 4:
                    System.out.print("Detail Hewan: ");
                    String animalDetails = scanner.nextLine();
                    newProject = new AnimalAidProject(projectName, beneficiary, address, needAid, animalDetails);
                    validCategory = true;
                    break;
                case 5:
                    System.out.print("Detail Difabel: ");
                    String difabelDetails = scanner.nextLine();
                    newProject = new DifabelAidProject(projectName, beneficiary, address, needAid, difabelDetails);
                    validCategory = true;
                    break;
                default:
                    System.out.println("Kategori tidak sesuai (1-5)");
                    scanner.nextLine();
                    clearScreen();
                    System.out.println();
                    break;
            }
        }
    
        projects.add(newProject);
        System.out.println("Proyek baru berhasil diajukan");
        scanner.nextLine();
        clearScreen();
    }
    
    

    private static void closeProject() {
        if (projects.isEmpty()) {
            System.out.println("Belum ada galang dana yang diinisiasi.");
            scanner.nextLine();
            clearScreen();
            return;
        }

        System.out.print("Masukkan project ID: ");
        int projectId = scanner.nextInt();
        scanner.nextLine();

        AidProject project = findProjectById(projectId);
        if (project == null) {
            System.out.println("Galang dana tidak ditemukan...");
            scanner.nextLine();
            clearScreen();
            return;
        }

        if (project.isCompleted()) {
            System.out.println("Proyek galang dana telah ditutup");
            scanner.nextLine();
            clearScreen();
            return;
        }

        project.completeProject();
        System.out.println("Proyek galang dana berhasil diakhiri");
        scanner.nextLine();
        clearScreen();
    }

    private static void showAvailableProjects() {
        if (projects.isEmpty()) {
            System.out.println("Belum ada galang dana yang diinisiasi.");
        } else {
            System.out.println("========================================");
            System.out.println("||       Daftar Proyek Tersedia       ||");
            System.out.println("========================================");
            int count = 1;
            for (AidProject project : projects) {
                System.out.println(count + ". " + project.getProjectName() + " - " + (project.isCompleted() ? "Done" : "On progress"));
                count++;
            }
        }
        scanner.nextLine();
        clearScreen();
    }
    
    private static void showProjectDetails() {
        if (projects.isEmpty()) {
            System.out.println("Belum ada galang dana yang diinisiasi.");
            scanner.nextLine();
            clearScreen();
            return;
        }
    
        System.out.print("Masukkan project ID: ");
        int projectId = scanner.nextInt();
        scanner.nextLine();
    
        AidProject project = findProjectById(projectId);
        if (project == null) {
            System.out.println("Galang dana tidak ditemukan...");
            scanner.nextLine();
            clearScreen();
            return;
        }
    
        System.out.println("=======================================");
        System.out.println("||          Informasi Detail         ||");
        System.out.println("=======================================");
        System.out.println("Nama Proyek         : " + project.getProjectName());
        System.out.println("Penerima manfaat    : " + project.getBeneficiary());
        System.out.println("Alamat penerima     : " + project.getAddress());
        System.out.println("Donasi terkumpul    : " + project.getCollectedDonation());
        System.out.println("Donasi dibutuhkan   : " + project.getNeedAid());
        project.displayProjectInfo();
        System.out.println("Status              : " + (project.isCompleted() ? "Telah Berakhir" : "Berlangsung"));
        System.out.println("--------------------------------------");
    
        scanner.nextLine();
        clearScreen();
    }
    
    
    
    private static AidProject findProjectById(int projectId) {
        for (AidProject project : projects) {
            if (project.getId() == projectId) {
                return project;
            }
        }
        return null;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}