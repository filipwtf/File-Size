package com.github.filipwtf.filesize

import com.intellij.codeInsight.hint.HintManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager

/**
 * @author Filip
 */
class FileSize : AnAction() {
    companion object {
        const val kb = 1024
    }

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project
        val editor = project?.let { FileEditorManager.getInstance(it).selectedTextEditor } ?: return
        val psiFile = project.let { PsiDocumentManager.getInstance(it).getPsiFile(editor.document) } ?: return
        run {
            val currentFile = psiFile.virtualFile
            val sizeInBytes = currentFile.length
            val fileInfo = if (sizeInBytes < kb) {
                "$sizeInBytes bytes"
            } else {
                "%.2f kb".format(currentFile.length.toDouble().div(kb))
            }
            HintManager.getInstance().showInformationHint(editor, "${currentFile.name} $fileInfo")
        }
    }

    override fun update(e: AnActionEvent) {
        val project: Project? = e.project
        e.presentation.isEnabledAndVisible = project != null
    }
}
