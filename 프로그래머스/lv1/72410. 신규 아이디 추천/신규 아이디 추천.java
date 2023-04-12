class Solution {
    
    public static class Id {
        private String id;
        private final int MAX_LENGTH = 15;
        private final int MIN_LENGTH = 3;

        public Id(String id) {
            this.id = id;
        }

        public Id toLowerCase() {
            id = id.toLowerCase();
            return this;
        }

        public Id removeSpecialChar() {
            id = id.replaceAll("[^-_.0-9a-z]", "");
            return this;
        }

        public Id removeContinuousDot() {
            id = id.replaceAll("[.]{2,}", ".");
            return this;
        }

        public Id removeStartOrEndDot() {
            if (id.startsWith(".")) id = id.substring(1);
            if (id.endsWith(".")) id = id.substring(0, id.length() - 1);
            return this;
        }

        public Id isEmpty() {
            if (id.length() == 0) id = "a";
            return this;
        }

        public Id moreThanMaxLength() {
            if (id.length() > MAX_LENGTH){
                id = id.substring(0, MAX_LENGTH);
                if (id.endsWith(".")) id = id.substring(0, id.length() - 1);
            }
            return this;
        }

        public Id lessThanMinLength() {
            if (id.length() < MIN_LENGTH) {
                String last = id.substring(id.length() - 1);
                while (id.length() < MIN_LENGTH) {
                    id += last;
                }
            }
            return this;
        }

        public String getId() {
            return id;
        }
    }
    
    public String solution(String new_id) {
        return new Id(new_id)
                .toLowerCase()
                .removeSpecialChar()
                .removeContinuousDot()
                .removeStartOrEndDot()
                .isEmpty()
                .moreThanMaxLength()
                .lessThanMinLength()
                .getId();
    }
}