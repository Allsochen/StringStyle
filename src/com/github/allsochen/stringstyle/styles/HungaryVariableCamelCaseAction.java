package com.github.allsochen.stringstyle.styles;

public class HungaryVariableCamelCaseAction extends AbstractCaseConvertingAction {
    public HungaryVariableCamelCaseAction() {
    }

    public HungaryVariableCamelCaseAction(boolean setupHandler) {
        super(setupHandler);
    }

    @Override
    public String transformByLine(String s) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        boolean foundFirstUpperCase = false;
        for (; index < s.length(); index++) {
            if (Character.isUpperCase(s.charAt(index))) {
                foundFirstUpperCase = true;
                break;
            }
        }
        if (index > 0 && foundFirstUpperCase) {
            char firstUpperCase = s.substring(index, index + 1).charAt(0);
            sb.append(Character.toLowerCase(firstUpperCase));
            sb.append(s.substring(index + 1));
            return sb.toString();
        }
        return s;
    }
}
