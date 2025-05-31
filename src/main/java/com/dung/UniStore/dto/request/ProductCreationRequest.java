package com.dung.UniStore.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreationRequest {
        @NotBlank(message = "ProDuctName is required!")
        @Size(min=3, max=200,message = "Tên sản phẩm phải từ 3 đến 200 kí tự")
        private String name;
        @Min(value =0 , message = "Giá phải lớn hơn 0")
        @Max(value = 1000000000, message = "Giá phải nhỏ hơn 1.000.000.000")
        private float price;
        private String description;
        private int categoryId;
        private Double discount;
        private String brand;
        private String model;
        private Byte available;
//        private List<String> imageUrls;
        private List<String> colors;
        private ProductDetailsRequest details;

}
