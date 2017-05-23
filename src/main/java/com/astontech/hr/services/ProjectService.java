package com.astontech.hr.services;

import com.astontech.hr.domain.Project;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
public interface ProjectService
{
    Iterable<Project> listAllProjects();

    Project getProjectById(Integer id);

    Project saveProject(Project project);

    Iterable<Project> saveProjectList(Iterable<Project> projectIterable);

    void deleteProject(Integer id);
}
