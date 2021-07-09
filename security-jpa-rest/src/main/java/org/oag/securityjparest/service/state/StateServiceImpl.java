package org.oag.securityjparest.service.state;

import org.oag.securityjparest.entity.state.StateEntity;
import org.oag.securityjparest.model.dto.state.StateDto;
import org.oag.securityjparest.model.response.ApiResponse;
import org.oag.securityjparest.repository.state.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateServiceImpl implements StateServiceInteface {
    @Autowired
    StateRepository stateRepository;


    @Override
    public ApiResponse addState(StateDto stateDto) {
        boolean existsByName = stateRepository.existsByName(stateDto.getName());
        if (existsByName) {
            return new ApiResponse("bunday mamlakat bazada mavjud!!!", false);
        }
        StateEntity stateEntity = createStateEntity(stateDto);
        stateRepository.save(stateEntity);
        return new ApiResponse("mamlakat qo'shildi", true);
    }

    @Override
    public Page<StateEntity> getProductPage(Optional<Integer> page, Optional<String> sortBy) {
        Page<StateEntity> productEntities = stateRepository.findAll(PageRequest.of(page.orElse(0), 10, Sort.Direction.ASC, isPage(sortBy.orElse("id"))));
        return productEntities;
    }

    @Override
    public StateEntity getStateById(Long id) {
        Optional<StateEntity> optionalStateEntity = stateRepository.findById(id);
        return optionalStateEntity.orElse(null);

    }

    @Override
    public ApiResponse editState(StateDto stateDto, Long id) {
        Optional<StateEntity> optionalStateEntity = stateRepository.findById(id);
        if (stateRepository.existsByNameAndIdNot(stateDto.getName(), id)) {
            return new ApiResponse("bunday mamlakat bazada mavjud!!!", false);
        }
        if (optionalStateEntity.isEmpty()) {
            return new ApiResponse("Bunday id li mamlakat mavjud emas!!!", false);
        }
        StateEntity stateEntity = optionalStateEntity.get();
        stateEntity.setName(stateDto.getName());
        stateRepository.save(stateEntity);
        return new ApiResponse("mamlakat taxrirlandi", true);
    }

    @Override
    public ApiResponse deleteStateById(Long id) {
        if (stateRepository.findById(id).isEmpty()) {
            return new ApiResponse("Bunday id li mamlakat mavjud emas!!!", false);
        }
        stateRepository.delete(stateRepository.getOne(id));
        return new ApiResponse("O'chirildi", true);
    }
}
