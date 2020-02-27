package emuns;

import lombok.Getter;

@Getter
public enum GenderRadioButton {
    FEMALE("Female"),
    MALE("Male");

    public String var;
    GenderRadioButton(String var){this.var=var;}

    public static GenderRadioButton getGenderRadioButtonName(String genderName) {
        for (GenderRadioButton gender : GenderRadioButton.values()) {
            if (gender.getVar().equalsIgnoreCase(genderName)) {
                return gender;
            }
        }
        throw new IllegalStateException("Wrong parameter passed");
    }
}

