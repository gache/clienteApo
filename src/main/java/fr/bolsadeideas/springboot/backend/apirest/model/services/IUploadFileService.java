package fr.bolsadeideas.springboot.backend.apirest.model.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Resource cargarFoto(String nombreFoto) throws MalformedURLException;

	public String guardar(MultipartFile archivo) throws IOException;

	public boolean eliminar(String nombreFoto);

	public Path getPath(String nombreFoto);

}
