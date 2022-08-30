package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class TestUploadFileController {

	@RequestMapping("/showUpload.do")
	public String showUpload() {
		return "upload";
	}
	@RequestMapping("/goUpload.do")
	public String goUpload(MultipartFile file) throws IOException {
		String str = file.getOriginalFilename();
		System.out.println(str);
		System.out.println(file.getContentType());
		File f = new File("/home/soft01/桌面/page/",str);
		file.transferTo(f);
		return "index";
	}
}
