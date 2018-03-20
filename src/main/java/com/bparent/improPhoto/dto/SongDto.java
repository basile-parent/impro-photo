package com.bparent.improPhoto.dto;

import com.bparent.improPhoto.util.FileUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongDto {

    private String nom;
    private String path;

    public SongDto(String nom) {
        this.nom = nom;
        this.path = FileUtils.formatPathWithCharacter("/handler/playlist/" + this.nom, "/");
    }

}
