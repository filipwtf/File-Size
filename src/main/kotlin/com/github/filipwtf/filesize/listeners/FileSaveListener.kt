package com.github.filipwtf.filesize.listeners

import com.github.filipwtf.filesize.FileSize
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.ui.playback.commands.ActionCommand
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent

/**
 * @author Filip
 */
class FileSaveListener : BulkFileListener {

    override fun after(events: MutableList<out VFileEvent>) {
        println("Hello")
        run {
            ActionManager.getInstance().tryToExecute(FileSize(), ActionCommand.getInputEvent
            ("EditorCompleteStatement"), null, ActionPlaces.UNKNOWN, true)
        }
    }
}