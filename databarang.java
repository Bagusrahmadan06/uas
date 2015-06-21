public class dataBarang
{
	private String idBarang;
	private String namaBarang;
	private double jml;
	private double hargaBarang;
	private int hargaJual;
	private double Keuntungan;
	
	//constructor
	public dataBarang(String idBarang, String namaBarang, double hargaBarang)
	{
		this.idBarang = idBarang;
		this.namaBarang = namaBarang;
		this.hargaBarang = hargaBarang;
		hargaJual = (int)hargaBarang + (int)(hargaBarang * 0.1);
		Keuntungan = hargaJual - hargaBarang;
	}
	
	public String getId()
	{
		return idBarang;
	}
	
	public String getNamaBarang()
	{
		return namaBarang;
	}
	
	public double getHargaBarang()
	{
		return hargaBarang;
	}
	
	public double getJumlah()
	{
		return jml;
	}
	
	public double getHargaJual()
	{
		return hargaJual;
	}
	
	public void setHarga(double hargaBarang)
	{
		this.hargaBarang = hargaBarang;
	}
	
	public static double subTotal(double hargaJual, double jml)
	{
		return hargaJual * jml;
	}
	
	public void setNama(String namaBarang)
	{
		this.namaBarang = namaBarang;
	}
	
}
