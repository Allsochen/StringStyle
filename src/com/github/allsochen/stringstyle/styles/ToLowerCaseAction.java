package com.github.allsochen.stringstyle.styles;

public class ToLowerCaseAction extends AbstractCaseConvertingAction {
    public ToLowerCaseAction() {
    }

    public ToLowerCaseAction(boolean setupHandler) {
        super(setupHandler);
    }

    @Override
    public String transformByLine(String s) {
        return s.toLowerCase();
    }
}
