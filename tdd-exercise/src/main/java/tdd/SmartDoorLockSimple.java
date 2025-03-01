package tdd;

public class SmartDoorLockSimple implements SmartDoorLock {

    private final static String LOCKED = "Locked";
    private final static String UNLOCKED = "Unlocked";
    private final static String BLOCKED = "Blocked";
    private final int MAXATTEMPTS = 3;
    private String lockState;
    private int pin;
    private final static int PIN_LENGTH = 4;
    private int attempts = 0;

    SmartDoorLockSimple() {
        lockState = UNLOCKED;
        attempts = 0;
        pin = 0;
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
            if(pin == this.pin){
                lockState = UNLOCKED;
                attempts = 0;
            } else {
                attempts++;
                if(attempts >= MAXATTEMPTS){
                    this.lockState = BLOCKED;
                }
            }
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
        return lockState.equals(BLOCKED);
    }

    @Override
    public int getMaxAttempts() {
        return MAXATTEMPTS - attempts;
    }

    @Override
    public int getFailedAttempts() {
        return attempts;
    }

    @Override
    public void reset() {
        this.lockState = UNLOCKED;
        this.attempts = 0;
        this.pin = 0;
    }
}
