package schoolproject.RentACarProject.core.utilities.results;

public class DataResult<T> extends Result {    //inheritance kullanıldı.

	private T data;
	
	public DataResult(T data, boolean success, String message) {
		super(success, message);   //super ile base sınıfın (Result) constructorlarını çalıştırmaya yarıyor.
		this.data = data;  //set etmiş olduk.
	}
	
	public DataResult(T data, boolean success) {  //message döndürmek istemeyebiliriz.
		super(success);
		this.data = data;  
	}
	
	public T getData() {    //Data bilgisini okumak için get etmemiz de lazım
		return this.data;
	}
	
}
