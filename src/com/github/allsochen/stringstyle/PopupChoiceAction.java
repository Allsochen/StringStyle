package com.github.allsochen.stringstyle;

import com.intellij.codeInsight.lookup.LookupManager;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;

public class PopupChoiceAction extends DumbAwareAction {
    private ActionGroup actionGroup;


    public PopupChoiceAction() {
        actionGroup = (ActionGroup) ActionManager.getInstance().getAction("StringStyle.ManipulateStringGroup");
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        ListPopup popup = JBPopupFactory.getInstance().createActionGroupPopup("", actionGroup,
                e.getDataContext(), JBPopupFactory.ActionSelectionAid.ALPHA_NUMBERING, false);

        popup.showInBestPositionFor(e.getDataContext());
    }

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        Editor editor = CommonDataKeys.EDITOR.getData(e.getDataContext());
        if (editor == null) {
            e.getPresentation().setEnabled(false);
            return;
        }
        Project project = getEventProject(e);
        if (project != null) {
            e.getPresentation().setEnabled(LookupManager.getInstance(project).getActiveLookup() == null);
            return;
        }
    }
}
