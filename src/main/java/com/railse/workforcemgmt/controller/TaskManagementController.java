package com.railse.workforcemgmt.controller;

import com.railse.workforcemgmt.dto.*;
import com.railse.workforcemgmt.dto.response.Response;
import com.railse.workforcemgmt.model.enums.Priority;
import com.railse.workforcemgmt.model.enums.ReferenceType;
import com.railse.workforcemgmt.service.TaskManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-mgmt")
public class TaskManagementController {

    private final TaskManagementService taskManagementService;

    public TaskManagementController(TaskManagementService taskManagementService) {
        this.taskManagementService = taskManagementService;
    }

    @GetMapping("/{id}")
    public Response<TaskManagementDto> getTaskById(@PathVariable Long id) {
        return new Response<>(taskManagementService.findTaskById(id));
    }

    @PostMapping("/create")
    public Response<List<TaskManagementDto>> createTasks(@RequestBody TaskCreateRequest request) {
        return new Response<>(taskManagementService.createTasks(request));
    }

    @PostMapping("/update")
    public Response<List<TaskManagementDto>> updateTasks(@RequestBody UpdateTaskRequest request) {
        return new Response<>(taskManagementService.updateTasks(request));
    }

    @PostMapping("/assign-by-ref")
    public Response<String> assignByReference(@RequestBody AssignByReferenceRequest request) {
        return new Response<>(taskManagementService.assignByReference(request));
    }

    @PostMapping("/fetch-by-date/v2")
    public Response<List<TaskManagementDto>> fetchByDate(@RequestBody TaskFetchByDateRequest request) {
        return new Response<>(taskManagementService.fetchTasksByDate(request));
    }

    //feature 2
    @PatchMapping("/{taskId}/priority")
    public Response<TaskManagementDto> updatePriority(
            @PathVariable Long taskId,
            @RequestParam Priority priority
    ) {
        return new Response<>(taskManagementService.updatePriority(taskId, priority));
    }

    @GetMapping("/priority/{priority}")
    public Response<List<TaskManagementDto>> getTasksByPriority(@PathVariable Priority priority) {
        return new Response<>(taskManagementService.findByPriority(priority));
    }


    //for testing
    @GetMapping("/by-reference")
    public Response<List<TaskManagementDto>> getTasksByReference(
            @RequestParam Long referenceId,
            @RequestParam ReferenceType referenceType
    ) {
        return new Response<>(taskManagementService.getTasksByReference(referenceId, referenceType));
    }
}