package tdd;

public class SmartDoorLockSimple implements SmartDoorLock {

    private enum LockState { UNLOCKED, LOCKED, BLOCKED }
    private final int MAXATTEMPTS = 3;
    private LockState lockState;
    private int pin;
    private final static int PIN_LENGTH = 4;
    private int attempts = 0;

    SmartDoorLockSimple() {
        lockState = LockState.UNLOCKED;
        attempts = 0;
        pin = 0;
    }

    private int lengthInt(int pin){
        return String.valueOf(Math.abs(pin)).length();
    }

    @Override
    public void setPin(int pin) {
        if(lockState == LockState.UNLOCKED && lengthInt(pin) == PIN_LENGTH){
            this.pin = pin;
        } else if(!(lockState == LockState.UNLOCKED)){
            throw new IllegalArgumentException("Error Door State");
        } else {
            throw new IllegalArgumentException("Error Pin Length");
        }
    }

    @Override
    public void unlock(int pin) {
        if(isLocked()){
            if(pin == this.pin){
                lockState = LockState.UNLOCKED;
                attempts = 0;
            } else {
                attempts++;
                if(attempts >= MAXATTEMPTS){
                    this.lockState = LockState.BLOCKED;
                }
            }
        }
    }

    @Override
    public void lock() {
        if(pin != 0){
            lockState = LockState.LOCKED;
        } else {
            throw new IllegalStateException("pin is not set");
        }
    }

    @Override
    public boolean isLocked() {
        return lockState == LockState.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return lockState == LockState.BLOCKED;
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
        this.lockState = LockState.UNLOCKED;
        this.attempts = 0;
        this.pin = 0;
    }
}
