package kodlamaio.hrmsApp.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>  {
	
	//Bana başarılı bir data sonucu vereceksen bana data ver mesajı ver
		public ErrorDataResult(T data, String success) {
			super(data, false, success);
			//DataRResultta 3 veri tipi gönderen constructure a göre ayarladık. false bilgisi gnderdik
		}

		//Sadece data ile success bilgisi dööndürmek isteyebilriz
		public ErrorDataResult(T data) {
			super(data, false);
		}
		
		//sadece mesajı dndürebilirsin
		public ErrorDataResult(String message) {
			super(null, false, message);
		}
		
		//Hiç data vermezsen null ve true döndürür hallederim
		public ErrorDataResult() {
			super(null, false);
		}

}
