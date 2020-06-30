package github.com.brunomeloesilva.cervejas.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import github.com.brunomeloesilva.cervejas.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> deferredResult;
	private FotoStorage fotoStorage;
	
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> deferredResult, FotoStorage fotoStorage) {
		this.deferredResult = deferredResult;
		this.files = files;
		this.fotoStorage = fotoStorage;
	}

	@Override
	public void run() {
		
		String nomeFoto = this.fotoStorage.salvarTemporariamente(files);
		String contentType = files[0].getContentType();
		deferredResult.setResult(new FotoDTO(nomeFoto, contentType));
	}
}
