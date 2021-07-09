package org.oag.securityjparest.service.state;

import org.oag.securityjparest.entity.state.StateEntity;
import org.oag.securityjparest.model.dto.state.StateDto;
import org.oag.securityjparest.model.response.ApiResponse;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StateServiceInteface {

    default StateEntity createStateEntity(StateDto stateDto) {
        StateEntity productEntity = new StateEntity();
        productEntity.setName(stateDto.getName());
        return productEntity;
    }

    ApiResponse addState(StateDto stateDto);

    Page<StateEntity> getProductPage(Optional<Integer> page, Optional<String> sort);

    default String isPage(String page) {
        switch (page) {
            case "name":
                return page;
            case "id":
                return page;
            default:
                return "id";
        }
    }

    StateEntity getStateById(Long id);

    ApiResponse editState(StateDto stateDto, Long id);

    ApiResponse deleteStateById(Long id);
}
