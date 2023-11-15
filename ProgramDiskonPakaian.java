import java.util.Scanner;

public class ProgramDiskonPakaian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runApplication = true;

        while (runApplication) {
            displayMainMenu();

            // Jika memilih 1 maka aplikasi akan dimulai
            int option = scanner.nextInt();
            scanner.nextLine();
            // Pilihan menu
            switch (option) {
                case 1:
                    System.out.println("\nSELAMAT DATANG ^_^\n");
                    processClothingOptions(scanner);
                    break;
                case 2:
                    // jika pilihan selain 1 maka keluar
                    System.out.println("\n\tTerima kasih");
                    System.out.println("\tSampai jumpa lagi ^_^\n");
                    runApplication = false;
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.");
                    break;
            }
        }
        while (runApplication)
            ;
    }

    private static void displayMainMenu() {
        /* Menu utama menampilkan permulaan aplikasi */
        System.out.println("\n+---------------------------------+");
        System.out.println("|                                 |");
        System.out.println("|   .-------------------------.   |");
        System.out.println("|   |    Selamat datang di    |   |");
        System.out.println("|   |         EM~Shop!        |   |");
        System.out.println("|   '-------------------------'   |");
        System.out.println("|   \\  1. Masuk   2. Keluar  /    |");
        System.out.println("|    \\________/                   |");
        System.out.println("|   _|___|__|__                   |");
        System.out.println("|  |_|___|__|__|                  |");
        System.out.println("|  .---------------------------.  |");
        System.out.println("|                                 |");
        System.out.println("+---------------------------------+");

        System.out.print("Masukkan pilihan anda: ");
    }

    private static void processClothingOptions(Scanner scanner) {
        boolean lanjutkan = true;
        while (lanjutkan) {
            System.out.println("\n========================================");
            System.out.println("---- <-EM~Shop Siap Melayani Anda-> ----");
            System.out.println("========================================\n");

            // Informasi tentang aturan Aplikasi
            System.out.println("+-------------------------------------+\n");
            System.out.println("+-------------------------------------+");
            System.out.println("|  Sebelum Memulai Pengecekan Diskon  |");
            System.out.println("|   Pakaian, Silahkan Dibaca Aturan   |");
            System.out.println("|              Aplikasi:              |");
            System.out.println("+---+---------------------------------+");
            System.out.println("| 1 | Toko menyediakan berbagai       |");
            System.out.println("|   | pilihan jenis pakaian, antara   |");
            System.out.println("|   | lain kemeja, blouse, dan        |");
            System.out.println("|   | gamis untuk pelanggan.          |");
            System.out.println("+---+---------------------------------+");
            System.out.println("| 2 | Saat pelanggan memilih          |");
            System.out.println("|   | 'kemeja', aplikasi akan         |");
            System.out.println("|   | menampilkan detail kemeja yang  |");
            System.out.println("|   | tersedia beserta diskon dan     |");
            System.out.println("|   | harga masing-masing model.      |");
            System.out.println("+---+---------------------------------+");
            System.out.println("| 3 | Pelanggan akan memilih model    |");
            System.out.println("|   | kemeja dengan memasukkan        |");
            System.out.println("|   | nomor model yang diinginkan.    |");
            System.out.println("+---+---------------------------------+");
            System.out.println("| 4 | Setelah pemilihan model,        |");
            System.out.println("|   | aplikasi akan menghitung        |");
            System.out.println("|   | harga setelah diskon berdasar   |");
            System.out.println("|   | model yang dipilih pelanggan.   |");
            System.out.println("+---+---------------------------------+");
            System.out.println("| 5 | Harga akhir produk akan         |");
            System.out.println("|   | ditampilkan kepada pelanggan.   |");
            System.out.println("+---+---------------------------------+");
            System.out.println("\n+-------------------------------------+");

            System.out.print("\nMasukkan nama anda: ");
            String nama = scanner.nextLine();

            System.out.println("\nBerikut Jenis Pakaian yang tersedia:");
            System.out.println("\t1. Kemeja");
            System.out.println("\t2. Blouse");
            System.out.println("\t3. Gamis");
            System.out.print("Silahkan pilih yang anda inginkan: ");
            int jenisPakaianOption = scanner.nextInt();
            scanner.nextLine();

            String jenisPakaian;

            switch (jenisPakaianOption) {
                case 1:
                    jenisPakaian = "Kemeja";
                    break;
                case 2:
                    jenisPakaian = "Blouse";
                    break;
                case 3:
                    jenisPakaian = "Gamis";
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    continue;
            }

            System.out.println("\nAnda memilih " + jenisPakaian + ".");

            displayClothingOptions(jenisPakaian);

            System.out.print("Pilih model " + jenisPakaian + " yang anda inginkan (1/2/3): ");
            int kategori = scanner.nextInt();
            scanner.nextLine();

            double harga = calculatePrice(jenisPakaian, kategori);
            if (kategori == 3) {
                System.out.println("Produk tidak sedang diskon, jadi harga produk adalah " + harga);
            } else {
                System.out.println("\n+---------------------------------------------+");
                System.out.println("\n\tWow!! Produk sedang ada diskon.");
                System.out.println("\nHarga produk yang anda pilih adalah " + "Rp" + harga);
                System.out.println("+---------------------------------------------+\n");
            }

            /*
             * Jika pelanggan selesai mengecek, maka berikan pilihan ingin lanjut
             * menggunakan aplikasi atau tidak
             */
            System.out.println("+--------------------------------------------+");
            System.out.println("|                                            |");
            System.out.println("|  Terima kasih telah menggunakan aplikasi!  |");
            System.out.println("|                                            |");
            System.out.println("|       Apakah Anda ingin memulai lagi?      |");
            System.out.println("|                 [ y ] Ya                   |");
            System.out.println("|                 [ t ] Tidak                |");
            System.out.println("|                                            |");
            System.out.println("+--------------------------------------------+");

            System.out.print("Masukkan pilihan Anda (y/t): ");
            String pilihan = scanner.nextLine();

            switch (pilihan.toLowerCase()) {
                case "y":
                    System.out.println("\nAnda memilih untuk memulai kembali aplikasi. Silakan lanjutkan.");
                    lanjutkan = false;
                    break;
                case "t":
                    System.out.println("\n\t\tTerima kasih ");
                    System.out.println("\t\tSampai jumpa. \n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.");
                    break;
            }
            // Setelah switch statement, tambahkan kondisi untuk memeriksa lanjutkan
            if (!lanjutkan) {
                break; // Keluar dari perulangan jika lanjutkan adalah false
            }
        }
    }

    private static void displayClothingOptions(String jenisPakaian) {
        System.out.println("Detail " + jenisPakaian + " yang tersedia:\n");
        switch (jenisPakaian.toLowerCase()) {
            case "kemeja":
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|                   Detail Jenis Pakaian                |");
                System.out.println("+-------------------------------------------------------+");
                System.out.println("| No |            Nama             | Diskon |   Harga   |");
                System.out.println("+----+-----------------------------+--------+-----------+");
                System.out.println("|  1 | Kemeja Motif Salur          |  10%   | Rp100.000 |");
                System.out.println("|  2 | Kemeja Flanel               |  30%   | Rp180.000 |");
                System.out.println("|  3 | Kemeja Katun (Tidak Diskon) |   -    | Rp100.000 |");
                System.out.println("+----+-----------------------------+--------+-----------+");
                break;
            case "blouse":
                System.out.println("+-------------------------------------------------------------+");
                System.out.println("|                     Detail Jenis Pakaian                    |");
                System.out.println("+-------------------------------------------------------------+");
                System.out.println("| No |               Nama                | Diskon |   Harga   |");
                System.out.println("+----+-----------------------------------+--------+-----------+");
                System.out.println("|  1 | Blouse Korea                      |  15%   | Rp120.000 |");
                System.out.println("|  2 | Blouse ZARA                       |  25%   | Rp150.000 |");
                System.out.println("|  3 | Blouse Motif bunga (Tidak Diskon) |   -    | Rp130.000 |");
                System.out.println("+----+-----------------------------------+--------+-----------+");
                break;
            case "gamis":
                System.out.println("+------------------------------------------------------+");
                System.out.println("|                 Detail Jenis Pakaian                 |");
                System.out.println("+------------------------------------------------------+");
                System.out.println("| No |            Nama            | Diskon |   Harga   |");
                System.out.println("+----+----------------------------+--------+-----------+");
                System.out.println("|  1 | Gamis Syar'i               |  50%   | Rp200.000 |");
                System.out.println("|  2 | Gamis Crinkel              |  30%   | Rp250.000 |");
                System.out.println("|  3 | Gamis Katun (Tidak Diskon) |   -    | Rp180.000 |");
                System.out.println("+----+----------------------------+--------+-----------+");
                break;
            default:
                System.out.println("Jenis pakaian tidak valid.");
                break;
        }
    }

    private static double calculatePrice(String jenisPakaian, int kategori) {
        double harga;
        switch (jenisPakaian.toLowerCase()) {
            case "kemeja":
                harga = hitungHargaKemeja(kategori);
                break;
            case "blouse":
                harga = hitungHargaBlouse(kategori);
                break;
            case "gamis":
                harga = hitungHargaGamis(kategori);
                break;
            default:
                System.out.println("Jenis pakaian tidak valid.");
                return 0;
        }
        // Format harga menjadi string tanpa desimal jika tidak diperlukan
        String formattedHarga = String.format("%.0f", harga);
        double parsedHarga = Double.parseDouble(formattedHarga);
        return parsedHarga;
    }

    private static double hitungHargaKemeja(int kategori) {
        switch (kategori) {
            case 1:
                return 100000 * 0.9;
            case 2:
                return 180000 * 0.7;
            case 3:
                return 100000;
            default:
                System.out.println("Kategori tidak valid.");
                return 0;
        }
    }

    private static double hitungHargaBlouse(int kategori) {
        double harga;
        switch (kategori) {
            case 1:
                harga = 120000 * 0.85;
                break;
            case 2:
                harga = 150000 * 0.75;
                break;
            case 3:
                harga = 130000;
                break;
            default:
                System.out.println("Kategori tidak valid.");
                return 0;
        }
        return harga;
    }

    private static double hitungHargaGamis(int kategori) {
        double harga;
        switch (kategori) {
            case 1:
                harga = 200000 * 0.8;
                break;
            case 2:
                harga = 250000 * 0.9;
                break;
            case 3:
                harga = 180000;
                break;
            default:
                System.out.println("Kategori tidak valid.");
                return 0;
        }
        return harga;
    }
}