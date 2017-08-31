package com.shutterfly.cns.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    public String userName;

    public String userEmail;

    public String userGroup;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (!userName.equals(userData.userName)) return false;
        if (userEmail != null ? !userEmail.equals(userData.userEmail) : userData.userEmail != null) return false;
        return userGroup != null ? userGroup.equals(userData.userGroup) : userData.userGroup == null;
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userGroup != null ? userGroup.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userGroup='" + userGroup + '\'' +
                '}';
    }
}
