package app.web.mdibuhossain.crud.controller;

import app.web.mdibuhossain.crud.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("api/v1/image")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("image") MultipartFile file) {
        return ResponseEntity.ok(fileService.uploadImage(file));
    }

    @GetMapping(value = "/{imgID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("imgID") String imgID, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(fileService.getImage(imgID), response.getOutputStream());
    }
}
