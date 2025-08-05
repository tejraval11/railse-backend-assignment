package com.railse.workforcemgmt.service;


import com.railse.workforcemgmt.dto.*;
import com.railse.workforcemgmt.model.enums.Priority;
import com.railse.workforcemgmt.model.enums.ReferenceType;

import java.util.List;

public interface TaskManagementService {
    List<TaskManagementDto> createTasks(TaskCreateRequest request);
    List<TaskManagementDto> updateTasks(UpdateTaskRequest request);
    String assignByReference(AssignByReferenceRequest request);
    List<TaskManagementDto> fetchTasksByDate(TaskFetchByDateRequest
                                                     request);
    TaskManagementDto findTaskById(Long id);
    //feature 2
    TaskManagementDto updatePriority(Long taskId, Priority priority);
    List<TaskManagementDto> findByPriority(Priority priority);

    //for testing
    List<TaskManagementDto> getTasksByReference(Long referenceId, ReferenceType referenceType);

}
