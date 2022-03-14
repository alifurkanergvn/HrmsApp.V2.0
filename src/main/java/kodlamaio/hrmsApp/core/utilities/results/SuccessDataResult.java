package kodlamaio.hrmsApp.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

		//Bana başarılı bir data sonucu vereceksen bana data ver mesajı ver
		public SuccessDataResult(T data, String success) {
			super(data, true, success);
			//DataRResultta 3 veri tipi gönderen constructure a göre ayarladık. true bilgisi gnderdikl
		}

		//Sadece data ile success bilgisi dööndürmek isteyebilriz
		public SuccessDataResult(T data) {
			super(data, true);
		}
		
		//sadece mesajı dndürebilirsin
		public SuccessDataResult(String message) {
			super(null, true, message);
		}
		
		//Hiç data vermezsen null ve true döndürür hallederim
		public SuccessDataResult() {
			super(null, true);
		}
}
