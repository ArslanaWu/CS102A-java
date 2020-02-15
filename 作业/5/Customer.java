public class Customer {

        private String firstName;
        private String lastName;
        private Gender gender;
        private String socialSecurityNumber;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getSocialSecurityNumber() {
            return socialSecurityNumber;
        }

        public void setSocialSecurityNumber(String socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
        }

        public Customer(String firstName, String lastName, Gender gender, String ssn) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            socialSecurityNumber = ssn;
        }

        public static boolean checkName(String name) {
            for (int i = 0; i < name.length(); i++) {
                if (!Character.isLetter(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        public static String formatName(String name) {
            String firstLetter = name.substring(0, 1).toUpperCase();
            String otherLetter = name.substring(1).toLowerCase();
            name = firstLetter + otherLetter;
            return name;
        }

        public static boolean checkSSN(String ssn) {
            if (ssn.length() != 8) {
                return false;
            } else if (ssn.charAt(0) == 0) {
                return false;
            } else {
                return true;
            }
        }


}
