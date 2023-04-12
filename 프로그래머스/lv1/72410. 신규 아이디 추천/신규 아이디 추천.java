class Solution {
    public String solution(String new_id) {
        char[] chars = new_id.toCharArray();
        String update_id = "";
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            //1단계
            if (Character.isUpperCase(chars[i])) {
                temp = Character.toLowerCase(chars[i]);
            }
            //2단계
            if (canUse(temp)) {
                update_id += temp;
            }
        }
        //3단계
        update_id = removeContinuousPeriod(update_id);

        //4단계
        update_id = removeStartOrEndPeriod(update_id);

        //5단계
        if (update_id.length() == 0) {
            return "aaa";
        }

        //6단계
        update_id = removeOverLength(update_id);

        //7단계
        if (update_id.length() <= 2) {
            update_id = addLastWord(update_id);
        }

        return update_id;
    }
    
    //사용 가능한 문자인지 판단
    public boolean canUse(char c) {
        if (Character.isAlphabetic(c) || c == '-' || c == '_' || c == '.' || 0 <= c - '0' && c - '0' <= 9) {
            return true;
        }
        return false;
    }

    //연속되는 마침표 제거
    public String removeContinuousPeriod(String id) {
        char[] idChars = id.toCharArray();
        String update_id = "";
        boolean prevPeriod = false;
        for (char c : idChars) {
            if (c == '.') {
                if (!prevPeriod) {
                    prevPeriod = true;
                    update_id += c;
                }
                continue;
            }
            prevPeriod = false;
            update_id += c;
        }
        return update_id;
    }

    //처음과 끝 마침표 제거
    public String removeStartOrEndPeriod(String id) {
        if (id.startsWith(".")) {
            id = id.substring(1);
        }
        if (id.endsWith(".")) {
            id = id.substring(0, id.length() - 1);
        }
        return id;
    }

    public String removeOverLength(String id) {
        if (id.length() >= 16) {
            id = id.substring(0, 15);
        }
        return removeStartOrEndPeriod(id);
    }

    public String addLastWord(String id) {
        String last = id.substring(id.length() - 1);
        while (id.length() != 3) {
            id += last;
        }
        return id;
    }
}