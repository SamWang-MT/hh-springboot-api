package com.halcyon.file_manage.web;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.halcyon.file_manage.core.Result;
import com.halcyon.file_manage.core.ResultGenerator;

@RestController
@RequestMapping("/api/file")
public class FileController {
	private final Logger log = LoggerFactory.getLogger(FileController.class);

	@Value("${file.upload.url}")
	private String uploadFilePath;
	@Value("${file.upload.maxsize}")
	private Long uploadFileMaxSize;

	@PostMapping("/upload")
	public Result httpUpload(@RequestParam("files") MultipartFile files[]) {
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getOriginalFilename(); // 文件名
			long size = files[i].getSize();
			int lastIndexOf = fileName.lastIndexOf(".");
			String suffix = "";
			if (lastIndexOf != -1) {
				suffix = fileName.substring(lastIndexOf+1);
			}

			if (size > 15000000L || lastIndexOf == -1 || !suffix.equals("xls")) {
				log.error("{}{}", "文件格式异常 或文件过大，上传失败.", fileName);
				return ResultGenerator.genFailResult("文件格式异常 或文件过大，上传失败.");
			}

			File dest = new File(uploadFilePath + '/' + fileName);
			log.info("FileUpload SUCC -:fileName" + fileName + " -size:" + size + " -suffix:" + suffix + " -dest" + dest.getPath());
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			try {
				files[i].transferTo(dest);
			} catch (Exception e) {
				log.error("{}", e);

				return ResultGenerator.genFailResult("文件上传失败.");
			}
		}

		return ResultGenerator.genSuccessResult();
	}

}