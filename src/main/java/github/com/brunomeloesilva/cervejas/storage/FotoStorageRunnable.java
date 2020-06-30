package github.com.brunomeloesilva.cervejas.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import github.com.brunomeloesilva.cervejas.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> deferredResult;
	
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> deferredResult) {
		this.deferredResult = deferredResult;
		this.files = files;
	}

	@Override
	public void run() {
		
		System.out.println(">>> files: " + files[0].getSize());
		// TODO: Salvar a foto ....
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		deferredResult.setResult(new FotoDTO(nomeFoto, contentType));
	}
}
