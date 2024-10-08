package com.social.user_service.entity;

import org.hibernate.Length;

public final class Constants {

    public static final String SQL_RESTRICTION = "is_deleted = false";

    private Constants() {
        throw new RuntimeException("Cannot initialize a constant class");
    }

    public static class UserTable {
        public static final String TABLE_NAME = "user";

        public static final class Id {
            public static final String NAME = "id";
        }

        public static final class AccountId {
            public static final String NAME = "account_id";
        }

        public static final class Username {
            public static final String NAME = "username";

            public static final int LENGTH = 120;
        }

        public static final class FirstName {
            public static final String NAME = "first_name";

            public static final int LENGTH = 120;
        }

        public static final class LastName {
            public static final String NAME = "last_name";

            public static final int LENGTH = 120;
        }

        public static final class Password {
            public static final String NAME = "password";

            public static final int LENGTH = 60;
        }

        public static final class CreatedDate {
            public static final String NAME = "created_date";
        }

        public static final class IsDeleted {
            public static final String NAME = "is_deleted";
        }
    }
}
