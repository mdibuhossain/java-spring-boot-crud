package app.web.mdibuhossain.crud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileService {
    @Value("${spring.resources.static-locations}")
    private String staticLocation;
    public String uploadImage(MultipartFile file) {
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

//            Path path = Path.of(new ClassPathResource(staticLocation).getFile().getAbsolutePath());
//            Path path = Paths.get("uploads/image/");
            Path path = Paths.get(staticLocation);
            System.out.println(path.toString());
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Files.copy(file.getInputStream(), path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return "File uploaded successfully!";
        } catch (IOException ex) {
            return "Couldn't upload the file.";
        } catch (Exception e) {
            if (e.getMessage().length() > 0)
                return e.getMessage();
            return "Internet server error.";
        }
    }
}
