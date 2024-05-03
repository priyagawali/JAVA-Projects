package com.iastech.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iastech.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		/*
		 * By using below line we will get file name of client file, but it is always
		 * recommanded that we should change that name
		 */
		String name = file.getOriginalFilename();
		System.out.println("file name1>>>" + name);
		//create folder if given path not existing
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		/*
		 * by using above line, we get file name of client file, now we have to use
		 * other name , so by using below line we can generate RANDOM NAME to file
		 */

		String randomID = UUID.randomUUID().toString();
		String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
		// full path
		String filePath = path + File.separator + fileName1;
		
		// file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + File.separator + fileName;
		InputStream is = new FileInputStream(fullPath);

		return is;
	}

}
