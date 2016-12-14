package edu.calvin.dating.calvindatingwip;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Loganvp on 12/14/2016.
 *
 * Calvin Dating student object (POJO)
 *
 * @author LoganVP
 * @version Fall, 2016
 */

public class JavaCalls {

    /**
     * A User class for the Student relation
     *
     * @author Loganvp, meliornox
     * @version 12/14/16
     */
    public static class Student {

        private String CalvinID, password, picture, first, last, username, classYear, homeCity, homeState, homeCountry, major,
                majorDepartment, majorNumber, gender, genderWant, religion, mbti, job, hangout, bQuiv, diningPreference, sports,
                studySpot, chapelDay, nationality, vocation, aboutMe, status;
        private char loft;
        private int hateHope, bunHate, height;
        private boolean hasJob, tulip;
        private String birthday;

        public Student() { /* a default constructor, required by Gson */ }

        public Student(String CalvinID,
                String password,
                String picture,
                String first,
                String last,
                String username,
                String classYear,
                String birthday,
                String homeCity,
                String homeState,
                String homeCountry,
                String major,
                String majorDepartment,
                String majorNumber,
                String gender,
                String genderWant,
                String religion,
                String mbti,
                boolean hasJob,
                String job,
                boolean tulip,
                String hangout,
                int hateHope,
                String bQuiv,
                String diningPreference,
                String sports,
                int bunHate,
                String studySpot,
                String chapelDay,
                char loft,
                int height,
                String nationality,
                String vocation,
                String aboutMe,
                String status) {

            this.CalvinID = CalvinID;
            this.password = password;
            this.picture = picture;
            this.first = first;
            this.last = last;
            this.username = username;
            this.classYear = classYear;
            this.birthday = birthday;
            this.homeCity = homeCity;
            this.homeState = homeState;
            this.homeCountry = homeCountry;
            this.major = major;
            this.majorDepartment = majorDepartment;
            this.majorNumber = majorNumber;
            this.gender = gender;
            this.genderWant = genderWant;
            this.religion = religion;
            this.mbti = mbti;
            this.hasJob = hasJob;
            this.job = job;
            this.tulip = tulip;
            this.hangout = hangout;
            this.hateHope = hateHope;
            this.bQuiv = bQuiv;
            this.diningPreference = diningPreference;
            this.sports = sports;
            this.bunHate = bunHate;
            this.studySpot = studySpot;
            this.chapelDay = chapelDay;
            this.loft = loft;
            this.height = height;
            this.nationality = nationality;
            this.vocation = vocation;
            this.aboutMe = aboutMe;
            this.status = status;
        }
        /*
         *  GET methods
         */

        public String getCalvinID() { return CalvinID; }
        public String getPassword() { return password; }
        public String getPicture() { return picture; }
        public String getFirst() { return first; }
        public String getLast() { return last; }
        public String getUsername() { return username; }
        public String getClassYear() { return classYear; }
        public String getBirthday() { return birthday.toString(); }
        public String getHomeCity() { return homeCity; }
        public String getHomeState() { return homeState; }
        public String getHomeCountry() { return homeCountry; }
        public String getMajor() { return major; }
        public String getMajorDepartment() { return majorDepartment; }
        public String getMajorNumber() { return majorNumber; }
        public String getGender() { return gender; }
        public String getGenderWant() { return genderWant; }
        public String getReligion() { return religion; }
        public String getMbti() { return mbti; }
        public boolean getHasJob() { return hasJob; }
        public String getJob() { return job; }
        public boolean getTulip() { return tulip; }
        public String getHangout() { return hangout; }
        public int getHateHope() { return hateHope; }
        public String getBQuiv() { return bQuiv; }
        public String getDiningPreference() { return diningPreference; }
        public String getSports() { return sports; }
        public int getBunHate() { return bunHate; }
        public String getStudySpot() { return studySpot; }
        public String getChapelDay() { return chapelDay; }
        public char getLoft() { return loft; }
        public int getHeight() { return height; }
        public String getNationality() { return nationality; }
        public String getVocation() { return vocation; }
        public String getAboutMe() { return aboutMe; }
        public String getStatus() { return status; }
        /*
         * SET Methods
         */
        public void setCalvinID(String CalvinID) { this.CalvinID = CalvinID; }
        public void setPassword(String password) { this.password = password; }
        public void setPicture(String picture) { this.picture = picture; }
        public void setFirst(String first) { this.first = first; }
        public void setLast(String last) { this.last = last; }
        public void setUsername(String username) { this.username = username; }
        public void setClassYear(String classYear) { this.classYear = classYear; }
        public void setBirthday(String birthday) { this.birthday = birthday; }
        public void setHomeCity(String homeCity) { this.homeCity = homeCity; }
        public void setHomeState(String homeState) { this.homeState = homeState; }
        public void setHomeCountry(String homeCountry) { this.homeCountry = homeCountry; }
        public void setMajor(String major) { this.major = major; }
        public void setMajorDepartment(String majorDepartment) { this.majorDepartment = majorDepartment; }
        public void setMajorNumber(String majorNumber) { this.majorNumber = majorNumber; }
        public void setGender(String gender) { this.gender = gender; }
        public void setGenderWant(String genderWant) { this.genderWant = genderWant; }
        public void setReligion(String religion ) { this.religion = religion; }
        public void setMbti(String mbti) { this.mbti = mbti; }
        public void setHasJob(boolean hasJob) { this.hasJob = hasJob; }
        public void setJob(String job) { this.job = job; }
        public void setTulip(boolean tulip) { this.tulip = tulip; }
        public void setHangout(String hangout) { this.hangout = hangout; }
        public void setHateHope(int hateHope) { this.hateHope = hateHope; }
        public void setBQuiv(String bQuiv) { this.bQuiv = bQuiv; }
        public void setDiningPreference(String diningPreference) { this.diningPreference = diningPreference; }
        public void setSports(String sports) { this.sports = sports; }
        public void setBunHate(int bunHate) { this.bunHate = bunHate; }
        public void setStudySpot(String studySpot) { this.studySpot = studySpot; }
        public void setChapelDay(String chapelDay) { this.chapelDay = chapelDay; }
        public void setLoft(char loft) { this.loft = loft; }
        public void setHeight(int height) { this.height = height; }
        public void setNationality(String nationality) { this.nationality = nationality; }
        public void setVocation(String vocation) { this.vocation = vocation; }
        public void setAboutMe(String aboutMe) { this.aboutMe = aboutMe; }
        public void setStatus(String status) { this.status = status; }
    }

    /**
     * A User class for the datedate relation
     *
     * @author Loganvp, meliornox
     * @version 12/14/16
     */
    public static class Datedate {

        private int ID;
        private String aCalvinID, bCalvinID, place, activity;
        private boolean aAccept, bAccept;
        private Timestamp timestamp;

        public Datedate() { /* a default constructor, required by Gson */ }

        public Datedate(int ID, String aCalvinID, String bCalvinID, boolean aAccept, boolean bAccept,String place, String activity,
                 Timestamp timestamp) {

            this.ID = ID;
            this.aCalvinID = aCalvinID;
            this.bCalvinID = bCalvinID;
            this.aAccept = aAccept;
            this.bAccept = bAccept;
            this.place = place;
            this.activity = activity;
            this.timestamp = timestamp;

        }
        /*
         *  GET methods
         */

        public int getID() { return ID; }
        public String getACalvinID() { return aCalvinID; }
        public String getBCalvinID() { return bCalvinID; }
        public boolean getAAccept() { return aAccept; }
        public boolean getBAccept() { return bAccept; }
        public String getPlace() { return place; }
        public String getActivity() { return activity; }
        public Timestamp getTimestamp() { return timestamp; }

        /*
         * SET Methods
         */
        public void setID(int ID) { this.ID = ID; }
        public void setACalvinID(String aCalvinID) { this.aCalvinID = aCalvinID; }
        public void setBCalvinID(String bCalvinID) { this.bCalvinID = bCalvinID; }
        public void setAAccept(boolean aAccept) { this.aAccept = aAccept; }
        public void setBAccept(boolean bAccept) { this.bAccept = bAccept; }
        public void setPlace(String place) { this.place = place; }
        public void setActivity(String activity) { this.activity = activity; }
        public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
    }

    /**
     * A User class for the Message relation
     *
     * @author Loganvp, meliornox
     * @version 12/14/16
     */
    public static class Message {

        private int ID;
        private Timestamp timestamp;
        private String toID, fromID, message;

        public Message() { /* a default constructor, required by Gson */ }

        public Message(int ID, Timestamp timestamp, String toID, String fromID, String message) {

            this.ID = ID;
            this.timestamp = timestamp;
            this.toID = toID;
            this.fromID = fromID;
            this.message = message;

        }

        /*
         *  GET methods
         */
        public int getID() { return ID; }
        public Timestamp getTimestamp() { return timestamp; }
        public String getToID() { return toID; }
        public String getFromID() { return fromID; }
        public String getMessage() { return message; }

        /*
         * SET Methods
         */
        public void setID(int ID) { this.ID = ID; }
        public void getTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
        public void getToID(String toID) { this.toID = toID; }
        public void getFromID(String fromID) { this.fromID = fromID; }
        public void getMessage(String message) { this.message = message; }
    }

    /**
     * A User class for the Match relation
     *
     * @author Loganvp, meliornox
     * @version 12/14/16
     */
    public static class Match {

        private String aCalvinID, bCalvinID, reason;
        private int aValid, bValid;

        public Match() { /* a default constructor, required by Gson */ }

        public Match(String aCalvinID, String bCalvinID, String reason, int aValid, int bValid) {

            this.aCalvinID = aCalvinID;
            this.bCalvinID = bCalvinID;
            this.reason = reason;
            this.aValid = aValid;
            this.bValid = bValid;

        }
        /*
         *  GET methods
         */

        public String getACalvinID() { return aCalvinID; }
        public String getBCalvinID() { return bCalvinID; }
        public String getReason() { return reason; }
        public int getAValid() { return aValid; }
        public int getBValid() { return bValid; }
        /*
         * SET Methods
         */

        public void setACalvinID(String aCalvinID) { this.aCalvinID = aCalvinID; }
        public void setBCalvinID(String bCalvinID) { this.bCalvinID = bCalvinID; }
        public void setReason(String reason) { this.reason = reason; }
        public void setAValid(int aValid) { this.aValid = aValid; }
        public void setBValid(int bValid) { this.bValid = bValid; }
    }
}
