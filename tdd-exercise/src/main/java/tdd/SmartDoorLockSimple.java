package tdd;

public class SmartDoorLockSimple implements SmartDoorLock {

    private final static String LOCKED = "Locked";
    private final static String UNLOCKED = "Unlocked";
    private final static String BLOCKED = "Blocked";
    private String lockState;
    private int pin;
    private final static int PIN_LENGTH = 4;

    SmartDoorLockSimple() {
        lockState = UNLOCKED;
    }

    private int lengthInt(int pin){
        return String.valueOf(Math.abs(pin)).length();
    }

    @Override
    public void setPin(int pin) {
        if(lockState.equals(UNLOCKED) && lengthInt(pin) == PIN_LENGTH){
            this.pin = pin;
        } else if(!lockState.equals(UNLOCKED)){
            throw new IllegalArgumentException("Error Door State");
        } else {
            throw new IllegalArgumentException("Error Pin Length");
        }
    }

    @Override
    public void unlock(int pin) {
        if(isLocked()){

        }
    }

    @Override
    public void lock() {
        if(pin != 0){
            lockState = LOCKED;
        } else {
            throw new IllegalStateException("pin is not set");
        }
    }

    @Override
    public boolean isLocked() {
        return lockState.equals(LOCKED);
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
