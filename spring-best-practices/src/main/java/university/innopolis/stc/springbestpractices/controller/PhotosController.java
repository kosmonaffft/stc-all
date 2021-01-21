package university.innopolis.stc.springbestpractices.controller;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import university.innopolis.stc.springbestpractices.service.UsersService;

import java.io.IOException;

@Controller
public class PhotosController {

    private final UsersService usersService;

    public PhotosController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "upload")
    public String page() {
        return "upload";
    }

    @SneakyThrows(IOException.class)
    @PostMapping(path = "/upload_photo")
    public String upload(
            @RequestParam("id") Long id,
            @RequestParam("photo") MultipartFile file) {

        usersService.savePicture(id, file.getBytes());
        return "redirect:upload";
    }

    @GetMapping(path = "/users/{id}/picture", produces = "image/jpeg")
    public ResponseEntity<byte[]> getPicture(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .body(usersService.getPicture(id));
    }
}
