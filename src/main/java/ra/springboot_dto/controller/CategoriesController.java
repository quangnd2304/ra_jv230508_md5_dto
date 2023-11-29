package ra.springboot_dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.springboot_dto.dto.request.CategoriesRequestDTO;
import ra.springboot_dto.dto.response.CategoriesResponseDTO;
import ra.springboot_dto.service.CategoriesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<CategoriesResponseDTO>> getAllCategories() {
        List<CategoriesResponseDTO> listResponseCategories = categoriesService.findAll();
        return new ResponseEntity<>(listResponseCategories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriesResponseDTO> createCategories(@RequestBody CategoriesRequestDTO catalogRequest) {
        CategoriesResponseDTO catalogResponse = categoriesService.save(catalogRequest);
        return new ResponseEntity<>(catalogResponse,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriesResponseDTO> updateCategories(@RequestBody CategoriesRequestDTO catalogRequest,@PathVariable long id){
        CategoriesResponseDTO catalogResponse = categoriesService.update(catalogRequest,id);
        return new ResponseEntity<>(catalogResponse,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void deleteCategories(@PathVariable long id){
        categoriesService.delete(id);
    }
}
