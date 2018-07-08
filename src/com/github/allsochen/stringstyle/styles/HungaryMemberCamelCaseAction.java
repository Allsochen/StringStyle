package com.github.allsochen.stringstyle.styles;

public class HungaryMemberCamelCaseAction extends AbstractCaseConvertingAction {
    public HungaryMemberCamelCaseAction() {
    }

    public HungaryMemberCamelCaseAction(boolean setupHandler) {
        super(setupHandler);
    }

    @Override
    public String transformByLine(String s) {
        // m_iHungaryMember => m_hungaryMember
        if (s.startsWith("m_")) {
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
                sb.append("m_");
                char firstUpperCase = s.substring(index, index + 1).charAt(0);
                sb.append(Character.toLowerCase(firstUpperCase));
                sb.append(s.substring(index + 1));
                return sb.toString();
            }
        }
        return s;
    }
}
