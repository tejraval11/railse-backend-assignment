package com.railse.workforcemgmt.model;

import com.railse.workforcemgmt.model.enums.Priority;
import com.railse.workforcemgmt.model.enums.ReferenceType;
import com.railse.workforcemgmt.model.enums.Task;
import com.railse.workforcemgmt.model.enums.TaskStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TaskManagement {
    private Long id;
    private Long referenceId;
    private ReferenceType referenceType;
    private Task task;
    private String description;
    private TaskStatus status;
    private Long assigneeId; // Simplified from Entity for this assignment
    private Long taskDeadlineTime;
    private Priority priority;
    private List<String> comments = new ArrayList<>();
    private List<String> activityHistory = new ArrayList<>();

}
