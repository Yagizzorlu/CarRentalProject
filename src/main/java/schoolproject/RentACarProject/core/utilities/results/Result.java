package schoolproject.RentACarProject.core.utilities.results;

public class Result {
	private boolean success;
	private String message;
	
	public Result (boolean success) {  //Sadece true/false döndürmek isteyebiliriz.
		this.success= success;
	}
	
    public Result (boolean success, String message) {      //Polimorpshism uygulandı.
		this(success);
		this.message = message;    //ilgili nesneleri yapılandırmış olduk.
	}
    
    public boolean isSuccess() {    //Dışarıdan erişim için uygulandı.
    	return this.success;
    }
    
    public String getMessage() {
    	return this.message;
    }
}
