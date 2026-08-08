package august.augest8;

class Department implements Cloneable {
    String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    // Required ONLY for Deep Copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
