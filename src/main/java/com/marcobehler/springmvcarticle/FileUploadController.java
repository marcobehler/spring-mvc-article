package com.marcobehler.springmvcarticle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam MultipartFile file) throws IOException {
        // don't generate upload files like this in a real project.
        // give them random names and save their uploaded name as metadata in a database or similar
        final Path uploadDestination = Paths.get("C:\\uploads").resolve(file.getName());

        file.transferTo(uploadDestination);
        return "redirect:/";
    }

}
