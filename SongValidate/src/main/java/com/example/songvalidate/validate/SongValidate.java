package com.example.songvalidate.validate;

import com.example.songvalidate.entity.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.springframework.util.StringUtils;

public class SongValidate implements Validator {
    // Xác định validator này dùng cho class nào
    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song songDto = (Song) target;

        // Regex loại bỏ ký tự đặc biệt (chỉ cho phép chữ, số, khoảng trắng)
        String invalidCharsRegex = ".*[@;,.=\\-+!#$%^&*(){}\\[\\]<>?\\\\/|`~].*";

        // ----- Validate TÊN BÀI HÁT -----
        if (!StringUtils.hasText(songDto.getName())) {
            errors.rejectValue("name", "song.name.empty", "Tên bài hát không được để trống");
        } else if (songDto.getName().length() > 800) {
            errors.rejectValue("name", "song.name.length", "Tên bài hát không vượt quá 800 ký tự");
        } else if (songDto.getName().matches(invalidCharsRegex)) {
            errors.rejectValue("name", "song.name.invalid", "Tên bài hát không được chứa ký tự đặc biệt");
        }

        // ----- Validate NGHỆ SĨ -----
        if (!StringUtils.hasText(songDto.getArtist())) {
            errors.rejectValue("artist", "song.artist.empty", "Nghệ sĩ không được để trống");
        } else if (songDto.getArtist().length() > 300) {
            errors.rejectValue("artist", "song.artist.length", "Nghệ sĩ không vượt quá 300 ký tự");
        } else if (songDto.getArtist().matches(invalidCharsRegex)) {
            errors.rejectValue("artist", "song.artist.invalid", "Nghệ sĩ không được chứa ký tự đặc biệt");
        }

        // ----- Validate THỂ LOẠI -----
        if (!StringUtils.hasText(songDto.getGenre())) {
            errors.rejectValue("genre", "song.genre.empty", "Thể loại không được để trống");
        } else if (songDto.getGenre().length() > 1000) {
            errors.rejectValue("genre", "song.genre.length", "Thể loại không vượt quá 1000 ký tự");
        } else if (songDto.getGenre().matches(".*[@;.=\\-+!#$%^&*(){}\\[\\]<>?/|`~].*")) {
            errors.rejectValue("genre", "song.genre.invalid", "Thể loại chỉ được phép chứa dấu phẩy (,)");
        }
    }
}
