package com.github.allsochen.stringstyle.styles;

import org.apache.commons.lang.WordUtils;

public class WordsCapitalizeAction extends AbstractCaseConvertingAction {

    @Override
    public String transformByLine(String s) {
        return WordUtils.capitalize(s);
    }
}
