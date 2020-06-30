package github.com.brunomeloesilva.cervejas.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<String> deferredResult;
	
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<String> deferredResult) {
		this.deferredResult = deferredResult;
		this.files = files;
	}

	@Override
	public void run() {
		
		System.out.println(">>> files: " + files[0].getSize());
		// TODO: Salvar a foto ....
		deferredResult.setErrorResult("Ok, foto recebida !");
	}
}
