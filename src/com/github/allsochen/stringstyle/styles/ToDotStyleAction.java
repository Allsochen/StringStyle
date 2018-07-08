package com.github.allsochen.stringstyle.styles;

public class ToDotStyleAction extends AbstractCaseConvertingAction {
    public ToDotStyleAction() {
    }

    public ToDotStyleAction(boolean b) {
        super(b);
    }

    @Override
    public String transformByLine(String s) {
        Style from = Style.from(s);
        if (from == Style.DOT) {
            return Style.CAMEL_CASE.transform(from, s);
        } else {
            return Style.DOT.transform(from, s);
        }
    }

}
