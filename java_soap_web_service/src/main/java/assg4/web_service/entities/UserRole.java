package assg4.web_service.entities;

public enum UserRole {
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
