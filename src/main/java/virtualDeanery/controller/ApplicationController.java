package virtualDeanery.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import virtualDeanery.model.User;

@Controller
public class ApplicationController {
	
	private static String UPLOADED_FOLDER = "C://podania//";
	
	@RequestMapping("/application")
	public String applicationController(Model model) {
		return "application";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model, HttpSession session) {

		User currentUser = (User) session.getAttribute("loggedInUser");
		
		try {
			
			byte[] bytes = file.getBytes();
			
			Path path = Paths.get(UPLOADED_FOLDER + currentUser.getId() + file.getOriginalFilename());
			
			Files.write(path, bytes);


		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("message", "Wysy³anie pliku zakoñczone powodzeniem");
		return "application";
	}

}
