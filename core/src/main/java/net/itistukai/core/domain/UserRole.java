package net.itistukai.core.domain;

/**
 * Created by giylmi on 06.01.15.
 */
public enum UserRole {

    ADMIN(1),
    USER(0);

    private final int value;

    UserRole(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public static UserRole byIntValue(int value){
        for (UserRole role: UserRole.values())
            if (role.getValue() == value)
                return role;
        return USER;
    }

    public static boolean check(String name){
        for (UserRole role: UserRole.values())
            if (role.toString().equals(name)) return true;
        return false;
    }
}
