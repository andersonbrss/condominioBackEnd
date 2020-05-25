package com.zends.condominio.upload.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zends.condominio.comum.exception.ObjectNotFoundException;
import com.zends.condominio.comum.service.AbstractService;
import com.zends.condominio.upload.domain.Upload;
import com.zends.condominio.upload.repository.UploadRepository;

@Service
public class UploadService implements AbstractService<Upload> {

	@Autowired
	private UploadRepository dao;

	@Autowired
	MessageSource messageSource;

//    public Upload storeFile(MultipartFile file) {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        try {
//            // Check if the file's name contains invalid characters
//            if(fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }
//
//            Upload dbFile = new Upload(fileName, file.getContentType(), file.getBytes());
//
//            return dao.save(dbFile);
//        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//        }
//    }
//
//    public Upload getFile(Long fileId) {
//        return dao.findById(fileId)
//                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
//    }

	@Override
	public ResponseEntity<Upload> getObj(Long idObj) {
		Optional<Upload> arquivo = dao.findById(idObj);
		if (!arquivo.isPresent()) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("erro.consulta", null, LocaleContextHolder.getLocale()));
		}
		return new ResponseEntity<Upload>(arquivo.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Upload>> getList() {
		List<Upload> listaArquivos = dao.findAllByOrderByIdDesc();
		if (listaArquivos.isEmpty()) {
			throw new ObjectNotFoundException(String.format(
					messageSource.getMessage("lista.vazia", null, LocaleContextHolder.getLocale()), "Arquivos"));
		}
		return new ResponseEntity<List<Upload>>(listaArquivos, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> save(Upload obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public ResponseEntity<Upload> save(MultipartFile file) throws IOException {
		String nomeArquivo = file.getOriginalFilename();
		Upload dbFile = new Upload(nomeArquivo, file.getContentType(), file.getBytes());
		dao.save(dbFile);
		return new ResponseEntity<Upload>(dbFile, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<Upload> update(Upload obj) {
		if (obj.getId() == null) {
			throw new ObjectNotFoundException(String.format(
					messageSource.getMessage("erro.atualizacao", null, LocaleContextHolder.getLocale()), "Arquivo"));
		}
		getObj(obj.getId());
		obj = dao.save(obj);
		return new ResponseEntity<Upload>(obj, HttpStatus.OK);

	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idObj) {
		getObj(idObj);
		dao.deleteById(idObj);
		return ResponseEntity.noContent().build();
	}

}