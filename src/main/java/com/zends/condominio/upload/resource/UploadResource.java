package com.zends.condominio.upload.resource;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zends.condominio.upload.domain.Upload;
import com.zends.condominio.upload.service.UploadService;

@CrossOrigin("*")
@RestController
@RequestMapping("/upload")
public class UploadResource {


    @Autowired
    private UploadService service;

//    @PostMapping("/uploadArquivo")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        Upload dbFile = dbFileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/recuperaImagem/")    
//                .toUriString();	
//
//        return new UploadFileResponse(dbFile.getNomeArquivo(), fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//
//    @PostMapping("/uploadVariosArquivos")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/recuperaImagem/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
//        // Load file from database
//    	Upload dbFile = dbFileStorageService.getFile(fileId);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFile.getTipoArquivo()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getNomeArquivo() + "\"")
//                .body(new ByteArrayResource(dbFile.getArquivo()));
//    }
    
	@GetMapping
	private ResponseEntity<List<Upload>> getList() {
		return service.getList();
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> getArquivo(@PathVariable("id") Long idDominio) {
		
  	ResponseEntity<Upload> dbFile = service.getObj(idDominio);
  	
      return ResponseEntity.ok()
              .contentType(MediaType.parseMediaType(dbFile.getBody().getTipoArquivo()))
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getBody().getNomeArquivo() + "\"")
              .body(new ByteArrayResource(dbFile.getBody().getArquivo()));
	}
	
	@PostMapping
	private ResponseEntity<?> save(@RequestParam("file") MultipartFile file) throws IOException  {		
		 return service.save(file);	      
	}
  

	@PutMapping
	private ResponseEntity<?> update(@RequestBody Upload arquivo) {
		return service.update(arquivo);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") Long idArquivo) {
		return service.delete(idArquivo);
	}

}
