package model;

public class TimerBean {

    private String name;
    private int sessionTime;
    private int breakTime;
    private int utenteId;

    public TimerBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public int getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }
}
