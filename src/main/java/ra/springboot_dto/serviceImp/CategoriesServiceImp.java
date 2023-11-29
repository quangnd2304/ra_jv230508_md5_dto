package ra.springboot_dto.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springboot_dto.dto.request.CategoriesRequestDTO;
import ra.springboot_dto.dto.response.CategoriesResponseDTO;
import ra.springboot_dto.model.Categories;
import ra.springboot_dto.repository.CategoriesRepository;
import ra.springboot_dto.service.CategoriesService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<CategoriesResponseDTO> findAll() {
        //Input:
        //Output: responseDTO
        //Repository: Entiy --> ResponseDTO
        List<Categories> listCategories = categoriesRepository.findAll();
        //Chuyen danh sach Categories sang danh sach CategoriesResponseDTO
        List<CategoriesResponseDTO> listDTO = listCategories.stream()
                .map(catalog -> new CategoriesResponseDTO(catalog.getId(),catalog.getName(),catalog.isStatus()))
                .collect(Collectors.toList());
        return listDTO;
    }

    @Override
    public CategoriesResponseDTO findById(long id) {
        return null;
    }

    @Override
    public CategoriesResponseDTO save(CategoriesRequestDTO catalog) {
        /*
        * input: RequestDTO
        * output: ResponseDTO
        * call repository: Entity
        * Tranfer: RequestDTO --> Entity, Entity--> ResponseDTO
        * */
        //B1: RequestDTO --> Entity
        Categories catalogNew = new Categories(catalog.getId(),catalog.getName(),catalog.isStatus(),null);
        //B2: call repository
        Categories catalogInserted = categoriesRepository.save(catalogNew);
        //B3: Entity --> ResponseDTO và return
        return new CategoriesResponseDTO(catalogInserted.getId(),catalogInserted.getName(),catalogInserted.isStatus());
    }

    @Override
    public CategoriesResponseDTO update(CategoriesRequestDTO catalog, long id) {
        //1. RequestDTO --> entity
        Categories categoriesUpdate = categoriesRepository.findById(id).get();
        categoriesUpdate.setName(catalog.getName());
        categoriesUpdate.setStatus(catalog.isStatus());
        //2. Call Repository
        Categories categoriesUpdated = categoriesRepository.save(categoriesUpdate);
        //3. return ResponseDTO
        return new CategoriesResponseDTO(categoriesUpdated.getId(),categoriesUpdated.getName(),categoriesUpdated.isStatus());
    }

    @Override
    public void delete(long id) {
        categoriesRepository.deleteById(id);
    }
}
