package com.marcobehler.springmvcarticle;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Controller
public class FileDownloadController {

    @RequestMapping(value = "/download/{jpgName}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadJpg(
            @PathVariable String jpgName) throws IOException {

        //  Resource downloadResource = new InputStreamResource(soimeinputStream)
        //  Resource downloadResource = new ByteArrayResource(someByteArray)
        //  Resource downloadResource = new FileSystemResource(someFile)
        final ClassPathResource downloadResource = new ClassPathResource(jpgName);

        if (!downloadResource.exists()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        HttpHeaders headers = new HttpHeaders();

        // 1. set the correct content type
        headers.setContentType(MediaType.IMAGE_JPEG);

        // 2. set the correct content length, maybe stored in a db table
        headers.setContentLength(downloadResource.contentLength());

        // 3. if you want to force downloads, otherwise attachments might be displayed directly in the brwoser
        headers.setContentDispositionFormData("attachment", jpgName);

        return new ResponseEntity<>(downloadResource, headers, HttpStatus.OK);
    }
}
