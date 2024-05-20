package com.task.management.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDTO {
    public Long id;
    public String code;
    public String description;
    public String notes;
    public String featureFlagName;
    public boolean isActive;

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
