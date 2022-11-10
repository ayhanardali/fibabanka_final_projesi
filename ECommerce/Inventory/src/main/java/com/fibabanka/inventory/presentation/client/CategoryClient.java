package com.fibabanka.inventory.presentation.client;

import com.fibabanka.inventory.business.dto.CategoryDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class CategoryClient {

    @GetMapping("/categories")
    @ResponseBody
    public List<CategoryDto> getCategories()
    {
        String url = "http://localhost:8081/api/inventory/categories/";
        RestTemplate restTemplate = new RestTemplate();
        List<CategoryDto> categoryDtoList = restTemplate.getForObject(url, List.class);
        System.out.println("getForObject(categories) başarılı.");
        return categoryDtoList;
    }

}
