package github.com.brunomeloesilva.cervejas.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import github.com.brunomeloesilva.cervejas.storage.FotoStorageRunnable;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	@PostMapping
	public DeferredResult<String> upload(@RequestParam("files[]") MultipartFile[] files) {
		
		DeferredResult<String> deferredResult = new DeferredResult<String>();
		Thread thread = new Thread(new FotoStorageRunnable(files, deferredResult));
		thread.start();
		return deferredResult;
	}
	
}