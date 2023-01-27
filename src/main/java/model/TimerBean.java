package model;

public class TimerBean {

    private int name;
    private int sessionTime;
    private int breakTime;

    public TimerBean() {
    }

    public TimerBean(int name, int sessionTime, int breakTime) {
        this.name = name;
        this.sessionTime = sessionTime;
        this.breakTime = breakTime;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
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

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }
}
