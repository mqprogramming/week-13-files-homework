package com.example.codeclan.files_hwk.controllers;

import com.example.codeclan.files_hwk.models.File;
import com.example.codeclan.files_hwk.models.Folder;
import com.example.codeclan.files_hwk.repositories.FileRepository;
import com.example.codeclan.files_hwk.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFiles() {
        List<Folder> foundFolders = folderRepository.findAll();
        return new ResponseEntity<List<Folder>>(foundFolders, HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFile(@PathVariable Long id) {
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

}

