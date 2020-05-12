package com.example.codeclan.files_hwk.components;

import com.example.codeclan.files_hwk.models.File;
import com.example.codeclan.files_hwk.models.Folder;
import com.example.codeclan.files_hwk.models.User;
import com.example.codeclan.files_hwk.repositories.FileRepository;
import com.example.codeclan.files_hwk.repositories.FolderRepository;
import com.example.codeclan.files_hwk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private UserRepository userRepository;

    public void run(ApplicationArguments args){

        userRepository.deleteAll();
        folderRepository.deleteAll();
        fileRepository.deleteAll();

        User user1 = new User("Matt");
        userRepository.save(user1);

        Folder folder = new Folder("new folder", user1);
        folderRepository.save(folder);

        File text = new File(".txt", 11.5, folder);
        fileRepository.save(text);

        folder.addFile(text);
        folderRepository.save(folder);

        user1.addFolder(folder);
        userRepository.save(user1);

    }

}
