package com.bparent.improPhoto.controller;

import com.bparent.improPhoto.dao.CategorieDao;
import com.bparent.improPhoto.dao.DateImproDao;
import com.bparent.improPhoto.dao.RemerciementDao;
import com.bparent.improPhoto.domain.Remerciement;
import com.bparent.improPhoto.dto.CategorieDto;
import com.bparent.improPhoto.dto.DateImproDto;
import com.bparent.improPhoto.dto.RemerciementDto;
import com.bparent.improPhoto.dto.SongDto;
import com.bparent.improPhoto.exception.ImproMappingException;
import com.bparent.improPhoto.mapper.BasicMapper;
import com.bparent.improPhoto.mapper.CategorieMapper;
import com.bparent.improPhoto.mapper.DateImproMapper;
import com.bparent.improPhoto.util.FileUtils;
import com.bparent.improPhoto.util.IConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private CategorieDao categorieDao;

    @Autowired
    private DateImproDao dateImproDao;

    @Autowired
    private RemerciementDao remerciementDao;



    @Autowired
    private CategorieMapper categorieMapper;

    @Autowired
    private DateImproMapper dateMapper;

    @Autowired
    private BasicMapper<RemerciementDto, Remerciement> remerciementMapper;



    @RequestMapping("/categories")
    public List<CategorieDto> getAllCategories() throws ImproMappingException {
        return categorieMapper.toDto(this.categorieDao.findAll());
    }

    @RequestMapping("/dates")
    public List<DateImproDto> getAllDates() throws ImproMappingException {
        return dateMapper.toDto(DateImproDto.class, this.dateImproDao.findAll());
    }

    @RequestMapping("/remerciements")
    public List<RemerciementDto> getAllRemerciements() throws ImproMappingException {
        return remerciementMapper.toDto(RemerciementDto.class, this.remerciementDao.findAll());
    }

    @RequestMapping("/allPhotos")
    public List<String> getAllPhotos() throws ImproMappingException {
        return Arrays.stream(
                new File(IConstants.IPath.IPhoto.PHOTOS_INTRODUCTION)
                        .listFiles((dir, name) -> IConstants.PICTURE_EXTENSION_ACCEPTED.contains(FileUtils.getFileExtension(name.toLowerCase())))
                )
                .map(file -> file.getPath()) // ==> /photos
                .map(filePath -> FileUtils.formatPathWithCharacter("/handler/" + filePath, "/"))
                .collect(Collectors.toList());
    }

    @RequestMapping("/playlistSongs")
    public List<SongDto> getAllPlaylistSongs() throws ImproMappingException {
        return Arrays.stream(
                new File(IConstants.IPath.IAudio.AUDIOS_PLAYLIST)
                        .listFiles((dir, name) -> IConstants.AUDIO_EXTENSION_ACCEPTED.contains(FileUtils.getFileExtension(name.toLowerCase())))
                )
                .map(file -> file.getName()) // ==> /photos
                .map(fileName -> new SongDto(fileName, FileUtils.formatPathWithCharacter("/handler/playlist/" + fileName, "/")))
                .collect(Collectors.toList());
    }


    @RequestMapping("/jingles")
    public List<SongDto> getAllJingles() throws ImproMappingException {
        return Arrays.stream(
                new File(IConstants.IPath.IAudio.AUDIOS_JINGLES)
                        .listFiles((dir, name) -> IConstants.AUDIO_EXTENSION_ACCEPTED.contains(FileUtils.getFileExtension(name.toLowerCase())))
                )
                .map(file -> file.getName()) // ==> /photos
                .map(fileName -> new SongDto(fileName, FileUtils.formatPathWithCharacter("/handler/jingles/" + fileName, "/")))
                .collect(Collectors.toList());
    }


}
