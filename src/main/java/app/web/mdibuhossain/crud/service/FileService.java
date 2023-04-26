package app.web.mdibuhossain.crud.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileService {
    @Value("${spring.resources.static-locations}")
    private String staticLocation;
    @Autowired
    private ResourceLoader resourceLoader;

    public String upload(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new Exception("file not send.");
            }
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            int lastDotIndex = fileName.lastIndexOf('.');
            if ((lastDotIndex > 0) && (lastDotIndex < fileName.length() - 1)) {
                fileName = System.currentTimeMillis() + "." + fileName.substring(lastDotIndex + 1);
            } else {
                throw new Exception("File extension not found!");
            }

            Path path = Paths.get(staticLocation);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Files.copy(file.getInputStream(), path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return "File uploaded successfully: " + fileName;
        } catch (IOException ex) {
            return "Couldn't upload the file.";
        } catch (Exception e) {
            if (e.getMessage().length() > 0)
                return e.getMessage();
            return "Internet server error.";
        }
    }

    public InputStream image(String imgID) throws IOException {
        Path filePath = Paths.get(staticLocation + imgID);
        return (InputStream) new UrlResource(filePath.toUri()).getInputStream();
    }
}
