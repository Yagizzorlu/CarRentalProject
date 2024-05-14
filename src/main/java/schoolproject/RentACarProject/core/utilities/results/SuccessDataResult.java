package schoolproject.RentACarProject.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data, true, message);  //Success olduğundan true/false bilgisini vermeden direkt true diye success bilgisi verebiliyoruz.
	}
	
	public SuccessDataResult(T data) {
		super(data,true);
	}
	
	public SuccessDataResult(String message) {
		super(null, true, message);
	}
	
	public SuccessDataResult() {
		super(null, true);
	}
	
}
