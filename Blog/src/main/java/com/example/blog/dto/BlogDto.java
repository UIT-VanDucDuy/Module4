package com.example.blog.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private int id;
    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(min = 5, max = 255, message = "Tiêu đề phải từ 5 đến 255 ký tự")
    private String title;

    @NotNull(message = "Danh mục không được để trống")
    private Integer categoryId;

    @NotBlank(message = "Nội dung không được để trống")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
