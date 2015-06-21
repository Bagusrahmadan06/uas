import java.text.SimpleDateFormat;
import java.util.*;
public class ManageBarang
{
	public static Vector<dataBarang> dbBarang = new Vector<dataBarang>();
	public static Vector<UserLogin> dataUser = new Vector<UserLogin>();
	public static Scanner Scn = new Scanner(System.in);
	public static Vector idTrans = new Vector();
	public static Vector idBarang = new Vector();
	public static Vector hargaJual = new Vector();
	public static Vector NBarang = new Vector();
	public static Vector <Double>subTotal = new Vector<Double>();
	public static Vector <Double>Total = new Vector<Double>();
	public static Vector kuantiti = new Vector();
	public static String ID = "";
	public static String nBarang = "";
	public static int idx;
	public static boolean valid = false;
	
	public static void Barang() //menu buah
	{
		
		int Pilihan = 0;
		do
		{
			System.out.println();
			System.out.println("=========================================");
			System.out.println("     Toko Barang     ");
			System.out.println("=========================================");
			System.out.println();
			System.out.println("1. Tambah Barang");
			System.out.println("2. Data Barang");
			System.out.println("3. Hapus Barang");
			System.out.println("4. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-4): ");
			Pilihan = Scn.nextInt();
			System.out.println();
			switch(Pilihan)
			{
				case 1 : TambahBarang();
				break;
				case 2 : LihatBarang();
				break;
				case 3 : HapusBarang();
				break;
			}
		}while(Pilihan < 4);
	}
		
		//tambah buah
		
	public static void TambahBarang() 
	{
		System.out.println();
		System.out.println("=========================================");
		System.out.println("     Tambah Data Barang Baru     ");
		int index = 0;
		
		do
		{
			System.out.print("nomer Barang   : ");
			ID = Scn.next();
			//cariIdxID(ID, dbBarang);
		}
		while(!valid);
		System.out.print("Masukkan Nama Barang : ");
		String nmBarang = Scn.next();
		System.out.print("Masukkan Harga Barang  : Rp. ");
		int hgBarang = Scn.nextInt();
		dbBarang.add(new dataBarang(ID, nmBarang, hgBarang));
	}
	
	//lihat buah
	
	public static void LihatBarang() 
	{
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("No. ID_barang \t Nama_barang \t Harga Beli \t Harga Jual");
		System.out.println("==================================================================");
		int i = 0;
		for(dataBarang vBarang : dbBarang)
		{
			System.out.println((i+1) + ".  " + vBarang.getId() + "\t" + vBarang.getNamaBarang() + "\t\tRp. " + vBarang.getHargaBarang() + "\t\tRp. " + vBarang.getHargaJual());
			i++;
		}
		System.out.println("==================================================================");
	}
	
	//hapus buah
	
	public static void HapusBarang() 
	{
		int idx = -1;
		int i = 0;
		System.out.println();
		System.out.println("=========================================");
		System.out.println("     Hapus Data Barang     ");
		System.out.print("Masukkan nomer Barang yang akan dihapus : ");
		String ID = Scn.next();
		do
		{
			if(dbBarang.elementAt(i).getId().equals(ID))
			{
				idx = i;
			}
			i++;
		}while((i < dbBarang.size() && (idx == -1)));
		
		if(idx == -1)
		{
			System.out.println(ID + " Tidak ada ditemukan");
		}
		else
		{
			System.out.print("Apakah User " + ID + " akan dihapus (Y / T) : ");
			String Hapus = Scn.next();
			if(Hapus.equalsIgnoreCase("Y"))
			{
				dbBarang.removeElementAt(idx);
				System.out.println("User " + ID + " Berhasil dihapus");
				System.out.println("=========================================");
			}
		}
	}
	
	//cari id
	/*public static int cariIdxID(String Key, Vector<dataBarang> dBarang) 
	{
		int idx = -1;
		int i = 0;
		while((i < dbBarang.size()) && (idx == -1))
		{
			if(dbBarang.elementAt(i).getId().equals(Key))
			{
				idx = i;
			}
				i++;
		}
		if(idx != - 1)
			{
				System.out.println("ID " + ID + " Sudah ada dalam Tabel Barang");
			}
			else
			{
				valid = true;
			}
	}*/
	
	//cari id nama
	public static int cariIdxNama(String Key, Vector<dataBarang>vb) 
	{
		int indeks = -1;
		int i = 0;
		while((i < vb.size()) && (idx != -1))
		{
			if(dbBarang.elementAt(i).getNamaBarang().equalsIgnoreCase(Key))
			{
				indeks = i;
			}
				i++;
		}
		return indeks;
	}
	
	
	//transaksi
	public static void penjualan() 
	{
		Date date = new Date ();
		int idx=0;
		int idx2 = 0;
		String Trans = "";
		String NmBarang = "";
		String Tambah = "";
		double Ttl = 0;
			System.out.println("");
			System.out.println("Tanggal : "+date.toString());
			System.out.println("=======================================");
			System.out.print("Mau berapa transaksi anda? ");
			int jmltot = Scn.nextInt();
			int j=0;
			do
			{
			System.out.println("TRANSAKSI");
			Trans = Scn.next();
			idTrans.add(Trans);
				System.out.print("Nama Barang   : ");
				NmBarang = Scn.next();
				idx2 = cariIdxNama(NmBarang,dbBarang);
				if(idx2 == - 1)
				{
					System.out.println("Nama " + NmBarang + " Tidak ada dalam Tabel Barang");
				}
				else
				{
					NBarang.add(NmBarang);
					idBarang.add(dbBarang.elementAt(idx2).getId());
					System.out.print("Masukkan Jumlah Barang : ");
					double Kuantiti = Scn.nextDouble();
					kuantiti.add(Kuantiti);
					double subTtl = (dbBarang.elementAt(idx2).getHargaJual() * Kuantiti);
					subTotal.add(subTtl);
					Ttl += subTtl;
					Total.add(subTtl);
					hargaJual.add(dbBarang.elementAt(idx2).getHargaJual());
				}j++;
			}while(j<jmltot);
	}
	
	//hasil transaksi
	
	public static void reportPenjualan() 
	{
		double TotalBayar = 0;
		for(int i = 0; i < idTrans.size(); i++)
		{
			System.out.println("");
			System.out.println("========================================================");
			System.out.println("ID TRANSAKSI" + idTrans.elementAt(i));
			System.out.println("========================================================");
			System.out.println("ID Barang\t Barang\tHarga Jual\t Kuantiti\t Total");
			System.out.println("========================================================");
			for(int j = 0; j < idBarang.size(); j++)
			{
				System.out.println(idBarang.elementAt(j) + "\t" + NBarang.elementAt(j) + "\t" + hargaJual.elementAt(j) + "\t" + kuantiti.elementAt(j) + "\t" + subTotal.elementAt(j));TotalBayar += subTotal.elementAt(j);
			}
			System.out.println("========================================================");
			System.out.println("Total Keseluruhan : Rp. " + TotalBayar);
			TotalBayar=0;
			System.out.println("========================================================");
		}
	}
}
