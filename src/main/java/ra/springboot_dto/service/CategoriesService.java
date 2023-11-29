package ra.springboot_dto.service;

import ra.springboot_dto.dto.request.CategoriesRequestDTO;
import ra.springboot_dto.dto.response.CategoriesResponseDTO;

import java.util.List;

public interface CategoriesService {
    List<CategoriesResponseDTO> findAll();
    CategoriesResponseDTO findById(long id);
    CategoriesResponseDTO save(CategoriesRequestDTO catalog);
    CategoriesResponseDTO update(CategoriesRequestDTO catalog, long id);
    void delete(long id);
}
