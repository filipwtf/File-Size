package com.github.filipwtf.filesize.services

import com.intellij.openapi.project.Project
import com.github.filipwtf.filesize.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
