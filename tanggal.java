import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;


public static String getTanggal(){
	String tgl ="";
	Date sekarang = new Date();
	
	SimpleDateFormat seting = new SimpleDateFormat("dd-MM-YYYY");
	tgl = seting.seting(sekarang);
	return tgl;
}
