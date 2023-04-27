
package week08_competitionwithfile;

import java.time.LocalDate;

public enum Category {
    M49("Muzi do 50", 0, 49, Gender.MALE),
    M99("Muzi nad 50", 50, 120, Gender.MALE),
    Z49("Zeny do 50", 0, 49, Gender.FEMALE),
    Z99("Zeny nad 50", 50, 120, Gender.FEMALE);
    
    private String description;
    private int minAge;
    private int maxAge;
    private Gender gender;

    private Category(String description, int minAge, int maxAge, Gender gender) {
        this.description = description;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public Gender getGender() {
        return gender;
    }
    
    public static Category getInstance(Gender gender, int yearOfBirth){
        int age = LocalDate.now().getYear() - yearOfBirth;
        for(Category cat :Category.values()){
            if (cat.gender.equals(gender) && cat.minAge <= age && cat.maxAge >= age){
                return cat;
            }
        } throw new IllegalArgumentException("No category for gender " 
                + gender.toString() + " and year of birth " + yearOfBirth);
    }
    
}
