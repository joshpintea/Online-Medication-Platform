package assignment1.dto;

public enum UserRoleDto {
    ROLE_DOCTOR {
        @Override
        public String withoutRoleKey() {
            return "DOCTOR";
        }
    },
    ROLE_CAREGIVER {
        @Override
        public String withoutRoleKey() {
            return "CAREGIVER";
        }
    },
    ROLE_PATIENT {
        @Override
        public String withoutRoleKey() {
            return "PATIENT";
        }
    };

    public String withoutRoleKey() {
        return "User roles";
    }
}
