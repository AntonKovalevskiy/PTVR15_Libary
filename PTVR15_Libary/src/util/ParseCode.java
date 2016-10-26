/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;

/**
 *
 * @author pupil
 */
public class ParseCode {
    private String code;
    private Integer age;
    private Integer day;
    private Integer month;
    private Integer year;
    private String bday;
    private String sex;

    public ParseCode(String code) {
        this.code=code;
        setGender(code);
        setBday(code);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(getYear(), getMonth(), getDay());
        dob.add(Calendar.DAY_OF_MONTH, -1);

        Integer intAge = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_MONTH)) {
            intAge--;
        }
        this.age = intAge;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        String d = Integer.toString(getDay());
        String m = Integer.toString(getMonth());
        String y = Integer.toString(getYear());
        this.bday = y + "." + m + "." + d;
    }

    public String getGender() {
        return sex;
    }

    public void setGender(String gender) {
        String stringGender = code.substring(0, 1);
        String codeYear = code.substring(1, 3);
        String codeMounth = code.substring(3, 5);
        String codeDay = code.substring(5, 7);
        String stringDay = "";
        String stringMounth = "";
        String stringYear = "";
        switch (stringGender) {
            case "3":
                this.sex = "Мужчина";
                stringYear = "19" + codeYear;
                stringMounth = codeMounth;
                stringDay = codeDay;
                break;
            case "4":
                this.sex = "Женщина";
                stringYear = "19" + codeYear;
                stringMounth = codeMounth;
                stringDay = codeDay;
                break;
            case "5":
                this.sex = "Мужчина";
                stringYear = "20" + codeYear;
                stringMounth = codeMounth;
                stringDay = codeDay;
                break;
            case "6":
                this.sex = "Женщина";
                stringYear = "20" + codeYear;
                stringMounth = codeMounth;
                stringDay = codeDay;
                break;
            default:
                throw new AssertionError("Неправильная инициализация ID!");
        }
        this.setYear(Integer.parseInt(stringYear));
        this.setMonth(Integer.parseInt(stringMounth));
        this.setDay(Integer.parseInt(stringDay));;
    }

    
}
