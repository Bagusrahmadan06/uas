import java.util.*;
public class ManageUser
{
	public static Vector<UserLogin> dataUser = new Vector<UserLogin>();
	public static Scanner Scn = new Scanner(System.in);
	
	public static void TambahUser() // Tambah User
	{
		System.out.println();
		System.out.println("=========================================");
		System.out.println("     Tambah User     ");
		System.out.print("Masukkan Username Baru : ");
		String userName = Scn.next();
		System.out.print("Masukkan Password : ");
		String password = Scn.next();
		System.out.print("Masukkan Bagian : ");
		String type = Scn.next();
		UserLogin userBaru = new UserLogin(userName, password, type);
		dataUser.add(userBaru);
	}
	
	public static void LihatUser() // Lihat Data User
	{
		System.out.println();
		System.out.println("No. Username \t Password \t Bagian");
		System.out.println("===========================================");
		int i = 0;
		for(UserLogin vUser : dataUser)
		{
			System.out.println((i+1) + ".  " + vUser.getUserName() + "\t" + vUser.getPassword() + "\t\t" + vUser.getType());
			i++;
		}
		System.out.println("==========================================");
	}
	
	public static void HapusUser() // Hapus Data User
	{
		int idx = -1;
		int i = 0;
		System.out.println();
		System.out.println("=======================================");
		System.out.println("     Hapus User     ");
		System.out.print("Masukkan nama User yang akan dihapus : ");
		String userName = Scn.next();
		do
		{
			if(dataUser.elementAt(i).getUserName().equals(userName))
			{
				idx = i;
			}
			i++;
		}while((i < dataUser.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(userName + " TIDAK ADA");
		}
		else
		{
			System.out.print("Apakah User " + userName + " akan dihapus (Y / T) : ");
			String Hapus = Scn.next();
			if(Hapus.equalsIgnoreCase("Y"))
			{
				dataUser.removeElementAt(idx);
				System.out.println("User " + userName + " Berhasil dihapus");
			}
		}
	}
	
	public static void GantiPass() //Ganti Password
	{
		int idx = -1;
		int i = 0;
		System.out.println();
		System.out.println("=======================================");
		System.out.println("     Ganti Password User     ");
		System.out.print("Masukkan nama User yang akan diubah Password \t: ");
		String usrName = Scn.next();
		do
		{
			if(dataUser.elementAt(i).getUserName().equals(usrName))
			{
				idx = i;
			}
			i++;
		}while((i < dataUser.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(usrName + " TIDAK ADA");
		}
		else
		{
			System.out.print("Masukkan Password Baru : ");
			String newPass = Scn.next();
			dataUser.elementAt(idx).setPassword(newPass);
			System.out.println("Password " + usrName + " Berhasil diganti");
		}
	}
	
	public static void MenuAdmin() //menu admin
	{
		//boolean halamanAdmin = false;
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("===================================");
			System.out.println(" 		  Admin    ");
			System.out.println(" 		Toko Barang	  ");
			System.out.println("===================================");
			System.out.println("1. User");
			System.out.println("2. lihat barang");
			System.out.println("3. Laporan Penjualan");
			System.out.println("4. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-4): ");
			Pilihan = Scn.nextInt();
			switch(Pilihan)
			{
				case 1 : User();
				break;
				case 2 : ManageBarang.Barang();
				break;
				case 3 : ManageBarang.reportPenjualan();
				break;
			}
		}while(Pilihan < 4);
	}
	
	public static void MenuKasir() //menu kasir
	{
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("====================================");
			System.out.println("     Menu Kasir    ");
			System.out.println(" 	  Toko Toserba	   ");
			System.out.println("====================================");
			System.out.println("1. Penjualan");
			System.out.println("2. Lihat Data Barang");
			System.out.println("3. Laporan Penjualan barang");
			System.out.println("4. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-4) : ");
			Pilihan = Scn.nextInt();
			switch(Pilihan)
			{
				case 1 : ManageBarang.penjualan();
				break;
				case 2 : ManageBarang.LihatBarang();
				break;
				case 3 : ManageBarang.reportPenjualan();
				break;
			}
		}while(Pilihan < 4);
		
	}
	
	public static void User() //user
	{
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("===============================");
			System.out.println("	  Admin    ");
			System.out.println("	Toko Toserba    ");
			System.out.println("===============================");
			System.out.println("1. Tambah User");
			System.out.println("2. Lihat User");
			System.out.println("3. Hapus User");
			System.out.println("4. Ganti Password User");
			System.out.println("5. Keluar");
			System.out.print(" Masukkan Pilihan Anda (1-5) : ");
			Pilihan = Scn.nextInt();
			switch(Pilihan)
			{
				case 1 : TambahUser();
				break;
				case 2 : LihatUser();
				break;
				case 3 : HapusUser();
				break;
				case 4 : GantiPass();
				break;
				default:break;
			}
		}while(Pilihan < 5);
	}
	
	public static void main(String[] args)
	{
		ManageBarang.dbBarang.add(new dataBarang("001","Kaos",15000));
		ManageBarang.dbBarang.add(new dataBarang("002","Sepatu",60000));
		ManageBarang.dbBarang.add(new dataBarang("003","celana",70000));
		ManageBarang.dbBarang.add(new dataBarang("004","kemeja",80000));
		dataUser.add(new UserLogin("admin","123","admin"));
		dataUser.add(new UserLogin("kasir","345","kasir"));
		int Pilihan = 0;
		boolean loginSukses = false;
		if(!cekPass())
		{
			loginSukses = true;
		}
	}
	
	public static boolean cekPass() // Cek User dan Password
	{
		boolean Benar = false;
		//String userLgn = "";
		//String passLgn = "";
		int i = 0;
		do
		{
			
			System.out.println();
			System.out.println("masuk login");
			System.out.println();
			System.out.print("Masukkan User name : ");
			String userLgn = Scn.next();
			System.out.print("Masukkan Password : ");
			String passLgn = Scn.next();
			System.out.println();
			int a = 0;
			int idx = -1;
			do
			{
				if(dataUser.elementAt(a).checkPassUser(userLgn, passLgn, "admin"))
				{
					System.out.println("\"Selamat Anda masuk ke Admin\"");
					Benar = true;
					MenuAdmin();
				}
				else if(dataUser.elementAt(a).checkPassUser(userLgn, passLgn, "kasir"))
				{
					System.out.println("\"Selamat Anda masuk ke Kasir\"");
					Benar = true;
					MenuKasir();
				}
				a++;
			}while(a < dataUser.size());
			i++;
			System.out.println("\"Login gagal\"");
		}while((Benar = true) && (i < 3));
		System.out.println("");
		System.out.println("======================================");
		System.out.println("\"Maaf login anda salah\"");
		System.out.println("======================================");
		return Benar;
	}
}
